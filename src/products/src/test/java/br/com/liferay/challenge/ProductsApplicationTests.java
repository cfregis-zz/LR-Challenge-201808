package br.com.liferay.challenge;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.liferay.challenge.products.facade.ProductFacade;
import br.com.liferay.challenge.products.model.Product;
import br.com.liferay.challenge.products.model.enums.ProductType;

/**
 * 
 * @author Carlos Filipe
 * Unit Tests
 */
@RunWith(SpringRunner.class)
@ContextConfiguration()
@SpringBootTest(classes = ProductsApplication.class)
public class ProductsApplicationTests {

	@Autowired
	protected ProductFacade productFacade;
	
	@Test
	public void contextLoads() {
	}

	
	/**
	 * Books are exempt
	 */
	@Test
	public void testProductInsertion1() {
		Product p1 = new Product();
		p1.setDescription("book");
		p1.setPrice(new BigDecimal("12.49"));
		p1.setImported(false);
		p1.setProductType(ProductType.BOOK);
		this.productFacade.registerNewProduct(p1);
		p1 = productFacade.registerNewProduct(p1);
		assertEquals(new BigDecimal("0.00"), p1.getTaxPrice());
		assertEquals(new BigDecimal("12.49"), p1.getFinalPrice());
	}
	
	/**
	 * General are 10% taxed
	 */
	@Test
	public void testProductInsertion2() {

		Product p2 = new Product();
		p2.setDescription("music CD");
		p2.setPrice(new BigDecimal("14.99"));
		p2.setImported(false);
		p2.setProductType(ProductType.GENERAL);
		p2 = this.productFacade.registerNewProduct(p2);
		assertEquals(new BigDecimal("1.50"), p2.getTaxPrice());
		assertEquals(new BigDecimal("16.49"), p2.getFinalPrice());
	
		
	}
	
	/**
	 * Imported are 5% taxed
	 */
	@Test
	public void testProductInsertion3() {
		Product p1 = new Product();
		p1.setDescription("imported box of chocolates");
		p1.setPrice(new BigDecimal("10.00"));
		p1.setImported(true);
		p1.setProductType(ProductType.FOOD);
		p1 = productFacade.registerNewProduct(p1);
		assertEquals(new BigDecimal("0.50"), p1.getTaxPrice());
		assertEquals(new BigDecimal("10.50"), p1.getFinalPrice());
	}
}

