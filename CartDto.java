package jp.co.internous.angular.model.domain.dto;

import jp.co.internous.angular.model.domain.MstProduct;
import jp.co.internous.angular.model.domain.TblCart;

public class CartDto {

	private int id;
	private int userId;
	private int productId;
	private String imageFullPath;
	private String productName;
	private int price;
	private int productCount;
	
	public CartDto() {}
	
	public CartDto(TblCart cart) {
		MstProduct p = cart.getProductList().get(0);
		this.setId(cart.getId());
		this.setImageFullPath(p.getImageFullPath());
		this.setProductName(p.getProductName());
		this.setPrice(p.getPrice());
		this.setProductCount(cart.getProductCount());
		this.setUserId(cart.getUserId());
		this.setProductId(cart.getProductId());
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getImageFullPath() {
		return imageFullPath;
	}
	public void setImageFullPath(String imageFullPath) {
		this.imageFullPath = imageFullPath;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}


}
