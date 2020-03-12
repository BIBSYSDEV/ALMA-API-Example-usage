package no.unit.alma.bibs;

import javax.xml.bind.JAXBElement;

import no.bibsys.alma.rest.bibs.Bib;

public interface AlmaBibRecord extends AlmaRecord<JAXBElement<Bib>>{

	public Bib getBib();
	
	public class Factory{
		
		public static AlmaBibRecord create(AlmaResponse<JAXBElement<Bib>> bibResponse){
			
			return new AlmaBibRecordImplementation(bibResponse);
			
		}
		
	}
}
