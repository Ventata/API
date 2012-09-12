Stores
============

https://api.ventata.com/stores?ApiKey={YourCompanyAPIKey}

Store Providers
-------------------------

Store providers allow us to sync up to an ecommerce platform of your choice.   If you are handling your own integration, you should choose Custom (ID: 1006).  Entering null for store type is the same as entering custom, except the OCD engineers here don't go crazy.

If you are already on one of these fine ecommerce platforms then we already have that programmed for you!  Check out our integrations on your Ventata [Management](https://manage.ventata.com/) page for instant integrations.

**Request**
<pre>
GET https://api.ventata.com/store/providers
Content-Type: application/json;
</pre>

**Response**
<pre>
[
    {
        "Id": 1004,
        "Name": "Magento"
    },
    {
        "Id": 1005,
        "Name": "Shopify"
    },
    {
        "Id": 1006,
        "Name": "Custom"
    },
    {
        "Id": 1007,
        "Name": "OSCommerce"
    },
    {
        "Id": 1008,
        "Name": "ZenCart"
    },
    {
        "Id": 1009,
        "Name": "WooCommerce"
    },
    {
        "Id": 1010,
        "Name": "PrestaShop"
    },
    {
        "Id": 1011,
        "Name": "Volusion"
    },
    {
        "Id": 1012,
        "Name": "BigCommerce"
    }
]
</pre>

Currencies
-------------------------

Currency is set on a store level.   If you make a GET request to the currencies API (no API Key needed) you'll get a list of all active currencies we support.

Set the store "CurrencyCode" property with your currency code.

If you don't set currency, we'll default it to USD.

**Request**
<pre>
GET https://api.ventata.com/currencies
Content-Type: application/json;
</pre>

**Response**
For GitHub, I've abbreviated the response. Please do a GET request to get an updated list.
<pre>
[
    {
        "Code": "EUR",
        "Name": "Euro"
    },
    {
        "Code": "USD",
        "Name": "US Dollar"
    },
    {
        "Code": "CAD",
        "Name": "Canadian Dollar"
    },
    ...
</pre>

Create
-------------------------

Create a store by sending the store in the content of a POST request as json or xml.   In this example, we are using json.

**Request**
<pre>
POST https://api.ventata.com/store?ApiKey={YourCompanyAPIKey}
Content-Type: application/json;

{
    "Name": "My Awesome TShirt Store",
    "StoreType": {
        "Id": 1006,
        "Name": "Custom"
     },
    "URL": "https://myTShirtStoreOnline.com",
    "CurrencyCode": "USD"
}
</pre>

**Response**
<pre>
{
    "ApiKey": "14sbf781-77fa-46fd-be2c-41141af6d58c",
    "CompanyId": "5df8b21b-a140-4317-b753-455g0e2898f3",
    "DateCreated": "/Date(1329782400000+0000)/",
    "DateModified": "/Date(1329782400000+0000)/",
    "Id": "141h55de-7776-49e2-996e-7c0cf7kc5f92",
    "Name": "My Awesome TShirt Store",
    "StoreType": {
        "Id": 1006,
        "Name": "Custom"
     },
    "URL": "https://myTShirtStoreOnline.com",
    "CurrencyCode": "USD"
}
</pre>


Read
-------------------------
Get a store by adding the store id to the endpoint:

**Request**
<pre>
GET https://api.ventata.com/store/141h55de777649e2996e7c0cf7kc5f92?ApiKey={YourCompanyAPIKey}
Accept: application/json;
</pre>

**Response**
<pre>
{
    "ApiKey": "14sbf781-77fa-46fd-be2c-41141af6d58c",
    "CompanyId": "5df8b21b-a140-4317-b753-455g0e2898f3",
    "DateCreated": "/Date(1329782400000+0000)/",
    "DateModified": "/Date(1329782400000+0000)/",
    "Id": "141h55de-7776-49e2-996e-7c0cf7kc5f92",
    "Name": "My Awesome TShirt Store",
    "StoreType":  {
        "Id": 1006,
        "Name": "Custom"
     },
    "URL": "https://myTShirtStoreOnline.com",
    "CurrencyCode": "USD"
}
</pre>


Update
-------------------------
Update a store by sending the store data in the content of a PUT request as json or xml.   In this example, we are using json.

**Request**
<pre>
PUT https://api.ventata.com/product?ApiKey={YourCompanyAPIKey}
Content-Type: application/json;

{
    "Id": "141h55de-7776-49e2-996e-7c0cf7kc5f92"
    "Name": "My Awesome TShirt Store",
    "StoreType":  {
        "Id": 1006,
        "Name": "Custom"
     },
    "URL": "https://myTShirtStoreOnline.com"
}
</pre>

**Response**
<pre>
{
    "ApiKey": "14sbf781-77fa-46fd-be2c-41141af6d58c",
    "CompanyId": "5df8b21b-a140-4317-b753-455g0e2898f3",
    "DateCreated": "/Date(1329782400000+0000)/",
    "DateModified": "/Date(1329782400000+0000)/",
    "Id": "141h55de-7776-49e2-996e-7c0cf7kc5f92",
    "Name": "My Awesome TShirt Store",
    "StoreType":  {
        "Id": 1006,
        "Name": "Custom"
     },
    "URL": "https://myTShirtStoreOnline.com",
    "CurrencyCode": "USD"
}
</pre>


Delete
-------------------------
Delete a store by sending a DELETE request with the store id in the querystring:

**Request**
<pre>
DELETE https://api.ventata.com/store/141h55de-7776-49e2-996e-7c0cf7kc5f92?ApiKey={YourCompanyAPIKey}
Content-Length: 0
</pre>

**Response**

Response will be empty.


