package com.ecom.seller.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.seller.dto.ProductDTO;
import com.ecom.seller.dto.SellerDetailsDTO;

@Repository
public interface SellerRepository extends JpaRepository<SellerDetailsDTO, String> {

	List<ProductDTO> findByProductName(String productName);

}
