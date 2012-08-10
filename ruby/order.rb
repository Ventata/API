class Order
  
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
  
  BASEURI="https://api.ventata.com/order"
  
  def self.create(storeApiKey,info)
    jsondata=JSON.generate(info)
    url = URI.parse( (BASEURI+"?ApiKey=#{storeApiKey}") )
    
    request = Net::HTTP::Post.new(url.request_uri)
    http  = Net::HTTP.new(url.host, url.port) 
    http.use_ssl = true
    request.content_type = 'application/json'
    request.body = jsondata.to_s
    #request["Accept"] = 'application/json'
    response=http.start do |h| 
        h.request(request) 
      end
      
    #assert_equal '201 Created', response.get_fields('Status')[0]
    order_info= JSON.parse response.body
    return order_info  
  end
 
 def self.create_many(storeApiKey,info)
    jsondata=JSON.generate(info)
    url = URI.parse( (BASEURI+"/list?ApiKey=#{storeApiKey}") )
    
    request = Net::HTTP::Post.new(url.request_uri)
    http  = Net::HTTP.new(url.host, url.port) 
    http.use_ssl = true
    request.content_type = 'application/json'
    request.body = jsondata.to_s
    #request["Accept"] = 'application/json'
    response=http.start do |h| 
        h.request(request) 
      end
    #assert_equal '201 Created', response.get_fields('Status')[0]
    order_info= JSON.parse response.body
    return order_info  
  end
 
  
  def self.get(storeApiKey,orderId)
    
     url = URI.parse( (BASEURI+"/#{orderId}?ApiKey=#{storeApiKey}") )
     request = Net::HTTP::Get.new(url.request_uri)
     http  = Net::HTTP.new(url.host, url.port) 
     http.use_ssl = true
     request["Accept"] = 'application/json' #You have to set this field in request header in order to obtain 
                                           #respose as JSON
     response=http.start do |h| 
        h.request(request) 
      end
      order_info= JSON.parse response.body
      return order_info
  end
 
  
  def self.delete(storeApiKey,orderId)
    url = URI.parse( (BASEURI+"/#{orderId}?ApiKey=#{storeApiKey}") )
     request = Net::HTTP::Delete.new(url.request_uri)
     http  = Net::HTTP.new(url.host, url.port) 
     http.use_ssl = true
     request["Content-Length"]="0";
     response=http.start do |h| 
        h.request(request) 
      end
      
      return response.body
  end
end