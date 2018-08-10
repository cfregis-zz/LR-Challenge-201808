package br.com.liferay.challenge.products.facade;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.liferay.challenge.products.bussinessobject.ProductBusinessObject;
import br.com.liferay.challenge.products.model.Product;

@Component
public class ProductFacade {

	@Autowired
	private ProductBusinessObject productBusinessObject;
	
	public void printReceiptDeails(List<Product> products) {
		productBusinessObject.printReceiptDeails(products);
	}

	public List<Product> list() {
		return productBusinessObject.list();
	}

	public Product findById(Integer id) {
		return productBusinessObject.findById(id);
	}

	public Product registerNewProduct(Product product) {
		return productBusinessObject.registerNewProduct(product);
	}

	public Product update(Product product) {
		return productBusinessObject.update(product);
	}

	public BigDecimal salesTaxesFromlist(List<Product> listProducts) {
		return productBusinessObject.salesTaxesFromlist(listProducts);
	}

	public BigDecimal totalSumPricelist(List<Product> listProducts) {
		return productBusinessObject.totalSumPricelist(listProducts);
	}
		
	
}
