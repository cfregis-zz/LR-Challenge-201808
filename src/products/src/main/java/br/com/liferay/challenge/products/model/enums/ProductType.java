package br.com.liferay.challenge.products.model.enums;

import java.util.ArrayList;
import java.util.List;

public enum ProductType {

  	GENERAL("General Product",1),
    BOOK("Book",2),
    FOOD("Food",3),
    MEDICAL("Medical Product",4);

    private String description;
    private int value;

    ProductType(String description,int value) {
        this.description = description;
        this.value = value;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public static List<ProductType> getAllValues(){
		List<ProductType> list = new ArrayList<>();
		for (ProductType productType : ProductType.values()) {
			list.add(productType);
		}	
		return list ;
	}
    
}