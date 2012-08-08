package com.ventata.persistence.dao;

import com.ventata.persistence.domain.Order;

public interface OrderDao {
	
    public Order createOrder(String json, String ventataStoreAPIKey);
    
	public Order findOrder(String ventataOrderId, String ventataStoreAPIKey);
	
	public void deleteOrder(String ventataOrderId, String ventataStoreAPIKey);
	

}
