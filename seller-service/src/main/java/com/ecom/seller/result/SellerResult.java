package com.ecom.seller.result;

import com.ecom.seller.dto.SellerDetailsDTO;

import common.result.Result;

public class SellerResult extends Result {
	private SellerDetailsDTO sellerdetailsDto;

	public SellerDetailsDTO getSellerdetailsDto() {
		return sellerdetailsDto;
	}

	public void setSellerdetailsDto(SellerDetailsDTO sellerdetailsDto) {
		this.sellerdetailsDto = sellerdetailsDto;
	}
}
