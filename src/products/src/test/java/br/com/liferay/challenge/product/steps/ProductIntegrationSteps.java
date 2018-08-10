package br.com.liferay.challenge.product.steps;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import br.com.liferay.challenge.product.ProductIntegrationDefs;
import br.com.liferay.challenge.products.model.Product;
import br.com.liferay.challenge.products.model.enums.ProductType;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author Carlos Filipe
 * BDD Tests
 */
public class ProductIntegrationSteps extends ProductIntegrationDefs{
	
	private List<Product> products;
	private BigDecimal priceBigDecimal;
	private BigDecimal priceSalesTax;
	
	
	@Before
    public void setUp() throws Exception{
		deletion.deleteAll();
    }
	
	@After
	public void tearDown() {
		deletion.deleteAll();
	}
	
	
	@Given("^existing (\\d+) products in database$")
	public void existing_products_in_database(int prodListSize) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		switch (prodListSize)
		{
		     case 2:
		    	 createProductsScenario1();
		     case 3:
		    	 createProductsScenario2();
		     case 4:
		    	 createProductsScenario3();
		     default:
		    	 ;
		    	 
		}
	}

	@When("^run list products, after products creation process$")
	public void run_list_products_after_products_creation_process() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		products = this.productFacade.list();
	}

	@Then("^the facade should return \"([^\"]*)\" price And  \"([^\"]*)\" sales tax$")
	public void the_facade_should_return_price_And_sales_tax(String price, String salesTax) throws
	 Throwable {
	    // Write code here that turns the phrase above into concrete actions
		priceBigDecimal = new BigDecimal(price);
		priceSalesTax = new BigDecimal(salesTax);
		assertEquals(priceBigDecimal, this.productFacade.salesTaxesFromlist(products));
		assertEquals(priceSalesTax, this.productFacade.totalSumPricelist(products));
	}

	
	private void createProductsScenario1() {
		Product p1 = new Product();
		p1.setDescription("book");
		p1.setPrice(new BigDecimal("12.49"));
		p1.setImported(false);
		p1.setProductType(ProductType.BOOK);
		this.productFacade.registerNewProduct(p1);
		
		Product p2 = new Product();
		p2.setDescription("music CD");
		p2.setPrice(new BigDecimal("14.99"));
		p2.setImported(false);
		p2.setProductType(ProductType.GENERAL);
		this.productFacade.registerNewProduct(p2);
		
		Product p3 = new Product();
		p3.setDescription("chocolate bar");
		p3.setPrice(new BigDecimal("0.85"));
		p3.setImported(false);
		p3.setProductType(ProductType.FOOD);
		this.productFacade.registerNewProduct(p3);
	}
	
	private void createProductsScenario2() {
		Product p1 = new Product();
		 p1.setDescription("imported box of chocolates");
		 p1.setPrice(new BigDecimal("10.00"));
		 p1.setImported(true);
		 p1.setProductType(ProductType.FOOD);
		 this.productFacade.registerNewProduct(p1);
		 
		 Product p2 = new Product();
		 p2.setDescription("imported bottle of perfume");
		 p2.setPrice(new BigDecimal("47.50"));
		 p2.setImported(true);
		 p2.setProductType(ProductType.GENERAL);
		 this.productFacade.registerNewProduct(p2);
	}
	
	private void createProductsScenario3() {
		Product p1 = new Product();
		p1.setDescription("imported bottle of perfume");
		p1.setPrice(new BigDecimal("27.99"));
		p1.setImported(true);
		p1.setProductType(ProductType.GENERAL);
		this.productFacade.registerNewProduct(p1);
		
		Product p2 = new Product();
		p2.setDescription("bottle of perfume");
		p2.setPrice(new BigDecimal("18.99"));
		p2.setImported(false);
		p2.setProductType(ProductType.GENERAL);
		this.productFacade.registerNewProduct(p2);
		
		Product p3 = new Product();
		p3.setDescription("packet of headache pills");
		p3.setPrice(new BigDecimal("9.75"));
		p3.setImported(false);
		p3.setProductType(ProductType.MEDICAL);
		this.productFacade.registerNewProduct(p3);
		
		Product p4 = new Product();
		p4.setDescription("box of imported chocolates");
		p4.setPrice(new BigDecimal("11.25"));
		p4.setImported(true);
		p4.setProductType(ProductType.FOOD);
		this.productFacade.registerNewProduct(p4);
	}
}
