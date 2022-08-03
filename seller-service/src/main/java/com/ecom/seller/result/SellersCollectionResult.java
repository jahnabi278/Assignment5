package com.ecom.seller.result;

import java.util.List;

import com.ecom.seller.dto.SellerDetailsDTO;

import common.result.Result;

public class SellersCollectionResult extends Result {
	private List<SellerDetailsDTO> listOfSellers;

	public List<SellerDetailsDTO> getListOfSellers() {
		return listOfSellers;
	}

	public void setListOfSellers(List<SellerDetailsDTO> listOfSellers) {
		this.listOfSellers = listOfSellers;
	}
}
