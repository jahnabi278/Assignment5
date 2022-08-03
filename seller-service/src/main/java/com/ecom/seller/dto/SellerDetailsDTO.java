package com.ecom.seller.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "sellerDetails")

public class SellerDetailsDTO {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String sellerId;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ProductDTO> listOfProductDetails;

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public List<ProductDTO> getListOfProductDetails() {
		return listOfProductDetails;
	}

	public void setListOfProductDetails(List<ProductDTO> listOfProductDetails) {
		this.listOfProductDetails = listOfProductDetails;
	}

}
