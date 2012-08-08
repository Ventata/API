package com.ventata.persistence.domain;

public class Product {
	
	 private float Cost;
	 private int CurrentSupply; 
	 private String DateAvailable;
	 private String DateExpires;
	 private String Description;
	 private String MANUCODE;
	 private float MaxPrice;
	 private float MinPrice;
	 private String Name;
	 private float Price;
	 private String SKU;
	 private int StartingSupply;
	 private String Strategy;
	 private String Id;
	/**
	 * 
	 */
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param cost
	 * @param currentSupply
	 * @param dateAvailable
	 * @param dateExpires
	 * @param description
	 * @param mANUCODE
	 * @param maxPrice
	 * @param minPrice
	 * @param name
	 * @param price
	 * @param sKU
	 * @param startingSupply
	 * @param strategy
	 */
	public Product(float cost, int currentSupply, String dateAvailable,
			String dateExpires, String description, String mANUCODE,
			float maxPrice, float minPrice, String name, float price,
			String sKU, int startingSupply, String strategy, String id) {
		super();
		Cost = cost;
		CurrentSupply = currentSupply;
		DateAvailable = dateAvailable;
		DateExpires = dateExpires;
		Description = description;
		MANUCODE = mANUCODE;
		MaxPrice = maxPrice;
		MinPrice = minPrice;
		Name = name;
		Price = price;
		SKU = sKU;
		StartingSupply = startingSupply;
		Strategy = strategy;
		Id = id;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [Cost=" + Cost + ", CurrentSupply=" + CurrentSupply
				+ ", DateAvailable=" + DateAvailable + ", DateExpires="
				+ DateExpires + ", Description=" + Description + ", MANUCODE="
				+ MANUCODE + ", MaxPrice=" + MaxPrice + ", MinPrice="
				+ MinPrice + ", Name=" + Name + ", Price=" + Price + ", SKU="
				+ SKU + ", StartingSupply=" + StartingSupply + ", Strategy="
				+ Strategy + "]";
	}
	/**
	 * @return the cost
	 */
	public float getCost() {
		return Cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(float cost) {
		Cost = cost;
	}
	/**
	 * @return the currentSupply
	 */
	public int getCurrentSupply() {
		return CurrentSupply;
	}
	/**
	 * @param currentSupply the currentSupply to set
	 */
	public void setCurrentSupply(int currentSupply) {
		CurrentSupply = currentSupply;
	}
	/**
	 * @return the dateAvailable
	 */
	public String getDateAvailable() {
		return DateAvailable;
	}
	/**
	 * @param dateAvailable the dateAvailable to set
	 */
	public void setDateAvailable(String dateAvailable) {
		DateAvailable = dateAvailable;
	}
	/**
	 * @return the dateExpires
	 */
	public String getDateExpires() {
		return DateExpires;
	}
	/**
	 * @param dateExpires the dateExpires to set
	 */
	public void setDateExpires(String dateExpires) {
		DateExpires = dateExpires;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}
	/**
	 * @return the mANUCODE
	 */
	public String getMANUCODE() {
		return MANUCODE;
	}
	/**
	 * @param mANUCODE the mANUCODE to set
	 */
	public void setMANUCODE(String mANUCODE) {
		MANUCODE = mANUCODE;
	}
	/**
	 * @return the maxPrice
	 */
	public float getMaxPrice() {
		return MaxPrice;
	}
	/**
	 * @param maxPrice the maxPrice to set
	 */
	public void setMaxPrice(float maxPrice) {
		MaxPrice = maxPrice;
	}
	/**
	 * @return the minPrice
	 */
	public float getMinPrice() {
		return MinPrice;
	}
	/**
	 * @param minPrice the minPrice to set
	 */
	public void setMinPrice(float minPrice) {
		MinPrice = minPrice;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * @return the price
	 */
	public float getPrice() {
		return Price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		Price = price;
	}
	/**
	 * @return the sKU
	 */
	public String getSKU() {
		return SKU;
	}
	/**
	 * @param sKU the sKU to set
	 */
	public void setSKU(String sKU) {
		SKU = sKU;
	}
	/**
	 * @return the startingSupply
	 */
	public int getStartingSupply() {
		return StartingSupply;
	}
	/**
	 * @param startingSupply the startingSupply to set
	 */
	public void setStartingSupply(int startingSupply) {
		StartingSupply = startingSupply;
	}
	/**
	 * @return the strategy
	 */
	public String getStrategy() {
		return Strategy;
	}
	/**
	 * @param strategy the strategy to set
	 */
	public void setStrategy(String strategy) {
		Strategy = strategy;
	}
	/**
	 * @return the Id
	 */
	public String getId() {
		return Id;
	}
	/**
	 * @param Id the Id to set
	 */
	public void setId(String id) {
		Id = id;
	}
	

 

}
