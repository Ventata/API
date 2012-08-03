Stores
============

https://api.ventata.com/products


Create
-------------------------

Create a store by sending the store in the content of a POST request as json or xml.   In this example, we are using json.

**Request**
<pre>
POST https://api.ventata.com/store/6ade437a85353r84979c08k58d3d9228?ApiKey={YourCompanyAPIKey}
Content-Type: application/json;

{
    "Name": "My Awesome TShirt Store",
    "StoreType": null,
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
    "StoreType": null,
    "URL": "https://myTShirtStoreOnline.com"
}
</pre>


Read
-------------------------
Get a store by adding the store id to the endpoint:

**Request**
<pre>
GET https://api.ventata.com/store/141h55de777649e2996e7c0cf7kc5f92?ApiKey={YourStoreAPIKey}
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
    "StoreType": null,
    "URL": "https://myTShirtStoreOnline.com"
}
</pre>


Update
-------------------------
Update a product by sending the product in the content of a PUT request as json or xml.   In this example, we are using json.

**Request**
<pre>
PUT https://api.ventata.com/product?ApiKey={YourStoreAPIKey}
Content-Type: application/json;

{
    "Id": "141h55de-7776-49e2-996e-7c0cf7kc5f92"
    "Name": "My Awesome TShirt Store",
    "StoreType": null,
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
    "StoreType": null,
    "URL": "https://myTShirtStoreOnline.com"
}
</pre>


Delete
-------------------------
Delete a store by sending a DELETE request with the store id in the querystring:

**Request**
<pre>
DELETE https://api.ventata.com/store/141h55de-7776-49e2-996e-7c0cf7kc5f92?ApiKey={YourStoreAPIKey}
Content-Length: 0
</pre>

**Response**

Response will be empty.


