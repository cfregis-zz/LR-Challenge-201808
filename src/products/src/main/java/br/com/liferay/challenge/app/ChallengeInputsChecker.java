package br.com.liferay.challenge.app;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.liferay.challenge.facade.ProductFacade;
import br.com.liferay.challenge.model.Product;
import br.com.liferay.challenge.model.enums.ProductType;
import br.com.liferay.challenge.util.AuxiliaryFunctions;

public class ChallengeInputsChecker {

	/**
	 * Main method to run test cases
	 * @param args
	 */
	public static void main(String[] args) {
//		testCustomRound();
		System.out.println("START PROGRAM : ");
		ProductFacade productFacade = ProductFacade.getInstance(); 
		System.out.println("----------------");
		validateInput1(productFacade);
		System.out.println("----------------");
		validateInput2(productFacade);
		System.out.println("----------------");
		validateInput3(productFacade);
		System.out.println("----------------");
		System.out.println("END PROGRAM.");
	}

	@SuppressWarnings("unused")
	private static void testCustomRound() {
		BigDecimal scale = new BigDecimal("7.60");
		System.out.println(AuxiliaryFunctions.customRound(scale));
	}

	private static void validateInput1(ProductFacade productFacade) {
//		Input 1:
//			1 book at 12.49
//			1 music CD at 14.99
//			1 chocolate bar at 0.85

		Product p1 = new Product();
		p1.setDescription("book");
		p1.setPrice(new BigDecimal("12.49"));
		p1.setImported(false);
		p1.setProductType(ProductType.BOOK);
		
		Product p2 = new Product();
		p2.setDescription("music CD");
		p2.setPrice(new BigDecimal("14.99"));
		p2.setImported(false);
		p2.setProductType(ProductType.GENERAL);
		
		Product p3 = new Product();
		p3.setDescription("chocolate bar");
		p3.setPrice(new BigDecimal("0.85"));
		p3.setImported(false);
		p3.setProductType(ProductType.FOOD);
		
		List<Product> products = new ArrayList<Product>();
		products.add(p1);
		products.add(p2);
		products.add(p3);
		productFacade.printReceiptDeails(products);
	}

	private static void validateInput2(ProductFacade productFacade) {
//		Input 2:
//			1 imported box of chocolates at 10.00
//			1 imported bottle of perfume at 47.50
		Product p1 = new Product();
		p1.setDescription("imported box of chocolates");
		p1.setPrice(new BigDecimal("10.00"));
		p1.setImported(true);
		p1.setProductType(ProductType.FOOD);
		
		Product p2 = new Product();
		p2.setDescription("imported bottle of perfume");
		p2.setPrice(new BigDecimal("47.50"));
		p2.setImported(true);
		p2.setProductType(ProductType.GENERAL);
		
		List<Product> products = new ArrayList<Product>();
		products.add(p1);
		products.add(p2);
		productFacade.printReceiptDeails(products);
	}
	
	private static void validateInput3(ProductFacade productFacade) {
//		Input 3:
//			1 imported bottle of perfume at 27.99
//			1 bottle of perfume at 18..99
//			1 packet of headache pills at 9.75
//			1 box of imported chocolates at 11.25
		Product p1 = new Product();
		p1.setDescription("imported bottle of perfume");
		p1.setPrice(new BigDecimal("27.99"));
		p1.setImported(true);
		p1.setProductType(ProductType.GENERAL);
		
		Product p2 = new Product();
		p2.setDescription("bottle of perfume");
		p2.setPrice(new BigDecimal("18.99"));
		p2.setImported(false);
		p2.setProductType(ProductType.GENERAL);
		
		Product p3 = new Product();
		p3.setDescription("packet of headache pills");
		p3.setPrice(new BigDecimal("9.75"));
		p3.setImported(false);
		p3.setProductType(ProductType.MEDICAL);
		
		Product p4 = new Product();
		p4.setDescription("box of imported chocolates");
		p4.setPrice(new BigDecimal("11.25"));
		p4.setImported(true);
		p4.setProductType(ProductType.FOOD);

		List<Product> products = new ArrayList<Product>();
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		productFacade.printReceiptDeails(products);
	}
}
