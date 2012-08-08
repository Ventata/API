package com.ventata.persistence.domain;

public class Company {
	
    private String Address1;
    private String Address2;
    private String City;
    private String DateCreated;
    private String DateModified;
    private int FaxNumber;
    private String Id; 
    private String Name;
    private int PhoneNumber;
    private String State;
    private String Zip;
	/**
	 * 
	 */
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param address1
	 * @param address2
	 * @param city
	 * @param dateCreated
	 * @param dateModified
	 * @param faxNumber
	 * @param id
	 * @param name
	 * @param phoneNumber
	 * @param state
	 * @param zip
	 */
	public Company(String address1, String address2, String city,
			String dateCreated, String dateModified, int faxNumber, String id,
			String name, int phoneNumber, String state, String zip) {
		super();
		Address1 = address1;
		Address2 = address2;
		City = city;
		DateCreated = dateCreated;
		DateModified = dateModified;
		FaxNumber = faxNumber;
		Id = id;
		Name = name;
		PhoneNumber = phoneNumber;
		State = state;
		Zip = zip;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Company [Address1=" + Address1 + ", Address2=" + Address2
				+ ", City=" + City + ", DateCreated=" + DateCreated
				+ ", DateModified=" + DateModified + ", FaxNumber=" + FaxNumber
				+ ", Id=" + Id + ", Name=" + Name + ", PhoneNumber="
				+ PhoneNumber + ", State=" + State + ", Zip=" + Zip + "]";
	}
	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return Address1;
	}
	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		Address1 = address1;
	}
	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return Address2;
	}
	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		Address2 = address2;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return City;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		City = city;
	}
	/**
	 * @return the dateCreated
	 */
	public String getDateCreated() {
		return DateCreated;
	}
	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(String dateCreated) {
		DateCreated = dateCreated;
	}
	/**
	 * @return the dateModified
	 */
	public String getDateModified() {
		return DateModified;
	}
	/**
	 * @param dateModified the dateModified to set
	 */
	public void setDateModified(String dateModified) {
		DateModified = dateModified;
	}
	/**
	 * @return the faxNumber
	 */
	public int getFaxNumber() {
		return FaxNumber;
	}
	/**
	 * @param faxNumber the faxNumber to set
	 */
	public void setFaxNumber(int faxNumber) {
		FaxNumber = faxNumber;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		Id = id;
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
	 * @return the phoneNumber
	 */
	public int getPhoneNumber() {
		return PhoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(int phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return State;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		State = state;
	}
	/**
	 * @return the zip
	 */
	public String getZip() {
		return Zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		Zip = zip;
	}
    
    

}
