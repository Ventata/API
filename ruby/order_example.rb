require 'pp'
require './order.rb'

#Store API key is required for creating,retrieving and deleting orders.
store_api_key="964e6b96-4183-475b-9104-429034eeebdf" #Replace it with API Key of your store


#create mutliple orders at once
orders= Array.new #You will can send an  array of orders to the server.
                  #Just create a ruby hash for each order, put them in an array and call Order.create_many()

order1={
    "DateCreated" => "/Date(1339205240+0000)/",
    "ExternalOrderId"=>  "1260",
    "OrderDetails"=>  [
        {
            "CostPerItem"=>  4.96,
            "PricePaid"=>  12.96,
            "ProductId"=>  "c83e7fda-7c51-4736-8a51-388409f72d9d",
            "Quantity"=>  1
        },
        {
            "CostPerItem"=>  5.99,
            "PricePaid"=>  14.99,
            "ProductId"=>  "d011f4ad-f336-4d99-b00f-a8b93789ac3d",
            "Quantity"=>  1
        }
    ],
    "ShippingCost"=>  0,
    "SubTotal"=>  27.95,
    "Taxes"=>  0,
    "TotalPrice"=>  27.95
}
order2={
    "DateCreated" => "/Date(1339205240+0000)/",
    "ExternalOrderId"=>  "1261",
    "OrderDetails"=>  [
        {
            "CostPerItem"=>  4.96,
            "PricePaid"=>  12.96,
            "ProductId"=>  "c83e7fda-7c51-4736-8a51-388409f72d9d",
            "Quantity"=>  2
        },
        {
            "CostPerItem"=>  5.99,
            "PricePaid"=>  14.99,
            "ProductId"=>  "d011f4ad-f336-4d99-b00f-a8b93789ac3d",
            "Quantity"=>  3
        }
    ],
    "ShippingCost"=>  5,
    "SubTotal"=>  27.95,
    "Taxes"=>  0,
    "TotalPrice"=>  27.95
}

orders.push(order1);
#orders.push(order2);

orders_created= Order.create_many(store_api_key,orders) #returns information about the newly created order as an array ofruby hashes
puts "Just created  two orders"
orders_created.each do |ord|
puts "**************************"
pp ord
puts "**************************"
end

#-------------------------------------------------------

#create a single order
order_created=Order.create(store_api_key,order1)
puts "Just created  an order"
pp order_created


#--------------------------------------------------------


#Retrieve an order details from the server using order Id
order_id= order_created["Id"] #Id of the order we just created
retrieved= Order.get(store_api_key,order_id)
puts "Order details retrieved from server"
pp retrieved


#---------------------------------------------------------

#Deleting an existing order using order Id
puts "Deleting an order"
Order.delete(store_api_key,order_id)
