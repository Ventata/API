package com.ventata.persistence.test;

import java.util.Date;

import com.ventata.persistence.dao.*;
import com.ventata.persistence.domain.*;

import net.sf.json.JSONObject;

public class Tester
{
	
	public static void main(String args[])
	{
		//Enter your Company API Key that you received from us when you signed up
		String yourVentataCompanyAPIKey="xxxxxxxxx";		
		
		//Create a new store
		Store store=new Store();
		store.setName("My Awesome TShirt Store");
		store.setURL("https://myTShirtStoreOnline.com");

		//Set the store type to "Custom"
		StoreType storeType= new StoreType();
		storeType.setId(1006);
		storeType.setName("Custom");
        	store.setStoreType(storeType);
        
        	//Send the store to Ventata
	        StoreDao storeDao= new StoreDaoImpl();
	        String storeJson = JSONObject.fromObject(store).toString();
	        Store createdStore = storeDao.createStore(storeJson, yourVentataCompanyAPIKey);
	        System.out.println("New Store Id: "+createdStore.getId());
	
	        //Use the store level API key to make Product and Order calls
	        //Save this key the first time you create a store
	        String ventataStoreAPIKey= createdStore.getApiKey();
	        
	        //Create a Product
	        Product product = new Product();
	        product.setCost(4.5f);
	        product.setCurrentSupply(0);
	        product.setDescription("The most amazing Nirvana t-shirt anyone will even own");
	        product.setMANUCODE("TSHIRT120");
	        product.setMinPrice(0f);
	        product.setMaxPrice(0f);
	        product.setName("Nirvana Shirt");
	        product.setPrice(10);
	        product.setSKU("SHIRT-1");
	        product.setStrategy("Unlimited Supply");
	        
	        //Send product to Ventata
	        ProductDao productDao = new ProductDaoImpl();
	        String prodJson = JSONObject.fromObject(product).toString();
	        Product createdProduct = productDao.createProduct(prodJson, ventataStoreAPIKey);
	        System.out.println("Newly Created Product Id: " + createdProduct.getId());
	        
	        //Create an Order
	        Order order= new Order();
	        order.setDateCreated("/Date("+new Date().getTime()+")/");
	        order.setExternalOrderId("1260");
	        order.setShippingCost(0);
	        order.setSubTotal(27.95f);
	        order.setTaxes(0);
	        order.setTotalPrice(27.95f);
	
	        OrderDetails orderDetails= new OrderDetails();
	        orderDetails.setCostPerItem(4.96f);
	        orderDetails.setPricePaid(12.96f);
	        orderDetails.setQuantity(1);
	        orderDetails.setProductId(createdProduct.getId());
	        OrderDetails orderDetailsArr[]={orderDetails};
	        order.setOrderDetails(orderDetailsArr);
	        
	        //Send the Order to Ventata
	        OrderDao orderDao= new OrderDaoImpl();
	        String orderJson = JSONObject.fromObject(order).toString();
	        Order createdOrder=orderDao.createOrder(orderJson, ventataStoreAPIKey);
	        System.out.println("Newly Created Order Id: " + createdOrder.getId());
	
	        //Get a new price
	        System.out.println("New Price: " + productDao.getNewPrice(createdProduct.getId(), ventataStoreAPIKey));
	}
	
}
