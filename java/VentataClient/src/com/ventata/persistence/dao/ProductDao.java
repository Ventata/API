/**
 * 
 */
package com.ventata.persistence.dao;

import com.ventata.persistence.domain.Product;

/**
 * @author ehab
 *
 */
public interface ProductDao {
	
	public Product createProduct(String json, String ventataStoreAPIKey);
	
	public Product updateProduct(String json, String ventataStoreAPIKey);
	
	public Product findProduct(String ventataProductId, String ventataStoreAPIKey);
	
	public void deleteProduct(String ventataProductId, String ventataStoreAPIKey);
	
	public String getPriceHistoryt(String ventataProductId, String ventataStoreAPIKey);
	
	public Product getNewPrice(String ventataProductId, String ventataStoreAPIKey);
	

}
