using System.Net;
using System.IO;
using System;
using System.Configuration;
using System.Collections.Generic;
using System.Json;

namespace VentataSampleApplication
{
    public class SampleApplication
    {
        public SampleApplication()
        {
            //1.  Create a store with your company API key you get at signup
            string storeInfo = @"{
                                       ""Name"": ""My Awesome TShirt Store"",
                                       ""StoreType"": {
                                             ""Id"": 1006,
                                             ""Name"": ""Custom""
                                       },
                                       ""URL"": ""https://myTShirtStoreOnline.com"",
                                       ""CurrencyCode"": ""USD""
                                 }";

            CreateStore(storeInfo);

            //2.  Create a product
            string productInfo = @"{
                                        ""Cost"": 4.5,
                                        ""CurrentSupply"": 0,
                                        ""DateAvailable"": ""/Date(-62135596800000+0000)/"",
                                        ""DateExpires"": ""/Date(-62135596800000+0000)/"",
                                        ""Description"": ""The most amazing Nirvana t-shirt anyone will ever own"",
                                        ""MANUCODE"": ""TSHIRT120"",
                                        ""MaxPrice"": 0,
                                        ""MinPrice"": 0,
                                        ""Name"": ""New testing"",
                                        ""Price"": 10,
                                        ""SKU"": ""SHIRT-1"",
                                        ""StartingSupply"": 0,
                                        ""Strategy"": ""Unlimited Supply""
                                    }";

            string productId = CreateProduct(productInfo);

            //enter 10 orders and get a new price after each time
            decimal newPrice = 10;
            for (int i = 0; i < 10; i++)
            {
                //3a. Build an order in JSON
                int epoch = (int)(DateTime.UtcNow - new DateTime(1970, 1, 1)).TotalSeconds;
                string orderInfo = String.Format(@"{
                                        ""DateCreated"""": ""/Date({0}+0000)/"",
                                        ""ExternalOrderId"": ""{1}"",
                                        ""OrderDetails"": [
                                            {
                                                ""CostPerItem"": 5.00,
                                                ""Id"": ""f6cf2460-0f19-47bb-afea-38e1d66bf3b7"",
                                                ""ManuCode"": """",
                                                ""PricePaid"": {2},
                                                ""ProductId"": ""{3}"",
                                                ""Quantity"": 1,
                                            }
                                        ],
                                        ""ShippingCost"": 0,
                                        ""SubTotal"": {2},
                                        ""Taxes"": 0,
                                        ""TotalPrice"": {2}
                                    }", epoch, i, newPrice, productId);

                //3b.  Send it to the Ventata API
                CreateOrder(orderInfo);

                //5.  Get a new price
                newPrice = GetNewPrice(productId);
            }
        }

        private static string VentataAPILocation = "https://api.ventata.com";

        //enter the company api key ventata gives you when you sign up
        private static string VentataCompanyAPIKey = "";

        //we will populate this with the CreateStore method
        private static string VentataStoreAPIKey = string.Empty;

        /// <summary>
        /// Creates a store in the ventata system and sets the VentataStoreAPIKey to the new key
        /// </summary>
        /// <param name="json">json representation of the order</param>
        /// <returns></returns>
        public void CreateStore(string json)
        {
            string resource = String.Format(VentataAPILocation + "/store?ApiKey={0}", VentataCompanyAPIKey);

            string jsonResponse = CreateRequest(json, resource, "POST");

            using (StringReader stringReader = new StringReader(jsonResponse))
            {
                var jsonObject = JsonValue.Load(stringReader);
                var storeInfo = jsonObject.AsDynamic();

                //Set the store api key with the response
                VentataStoreAPIKey = storeInfo.APIKey;
            }
        }

        /// <summary>
        /// Creates a product in the ventata system and returns the ventata id for it
        /// </summary>
        /// <param name="json">json representation of the product</param>
        /// <returns></returns>
        public string CreateProduct(string json)
        {
            string resource = String.Format(VentataAPILocation + "/product?ApiKey={0}", VentataStoreAPIKey);
            string jsonResponse = CreateRequest(json, resource, "POST");

            using (StringReader stringReader = new StringReader(jsonResponse))
            {
                var jsonObject = JsonValue.Load(stringReader);
                var productInfo = jsonObject.AsDynamic();

                return productInfo.Id;
            }
        }

        /// <summary>
        /// Creates an order in the ventata system and returns the ventata id for it
        /// </summary>
        /// <param name="json">json representation of the order</param>
        /// <returns></returns>
        public string CreateOrder(string json)
        {
            string resource = String.Format(VentataAPILocation + "/order?ApiKey={0}", VentataStoreAPIKey);
            string jsonResponse = CreateRequest(json, resource, "POST");

            using (StringReader stringReader = new StringReader(jsonResponse))
            {
                var jsonObject = JsonValue.Load(stringReader);
                var orderInfo = jsonObject.AsDynamic();

                return orderInfo.Id;
            }
        }

        /// <summary>
        /// Creates an order in the ventata system and returns the ventata id for it
        /// </summary>
        /// <param name="json">json representation of the order</param>
        /// <returns></returns>
        public decimal GetNewPrice(string ventataProductId)
        {
            string resource = String.Format(VentataAPILocation + "/product/" + ventataProductId + "/price?ApiKey={0}", VentataStoreAPIKey);
            string jsonResponse = CreateRequest(string.Empty, resource, "GET");

            using (StringReader stringReader = new StringReader(jsonResponse))
            {
                var jsonObject = JsonValue.Load(stringReader);
                var productInfo = jsonObject.AsDynamic();

                return Convert.ToDecimal(productInfo.Price);
            }
        }

        private string CreateRequest(string json, string resource, string method)
        {
            string jsonResponse = string.Empty;
            try
            {
                WebRequest CreateWebRequest = WebRequest.Create(resource);
                CreateWebRequest.Method = method;
                CreateWebRequest.ContentType = "application/json";

                HttpWebRequest httpCreateWebRequest = (HttpWebRequest)CreateWebRequest;
                httpCreateWebRequest.UseDefaultCredentials = true;

                if (!String.IsNullOrWhiteSpace(json))
                {
                    byte[] arr = System.Text.Encoding.UTF8.GetBytes(json);

                    httpCreateWebRequest.ContentLength = arr.Length;
                    Stream dataStream = httpCreateWebRequest.GetRequestStream();
                    dataStream.Write(arr, 0, arr.Length);
                    dataStream.Close();
                }

                HttpWebResponse response = (HttpWebResponse)httpCreateWebRequest.GetResponse();
                jsonResponse = new StreamReader(response.GetResponseStream()).ReadToEnd();
            }
            catch (WebException webException)
            {
                var resp = (HttpWebResponse)webException.Response;
                //resp.StatusCode
                //https://github.com/Ventata/API#response-codes
            }

            return jsonResponse;
        }
    }
}