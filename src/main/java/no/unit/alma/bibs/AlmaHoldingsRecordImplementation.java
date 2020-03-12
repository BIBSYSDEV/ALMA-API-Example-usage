package no.unit.alma.bibs;

import java.util.List;

import javax.xml.bind.JAXBElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import no.bibsys.alma.rest.holding.Holding;

public class AlmaHoldingsRecordImplementation extends AbstractAlmaRecord<JAXBElement<Holding>> implements AlmaHoldingsRecord {

	private static transient Logger log = LoggerFactory.getLogger(AlmaHoldingsRecordImplementation.class);
	
	private Holding holding;
	private AlmaResponse<JAXBElement<Holding>> almaResponse;

	public AlmaHoldingsRecordImplementation(AlmaResponse<JAXBElement<Holding>> holdingResponse) {
		almaResponse = holdingResponse;
		this.holding = holdingResponse.resultObject().getValue();

		List<Object> contentList = holding.getAny();
		for (Object object : contentList) {
			if(object instanceof Node){
				Node node = (Node)object;
				if(node.getLocalName().equals("record")){
					document = node.getOwnerDocument();
					rootElement = (Element) node;
				}
			}
		}

		if(document == null){
			log.error("Missing marc record. holdingId = {}", holding.getHoldingId());
			throw new RuntimeException("Missing marc record");
		}
	}

	@Override
	public Holding getHolding() {
		return holding;
	}

	@Override
	public AlmaResponse<JAXBElement<Holding>> response() {
		return almaResponse;
	}

}
