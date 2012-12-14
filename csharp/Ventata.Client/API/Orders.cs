using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Domain.External;
using Ventata.Client.Helper;

namespace Ventata.Client.API
{
    public class Orders
    {
        Guid storeApiKey = new Guid();
        public Orders(Guid StoreAPIKey)
        {
            storeApiKey = StoreAPIKey;
        }

        public VentataOrder Create(VentataOrder order)
        {
            VentataOrder orderWithId = RestHelper.CallResource(
                "POST", String.Format("{0}?ApiKey={1}", 
                    "order", 
                    storeApiKey), order.ToJSON() //we are going to POST to Orders with the new order information
                ).FromJSON<VentataOrder>();  //then we convert it the JSON to a Ventata Order (to access the Id)

            return orderWithId;
        }

        public VentataOrder Get(string VentataOrderId)
        {
            VentataOrder orderWithId = RestHelper.CallResource(
                "GET", String.Format("{0}/{1}?ApiKey={2}", 
                    "order", 
                    VentataOrderId,
                    storeApiKey) //we are going to GET from Orders by hitting order/{id}
                ).FromJSON<VentataOrder>();  //then we convert it the JSON to a Ventata Order

            return orderWithId;
        }

        public VentataOrder Update(VentataOrder order)
        {
            VentataOrder orderWithId = RestHelper.CallResource(
                "PUT", String.Format("{0}?ApiKey={1}",
                    "order",
                    storeApiKey), order.ToJSON() //we are going to PUT to Orders with the new order information
                ).FromJSON<VentataOrder>();  //then we convert it the JSON to a Ventata Order

            return orderWithId;
        }

        public bool Delete(Guid VentataOrderId)
        {
            //We added a simple try/catch to give some feedback if the call didn't go through
            //I would expand this section to add your own exception handling
            try
            {
                //we are going to DELETE from Orders by hitting order/{id}
                RestHelper.CallResource(
                    "DELETE", String.Format("{0}/{1}?ApiKey={2}",
                        "order",
                        VentataOrderId,
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
