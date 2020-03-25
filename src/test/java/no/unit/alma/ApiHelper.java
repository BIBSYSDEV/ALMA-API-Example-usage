package no.unit.alma;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

import no.unit.alma.generated.holdings.Holding;
import no.unit.alma.generated.holdings.Holdings;
import no.unit.alma.generated.items.Item;
import no.unit.alma.generated.items.Items;
import no.unit.alma.generated.vendors.Vendor;
import org.junit.jupiter.api.Test;

import no.unit.alma.generated.bibs.Bib;
import no.unit.alma.generated.bibs.Bibs;

public class ApiHelper {

    @Test
    void testReadBibs() {
        String fileName = "src/test/resources/bib.xml";
        String bibsFileName = "src/test/resources/bibs.xml";
        try {
            Bib bib = readXmlFromFile(fileName, Bib.class);
            writeObject(bib, Bib.class);
            Bibs bibs = readXmlFromFile(bibsFileName, Bibs.class);
            writeObject(bibs, Bibs.class);
        } catch (JAXBException e) {
            e.printStackTrace();
            fail(String.format("Error unmarshalling file %s", fileName));
        }
    }

    @Test
    void testReadExampleFiles() {
        readExampleFile("bib", Bib.class);
        readExampleFile("bibs", Bibs.class);
        readExampleFile("holding", Holding.class);
        readExampleFile("holdings", Holdings.class);
        readExampleFile("item", Item.class);
        readExampleFile("items", Items.class);
        readExampleFile("vendor", Vendor.class);
    }

    private void readExampleFile(String fileName, Class<?> type) {
        String path = "src/test/resources/%s.xml";
        path = String.format(path, fileName);
        try {
            readXmlFromFile(path, type);
        } catch (JAXBException e) {
            e.printStackTrace();
            System.out.printf("Failed to read from file %s%n", fileName);
            fail(String.format("Failed to read from file %s", fileName));
        }
    }

    public static <T> String writeObject(T object, Class<T> type) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter sw = new StringWriter();
        QName qName = new QName(object.getClass().getPackageName(), object.getClass().getName());
        JAXBElement<T> root = new JAXBElement<T>(qName, type, object);

        jaxbMarshaller.marshal(root, sw);

        return sw.toString();
    }

    public static <T> T readXmlFromFile(String fileName, Class<T> type) throws JAXBException {
        File file = new File(fileName);
        JAXBContext jaxbContext = JAXBContext.newInstance(type);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement<T> root = jaxbUnmarshaller.unmarshal(new StreamSource(file), type);

        return root.getValue();
    }
}
