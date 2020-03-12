package no.unit.alma.bibs;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class AbstractAlmaRecord<E> implements AlmaRecord<E> {

	private static final Logger log = LoggerFactory.getLogger(AbstractAlmaRecord.class);


	protected Document document;
	protected TransformerFactory factory;
	protected Transformer trans;
	protected Element rootElement;

	@Override
	public void addControlField(String marcCode, String value) {
		Element controlField = createControlField(marcCode,value);

		NodeList nodeList = rootElement.getChildNodes();
		boolean inserted = false;
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if(findAttributeValue(node, TAG).compareTo(marcCode) > 0) {
				log.trace("inserting at pos={}",i);
				rootElement.insertBefore(controlField, node);
				inserted = true;
				break;
			}
		}
		if (!inserted) {
			log.trace("No matching nodes found, appending new marcdata!");
			rootElement.appendChild(controlField);
		}		
	}

	private Element createControlField(String marcCode, String value) {
		Element newChild;
		newChild = document.createElement(CONTROLFIELD);
		newChild.setAttribute(TAG, marcCode);
		newChild.setTextContent(value);
		return newChild;
	}

	@Override
	public void  addNewMarcData(Node marcDataNode, boolean clone) {
		if(clone){
			Node newNode = document.importNode(marcDataNode, true);
			rootElement.appendChild(newNode);
		}else{
			addNewMarcData(marcDataNode);
		}
	}


	@Override
	public void  addNewMarcData(Node marcDataNode) {

		String marcCode = findAttributeValue(marcDataNode, TAG);
		String ind1 = findAttributeValue(marcDataNode, IND1);
		String ind2 = findAttributeValue(marcDataNode, IND2);

		Element newDatafield;
		newDatafield = document.createElement(DATAFIELD);
		newDatafield.setAttribute(TAG, marcCode);
		newDatafield.setAttribute(IND1, ind1);
		newDatafield.setAttribute(IND2, ind2);



		Node child = marcDataNode.getFirstChild();
		while(child != null){
			String subCode = findAttributeValue(child, CODE);
			if (subCode != null && !subCode.isEmpty()) {
				String value =  child.getTextContent();
				Element subField = document.createElement(SUBFIELD);
				subField.setAttribute(CODE, subCode);
				subField.setTextContent(value);
				newDatafield.appendChild(subField);
			}
			child = child.getNextSibling();
		}
		NodeList nodeList = rootElement.getChildNodes();
		boolean inserted = false;
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if(node.getNodeName().equalsIgnoreCase(DATAFIELD) && findAttributeValue(node, TAG).compareTo(marcCode) > 0) {
				log.trace("inserting at pos={}",i);
				rootElement.insertBefore(newDatafield, node);
				inserted = true;
				break;
			}
		}
		if (!inserted) {
			log.trace("No matching nodes found, appending new marcdata!");
			rootElement.appendChild(newDatafield);
		}

		// TODO Add sorting of nodes
	}



	@Override
	public Node createDataField(String marcCode, String subCode, String value, String indicator1, String indicator2) {
		Element newChild;
		newChild = document.createElement(DATAFIELD);
		newChild.setAttribute(TAG, marcCode);
		newChild.setAttribute(IND1, indicator1);
		newChild.setAttribute(IND2, indicator2);
		Element subField = createSubField(subCode, value);
		newChild.appendChild(subField);
		return newChild;
	}

	@Override
	public Element createSubField(String subCode, String value){

		Element subField = document.createElement(SUBFIELD);
		subField.setAttribute(CODE, subCode);
		subField.setTextContent(value);

		return subField;
	}

	@Override
	public boolean hasSameSignature(Node node, String wantedSignature) {
		StringBuilder signature = new StringBuilder();
		int subFieldCounter = 0;
		NodeList childNodes = node.getChildNodes(); 
		for(int i = 0; i < childNodes.getLength(); i++) {
			Node subField = childNodes.item(i);	

			if (subField.getNodeName().equals(AlmaRecord.SUBFIELD)) {
				String subCode = findAttributeValue(subField, AlmaRecord.CODE);
				if (subCode != null && !subCode.isEmpty()) {
					subFieldCounter++;
					signature.append(subCode);
				}
			}
		}
		log.trace("wantedSignature={}, signature={}, subFieldCounter={}",wantedSignature, signature, subFieldCounter);
		if (wantedSignature.equals(signature.toString())) {
			return true;
		}
		return false;
	}

	@Override
	// Sjekker kun likhet i feltene a,b,c,d,i,j,k,l. Øvrige subkoder ignoreres i sammenligningen
	public boolean hasSameEnumerationAndChronologySignature(Node node, String wantedSignature) {
		StringBuilder signature = new StringBuilder();
		int subFieldCounter = 0;
		NodeList childNodes = node.getChildNodes();
		for(int i = 0; i < childNodes.getLength(); i++) {
			Node subField = childNodes.item(i);

			if (subField.getNodeName().equals(AlmaRecord.SUBFIELD)) {
				String subCode = findAttributeValue(subField, AlmaRecord.CODE);
				if (subCode != null && !subCode.isEmpty() && isEnumerationOrChronology(subCode)) {
					subFieldCounter++;
					signature.append(subCode);
				}
			}
		}
		log.trace("wantedSignature={}, signature={}, subFieldCounter={}",wantedSignature, signature, subFieldCounter);
		if (wantedSignature.equals(signature.toString())) {
			return true;
		}
		return false;
	}

	private boolean isEnumerationOrChronology(String subCode){
		if(subCode.equalsIgnoreCase("a") || subCode.equalsIgnoreCase("b") || subCode.equalsIgnoreCase("c") || subCode.equalsIgnoreCase("d") ||
				subCode.equalsIgnoreCase("i") || subCode.equalsIgnoreCase("j") || subCode.equalsIgnoreCase("k") || subCode.equalsIgnoreCase("l")) {
			return true;
		}
		return false;
	}

	@Override
	public void deleteMarcData(String marcCode) {
		Node node = rootElement.getFirstChild();
		while(node != null){

			if(findAttributeValue(node, TAG).equals(marcCode)){
				rootElement.removeChild(node);
				break;
			}
			node = node.getNextSibling();
		}
	}

	@Override
	public void deleteMarcDataValue(String marcCode, String subCode) {
		if(marcCode.startsWith("00")){
			deleteMarcData(marcCode);
		}else{
			Node node = rootElement.getFirstChild();
			while(node != null){

				if(findAttributeValue(node, TAG).equals(marcCode)){
					break;
				}
				node = node.getNextSibling();
			}
			if(node != null){
				Node child = node.getFirstChild();
				while(child != null){
					if(findAttributeValue(child, CODE).equals(subCode)){
						node.removeChild(child);
						break;
					}
					child = child.getNextSibling();
				}
			}
		}
	}

	@Override
	public void removeMarcDataByValue(String marcCode, String subCode, String value) {

		if(marcCode.startsWith("00")){
			deleteMarcData(marcCode);
		}else{
			Node node = rootElement.getFirstChild();
			while(node != null){

				if(findAttributeValue(node, TAG).equals(marcCode)){
					Node child = node.getFirstChild();
					boolean deleteThisNode = false;
					while(child != null){
						String attributeValue = findAttributeValue(child, CODE);
						if(attributeValue != null 
								&& attributeValue.equals(subCode)){
							if(child.getFirstChild().getNodeValue().equals(value)){
								deleteThisNode = true;
							}else{
								deleteThisNode = false;
								break;
							}
						}
						child = child.getNextSibling();
					}
					if(deleteThisNode){
						rootElement.removeChild(node);
					}
				}
				node = node.getNextSibling();
			}
		}
	}

	protected void setUpTransformerFactory() throws TransformerFactoryConfigurationError {
		factory = TransformerFactory.newInstance();
		trans = null;
		try {
			trans = factory.newTransformer();
		} catch (TransformerConfigurationException e) {
			log.error("Error during transformer factory configuration", e);
		}
		trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		trans.setOutputProperty(OutputKeys.INDENT, "yes");
	}


	private String findAttributeValue(Node item, String attributeName) {
		String attributeValue = "";
		NamedNodeMap attributes = item.getAttributes();
		if(attributes != null){
			for (int i = 0; i < attributes.getLength(); i++) {
				Node attribute = attributes.item(i);
				if(attribute.getNodeName().equals(attributeName)){
					attributeValue = attribute.getTextContent();
				}
			}
		}
		return attributeValue;
	}

	public static String nodeToString(Node node){
		TransformerFactory newFactory = TransformerFactory.newInstance();
		Transformer newTrans = null;
		try {
			newTrans = newFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			log.error("Error during transformer factory configuration", e);
		}
		newTrans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		newTrans.setOutputProperty(OutputKeys.INDENT, "yes");
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		DOMSource source = new DOMSource(node);
		try {
			newTrans.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		String xmlString = writer.toString();

		return xmlString;
	}

	@Override
	public String toString(){

		return nodeToString(rootElement);

	}

	@Override
	public List<String> getValues(String marcCode, String subCode) {

		List<String> values = new ArrayList<String>();

		Node node = rootElement.getFirstChild();
		while(node != null){
			if(findAttributeValue(node, TAG).equals(marcCode)){
				Node child = node.getFirstChild();
				while(child != null){
					if(findAttributeValue(child, CODE).equals(subCode)){
						values.add(child.getTextContent());
					}
					child = child.getNextSibling();
				}
			}
			node = node.getNextSibling();
		}

		return values;
	}


	@Override
	public List<Node> getMarcNodes(String marcCode) {
		List<Node> values = new ArrayList<>();
		Node node = rootElement.getFirstChild();
		while(node != null){
			if(findAttributeValue(node, TAG).equals(marcCode)){
				values.add(node);
			}
			node = node.getNextSibling();
		}
		return values;
	}




}
