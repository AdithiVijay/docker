package com.eatza.restaurantsearch.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data @NoArgsConstructor
public class ItemRequestDto {
	
	private Long menuId;
	private String name;
	private String description;
	private int price;
	


}
