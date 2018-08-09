package br.com.liferay.challenge.facade;

import java.util.List;

import br.com.liferay.challenge.bussinessobject.ProductBusinessObject;
import br.com.liferay.challenge.model.Product;

public class ProductFacade {

	private static ProductFacade productFacade = null;
	
	private ProductBusinessObject productBusinessObject;
	
	public static ProductFacade getInstance() {
		 if(productFacade == null) {
	         productFacade = new ProductFacade();
	      }
	      return productFacade;
	}

	private ProductFacade() {
		productBusinessObject = new ProductBusinessObject();
	}

	public void printReceiptDeails(List<Product> products) {
		productBusinessObject.printReceiptDeails(products);
	}
		
	
}
