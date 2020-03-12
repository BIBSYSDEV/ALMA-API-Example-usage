package no.unit.alma.bibs;

import javax.xml.bind.JAXBElement;

import no.bibsys.alma.rest.holding.Holding;

public interface AlmaHoldingsRecord extends AlmaRecord<JAXBElement<Holding>>{

	Holding getHolding();
	
	class Factory{
		
		public static AlmaHoldingsRecord create(AlmaResponse<JAXBElement<Holding>> holding){
			return new AlmaHoldingsRecordImplementation(holding);
		}
	}
}
