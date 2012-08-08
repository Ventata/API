package com.ventata.persistence.domain;

public class Store {

	private String Name;
	private String URL;
	private StoreType StoreType;
	private String ApiKey;
	private String Id;	
	/**
	 * 
	 */
	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param name
	 * @param uRL
	 * @param storeType
	 */
	public Store(String name, String uRL,
			com.ventata.persistence.domain.StoreType storeType, String apiKey, String id) {
		super();
		Name = name;
		URL = uRL;
		StoreType = storeType;
		ApiKey = apiKey;
		Id = id;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Store [Name=" + Name + ", URL=" + URL + ", StoreType="
				+ StoreType + "]";
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
	 * @return the uRL
	 */
	public String getURL() {
		return URL;
	}
	/**
	 * @param uRL the uRL to set
	 */
	public void setURL(String uRL) {
		URL = uRL;
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
	 * @return the apiKey
	 */
	public String getApiKey() {
		return ApiKey;
	}
	/**
	 * @param apiKey the apiKey to set
	 */
	public void setApiKey(String apiKey) {
		ApiKey = apiKey;
	}
	/**
	 * @return the storeType
	 */
	public StoreType getStoreType() {
		return StoreType;
	}
	/**
	 * @param storeType the storeType to set
	 */
	public void setStoreType(StoreType storeType) {
		StoreType = storeType;
	}
	
	
}
