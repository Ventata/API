require 'pp'
require './store.rb'


api_key="856fd725-cbf1-4dd4-9e3d-96b0a9ceefd4" #Replace it with API Key of your company


#create a new store
new_store= {
    :Name => "My Awesome TShirt Store",
    :StoreType=> {
        :Id=> 2038,
        :Name=> "Custom"
     },
    :URL=> "https://myTShirtStoreOnline.com"
}

store_info= Store.create(api_key,new_store) #returns information about the newly created store as ruby hash
puts "Just created a new store"
pp store_info

##------------------------------------------------------------------


#modifying the store just created
new_store={   :Id=>store_info["Id"], #Store Id as returned by the server
              :Name=>"My Modified TShirt Store",
              :StoreType=> {
                :Id=> store_info["StoreType"]["Id"],
                :Name=> "Modified Name"
            },
                :URL=> "https://myTShirtStoreOnline.com"
        }


modified_store_info = Store.modify(api_key,new_store) #returns information about the modified  store as ruby hash
puts "Modified the store"
pp modified_store_info
##------------------------------------------------------------------


#Get info of all stores

all_stores=Store.all(api_key) #list of all stores as an array of hashes
puts "All avaialable stores"
pp all_stores
puts "Iterating through stores"
all_stores.each do |store|
  puts "Store name:#{store["Name"]}  | Store Id:#{store["Id"]}"
end


##------------------------------------------------------------------

#Get info of a particular store
store_id = modified_store_info["Id"] #Idof the store we just modified above
info= Store.get(api_key,store_id)
puts "Info of store with Id #{store_id} is"
pp info


#Delete a store by store Id
puts "Deleting store"
Store.delete(api_key,store_id) 
