Orders
============

https://api.ventata.com/orders?ApiKey={YourStoreAPIKey}


Dealing with Time
-------------------------

* All times should be set to UTC, our algorithms depend on the date and times being set to UTC to ensure consistency across evaluations.
* DateTimes in JSON are expecting a 13 digit epoch time, if your language only does 10 make sure to add '000' to the end to account for milliseconds.


Create
-------------------------

Create an order by sending the order info in the content of a POST request as json or xml.   In this example, we are using json.

**Request**
<pre>
POST https://api.ventata.com/order?ApiKey={YourStoreAPIKey}
Content-Type: application/json;

{
    "DateCreated": "/Date(1339205240+0000)/",
    "ExternalOrderId": "1260",
    "OrderDetails": [
        {
            "CostPerItem": 4.96,
            "PricePaid": 12.96,
            "ProductId": "6ade437a-8535-3r84-979c-08k58d3d9228",
            "Quantity": 1
        },
        {
            "CostPerItem": 5.99,
            "PricePaid": 14.99,
            "ProductId": "7arb437a-8147-3g34-409c-08m12d3d5428",
            "Quantity": 1
        }
    ],
    "ShippingCost": 0,
    "SubTotal": 27.95,
    "Taxes": 0,
    "TotalPrice": 27.95
}
</pre>

**Response**
<pre>

{
    "DateCreated": "/Date(1339205240+0000)/",
    "ExternalOrderId": "1260",
    "Id": "0c1f8d21-e9d9-417a-9e0f-009578b8d439",
    "OrderDetails": [
        {
            "CostPerItem": 4.96,
            "Id": "f6cf2460-0f19-47bb-afea-38e1d66bf3b7",
            "ManuCode": "",
            "OrderId": "0c1f8d21-e9d9-417a-9e0f-009578b8d439",
            "PricePaid": 12.96,
            "ProductId": "6ade437a-8535-3r84-979c-08k58d3d9228",
            "Quantity": 1
        },
        {
            "CostPerItem": 5.99,
            "Id": "cf471737-a71c-4bff-8182-452ae663a46a",
            "ManuCode": "",
            "OrderId": "0c1f8d21-e9d9-417a-9e0f-009578b8d439",
            "PricePaid": 14.99,
            "ProductId": "7arb437a-8147-3g34-409c-08m12d3d5428",
            "Quantity": 1
        }
    ],
    "ShippingCost": 0,
    "StoreId": "141f55de-7776-49e2-996e-7c0cfc6c5f92",
    "SubTotal": 27.95,
    "Taxes": 0,
    "TotalPrice": 27.95
}
</pre>


Create Many (Array of Orders)
-------------------------

To create many orders in our system, send an array of orders in the content of a POST request as json or xml to the subresource "list".   In this example, we are using json.

Do not send more than 50 orders in a single call.   Break them up into multiple calls.

**Request**
<pre>
POST https://api.ventata.com/order/list?ApiKey={YourStoreAPIKey}
Content-Type: application/json;
[
    {
        "DateCreated": "/Date(1339205240+0000)/",
        "ExternalOrderId": "1260",
        "OrderDetails": [
            {
                "CostPerItem": 4.96,
                "PricePaid": 12.96,
                "ProductId": "6ade437a-8535-3r84-979c-08k58d3d9228",
                "Quantity": 1
            },
            {
                "CostPerItem": 5.99,
                "PricePaid": 14.99,
                "ProductId": "7arb437a-8147-3g34-409c-08m12d3d5428",
                "Quantity": 1
            }
        ],
        "ShippingCost": 0,
        "SubTotal": 27.95,
        "Taxes": 0,
        "TotalPrice": 27.95
    },
    {
        "DateCreated": "/Date(1339205240+0000)/",
        "ExternalOrderId": "1261",
        "OrderDetails": [
            {
                "CostPerItem": 4.96,
                "PricePaid": 14.96,
                "ProductId": "6ade437a-8535-3r84-979c-08k58d3d9228",
                "Quantity": 1
            },
            {
                "CostPerItem": 5.99,
                "PricePaid": 16.99,
                "ProductId": "7arb437a-8147-3g34-409c-08m12d3d5428",
                "Quantity": 1
            }
        ],
        "ShippingCost": 0,
        "SubTotal": 31.95,
        "Taxes": 0,
        "TotalPrice": 31.95
    }
]
</pre>

**Response**
<pre>
[
    {
        "DateCreated": "/Date(1339205240+0000)/",
        "ExternalOrderId": "1260",
        "Id": "0c1f8d21-e9d9-417a-9e0f-009578b8d439",
        "OrderDetails": [
            {
                "CostPerItem": 4.96,
                "Id": "f6cf2460-0f19-47bb-afea-38e1d66bf3b7",
                "ManuCode": "",
                "OrderId": "0c1f8d21-e9d9-417a-9e0f-009578b8d439",
                "PricePaid": 12.96,
                "ProductId": "6ade437a-8535-3r84-979c-08k58d3d9228",
                "Quantity": 1
            },
            {
                "CostPerItem": 5.99,
                "Id": "cf471737-a71c-4bff-8182-452ae663a46a",
                "ManuCode": "",
                "OrderId": "0c1f8d21-e9d9-417a-9e0f-009578b8d439",
                "PricePaid": 14.99,
                "ProductId": "7arb437a-8147-3g34-409c-08m12d3d5428",
                "Quantity": 1
            }
        ],
        "ShippingCost": 0,
        "StoreId": "141f55de-7776-49e2-996e-7c0cfc6c5f92",
        "SubTotal": 27.95,
        "Taxes": 0,
        "TotalPrice": 27.95
    },
    {
        "DateCreated": "/Date(1339205240+0000)/",
        "ExternalOrderId": "1260",
        "Id": "85630cc2-3082-4836-bf97-8cc9055d651f",
        "OrderDetails": [
            {
                "CostPerItem": 4.96,
                "Id": "f6cf2460-0f19-47bb-afea-38e1d66bf3b7",
                "ManuCode": "",
                "OrderId": "85630cc2-3082-4836-bf97-8cc9055d651f",
                "PricePaid": 14.96,
                "ProductId": "6ade437a-8535-3r84-979c-08k58d3d9228",
                "Quantity": 1
            },
            {
                "CostPerItem": 5.99,
                "Id": "cf471737-a71c-4bff-8182-452ae663a46a",
                "ManuCode": "",
                "OrderId": "85630cc2-3082-4836-bf97-8cc9055d651f",
                "PricePaid": 16.99,
                "ProductId": "7arb437a-8147-3g34-409c-08m12d3d5428",
                "Quantity": 1
            }
        ],
        "ShippingCost": 0,
        "StoreId": "141f55de-7776-49e2-996e-7c0cfc6c5f92",
        "SubTotal": 31.95,
        "Taxes": 0,
        "TotalPrice": 31.95
    }
]
</pre>


Read
-------------------------
Retrieving an order is as simple as passing the order id to the Order endpoint:

**Request**
<pre>
GET https://api.ventata.com/orders/0c1f8d21e9d9417a9e0f009578b8d439?ApiKey={YourStoreAPIKey}
Accept: application/json;
</pre>

**Response**
<pre>

{
    "DateCreated": "/Date(1339205240+0000)/",
    "ExternalOrderId": "1260",
    "Id": "0c1f8d21-e9d9-417a-9e0f-009578b8d439",
    "OrderDetails": [
        {
            "CostPerItem": 4.96,
            "Id": "f6cf2460-0f19-47bb-afea-38e1d66bf3b7",
            "ManuCode": "",
            "OrderId": "0c1f8d21-e9d9-417a-9e0f-009578b8d439",
            "PricePaid": 12.96,
            "ProductId": "6ade437a-8535-3r84-979c-08k58d3d9228",
            "Quantity": 1
        },
        {
            "CostPerItem": 5.99,
            "Id": "cf471737-a71c-4bff-8182-452ae663a46a",
            "ManuCode": "",
            "OrderId": "0c1f8d21-e9d9-417a-9e0f-009578b8d439",
            "PricePaid": 14.99,
            "ProductId": "7arb437a-8147-3g34-409c-08m12d3d5428",
            "Quantity": 1
        }
    ],
    "ShippingCost": 0,
    "StoreId": "141f55de-7776-49e2-996e-7c0cfc6c5f92",
    "SubTotal": 27.95,
    "Taxes": 0,
    "TotalPrice": 27.95
}
</pre>



Delete
-------------------------
Delete an order by sending a DELETE request with the order id in the querystring:

**Request**
<pre>
DELETE https://api.ventata.com/orders/0c1f8d21e9d9417a9e0f009578b8d439?ApiKey={YourStoreAPIKey}
Content-Length: 0
</pre>

**Response**

Response will be empty.

