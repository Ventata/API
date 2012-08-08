package com.ventata.persistence.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyUtils {
	
	/*	 
    Create a URL.
    Retrieve the URLConnection object.
    Set output capability on the URLConnection.
    Open a connection to the resource.
    Get an output stream from the connection.
    Send Request.
    Gets Response.
    Write to the output stream.
    Close the output stream.
	 */	
    /**
     * @param json      json message
     * @param resource  URL to connect to
     * @param method wether GET or POST
     * @return String Response
     */
    public String createRequestRW(String json, String resource, String methodType)
    {
        String jsonResponse = "";
        URL ventataURL ;
        HttpURLConnection ventataCon =null;
        StringBuffer response = new StringBuffer(); 
        try
        {

            ventataURL = new URL(resource);
            ventataCon = (HttpURLConnection)ventataURL.openConnection();
            ventataCon.setRequestMethod(methodType);
            /*
            BufferedReader in = new BufferedReader(new InputStreamReader(ventataCon.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) 
                System.out.println(inputLine);
            in.close();*/
            ventataCon.setRequestProperty("Content-Type", "application/json");
         			
             ventataCon.setRequestProperty("Content-Length", "" + Integer.toString(json.getBytes().length));
             ventataCon.setRequestProperty("Content-Language", "en-US");  
         			
            ventataCon.setUseCaches (false);
            ventataCon.setDoInput(true);
            ventataCon.setDoOutput(true);

               //Send request
               DataOutputStream wr = new DataOutputStream (
            		   ventataCon.getOutputStream ());
               wr.writeBytes (json);
               wr.flush ();
               wr.close ();

               //Get Response	
               InputStream is = ventataCon.getInputStream();
               BufferedReader rd = new BufferedReader(new InputStreamReader(is));
               String line; 
               while((line = rd.readLine()) != null) {
                 response.append(line);
                 response.append('\r');
               }
               rd.close();
              // return response.toString();
          }
            
        catch (Exception e) {

            e.printStackTrace();
            return null;

          } finally {

            if(ventataCon != null) {
            	ventataCon.disconnect(); 
            }
          }
        
        if(response != null && !response.toString().equals(""))
        {
        	jsonResponse=response.toString();	
        }
        
        return jsonResponse;
    }
    
	/*	 
    Create a URL.
    Retrieve the URLConnection object.
    Set output capability on the URLConnection.
    Open a connection to the resource.
    Get an output stream from the connection.
    Gets Response.
    Close the output stream.
	 */	
    /**
     * @param json      json message
     * @param resource  URL to connect to
     * @param method wether GET or POST
     * @return String Response
     */
    public String createRequestR(String resource, String methodType)
    {
        String jsonResponse = "";
        URL ventataURL ;
        HttpURLConnection ventataCon =null;
        StringBuffer response = new StringBuffer(); 
        try
        {

            ventataURL = new URL(resource);
            ventataCon = (HttpURLConnection)ventataURL.openConnection();
            ventataCon.setRequestMethod(methodType);
            ventataCon.setRequestProperty("Content-Type", "application/json");

               //Get Response	
               InputStream is = ventataCon.getInputStream();
               BufferedReader rd = new BufferedReader(new InputStreamReader(is));
               String line;
               
               while((line = rd.readLine()) != null) {
                 response.append(line);
                 response.append('\r');
               }
               rd.close();
          }
            
        catch (Exception e) {

            e.printStackTrace();
            return null;

          } finally {

            if(ventataCon != null) {
            	ventataCon.disconnect(); 
            }
          }

        if(response != null && !response.toString().equals(""))
        {
        	jsonResponse=response.toString();	
        }
        
        return jsonResponse;
    }
}
