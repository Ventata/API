using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Domain.External;
using Ventata.Client.Helper;

namespace Ventata.Client.API
{
    public class Products
    {
        Guid storeApiKey = new Guid();
        public Products(Guid StoreAPIKey)
        {
            storeApiKey = StoreAPIKey;
        }

        public VentataProduct Create(VentataProduct product)
        {
            VentataProduct productWithId = RestHelper.CallResource(
                "POST", String.Format("{0}?ApiKey={1}", 
                    "product", 
                    storeApiKey), product.ToJSON() //we are going to POST to Products with the new product information
                ).FromJSON<VentataProduct>();  //then we convert it the JSON to a Ventata Product (to access the Id)

            return productWithId;
        }

        public VentataProduct Get(Guid VentataProductId)
        {
            VentataProduct productWithId = RestHelper.CallResource(
                "GET", String.Format("{0}/{1}?ApiKey={2}", 
                    "product", 
                    VentataProductId,
                    storeApiKey) //we are going to GET from Products by hitting product/{id}
                ).FromJSON<VentataProduct>();  //then we convert it the JSON to a Ventata Product

            return productWithId;
        }

        public VentataProduct Update(VentataProduct product)
        {
            VentataProduct productWithId = RestHelper.CallResource(
                "PUT", String.Format("{0}?ApiKey={1}",
                    "product",
                    storeApiKey), product.ToJSON() //we are going to PUT to Products with the new product information
                ).FromJSON<VentataProduct>();  //then we convert it the JSON to a Ventata Product

            return productWithId;
        }

        public VentataProduct GetNewPrice(Guid VentataProductId)
        {
            VentataProduct productWithId = RestHelper.CallResource(
                "GET", String.Format("{0}/{1}/price?ApiKey={2}",
                    "product",
                    VentataProductId,
                    storeApiKey) //we are going to GET from Products by hitting product/{id}
                ).FromJSON<VentataProduct>();  //then we convert it the JSON to a Ventata Product

            return productWithId;
        }

        public VentataProduct GetProductByStoreCode(string InternalProductId)
        {
            VentataProduct productWithId = RestHelper.CallResource(
                "GET", String.Format("{0}/{1}?ApiKey={2}",
                    "product/provider/",
                    InternalProductId,
                    storeApiKey) //we are going to GET from Products by hitting product/{id}
                ).FromJSON<VentataProduct>();  //then we convert it the JSON to a Ventata Product

            return productWithId;
        }

        public bool Delete(Guid VentataProductId)
        {
            //We added a simple try/catch to give some feedback if the call didn't go through
            //I would expand this section to add your own exception handling
            try
            {
                //we are going to DELETE from Products by hitting product/{id}
                RestHelper.CallResource(
                    "DELETE", String.Format("{0}/{1}?ApiKey={2}",
                        "product",
                        VentataProductId,
                        storeApiKey)
                    ); 

                return true;
            }
            catch
            {
                return false;
            }            
        }
    }
}
