Products
============
https://api.ventata.com/products


Get
-------------------------
Retrieving a product is as simple as passing the product id to the Product endpoint, like so:

**Request**
<pre>
GET https://api.ventata.com/product/6ade437a85353r84979c08k58d3d9228?ApiKey={YourStoreAPIKey}
Accept: application/json;
</pre>

**Response**
<pre>
{
    "CapacityBaselinePrice": 0,
    "CapacityCurb": 0,
    "Cost": 4.5,
    "CurrentMode": 0,
    "CurrentSupply": 0,
    "DateAvailable": "/Date(-62135596800000+0000)/",
    "DateCreated": "/Date(1343876420697+0000)/",
    "DateExpires": "/Date(-62135596800000+0000)/",
    "Description": "The most amazing Nirvana t-shirt anyone will ever own",
    "ExpectedSale": "/Date(-62135596800000+0000)/",
    "ExploitUntil": "/Date(-62135596800000+0000)/",
    "Id": "6ade437a-8535-3r84-979c-08k58d3d9228",
    "LastEvaluation": "/Date(1343876420697+0000)/",
    "MANUCODE": "TSHIRT120",
    "MaxPrice": 0,
    "MinPrice": 0,
    "Name": "New testing",
    "Price": 10,
    "PriceGroup": 0,
    "ProfitRate": 0,
    "SKU": "SHIRT-1",
    "StartingSupply": 0,
    "StoreCode": null,
    "StoreId": "141f55de-7776-49e2-996e-7c0cfc6c5f92",
    "Strategy": "Unlimited Supply"
}
</pre>