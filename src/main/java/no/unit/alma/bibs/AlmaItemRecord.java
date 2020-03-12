package no.unit.alma.bibs;

import no.bibsys.alma.rest.items.Item;

public interface AlmaItemRecord{

	public Item getItem();
	public AlmaResponse<Item> getResponse();
	
	class Factory{
		
		public static AlmaItemRecord create(AlmaResponse<Item> item){
			return new AlmaItemRecordImplementation(item);
		}
	}

}
