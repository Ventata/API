require './company.rb'
require 'pp'

#Retrieve your company info using company API key
#Use the company API key you recieved via email while signing up

api_key="856fd725-cbf1-4dd4-9e3d-96b0a9ceefd4" #Replace it with API Key for your company

company_info= Company.get(api_key)
#The information is recieved as a ruby hash
puts "Company info recieved from server"
pp company_info

#You can access individual componets as below
company_name= company_info["Name"]
puts "Name of the company is #{company_name}"
