Ventata API
============

The Ventata API is a REST web service that accepts both JSON and XML. Use our API to integrate [dynamic pricing](https://ventata.com/) into any software application you are working with.


Overview
-------------------------

First, sign up for an API key at [Ventata.com](https://ventata.com/Ecommerce/Pricing).  

The idea behind ventata is you seed your pricing model with order data then call for a new price.   As a new order comes in, send it over and we'll incorporate it into your pricing model.   Then call for a new price.  This process allows us to maximize your profits in real time.


When should you use Dynamic Pricing?
-------------------------
* Digital Goods: Applications, Songs, Videos and In-Game purchases
* Ecommerce:  Price competitive markets, drop-ship, flash sales or when you have a unique product like a hand-made item
* Tickets and Events:  Use dynamic pricing to sell out your event and maximize revenue
* Traffic & Parking:  Use dynamic pricing to control capacity

If you're building a store or application that sells one of these items, you can incorporate ventata into the order process to maximize your profits.


Example Code
-------------------------

**PHP**
* [Ventata / API / PHP](https://github.com/Ventata/API/tree/master/php)

**Java**
* [Ventata / API / Java](https://github.com/Ventata/API/tree/master/java)

**C#**
* [Ventata/ API / CSharp](https://github.com/Ventata/API/tree/master/csharp)

**Python**
* [Ventata / API / Python](https://github.com/Ventata/API/tree/master/python)

**Ruby**
* [Ventata / API / Ruby](https://github.com/Ventata/API/tree/master/ruby)


Endpoints
-------------

* [Stores](https://github.com/Ventata/API/blob/master/endpoints/stores.md)
* [Products](https://github.com/Ventata/API/blob/master/endpoints/products.md)
* [Orders](https://github.com/Ventata/API/blob/master/endpoints/orders.md)
* [Company](https://github.com/Ventata/API/blob/master/endpoints/company.md)
* [Billing](https://github.com/Ventata/API/blob/master/endpoints/billing.md)


Authentication
--------------

Auth is done through an API Key on the end of the querystring.  When you first sign up, we'll send you a company API key.  With this key, you'll be able to create as many stores as you want.  Each store will get it's own unique api key returned in the response.     

**When do I use the Company API Key?**

When you are using Company, Stores or Billing endpoints.

**When do I use the Store API Key?**

When you are using Products or Orders endpoints.

**Why is it setup this way?**

You can have many stores to a single company and we can control how much access a store API Key has, if you just had a single point of authenticating then all stores would be able to access all the other stores' data.   With the multiple API key system, if you want contractors to integrate our API into one of your sites, you can give them the relavent Store API Key for it without having to give them access to all of your other stores.


Response Codes:
--------------------

The Ventata API sends back the following standard HTTP Status codes:

<table>
  <tr>
    <th>Code</th><th>AKA</th><th>Reason</th>
  </tr>
  <tr>
    <td>200</td><td>ok</td><td>Request successfully received and sending back response data.</td>
  </tr>
  <tr>
    <td>201</td><td>created</td><td>Request successfully received and sending back response data that will have your new resource id.</td>
  </tr>
  <tr>
    <td>202</td><td>updated</td><td>Request successfully received and sending back response data.</td>
  </tr>
  <tr>
    <td>400</td><td>bad request</td><td>Request received but we couldn't process it because something was formatted incorrectly.  Check out the Endpoints section to make sure you are sending over the right info.</td>
  </tr>
  <tr>
    <td>401</td><td>unauthorized</td><td>Request received but not processed.  You aren't supposed to be here, make sure you are using the API key that is associated with the endpoint you are accessing.</td>
  </tr>
  <tr>
    <td>402</td><td>payment required</td><td>Request received but not processed.  We are having trouble processing your credit card, please make sure your billing information is up to date.</td>
  </tr>
  <tr>
    <td>404</td><td>not found</td><td>Request was not received, that resource is not in our system.</td>
  </tr>
  <tr>
    <td>500</td><td>server error</td><td>Did I do that?  It's something on our end.  If you're getting 500's contact our support team and we'll fix the issue.</td>
  </tr>
</table>



HTTPS
---------

All traffic must be made through HTTPS.   Any calls made to HTTP will return a 404, we do not do redirects for security reasons.



Questions & Comments
----------------------

You can reach us on our [contact page](https://ventata.com/contact) or chat with us on our [site](https://ventata.com)