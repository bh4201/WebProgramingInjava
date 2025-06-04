package com.cdac.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of="itemName",callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemDTO extends BaseDTO{	
	private String itemName;	
	private String itemDescription;	
	private boolean isVeg;
	private int price;
	
}
