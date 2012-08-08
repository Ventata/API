package com.ventata.persistence.utils;

public class ServiceURLs {	
	
	public final static String storeCreateUrl= "https://api.ventata.com/store?ApiKey={param0}";
	public final static String storeReateUrl= "https://api.ventata.com/store/{param0}?ApiKey={param1}";
	public final static String storeUpdateUrl= "https://api.ventata.com/product?ApiKey={param0}";
	public final static String storeDeleteUrl= "https://api.ventata.com/store/{param0}?ApiKey={param1}";
		
	public final static String productCreateUrl= "https://api.ventata.com/products?ApiKey={param0}";
	public final static String productReateUrl= "https://api.ventata.com/product/{param0}?ApiKey={param1}";
	public final static String productUpdateUrl= "https://api.ventata.com/product?ApiKey={param0}";
	public final static String productDeleteUrl= "https://api.ventata.com/product/{param0}?ApiKey={param1}";
	public final static String productNewPriceUrl= "https://api.ventata.com/product/{param0}/price?ApiKey={param1}";
	public final static String productPriceHistoryUrl= "https://api.ventata.com/product/{param0}/history?ApiKey={param1}";
	
	public final static String orderCreateUrl= "https://api.ventata.com/order?ApiKey={param0}";
	public final static String orderReadUrl= "https://api.ventata.com/orders/{param0}?ApiKey={param1}";
	public final static String orderDeleteUrl= "https://api.ventata.com/orders/{param0}?ApiKey={param1}";
		
	public final static String companyUpdateUrl= "https://api.ventata.com/company?ApiKey={param0}";
	public final static String companyReadUrl= "https://api.ventata.com/company?ApiKey={param0}";
}
