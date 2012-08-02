
<?php
function send_product_to_ventata($product_id)
{   
	//enter your ventata store API key here
	$storeApiKey = '';
	
	//build out the product in the data array
    $data = array(
        'Cost' => 0,
        'DateCreated' => '/Date(' . date('U', strtotime($product['products_date_added'])) . '+0000)/',
        'Description' => $product['products_description'],
        'MANUCODE' => $product['products_model'],
        'Name' => $product['products_name'],
        'Price' => $product['products_price'],
        'SKU' => product['SKU'],
        'StoreCode' => $product['products_id'],
        'Strategy' => 'Unlimited Supply',        
    );
    
	//encode the array in json...
    $data_string = json_encode($data);
	
	//and send it via curl
    $ch = curl_init();
    $url = "https://api.ventata.com/product/" . $product_id . "/price?ApiKey=" . $apiKey;    

	curl_setopt($ch,CURLOPT_URL,$url);
	curl_setopt($ch,CURLOPT_RETURNTRANSFER,1);
	curl_setopt($ch,CURLOPT_CONNECTTIMEOUT,$timeout);
    curl_setopt($ch, CURLOPT_HTTPHEADER, array("accept: text/json"));
	$data = json_decode(curl_exec($ch));
	curl_close($ch);
	
	return $data->{'Price'};
}

?>

