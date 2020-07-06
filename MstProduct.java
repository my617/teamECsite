package jp.co.internous.angular.model.domain;

import java.sql.Timestamp;

public class MstProduct {

  private int id;
  private String productName;
  private String productNameKana;
  private String productDescription;
  private int categoryId;
  private int price;
  private String imageFullPath;
  private String releaseDate;
  private String releaseCompany;
  private Timestamp createdAt;
  private Timestamp upadatedAt;

  
  public int getId() {
    return id;
  }

  public Timestamp getUpadatedAt() {
    return upadatedAt;
  }

  public void setUpadatedAt(Timestamp upadatedAt) {
    this.upadatedAt = upadatedAt;
  }

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  public String getReleaseCompany() {
    return releaseCompany;
  }

  public void setReleaseCompany(String releaseCompany) {
    this.releaseCompany = releaseCompany;
  }

  public String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }

  public String getImageFullPath() {
    return imageFullPath;
  }

  public void setImageFullPath(String imageFullPath) {
    this.imageFullPath = imageFullPath;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  public String getProductNameKana() {
    return productNameKana;
  }

  public void setProductNameKana(String productNameKana) {
    this.productNameKana = productNameKana;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public void setId(int id) {
    this.id = id;
  }
}