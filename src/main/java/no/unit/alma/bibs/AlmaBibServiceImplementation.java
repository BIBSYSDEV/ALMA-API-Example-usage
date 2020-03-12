package no.unit.alma.bibs;

import no.bibsys.alma.rest.bibs.Bib;
import no.bibsys.alma.rest.holding.Holding;
import no.bibsys.alma.rest.holdings.Holdings;
import no.bibsys.alma.rest.items.Item;
import no.bibsys.alma.rest.items.ItemData;
import no.bibsys.alma.rest.items.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBElement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

class AlmaBibServiceImplementation implements AlmaBibService {

    private static final Logger log = LoggerFactory.getLogger(AlmaBibServiceImplementation.class);

    AlmaBibServiceImplementation(String roleId, String secretId, String institutionServiceHost) {
        AlmaBibService.Factory.initVaultClient(roleId, secretId);
        AlmaBibService.Factory.initInstitutionServiceHost(institutionServiceHost);
    }

    @Override
    public AlmaBibRecord retrieveBibRecord(String recordId, String availParams, String context, String value) {
        AlmaResponse<JAXBElement<Bib>> almaResponse = RestJaxrsBib.Factory.create(context, value).getBib(recordId, availParams);
        return AlmaBibRecord.Factory.create(almaResponse);
    }

    @Override
    public AlmaBibRecord updateBibRecord(AlmaBibRecord bibRecord, String context, String value) {

        AlmaResponse<JAXBElement<Bib>> almaResponse = RestJaxrsBib.Factory.create(context, value).updateBib(bibRecord.getBib());
        return AlmaBibRecord.Factory.create(almaResponse);
    }

    @Override
    public List<AlmaHoldingsRecord> retrieveHoldingsRecordList(String recordId, String context, String value) {
        List<AlmaHoldingsRecord> holdingsList = new ArrayList<>();

        Holdings holdings = RestJaxrsHoldings.Factory.create(context, value).getHoldings(recordId).resultObject();
        List<no.bibsys.alma.rest.holdings.Holding> holdingInfoList = holdings.getHolding();
        for (no.bibsys.alma.rest.holdings.Holding holdingInfo : holdingInfoList) {
            AlmaResponse<JAXBElement<Holding>> holding = RestJaxrsHoldings.Factory.create(context, value).getHolding(recordId, holdingInfo.getHoldingId());
            holdingsList.add(AlmaHoldingsRecord.Factory.create(holding));
        }

        return holdingsList;
    }

    @Override
    public AlmaHoldingsRecord retrieveHoldingsRecord(String recordId, String holdingsId, String context, String value) {
        AlmaResponse<JAXBElement<Holding>> almaResponse = RestJaxrsHoldings.Factory.create(context, value).getHolding(recordId, holdingsId);
        return AlmaHoldingsRecord.Factory.create(almaResponse);
    }

    @Override
    public AlmaHoldingsRecord updateHoldingsRecord(String recordId, AlmaHoldingsRecord holdingsRecord, String context, String value) {

        AlmaResponse<JAXBElement<Holding>> almaResponse = RestJaxrsHoldings.Factory.create(context, value).updateHolding(recordId, holdingsRecord.getHolding());

        return AlmaHoldingsRecord.Factory.create(almaResponse);
    }

    @Override
    public List<AlmaItemRecord> retrieveItemRecordList(String recordId, String holdingsId, String context, String value) {
        List<AlmaItemRecord> itemList = new ArrayList<>();
        List<AlmaResponse<Items>> itemsList = RestJaxrsHoldings.Factory.create(context, value).getItems(recordId, holdingsId).responseList();
        for (AlmaResponse<Items> almaResponse : itemsList) {
            if (almaResponse.success()) {
                List<no.bibsys.alma.rest.items.Item> itemInfoList = almaResponse.resultObject().getItem();
                for (no.bibsys.alma.rest.items.Item itemInfo : itemInfoList) {
                    AlmaResponse<Item> item = RestJaxrsItems.Factory.create(context, value).getItem(recordId, holdingsId, itemInfo.getItemData().getPid());
                    itemList.add(AlmaItemRecord.Factory.create(item));
                }
            }
        }
        return itemList;
    }

    @Override
    public AlmaItemRecord retrieveItemRecord(String barcode, String context, String value) {
        AlmaResponse<Item> item = RestJaxrsItems.Factory.create(context, value).getItem(barcode);
        return AlmaItemRecord.Factory.create(item);
    }

    @Override
    public AlmaItemRecord updateItemRecord(AlmaItemRecord itemRecord, String context, String value) {
        AlmaResponse<Item> item = RestJaxrsItems.Factory.create(context, value).updateItem(itemRecord.getItem());
        return AlmaItemRecord.Factory.create(item);
    }

    @Override
    public AlmaItemRecord retrieveItemRecord(String mmsId, String holdingsId, String itemId, String context, String value) {
        AlmaResponse<Item> item = RestJaxrsItems.Factory.create(context, value).getItem(mmsId, holdingsId, itemId);
        return AlmaItemRecord.Factory.create(item);
    }

    @Override
    public boolean canBeDestroyed(String barcode, String context, String value, Set<String> validLibraries, int minimumAge, int minimumItems) {
        Item item = RestJaxrsItems.Factory.create(context, value).getItem(barcode).resultObject();
        if (item == null || item.getBibData() == null) {
            log.trace("Cannot get item for barcode: {}, institutionId: {}", barcode);
            return false;
        }
        return canBeDestroyed(item, context, value, validLibraries, minimumAge, minimumItems);
    }

    @Override
    public boolean canBeDestroyed(Item item, String context, String value, Set<String> validLibraries, int minimumAge, int minimumItems) {
        long startTime = System.currentTimeMillis();
        try {

            String mmsId = item.getBibData().getMmsId();
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);

            String label = item.getItemData().getDescription(); // createLabel(item);

            int itemCounter = 0;

            if (label.isEmpty()) {

                AlmaBibRecord bibRecord = retrieveBibRecord("" + mmsId, null, context, value);
                List<String> publicationYears = bibRecord.getValues("260", "c");
                for (String publicationYear : publicationYears) {
                    if (publicationYear != null && !publicationYear.isEmpty()) {
                        int year = 0;
                        try {
                            year = Integer.parseInt(publicationYear);
                        } catch (NumberFormatException e) {
                            String yearCandidate = publicationYear.replace("[", "").replace("]", "").replace("?", "").replace("cop.", "").replace("c", "").replace("<", "").replace(">", "").trim();
                            try {
                                year = Integer.parseInt(yearCandidate);
                            } catch (NumberFormatException e2) {
                                log.warn("Cannot parse year(260$c) in bibliographic record {}, content is {}", bibRecord.getBib().getMmsId(), publicationYear);
                            }

                        }
                        if (year + minimumAge > currentYear || year < 1900) {
                            return false;
                        }
                    }
                }

                Holdings holdings = RestJaxrsHoldings.Factory.create(context, value).getHoldings("" + mmsId).resultObject();
                for (no.bibsys.alma.rest.holdings.Holding holding : holdings.getHolding()) {
                    if (validLibraries.contains(holding.getLibrary().getValue())) {
                        List<AlmaResponse<Items>> items = RestJaxrsHoldings.Factory.create(context, value).getItems("" + mmsId, holding.getHoldingId()).responseList();
                        for (AlmaResponse<Items> almaResponse : items) {
                            if (almaResponse.success()) {
                                itemCounter += almaResponse.resultObject().getItem().size();
                            }
                        }
                    }
                }

            } else {

                Holdings holdings = RestJaxrsHoldings.Factory.create(context, value).getHoldings("" + mmsId).resultObject();
                for (no.bibsys.alma.rest.holdings.Holding holding : holdings.getHolding()) {
                    // TODO Burde de komme inn et array med LibraryCodes
                    if (validLibraries.contains(holding.getLibrary().getValue())) {
                        List<AlmaResponse<Items>> items = RestJaxrsHoldings.Factory.create(context, value).getItems("" + mmsId, holding.getHoldingId()).responseList();

                        for (AlmaResponse<Items> almaResponse : items) {
                            if (almaResponse.success()) {
                                for (Item candidate : almaResponse.resultObject().getItem()) {
                                    String candidateLabel = createLabel(candidate);
                                    log.trace("Checking incoming label {} against candidateLabel: {}", label, candidateLabel);
                                    if (candidateLabel.equals(label)) {
                                        int year = -1;
                                        try {
                                            year = Integer.parseInt(candidate.getItemData().getChronologyI());
                                        } catch (NumberFormatException ignored) {
                                        }
                                        if (year + minimumAge > currentYear || year < 1900) {
                                            log.trace("Candidate {} is out of year range..", candidate.getItemData().getBarcode());
                                            return false;
                                        }
                                        itemCounter++;
                                    }
                                }
                            }
                        }
                    }
                }

            }
            boolean enoughItems = itemCounter >= minimumItems;
            log.trace("item {} have enough items? {} : {}", item.getItemData().getBarcode(), enoughItems, itemCounter);
            return enoughItems;
        } finally {
            long timeUsed = System.currentTimeMillis() - startTime;
            log.debug("Item:{}, timeUsed:{}", item.getItemData().getBarcode(), timeUsed);
        }
    }

    @Override
    public String createLabel(String enumerationA, String enumerationB,
                              String enumerationC, String enumerationD, String chronologyI,
                              String chronologyJ, String chronologyK, String chronologyL) {

        enumerationA = (enumerationA != null ? enumerationA.trim() : "");
        enumerationB = (enumerationB != null ? enumerationB.trim() : "");
        enumerationC = (enumerationC != null ? enumerationC.trim() : "");
        enumerationD = (enumerationD != null ? enumerationD.trim() : "");
        chronologyI = (chronologyI != null ? chronologyI.trim() : "");
        chronologyJ = (chronologyJ != null ? chronologyJ.trim() : "");
        chronologyK = (chronologyK != null ? chronologyK.trim() : "");
        chronologyL = (chronologyL != null ? chronologyL.trim() : "");


        String label = enumerationA;

        if (!"".equals(chronologyI)) {
            label += "(" + chronologyI +
                (!"".equals(chronologyJ) ? "," + chronologyJ : "") +
                (!"".equals(chronologyK) ? "," + chronologyK : "") +
                (!"".equals(chronologyL) ? "," + chronologyL : "") + ")";
        }
        if (!"".equals(enumerationB)) {
            label += " " + enumerationB +
                (!"".equals(enumerationC) ? "," + enumerationC : "") +
                (!"".equals(enumerationD) ? "," + enumerationD : "");
        }


        if (label == null) {
            label = "";
        }

        return label;
    }

    @Override
    public String createLabel(Item item) {

        ItemData itemData = item.getItemData();
        return createLabel(itemData.getEnumerationA(),
            itemData.getEnumerationB(),
            itemData.getEnumerationC(),
            itemData.getEnumerationD(),
            itemData.getChronologyI(),
            itemData.getChronologyJ(),
            itemData.getChronologyK(),
            itemData.getChronologyL());

    }

}
