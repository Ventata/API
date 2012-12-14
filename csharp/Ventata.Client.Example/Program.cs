using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Domain.External;
using Domain.Internal;
using Domain.Maps;
using Ventata.Client.API;

namespace Ventata.Client.Example
{

    class Program
    {
        //Enter your Company API key here inside the Guid.Parse method
        static Guid CompanyAPIKey = Guid.Parse("");

        static void Main(string[] args)
        {
            //1.  Create a store
            VentataStore vStore = new VentataStore()
            {
                Name = "My Awesome First Store",
                CurrencyCode = "USD",
                ExternalId = "1",
                URL = "http://kateCoolToyStore.com/",
                StoreType = new StoreType()
                {
                    Id = 1006,
                    Name = "Custom"
                }
            };

            Stores ventataStoreAPI = new Stores(CompanyAPIKey);

            VentataStore newlyCreatedStore = ventataStoreAPI.Create(vStore);

            //You might want to store this Id and the API Key in your database so you can make GET/PUT calls to it
            Guid newStoreId = newlyCreatedStore.Id;
            Guid storeApiKey = newlyCreatedStore.ApiKey;

            //such as getting the store back out..
            newlyCreatedStore = ventataStoreAPI.Get(newStoreId);

            //or updating the store...
            newlyCreatedStore.Name = "My (Still Very) Awesome Second Store";
            newlyCreatedStore = ventataStoreAPI.Update(newlyCreatedStore);

            //2.  Now that we've created a store we can add our internal products to that store

            //We'll first start by creating a Product API with that store's security API Key
            Products ventataProductAPI = new Products(storeApiKey);

            //"Product" object is an internal product object, you'll need to edit this class
            //so that it looks like your Product object and also update the Mapper function in Domain
            //but for an example...

            Product prod = new Product()
            {
                Id = 12345,
                Name = "New test product",
                Cost = 4.5m,
                Supply = 100,
                MAP = 5,
                DescrLong = "The most amazing Nirvana t-shirt anyone will ever own",
                DescrShort = "A Nirvana Shirt",
                ManufacturerNo = "TSHIRT120",
                DateCreated = DateTime.UtcNow,
                SKU = "SHIRT-1",
                Price = 10
            };

            //Use the mapper and pick your pricing strategy
            VentataProduct vProduct = VentataMapper.ConvertProduct(prod, PricingStrategy.UnlimitedSupply);

            //Send product to Ventata
            vProduct = ventataProductAPI.Create(vProduct);

            //Store this Id in your database so you can make other calls to it
            Guid newlyCreatedProductId = vProduct.Id;

            //such as updating the product information...
            vProduct.MaxPrice = 50;
            vProduct.Cost = 4.0m;
            vProduct = ventataProductAPI.Update(vProduct);

            //3.  Now that we've created a product let's make 10 fake orders to associate with that product
            //We first create a ventata order api with the store api key
            Orders ventataOrderAPI = new Orders(storeApiKey);

            for (int i = 0; i < 10; i++)
            {
                //"Order" object is an internal order object, you'll need to edit this class
                //so that it looks like your Order object and also update the Mapper function in Domain
                //but for an example...

                Order o = new Order()
                {
                    Id = i,
                    DateOrdered = DateTime.UtcNow,
                    PaymentMethod = "CC",
                    Shipping = 7,
                    SubTotal = 80,
                    Taxes = 0,
                    Total = 87,
                    OrderDetails = new List<OrderDetail>()
                };

                //add line items to your internal order object
                o.OrderDetails.Add(new OrderDetail()
                {
                    Cost = 4,
                    Price = 10,
                    OrderId = o.Id,
                    ProductId = prod.Id,
                    Quantity = 4
                });

                //Convert to a VentataOrder
                VentataOrder vOrder = VentataMapper.ConvertOrder(o);

                //Convert VentataOrderDetails (line items)
                foreach (OrderDetail detail in o.OrderDetails)
                {
                    VentataOrderDetail vDetail = VentataMapper.ConvertOrderDetails(detail);

                    //set the product id to the ventata product id
                    //You could do this more elegantly in your own system
                    //but you can use our API to reconcile the two products Id's with the following call:
                    vDetail.ProductId = ventataProductAPI.GetProductByStoreCode(detail.ProductId.ToString()).Id;

                    //add it to the order
                    vOrder.OrderDetails.Add(vDetail);
                }

                //send it off to Ventata
                vOrder = ventataOrderAPI.Create(vOrder);

                //You can store this Id in your system to make future calls to this resources
                Guid newlyCreatedOrderId = vOrder.Id;
            }

            //4. Call for a new price!
            decimal newPrice = ventataProductAPI.GetNewPrice(newlyCreatedProductId).Price;

        }
    }
}
