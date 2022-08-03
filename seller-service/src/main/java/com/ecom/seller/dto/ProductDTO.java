package com.ecom.seller.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "product")
public class ProductDTO {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String productId;
	@NotBlank(message = "Product Name can not be null or empty !")
	private String productName;
	private String productMake;
	@NotBlank(message = "Product model can not be null or empty !")
	private String productModel;
	private int productStockNumber;
	@Min(value = 1, message = "Price can not be negative")
	private float price;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductMake() {
		return productMake;
	}

	public void setProductMake(String productMake) {
		this.productMake = productMake;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public int getProductStockNumber() {
		return productStockNumber;
	}

	public void setProductStockNumber(int productStockNumber) {
		this.productStockNumber = productStockNumber;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
