using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

//Domain namespaces
using Domain.External;
using Domain.Internal;

namespace Domain.Maps
{
    public class VentataMapper
    {
        /// <summary>
        /// Converts your internal Order into a Ventata Order
        /// </summary>
        /// <param name="order">An instance of your internal Order object</param>
        /// <returns></returns>
        public static VentataOrder ConvertOrder(Order order)
        {
            VentataOrder orderToReturn = new VentataOrder();

            //Map internal Order to Ventata Order
            orderToReturn.DateCreated = order.DateOrdered;
            orderToReturn.ShippingCost = order.Shipping;
            orderToReturn.SubTotal = order.SubTotal;
            orderToReturn.Taxes = order.Taxes;
            orderToReturn.TotalPrice = order.Total;
            orderToReturn.OrderDetails = new List<VentataOrderDetail>();


            return orderToReturn;
        }

        /// <summary>
        /// Converts your internal Order Details (aka Line Items) into a Ventata OrderDetail
        /// </summary>
        /// <param name="orderDetails">An instance of your internal Order Details object</param>
        /// <returns></returns>
        public static VentataOrderDetail ConvertOrderDetails(OrderDetail orderDetails)
        {
            VentataOrderDetail detailsToReturn = new VentataOrderDetail();

            //Map internal OrderDetail (Order Line Items) to VentataOrderDetails
            detailsToReturn.CostPerItem = orderDetails.Cost;
            detailsToReturn.PricePaid = orderDetails.Price;
            detailsToReturn.Quantity = orderDetails.Quantity;
            return detailsToReturn;
        }

        /// <summary>
        /// Converts your internal Product object into a Ventata Product.
        /// </summary>
        /// <param name="product">An instance of your internal Product object</param>
        /// <param name="strategy">What Pricing Strategy would you like to use?</param>
        /// <param name="DateAvailable">[Limited Supply Only] When will the sale start?</param>
        /// <param name="DateExpires">[Limited Supply Only] When will the sale end?</param>
        /// <returns></returns>
        public static VentataProduct ConvertProduct(Product product, PricingStrategy strategy, DateTime? DateAvailable = null, DateTime? DateExpires = null)
        {
            VentataProduct productToReturn = new VentataProduct();

            //This is where we keep your PK in our system for easy lookup
            productToReturn.StoreCode = product.Id.ToString();

            //Map internal Product to VentataProduct
            productToReturn.Cost = product.Cost;
            productToReturn.CurrentSupply = product.Supply;
            productToReturn.DateCreated = product.DateCreated;
            productToReturn.Description = product.DescrLong;
            productToReturn.MANUCODE = product.ManufacturerNo;
            productToReturn.MaxPrice = product.Price * 1.5m;
            productToReturn.MinPrice = product.MAP;
            productToReturn.Name = product.Name;
            productToReturn.Price = product.Price;
            productToReturn.SKU = product.SKU;
            
            //Set Strategy
            productToReturn.Strategy = strategy.ToString();

            //Limited Supply Mappings
            if (DateAvailable.HasValue && DateExpires.HasValue)
            {
                productToReturn.DateAvailable = DateAvailable.Value;
                productToReturn.DateExpires = DateExpires.Value;
            }

            return productToReturn;
        }
        
    }
}
