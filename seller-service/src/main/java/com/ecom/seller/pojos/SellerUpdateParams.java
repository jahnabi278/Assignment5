package com.ecom.seller.pojos;

public class SellerUpdateParams {
	private String sellerId;
	private int productStockNumber;
	private float price;

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
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
