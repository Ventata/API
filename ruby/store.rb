class Store
  
    
  require 'open-uri'
  require 'json'
  #require 'net/http'
  require 'net/https'
  require "uri"
  
  #If any of the above gems is not available on your system, you can install them by running the command
  # gem install 'gem_name_here'
  #for example
  # gem install 'json'
  #to install json gem on your system
  
  #When using with Ruby on Rails, you may add this class to /lib directory in your applications root
  #You may add following line to your application's gemfile 
  # gem 'json'
  
  BASEURI ="https://api.ventata.com/store"

  def self.create(apiKey,info) #creates a new store at ventata.com
    
    jsondata=JSON.generate(info)
    url = URI.parse( (BASEURI+"?ApiKey=#{apiKey}") )
    
    request = Net::HTTP::Post.new(url.request_uri)
    http  = Net::HTTP.new(url.host, url.port) 
    http.use_ssl = true
    request.content_type = 'application/json'
    request.body = jsondata.to_s
    request["Accept"] = 'application/json'
    response=http.start do |h| 
        h.request(request) 
      end
      
      #assert_equal '201 Created', response.get_fields('Status')[0]
    store_info= JSON.parse response.body
    return store_info  
  end 
 
#---------------------------------------------------------------------------

 
   def self.modify(apiKey,info) #modify an exiting store by store Id
    jsondata=JSON.generate(info)
    url = URI.parse( (BASEURI+"?ApiKey=#{apiKey}") )
    request = Net::HTTP::Put.new(url.request_uri)
    http  = Net::HTTP.new(url.host, url.port) 
    http.use_ssl = true
    request.content_type = 'application/json'
    request.body = jsondata.to_s
    request["Accept"] = 'application/json'
    response=http.start do |h| 
        h.request(request) 
      end
      
      #assert_equal '201 Updated', response.get_fields('Status')[0]
    store_info= JSON.parse response.body
    return store_info  
   end
  
#------------------------------------------------------------------------------
  
   def self.delete(apiKey,storeId)   #Delete a store specified by storeId    
        url = URI.parse( (BASEURI+"/#{storeId}?ApiKey=#{apiKey}") )
        request = Net::HTTP::Delete.new(url.request_uri)
        http  = Net::HTTP.new(url.host, url.port) 
        http.use_ssl = true
        request["Content-Length"]="0";

    #request["Accept"] = 'application/json'
    response=http.start do |h| 
        h.request(request) 
      end
    
   end
   
#------------------------------------------------------------------------------------ 

 
   def self.all(apiKey)  #Retrieved all store data
    url = URI.parse((BASEURI+"/?ApiKey=#{apiKey}"))
    request = Net::HTTP::Get.new(url.request_uri)
    http  = Net::HTTP.new(url.host, url.port) 
    http.use_ssl = true
    request["Accept"] = 'application/json'
    response=http.start do |h| 
        h.request(request) 
      end
      
    all_stores= JSON.parse response.body
    return all_stores
   end
  
#------------------------------------------------------------------------------------ 
   
   def self.get(apiKey,storeId) #Get info of a particular store by Id
     
     url = URI.parse( (BASEURI+"/#{storeId}?ApiKey=#{apiKey}") )
     request = Net::HTTP::Get.new(url.request_uri)
     http  = Net::HTTP.new(url.host, url.port) 
     http.use_ssl = true
     request["Accept"] = 'application/json' #You have to set this field in request header in order to obtain 
                                           #respose as JSON
    response=http.start do |h| 
        h.request(request) 
      end
      store_info= JSON.parse response.body
      return store_info
   end
   
end