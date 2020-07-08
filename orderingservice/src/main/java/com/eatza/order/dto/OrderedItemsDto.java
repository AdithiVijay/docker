package com.eatza.order.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data @NoArgsConstructor
public class OrderedItemsDto {
	
	private long itemId;
	private int quantity;
	


	public OrderedItemsDto(long itemId, int quantity) {
		super();
		this.itemId = itemId;
		this.quantity = quantity;
	}


}
