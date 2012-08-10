class Company
  
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
  
  
  BASEURI ="https://api.ventata.com/company"
  

  def self.get(apiKey) 
     
     url = URI.parse( (BASEURI+"?ApiKey=#{apiKey}") )
     request = Net::HTTP::Get.new(url.request_uri)
     http  = Net::HTTP.new(url.host, url.port) 
     http.use_ssl = true
     request["Accept"] = 'application/json' #You have to set this field in request header in order to obtain 
                                           #respose as JSON
    response=http.start do |h| 
        h.request(request) 
      end
      company_info= JSON.parse response.body
      return company_info
  end
  
end