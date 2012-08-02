
<?php
function send_order_to_ventata($order)
{
	//enter your store API key here
	$storeApiKey = '';
	
    $data = array();
    $data['DateCreated'] = "/Date(" . date('U', strtotime($order['date_purchased'])) . '+0000)/';
    $data['ExternalOrderId'] = $order['order_id'];
    $data['ShippingCost'] = $order['shipping_cost'];
    $data['SubTotal'] = $order['subtotal'];
    $data['Taxes'] = $order['taxes'];
    $data['TotalPrice'] = $order['total_price'];
    
	//populate the order details array
	$data['OrderDetails'] = array();
	foreach ($order['Order_Details'] as $orderDetail)
	{
		$tempData = array(
            'CostPerItem' => $products['products_price'],
            'ManuCode' => $products['products_model'],
            'Quantity' => $products['products_quantity'],
            'PricePaid' => $products['final_price'],
            'StoreCode' => $products['products_id']
        );
		
        array_push($data['OrderDetails'], $tempData);
	}	
    $data_string = json_encode($data);
    
    $ch = curl_init();
    
    $url = "https://api.ventata.com/order?ApiKey=" . $storeApiKey;

    curl_setopt($ch, CURLOPT_URL, $url);
    curl_setopt($ch, CURLOPT_POST, true);
    curl_setopt($ch, CURLOPT_POSTFIELDS, $data_string);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_HTTPHEADER, array("Content-Type: application/json"));
    curl_setopt($ch, CURLOPT_VERBOSE, true);
    
    $result = curl_exec($ch);	
    
    curl_close($ch);
}
?>

