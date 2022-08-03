package com.ecom.seller.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecom.seller.dto.ProductDTO;
import com.ecom.seller.dto.SellerDetailsDTO;
import com.ecom.seller.pojos.SellerUpdateParams;
import com.ecom.seller.repo.SellerRepository;
import com.ecom.seller.result.ProductDetailsResult;
import com.ecom.seller.result.SellerResult;
import com.ecom.seller.result.SellersCollectionResult;

import common.errormessages.ErrorMessages;
import common.result.Result;

@Service
public class SellerService {

	@Autowired
	SellerRepository sellerRepository;

	public Result saveSellerDetails(SellerDetailsDTO sellerDetails) {
		sellerRepository.save(sellerDetails);
		return new Result(200, ErrorMessages.SAVE_SUCCESSFUL);
	}

	public Result updateSellerDetails(SellerUpdateParams sellerUpdateParam) {
		Optional<SellerDetailsDTO> response = sellerRepository.findById(sellerUpdateParam.getSellerId());
		SellerDetailsDTO sellerDetails = response.get();
		List<ProductDTO> listOfSellerDetails = response.get().getListOfProductDetails();
		List<ProductDTO> newProductList = new ArrayList<>();
		if (!listOfSellerDetails.isEmpty()) {
			for (ProductDTO productDTO : listOfSellerDetails) {
				productDTO.setPrice(sellerUpdateParam.getPrice());
				productDTO.setProductStockNumber(sellerUpdateParam.getProductStockNumber());
				newProductList.add(productDTO);
			}
			sellerDetails.setListOfProductDetails(newProductList);
			sellerRepository.save(sellerDetails);
			return new Result(200, ErrorMessages.UPDATE_SUCCESSFUL);
		} else {
			return new Result(404, ErrorMessages.NOT_FOUND);
		}
	}

	@GetMapping
	public SellersCollectionResult getAllSellerDetails() {
		SellersCollectionResult result = new SellersCollectionResult();
		List<SellerDetailsDTO> collection = sellerRepository.findAll();
		if (!collection.isEmpty()) {
			result.setListOfSellers(collection);
			result.setErrorCode(200);
			result.setErrorMessage(ErrorMessages.RETRIEVE_SUCCESSFUL);
		} else {
			result.setListOfSellers(null);
			result.setErrorCode(404);
			result.setErrorMessage(ErrorMessages.NOT_FOUND);
		}
		return result;
	}

	public SellerResult getSellerDetailsById(String id) {
		SellerResult result = new SellerResult();
		Optional<SellerDetailsDTO> sellerDetails = sellerRepository.findById(id);
		if (!sellerDetails.isEmpty()) {
			result.setErrorCode(200);
			result.setErrorMessage(ErrorMessages.RETRIEVE_SUCCESSFUL);
			result.setSellerdetailsDto(sellerDetails.get());
		} else {
			result.setErrorCode(404);
			result.setErrorMessage(ErrorMessages.NOT_FOUND);
			result.setSellerdetailsDto(null);
		}
		return result;
	}

	public ProductDetailsResult getProductBasedOnProductName(String productName) {
		ProductDetailsResult result = new ProductDetailsResult();
		List<ProductDTO> listOfProductDetails = sellerRepository.findByProductName(productName);
		if (listOfProductDetails != null) {
			result.setErrorCode(200);
			result.setErrorMessage(ErrorMessages.RETRIEVE_SUCCESSFUL);
			result.setListOfProductDetails(listOfProductDetails);
		} else {
			result.setErrorCode(404);
			result.setErrorMessage(ErrorMessages.NOT_FOUND);
			result.setListOfProductDetails(null);
		}
		return result;
	}

}
