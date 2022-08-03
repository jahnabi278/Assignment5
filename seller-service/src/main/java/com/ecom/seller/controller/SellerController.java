package com.ecom.seller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.seller.dto.SellerDetailsDTO;
import com.ecom.seller.pojos.SellerUpdateParams;
import com.ecom.seller.result.ProductDetailsResult;
import com.ecom.seller.result.SellerResult;
import com.ecom.seller.result.SellersCollectionResult;
import com.ecom.seller.service.SellerService;

import common.result.Result;

@RestController
@RequestMapping("api/v1/ecommerce/seller")
public class SellerController {
	@Autowired
	SellerService sellerService;

	@PostMapping
	public Result createStore(@RequestBody SellerDetailsDTO sellerDetails) {
		return sellerService.saveSellerDetails(sellerDetails);
	}

	@PutMapping
	public Result updateStore(@RequestBody SellerUpdateParams sellerUpdateParam) {
		return sellerService.updateSellerDetails(sellerUpdateParam);
	}

	@GetMapping
	public SellersCollectionResult getAll() {
		return sellerService.getAllSellerDetails();
	}

	@GetMapping("/{id}")
	public SellerResult getById(@PathVariable String id) {
		return sellerService.getSellerDetailsById(id);
	}

	@GetMapping("/name/{productName}")
	public ProductDetailsResult getProductBasedOnProductName(@PathVariable String productName) {
		return sellerService.getProductBasedOnProductName(productName);
	}
}
