Company
============

https://api.ventata.com/company?ApiKey={YourCompanyAPIKey}

When you sign up, a company is already created for you.   That's why we only allow update.


Update
-------------------------

Update your company info by sending the new company info in the content of a PUT request as json or xml.   In this example, we are using json.

**Request**
<pre>
PUT https://api.ventata.com/company?ApiKey={YourCompanyAPIKey}
Content-Type: application/json;
{
    "Address1": "1000 Main Street",
    "Address2": "",
    "City": "Los Angeles",
    "FaxNumber": 5553002000,
    "Name": "Test Company",
    "PhoneNumber": 5552003000,
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
    "DateCreated": "/Date(1329264000000+0000)/",
    "DateModified": "/Date(1422835200000+0000)/",
    "FaxNumber": 5553002000,
    "Id": "5df8b21b-a140-4317-b753-454d0e2898f3",
    "Name": "Test Company",
    "PhoneNumber": 5552003000,
    "State": "CA",
    "Zip": "90067"
}
</pre>


Read
-------------------------
Get your company info by a GET at the endpoint with your Company API Key:

**Request**
<pre>
GET https://api.ventata.com/company?ApiKey={YourCompanyAPIKey}
Accept: application/json;
</pre>

**Response**
<pre>

{
    "Address1": "1000 Main Street",
    "Address2": "",
    "City": "Los Angeles",
    "DateCreated": "/Date(1329264000000+0000)/",
    "DateModified": "/Date(1422835200000+0000)/",
    "FaxNumber": 5553002000,
    "Id": "5df8b21b-a140-4317-b753-454d0e2898f3",
    "Name": "Test Company",
    "PhoneNumber": 5552003000,
    "State": "CA",
    "Zip": "90067"
}
</pre>

