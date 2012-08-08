package com.ventata.persistence.domain;

public class OrderDetails {
	
   
        private float CostPerItem;
        private float PricePaid;
        private String ProductId;
        private int Quantity;
		/**
		 * 
		 */
		public OrderDetails() {
			super();
			// TODO Auto-generated constructor stub
		}
		/**
		 * @param costPerItem
		 * @param pricePaid
		 * @param productId
		 * @param quantity
		 */
		public OrderDetails(float costPerItem, float pricePaid,
				String productId, int quantity) {
			super();
			CostPerItem = costPerItem;
			PricePaid = pricePaid;
			ProductId = productId;
			Quantity = quantity;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "OrderDetails [CostPerItem=" + CostPerItem + ", PricePaid="
					+ PricePaid + ", ProductId=" + ProductId + ", Quantity="
					+ Quantity + "]";
		}
		/**
		 * @return the costPerItem
		 */
		public float getCostPerItem() {
			return CostPerItem;
		}
		/**
		 * @param costPerItem the costPerItem to set
		 */
		public void setCostPerItem(float costPerItem) {
			CostPerItem = costPerItem;
		}
		/**
		 * @return the pricePaid
		 */
		public float getPricePaid() {
			return PricePaid;
		}
		/**
		 * @param pricePaid the pricePaid to set
		 */
		public void setPricePaid(float pricePaid) {
			PricePaid = pricePaid;
		}
		/**
		 * @return the productId
		 */
		public String getProductId() {
			return ProductId;
		}
		/**
		 * @param productId the productId to set
		 */
		public void setProductId(String productId) {
			ProductId = productId;
		}
		/**
		 * @return the quantity
		 */
		public int getQuantity() {
			return Quantity;
		}
		/**
		 * @param quantity the quantity to set
		 */
		public void setQuantity(int quantity) {
			Quantity = quantity;
		}
        
        
    

}
