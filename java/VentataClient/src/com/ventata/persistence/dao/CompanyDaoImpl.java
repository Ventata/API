package com.ventata.persistence.dao;

import net.sf.json.JSONObject;

import com.ventata.persistence.domain.Company;
import com.ventata.persistence.utils.HttpMethodType;
import com.ventata.persistence.utils.MyUtils;
import com.ventata.persistence.utils.ServiceURLs;

public class CompanyDaoImpl implements CompanyDao {

	@Override
	public Company updateCompany(String json, String ventataCompanyAPIKey) {

		String baseURL=ServiceURLs.companyUpdateUrl;
        	String resource = baseURL.replace("{param0}", ventataCompanyAPIKey);
        	MyUtils util=new MyUtils();
        	String jsonResponse = util.createRequestR( resource, HttpMethodType.PUT.toString());
        	JSONObject jsonObj= JSONObject.fromObject(jsonResponse);
        	return (Company)(JSONObject.toBean(jsonObj,Company.class));
	}

	@Override
	public Company findCompany(String ventataCompanyId, String ventataCompanyAPIKey) {
		String baseURL=ServiceURLs.companyReadUrl;
		baseURL=baseURL.replace("{param0}",ventataCompanyId);
        	String resource = baseURL.replace("{param1}",ventataCompanyAPIKey);;
        	MyUtils util=new MyUtils();
        	String jsonResponse = util.createRequestR( resource, HttpMethodType.GET.toString());
        	JSONObject jsonObj= JSONObject.fromObject(jsonResponse);
        	return (Company)(JSONObject.toBean(jsonObj,Company.class));
	}

}
