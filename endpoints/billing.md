Billing
============

You can control the billing info we use to charge you from our API.   Things such as credit cards and billing addresses can be changed on the fly with a few API calls.

To update billing do a POST instead of a PUT, we record every change to your billing info as a separate entity for account purposes.


Update
-------------------------

Update your billing info by sending the new credit card info in the content of a POST request as json or xml.   In this example, we are using json.

**Credit Card Information**

**Request**
<pre>
POST https://api.ventata.com/Billing/CreditCard?ApiKey={YourCompanyAPIKey}
Content-Type: application/json;

{
    "CardType": "AMEX",
    "CardholderName": "John Doe",
    "ExpMonth": "01",
    "ExpYear": "2016",
    "LastFourCC": "0005",
    "PrimaryAccountNumber": "378282246310005"
}
</pre>

**Response**
<pre>

{
    "CardType": "AMEX",
    "CardholderName": "John Doe",
    "CompanyId": "5df8c91b-a140-4317-b623-46gh0e2898f3",
    "DateCreated": "/Date(1339569371823-0700)/",
    "ExpMonth": "01",
    "ExpYear": "2016",
    "Id": "3705124e-0l53-48de-9e12-a8a3a5465ab0",
    "LastFourCC": "0005",
    "PrimaryAccountNumber": "378282246310005"
}
</pre>


**Billing Address**

**Request**
<pre>
POST https://api.ventata.com/Billing/CreditCard?ApiKey={YourCompanyAPIKey}
Content-Type: application/json;

{
    "Address1": "1000 Main Street",
    "Address2": "",
    "City": "Los Angeles",
    "Name": "John Doe",
    "Phone": 5555555555,
    "State": "CA",
    "Zip": "90067"
}
</pre>

**Response**
<pre>
{
    "Address1": "1000 Main Street",
    "Address2": "",
    "City": "Los Angeles",
    "CompanyId": "5df8b21b-a140-4317-b753-454d0e2898f3",
    "DateCreated": "/Date(1336921560600-0700)/",
    "DateModified": "/Date(1336921560600-0700)/",
    "Id": "e3422609-d95f-4e25-a71d-e4e3bf96e38c",
    "Name": "John Doe",
    "Phone": 5555555555,
    "State": "CA",
    "Zip": "90067"
}
</pre>


Read
-------------------------
Get your company billing info by just call for a GET at the endpoint with your Company API Key:

**Credit Card Information**

**Request**
<pre>
GET https://api.ventata.com/Billing/CreditCard?ApiKey={YourCompanyAPIKey}
Accept: application/json;
</pre>

**Response**
<pre>
{
    "CardType": "AMEX",
    "CardholderName": "John Doe",
    "CompanyId": "5df8c91b-a140-4317-b623-46gh0e2898f3",
    "DateCreated": "/Date(1339569371823-0700)/",
    "ExpMonth": "01",
    "ExpYear": "2016",
    "Id": "3705124e-0l53-48de-9e12-a8a3a5465ab0",
    "LastFourCC": "0005",
    "PrimaryAccountNumber": "378282246310005"
}
</pre>


**Billing Address**

**Request**
<pre>
GET https://api.ventata.com/Billing/Address?ApiKey={YourCompanyAPIKey}
Accept: application/json;
</pre>

**Response**
<pre>
{
    "Address1": "1000 Main Street",
    "Address2": "",
    "City": "Los Angeles",
    "CompanyId": "5df8b21b-a140-4317-b753-454d0e2898f3",
    "DateCreated": "/Date(1336921560600-0700)/",
    "DateModified": "/Date(1336921560600-0700)/",
    "Id": "e3422609-d95f-4e25-a71d-e4e3bf96e38c",
    "Name": "John Doe",
    "Phone": 5555555555,
    "State": "CA",
    "Zip": "90067"
}
</pre>