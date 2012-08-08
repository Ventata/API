package com.ventata.persistence.domain;

import java.util.Arrays;

public class Order {
	
	
	    private String DateCreated;
	    private String ExternalOrderId;
	    private OrderDetails OrderDetails[];
	    private float ShippingCost;
	    private float SubTotal;
	    private float Taxes;
	    private float TotalPrice;
	    private String Id;
		/**
		 * 
		 */
		public Order() {
			super();
			// TODO Auto-generated constructor stub
		}
		/**
		 * @param dateCreated
		 * @param externalOrderId
		 * @param orderDetails
		 * @param shippingCost
		 * @param subTotal
		 * @param taxes
		 * @param totalPrice
		 */
		public Order(String dateCreated, String externalOrderId,
				com.ventata.persistence.domain.OrderDetails[] orderDetails,
				float shippingCost, float subTotal, float taxes,
				float totalPrice, String id) {
			super();
			DateCreated = dateCreated;
			ExternalOrderId = externalOrderId;
			OrderDetails = orderDetails;
			ShippingCost = shippingCost;
			SubTotal = subTotal;
			Taxes = taxes;
			TotalPrice = totalPrice;
			Id = id;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Orders [DateCreated=" + DateCreated + ", ExternalOrderId="
					+ ExternalOrderId + ", OrderDetails="
					+ Arrays.toString(OrderDetails) + ", ShippingCost="
					+ ShippingCost + ", SubTotal=" + SubTotal + ", Taxes="
					+ Taxes + ", TotalPrice=" + TotalPrice + "]";
		}
		/**
		 * @return the dateCreated
		 */
		public String getDateCreated() {
			return DateCreated;
		}
		/**
		 * @param dateCreated the dateCreated to set
		 */
		public void setDateCreated(String dateCreated) {
			DateCreated = dateCreated;
		}
		/**
		 * @return the externalOrderId
		 */
		public String getExternalOrderId() {
			return ExternalOrderId;
		}
		/**
		 * @param externalOrderId the externalOrderId to set
		 */
		public void setExternalOrderId(String externalOrderId) {
			ExternalOrderId = externalOrderId;
		}
		/**
		 * @return the orderDetails
		 */
		public OrderDetails[] getOrderDetails() {
			return OrderDetails;
		}
		/**
		 * @param orderDetails the orderDetails to set
		 */
		public void setOrderDetails(OrderDetails[] orderDetails) {
			OrderDetails = orderDetails;
		}
		/**
		 * @return the shippingCost
		 */
		public float getShippingCost() {
			return ShippingCost;
		}
		/**
		 * @param shippingCost the shippingCost to set
		 */
		public void setShippingCost(float shippingCost) {
			ShippingCost = shippingCost;
		}
		/**
		 * @return the subTotal
		 */
		public float getSubTotal() {
			return SubTotal;
		}
		/**
		 * @param subTotal the subTotal to set
		 */
		public void setSubTotal(float subTotal) {
			SubTotal = subTotal;
		}
		/**
		 * @return the taxes
		 */
		public float getTaxes() {
			return Taxes;
		}
		/**
		 * @param taxes the taxes to set
		 */
		public void setTaxes(float taxes) {
			Taxes = taxes;
		}
		/**
		 * @return the totalPrice
		 */
		public float getTotalPrice() {
			return TotalPrice;
		}
		/**
		 * @param totalPrice the totalPrice to set
		 */
		public void setTotalPrice(float totalPrice) {
			TotalPrice = totalPrice;
		}
		/**
		 * @return the Id
		 */
		public String getId() {
			return Id;
		}
		/**
		 * @param Id the Id to set
		 */
		public void setId(String id) {
			Id = id;
		}

}
