package no.unit.alma;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.jupiter.api.Test;

import no.bibsys.alma.rest.bibs.Bib;
import no.bibsys.alma.rest.bibs.Bibs;
import no.bibsys.alma.rest.holding.Holding;
import no.bibsys.alma.rest.holdings.Holdings;
import no.bibsys.alma.rest.items.Item;
import no.bibsys.alma.rest.items.Items;
import no.bibsys.alma.rest.vendor.Vendor;

public class ApiHelper {

    @Test
    void testReadBibs() {
        String fileName = "src/test/resources/bib.xml";
        String bibsFileName = "src/test/resources/bibs.xml";
        try {
            Bib bib = readXmlFromFile(fileName, Bib.class);
            writeObject(bib);
            Bibs bibs = readXmlFromFile(bibsFileName, Bibs.class);
            writeObject(bibs);
        } catch (IOException e) {
            e.printStackTrace();
            fail(String.format("Error reading file %s", fileName));
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
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
            System.out.printf("Failed to read from file %s%n", fileName);
            fail(String.format("Failed to read from file %s", fileName));
        }
    }

    public static <T> String writeObject(T object) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter sw = new StringWriter();
        jaxbMarshaller.marshal(object, sw);
        return sw.toString();
    }

    public static <T> T readXmlFromFile(String fileName, Class<T> type) throws IOException, JAXBException {

        File file = new File(fileName);
        JAXBContext jaxbContext = JAXBContext.newInstance(type);
        JAXBIntrospector jaxbIntrospector = jaxbContext.createJAXBIntrospector();

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        T unmarshalledObject = (T) jaxbIntrospector.getValue(jaxbUnmarshaller.unmarshal(file));

        return unmarshalledObject;
    }
}
