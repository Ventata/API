/**
 * 
 */
package com.ventata.persistence.dao;

import net.sf.json.JSONObject;

import com.ventata.persistence.domain.Product;
import com.ventata.persistence.utils.HttpMethodType;
import com.ventata.persistence.utils.MyUtils;
import com.ventata.persistence.utils.ServiceURLs;

/**
 * @author ehab
 *
 */
public class ProductDaoImpl implements ProductDao {

	/* (non-Javadoc)
	 * @see com.ventata.persistence.dao.ProductDao#createProduct(java.lang.String, java.lang.String)
	 */
	@Override
	public Product createProduct(String json, String ventataStoreAPIKey) {

		String baseURL=ServiceURLs.productCreateUrl;
        	String resource = baseURL.replace("{param0}",ventataStoreAPIKey);
        	MyUtils util=new MyUtils();
        	String jsonResponse = util.createRequestRW(json, resource, HttpMethodType.POST.toString());
        	JSONObject jsonObj= JSONObject.fromObject(jsonResponse);
        	return (Product)(JSONObject.toBean(jsonObj,Product.class));
	}

	@Override
	public Product updateProduct(String json, String ventataStoreAPIKey) {

		String baseURL=ServiceURLs.productUpdateUrl;
        	String resource = baseURL.replace("{param0}", ventataStoreAPIKey);
        	MyUtils util=new MyUtils();
        	String jsonResponse = util.createRequestR( resource, HttpMethodType.PUT.toString());
        	JSONObject jsonObj= JSONObject.fromObject(jsonResponse);
        	return (Product)(JSONObject.toBean(jsonObj,Product.class));
	}

	@Override
	public Product findProduct(String ventataProductId, String ventataStoreAPIKey) {

		String baseURL=ServiceURLs.productReateUrl;
		baseURL=baseURL.replace("{param0}",ventataProductId);
        	String resource = baseURL.replace("{param1}",ventataStoreAPIKey);
        	MyUtils util=new MyUtils();
        	String jsonResponse = util.createRequestR( resource, HttpMethodType.GET.toString());
        	JSONObject jsonObj= JSONObject.fromObject(jsonResponse);
        	return (Product)(JSONObject.toBean(jsonObj,Product.class));
	}

	@Override
	public void deleteProduct(String ventataProductId, String ventataStoreAPIKey) {

		String baseURL=ServiceURLs.productDeleteUrl;
		baseURL=baseURL.replace("{param0}",ventataProductId);
        	String resource = baseURL.replace("{param1}",ventataStoreAPIKey);
        	MyUtils util=new MyUtils();
        	util.createRequestR( resource, HttpMethodType.DELETE.toString());
	}

	@Override
	public String getPriceHistoryt(String ventataProductId, String ventataStoreAPIKey){

		String baseURL=ServiceURLs.productPriceHistoryUrl;
		baseURL=baseURL.replace("{param0}",ventataProductId);
        	String resource = baseURL.replace("{param1}",ventataStoreAPIKey);
        	MyUtils util=new MyUtils();
        	String jsonResponse = util.createRequestR( resource, HttpMethodType.GET.toString());
        	JSONObject jsonObj= JSONObject.fromObject(jsonResponse);
        	return jsonObj.toString();
	}

	@Override
	public Product getNewPrice(String ventataProductId, String ventataStoreAPIKey){

		String baseURL=ServiceURLs.productNewPriceUrl;
		baseURL=baseURL.replace("{param0}",ventataProductId);
        	String resource = baseURL.replace("{param1}",ventataStoreAPIKey);
        	MyUtils util=new MyUtils();
        	String jsonResponse = util.createRequestR( resource, HttpMethodType.GET.toString());
        	JSONObject jsonObj= JSONObject.fromObject(jsonResponse);
        	return (Product)(JSONObject.toBean(jsonObj,Product.class));
	}
	
}
