package no.unit.alma.bibs;

import no.bibsys.alma.rest.items.Item;

public class AlmaItemRecordImplementation implements AlmaItemRecord {

	private Item item;
	private AlmaResponse<Item> almaResponse;

	public AlmaItemRecordImplementation(AlmaResponse<Item> almaResponse) {
		this.almaResponse = almaResponse;
		this.item = almaResponse.resultObject();
		
	}

	@Override
	public String toString() {
		return "AlmaItemRecord [item=" + item + "]";
	}

	@Override
	public Item getItem() {
		return item;
	}

	@Override
	public AlmaResponse<Item> getResponse() {
		return almaResponse;
	}
	
}
