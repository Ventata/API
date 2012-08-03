
<?php
function get_new_price_from_ventata($product_id)
{   
	//enter your ventata store API key here
	$storeApiKey = '';
	
	//call out to ventata api for new price
	$ch = curl_init();
	$url = "https://api.ventata.com/product/" . $product_id . "/price?ApiKey=" . $apiKey;
	curl_setopt($ch,CURLOPT_URL,$url);
	curl_setopt($ch,CURLOPT_RETURNTRANSFER,1);
	curl_setopt($ch,CURLOPT_CONNECTTIMEOUT,$timeout);
	curl_setopt($ch, CURLOPT_HTTPHEADER, array("accept: text/json"));
	$data = json_decode(curl_exec($ch));
	curl_close($ch);
	
	//return the new price
	return $data->{'Price'};
}

?>

