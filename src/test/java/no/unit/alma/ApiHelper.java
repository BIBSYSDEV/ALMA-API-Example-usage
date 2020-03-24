package no.unit.alma;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.stream.StreamSource;

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
            System.out.println(writeObject(bib, Bib.class));
            Bibs bibs = readXmlFromFile(bibsFileName, Bibs.class);
            System.out.println(writeObject(bibs, Bibs.class));
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
            fail(String.format("Error reading file %s", fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
            fail(String.format("Error unmarshalling file %s", fileName));
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

    public static <T> T readXmlFromFile(String fileName, Class<T> type) throws JAXBException, FileNotFoundException, XMLStreamException {

        File file = new File(fileName);
        JAXBContext jaxbContext = JAXBContext.newInstance(type);
//        JAXBIntrospector jaxbIntrospector = jaxbContext.createJAXBIntrospector();

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

//        T unmarshalledObject = (T) jaxbIntrospector.getValue(jaxbUnmarshaller.unmarshal(parser, type));

        JAXBElement<T> root = jaxbUnmarshaller.unmarshal(new StreamSource(file), type);

        return root.getValue();
    }
}
