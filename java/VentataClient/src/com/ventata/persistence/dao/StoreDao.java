package com.ventata.persistence.dao;

import com.ventata.persistence.domain.Store;

public interface StoreDao {
	
	public Store createStore(String json, String yourCompanyAPIKey);
	
	public Store updateStore(String json, String ventataCompanyAPIKey);
	
	public Store findStore(String ventataStoreId, String ventataCompanyAPIKey);
	
	public void deleteStore(String ventataStoreId, String ventataCompanyAPIKey);

}
