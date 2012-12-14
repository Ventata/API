using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Domain.External;
using Ventata.Client.Helper;

namespace Ventata.Client.API
{
    public class Stores
    {       
        Guid companyApiKey = new Guid();
        public Stores(Guid CompanyAPIKey)
        {
            companyApiKey = CompanyAPIKey;
        }

        public VentataStore Create(VentataStore store)
        {
            VentataStore storeWithId = RestHelper.CallResource(
                "POST", String.Format("{0}?ApiKey={1}", 
                    "store",
                    companyApiKey), store.ToJSON() //we are going to POST to Stores with the new store information
                ).FromJSON<VentataStore>();  //then we convert it the JSON to a Ventata Store (to access the Id)

            return storeWithId;
        }

        public VentataStore Get(Guid VentataStoreId)
        {
            VentataStore storeWithId = RestHelper.CallResource(
                "GET", String.Format("{0}/{1}?ApiKey={2}", 
                    "store", 
                    VentataStoreId,
                    companyApiKey) //we are going to GET from Stores by hitting store/{id}
                ).FromJSON<VentataStore>();  //then we convert it the JSON to a Ventata Store

            return storeWithId;
        }

        public VentataStore Update(VentataStore store)
        {
            VentataStore storeWithId = RestHelper.CallResource(
                "PUT", String.Format("{0}?ApiKey={1}",
                    "store",
                    companyApiKey), store.ToJSON() //we are going to PUT to Stores with the new store information
                ).FromJSON<VentataStore>();  //then we convert it the JSON to a Ventata Store

            return storeWithId;
        }

        public bool Delete(Guid VentataStoreId)
        {
            //We added a simple try/catch to give some feedback if the call didn't go through
            //I would expand this section to add your own exception handling
            try
            {
                //we are going to DELETE from Stores by hitting store/{id}
                RestHelper.CallResource(
                    "DELETE", String.Format("{0}/{1}?ApiKey={2}",
                        "store",
                        VentataStoreId,
                        companyApiKey)
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
