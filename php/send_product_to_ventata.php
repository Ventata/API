
<?php
function send_product_to_ventata($product)
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
    $url = "https://api.ventata.com/product?ApiKey=" . $apiKey;    
    curl_setopt($ch, CURLOPT_URL, $url);
    curl_setopt($ch, CURLOPT_POST, true);
    curl_setopt($ch, CURLOPT_POSTFIELDS, $data_string);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_HTTPHEADER, array("Content-Type: application/json"));
    curl_setopt($ch, CURLOPT_VERBOSE, true);
    
    $result = curl_exec($ch);	
    print_r($result);
    curl_close($ch);
}

?>

