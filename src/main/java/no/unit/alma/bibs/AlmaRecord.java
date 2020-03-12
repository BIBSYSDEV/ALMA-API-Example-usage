package no.unit.alma.bibs;

import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public interface AlmaRecord<E> {
	
	
	static final String LEADER = "leader";
	static final String CONTROLFIELD = "controlfield";
	static final String DATAFIELD = "datafield";
	static final String SUBFIELD = "subfield";
	static final String IND2 = "ind2";
	static final String IND1 = "ind1";
	static final String TAG = "tag";
	static final String CODE = "code";
	
	

	void addControlField(String marcCode, String value);
	
	void deleteMarcData(String marcCode);

	void deleteMarcDataValue(String marcCode, String subCode);

	List<String> getValues(String marcCode, String subCode);
	
	List<Node> getMarcNodes(String marcCode);
	
	void addNewMarcData(Node marcDataNode);

	void addNewMarcData(Node marcDataNode, boolean clone);

	void removeMarcDataByValue(String marcCode, String subCode, String value);
	
	Node createDataField(String marcCode, String subCode, String value,	String indicator1, String indicator2);

	Element createSubField(String subCode, String value);
	
	boolean hasSameSignature(Node node, String subCodes);

	boolean hasSameEnumerationAndChronologySignature(Node node, String subCodes);

	AlmaResponse<E> response();
}
