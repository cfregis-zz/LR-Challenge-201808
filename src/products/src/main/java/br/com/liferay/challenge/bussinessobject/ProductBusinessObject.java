package br.com.liferay.challenge.bussinessobject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import br.com.liferay.challenge.model.Product;
import br.com.liferay.challenge.model.enums.ProductType;
import br.com.liferay.challenge.util.AuxiliaryFunctions;

public class ProductBusinessObject {

	public void printReceiptDeails(List<Product> products) {
		BigDecimal totalPrice = new BigDecimal(0.00);
		BigDecimal taxPrice = new BigDecimal(0.00);
		
		for (Product product : products) {
			//by default tax is 10%
			Double taxFactor = 0.1;
			if(product.getProductType().equals(ProductType.BOOK)
					||product.getProductType().equals(ProductType.FOOD)
					||product.getProductType().equals(ProductType.MEDICAL)){
				
				//this kind of products that are exempt
				taxFactor = 0.00;
			}
			
			//an additional tax on all imported goods at a rate 5%
			if(product.getImported() == true){
				taxFactor = taxFactor + 0.05;
			}
			
			BigDecimal multiplicand = new BigDecimal(taxFactor.toString());
			BigDecimal prodTaxPrice = product.getPrice().multiply(multiplicand);
			prodTaxPrice = AuxiliaryFunctions.customRound(prodTaxPrice);
			
			if(prodTaxPrice.doubleValue() > 0){
				BigDecimal finalPrice = product.getPrice().add(prodTaxPrice);
				finalPrice = finalPrice.setScale(2, RoundingMode.HALF_UP);
				product.setFinalPrice(finalPrice);
			} else {
				product.setFinalPrice(product.getPrice());
			}
			
			
			System.out.println(product.toString());
			taxPrice = taxPrice.add(prodTaxPrice);
			totalPrice = totalPrice.add(product.getFinalPrice());
		}
		
		totalPrice = totalPrice.setScale(2, RoundingMode.HALF_UP);
		System.out.println("Sales Taxes: "+ taxPrice.doubleValue() 
			+" \nTotal: " + totalPrice.doubleValue() );
	}
	

}
