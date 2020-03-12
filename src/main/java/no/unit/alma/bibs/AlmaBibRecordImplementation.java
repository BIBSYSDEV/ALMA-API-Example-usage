package no.unit.alma.bibs;

import java.util.List;

import javax.xml.bind.JAXBElement;

import no.bibsys.alma.rest.bibs.Bib;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class AlmaBibRecordImplementation extends AbstractAlmaRecord<JAXBElement<Bib>> implements AlmaBibRecord {

	private Bib bib;
	private AlmaResponse<JAXBElement<Bib>> almaResponse;


	public AlmaBibRecordImplementation(AlmaResponse<JAXBElement<Bib>> newBib) {
	    almaResponse = newBib;

		setUpTransformerFactory();
        if (newBib != null) {
            bib = newBib.resultObject().getValue();
            List<Object> contentList = bib.getAny();

            for (Object object : contentList) {
                if (object instanceof Node) {
                    Node node = (Node) object;
                    if (node.getLocalName().equals("record")) {
                        rootElement = (Element) node;
                        document = rootElement.getOwnerDocument();
                    }
                }
            }
            if (document == null) {
                throw new RuntimeException("Missing marc record");
            }
        }
	}

    public AlmaBibRecordImplementation(Bib bib) {
        setUpTransformerFactory();
        this.bib = bib;
        if (bib != null) {
            final List<Object> contentList = bib.getAny();

            for (Object object : contentList) {
                if (object instanceof Node) {
                    Node node = (Node) object;
                    if (node.getLocalName().equals("record")) {
                        rootElement = (Element) node;
                        document = rootElement.getOwnerDocument();
                    }
                }
            }
            if (document == null) {
                throw new RuntimeException("Missing marc record");
            }
        }
    }


	@Override
	public Bib getBib() {
		return bib;
	}

	@Override
	public String toString() {
		return nodeToString(rootElement);
	}

	@Override
	public AlmaResponse<JAXBElement<Bib>> response() {
		return almaResponse;
	}
	
	

}
