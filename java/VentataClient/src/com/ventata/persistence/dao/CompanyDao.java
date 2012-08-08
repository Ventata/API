package com.ventata.persistence.dao;

import com.ventata.persistence.domain.Company;

public interface CompanyDao {

	public Company updateCompany(String json, String ventataCompanyAPIKey);
	
	public Company findCompany(String ventataCompanyId, String ventataCompanyAPIKey);
	
}
