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

public class ApiHelper {

    @Test
    void testReadBibs() {
        String fileName = "src/test/resources/bib.xml";
        String bibsFileName = "src/test/resources/bibs.xml";
        try {
            Bib bib = readXmlFromFile(fileName, Bib.class);
            System.out.println(writeObject(bib));
            Bibs bibs = readXmlFromFile(bibsFileName, Bibs.class);
            System.out.println(writeObject(bibs));
        } catch (IOException e) {
            e.printStackTrace();
            fail(String.format("Error reading file %s", fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
            fail(String.format("Error unmarshalling file %s", fileName));
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
