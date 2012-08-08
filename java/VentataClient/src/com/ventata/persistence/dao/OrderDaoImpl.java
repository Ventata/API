package com.ventata.persistence.dao;

import net.sf.json.JSONObject;

import com.ventata.persistence.domain.Order;
import com.ventata.persistence.utils.HttpMethodType;
import com.ventata.persistence.utils.MyUtils;
import com.ventata.persistence.utils.ServiceURLs;

public class OrderDaoImpl implements OrderDao {

	@Override
	public Order createOrder(String json, String ventataStoreAPIKey) {

		String baseURL=ServiceURLs.orderCreateUrl;
        	String resource = baseURL.replace("{param0}",ventataStoreAPIKey);
        	MyUtils util=new MyUtils();
        	String jsonResponse = util.createRequestRW(json, resource, HttpMethodType.POST.toString());
        	JSONObject jsonObj= JSONObject.fromObject(jsonResponse);
        	return (Order)(JSONObject.toBean(jsonObj,Order.class));
	}

	@Override
	public Order findOrder(String ventataOrderId, String ventataStoreAPIKey){

		String baseURL=ServiceURLs.orderReadUrl;
		baseURL=baseURL.replace("{param0}", ventataOrderId);
        	String resource = baseURL.replace("{param1}",ventataStoreAPIKey);
        	MyUtils util=new MyUtils();
        	String jsonResponse = util.createRequestR( resource, HttpMethodType.GET.toString());
        	JSONObject jsonObj= JSONObject.fromObject(jsonResponse);
        	return (Order)(JSONObject.toBean(jsonObj,Order.class));
	}

	@Override
	public void deleteOrder(String ventataOrderId, String ventataStoreAPIKey){

		String baseURL=ServiceURLs.orderDeleteUrl;
		baseURL=baseURL.replace("{param0}", ventataOrderId);
        	String resource = baseURL.replace("{param1}",ventataStoreAPIKey);
        	MyUtils util=new MyUtils();
        	util.createRequestR( resource, HttpMethodType.DELETE.toString());

	}

}
