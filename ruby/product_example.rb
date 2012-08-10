require 'pp'
require './product.rb'

store_api_key="964e6b96-4183-475b-9104-429034eeebdf" #Replace it with API Key of your store



#Create multiple products at once
products= Array.new #You will can send an  array of products to the server.
                  #Just create a ruby hash for each product, put them in an array and call Product.create_many()


product1={
        "Cost"=> 4.5,
        "CurrentSupply"=> 10,
        "DateAvailable"=> "/Date(-62135596800000+0000)/",
        "DateCreated"=> "/Date(1338874208950+0000)/",
        "DateExpires"=> "/Date(-62135596800000+0000)/",
        "Description"=> "The most amazing Nirvana t-shirt anyone will ever own",
        "LastEvaluation"=> "/Date(1338874208950+0000)/",
        "MANUCODE"=> "TSHIRT120",
        "MaxPrice"=> 0,
        "MinPrice"=> 0,
        "Name"=> "New test product",
        "Price"=> 10,
        "SKU"=> "SHIRT-1",
        "StartingSupply"=> 10,
        "StoreId"=> "e980c480-6675-40e1-a0b6-f2e2a63414d7",
        "Strategy"=> "Unlimited Supply"
    }
    
product2={
        "Cost"=> 4.5,
        "CurrentSupply"=> 10,
        "DateAvailable"=> "/Date(-62135596800000+0000)/",
        "DateCreated"=> "/Date(1338874208950+0000)/",
        "DateExpires"=> "/Date(-62135596800000+0000)/",
        "Description"=> "The second most amazing Nirvana t-shirt anyone will ever own",
        "LastEvaluation"=> "/Date(1338874208950+0000)/",
        "MANUCODE"=> "TSHIRT121", #optional
        "MaxPrice"=> 0,   #optional
        "MinPrice"=> 0,   #optional
        "Name"=> "New test product again",
        "Price"=> 10,
        "SKU"=> "SHIRT-1",
        "StartingSupply"=> 10,
        "StoreId"=> "e980c480-6675-40e1-a0b6-f2e2a63414d7",
        "Strategy"=> "Unlimited Supply"
    }

products.push(product1);
products.push(product2);
products_created= Product.create_many(store_api_key,products) #returns information about the newly created order as an array ofruby hashes
puts "Just created a products"

products_created.each do |pr|
puts "*****************************"
pp pr
puts "*****************************"
end

#---------------------------------------------------------------------------

#create a single product
product_created= Product.create(store_api_key,product1)
puts "Just created a product"
pp product_created

#---------------------------------------------------------------------------

#Retrieve a product details from the server using product Id
product_id= product_created["Id"] #Id of the order we just created
retrieved= Product.get(store_api_key,product_id)
puts "Product details retrieved from server"
pp retrieved


#---------------------------------------------------------

#Now let us modify an existing product and update it on the server
retrieved["Name"]="A new name" 
updated_product= Product.update(store_api_key,retrieved)
puts "Product details modified"
pp updated_product

#---------------------------------------------------------

#Now we may obtain a new price for a product
new_price=Product.get_new_price(store_api_key,updated_product["Id"])
puts "A new price for item #{updated_product['Name']} is #{new_price}"



#---------------------------------------------------------

#Deleting an existing product using product Id
puts "Deleting a product"
Product.delete(store_api_key,product_id)
