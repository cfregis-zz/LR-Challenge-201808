package br.com.liferay.challenge.products.bussinessobject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.liferay.challenge.foundation.util.AuxiliaryFunctions;
import br.com.liferay.challenge.products.model.Product;
import br.com.liferay.challenge.products.model.enums.ProductType;
import br.com.liferay.challenge.products.repository.ProductRepository;

@Component
public class ProductBusinessObject {
	
	@Autowired
	private ProductRepository productRepository;

	public void printReceiptDeails(List<Product> products) {
		BigDecimal totalPrice = new BigDecimal(0.00);
		BigDecimal taxPrice = new BigDecimal(0.00);
		
		for (Product product : products) {
			computeTaxPrice(product);
			System.out.println(product.toString());
			taxPrice = taxPrice.add(product.getTaxPrice());
			totalPrice = totalPrice.add(product.getFinalPrice());
		}
		
		totalPrice = totalPrice.setScale(2, RoundingMode.HALF_UP);
		System.out.println("Sales Taxes: "+ taxPrice.doubleValue() 
			+" \nTotal: " + totalPrice.doubleValue() );
	}

	private Product computeTaxPrice(Product product) {
		//by default tax is 10%
		Double taxFactor = 0.1;
		if(product.getProductType().equals(ProductType.BOOK)
				||product.getProductType().equals(ProductType.FOOD)
				||product.getProductType().equals(ProductType.MEDICAL)){
			
			//this kind of products that are exempt
			taxFactor = 0.00;
		}
		
		//an additional tax on all imported goods at a rate 5%
		if(product.getImported()){
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
		product.setTaxPrice(prodTaxPrice);
		return product;
	}

	public List<Product> list() {
		return (List<Product>) productRepository.findAll();
	}

	public Product findById(Integer id) {
		return productRepository.findById(id).get();
	}

	public Product registerNewProduct(Product product) {
		computeTaxPrice(product);
		return productRepository.save(product);
	}

	public Product update(Product product) {
		computeTaxPrice(product);
		return productRepository.save(product);
	}

	public BigDecimal salesTaxesFromlist(List<Product> listProducts) {
		return listProducts.stream()
				.map(Product::getTaxPrice)
		        .reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public BigDecimal totalSumPricelist(List<Product> listProducts) {
		return listProducts.stream()
				.map(Product::getFinalPrice)
		        .reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	

}
