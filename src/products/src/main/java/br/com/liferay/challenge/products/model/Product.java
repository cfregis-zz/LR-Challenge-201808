package br.com.liferay.challenge.products.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.liferay.challenge.products.model.enums.ProductType;


@Entity
@Table(name = "product")
@DynamicUpdate
@JsonIgnoreProperties({ "id" })
@SequenceGenerator(initialValue = 1, name = "userGen", sequenceName = "userGen", allocationSize = 1)
public class Product {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userGen")
	private Integer id;
	
	@Version
    private Integer version;
	
	@NotNull
	@Size(max = 254)
	@Column(name = "description", nullable = false, length = 254)
	private String description;
	
	@NotNull
	@Column(name="price", nullable = false)
	private BigDecimal price;
	
	@Column(name="finalPrice", nullable = false)
	private BigDecimal finalPrice;
	
	@Column(name="taxPrice", nullable = false)
	private BigDecimal taxPrice;
	
	@NotNull
	@Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "smallint")
	private ProductType productType = ProductType.GENERAL;
	
	@NotNull
	@Column(name="imported", nullable = false)
	private Boolean imported = false;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public BigDecimal getTaxPrice() {
		return taxPrice;
	}

	public void setTaxPrice(BigDecimal taxPrice) {
		this.taxPrice = taxPrice;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "1 "+ description + ": " + finalPrice.doubleValue();
	}	
		
}
