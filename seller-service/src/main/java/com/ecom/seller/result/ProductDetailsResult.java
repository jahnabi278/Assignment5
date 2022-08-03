package com.ecom.seller.result;

import common.result.Result;
import java.util.List;
import com.ecom.seller.dto.*;

public class ProductDetailsResult extends Result {
	private List<ProductDTO> listOfProductDetails;

	public List<ProductDTO> getListOfProductDetails() {
		return listOfProductDetails;
	}

	public void setListOfProductDetails(List<ProductDTO> listOfProductDetails) {
		this.listOfProductDetails = listOfProductDetails;
	}

}
