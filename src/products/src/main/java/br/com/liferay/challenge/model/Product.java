package br.com.liferay.challenge.model;

import java.math.BigDecimal;

import br.com.liferay.challenge.model.enums.ProductType;

public class Product {

	private String description;
	private BigDecimal price;
	private BigDecimal finalPrice;
	private ProductType productType = ProductType.GENERAL;
	private Boolean imported = false;
	
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public ProductType getProductType() {
		return productType;
	}
	
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public Boolean getImported() {
		return imported;
	}

	public void setImported(Boolean imported) {
		this.imported = imported;
	}

	public BigDecimal getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(BigDecimal finalPrice) {
		this.finalPrice = finalPrice;
	}

	@Override
	public String toString() {
		return "1 "+ description + ": " + finalPrice.doubleValue();
	}
	
	
		
}
