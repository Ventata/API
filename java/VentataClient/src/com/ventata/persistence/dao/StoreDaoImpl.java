package com.ventata.persistence.dao;

import net.sf.json.JSONObject;

import com.ventata.persistence.domain.Store;
import com.ventata.persistence.utils.HttpMethodType;
import com.ventata.persistence.utils.MyUtils;
import com.ventata.persistence.utils.ServiceURLs;

public class StoreDaoImpl implements StoreDao {

	@Override
	public Store createStore(String json, String yourCompanyAPIKey) {

		String baseURL=ServiceURLs.storeCreateUrl;
        	String resource = baseURL.replace("{param0}", yourCompanyAPIKey);
        	MyUtils util=new MyUtils();
        	String jsonResponse = util.createRequestRW(json, resource, HttpMethodType.POST.toString());
        	JSONObject jsonObj= JSONObject.fromObject(jsonResponse);
        	return (Store)(JSONObject.toBean(jsonObj,Store.class));
	}

	@Override
	public Store updateStore(String json, String ventataCompanyAPIKey) {

		String baseURL=ServiceURLs.storeUpdateUrl;
        	String resource = baseURL.replace("{param0}",ventataCompanyAPIKey);
        	MyUtils util=new MyUtils();
        	String jsonResponse = util.createRequestR( resource, HttpMethodType.PUT.toString());
        	JSONObject jsonObj= JSONObject.fromObject(jsonResponse);
        	return (Store)(JSONObject.toBean(jsonObj,Store.class));
	}

	@Override
	public Store findStore(String ventataStoreId, String ventataCompanyAPIKey) {

		String baseURL=ServiceURLs.storeReateUrl;
		baseURL=baseURL.replace("{param0}",ventataStoreId);
        	String resource = baseURL.replace("{param1}",ventataCompanyAPIKey);
        	MyUtils util=new MyUtils();
        	String jsonResponse = util.createRequestR( resource, HttpMethodType.GET.toString());
        	JSONObject jsonObj= JSONObject.fromObject(jsonResponse);
        	return (Store)(JSONObject.toBean(jsonObj,Store.class));
	}

	@Override
	public void deleteStore(String ventataStoreId, String ventataCompanyAPIKey) {

		String baseURL=ServiceURLs.storeDeleteUrl;
		baseURL=baseURL.replace("{param0}",ventataStoreId);
        	String resource = baseURL.replace("{param1}",ventataCompanyAPIKey);
        	MyUtils util=new MyUtils();
        	util.createRequestR( resource, HttpMethodType.DELETE.toString());
	}

}
