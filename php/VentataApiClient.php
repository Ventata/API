<?php

set_include_path(get_include_path() . PATH_SEPARATOR . dirname(__FILE__));
require 'VentataRequest.php';
// ------------------------------------------------------------------------

/**
 * Ventata API Client Class
 * A wrapper around Ventata Request Handler Class
 *
 * @package                  Ventata API
 * @subpackage          Library
 * @category                 Library
 * @author		        Can Ince
 */
// ------------------------------------------------------------------------

class VentataApiClient extends VentataRequest
{

        /**
         * Constructor
         *
         * @access	    public
         * @param           string  apiKey
         */
        public function __construct($apiKey)
        {
                parent::__construct($apiKey);
        }

        /**
         * Destructor
         */
        public function __destruct()
        {
                parent::__destruct();
        }

        /**
         * Send a store to Ventata
         *
         * @access	    public
         * @param           string  storeName
         * @param           string  storeURL
         * @return	    string
         */
        public function sendStoreToVentata($storeName, $storeURL)
        {
                //build the store information in an array
                $data = array(
                    'Name' => $storeName,
                    'URL' => $storeURL
                );

                return $this->_request($data, 'store');
        }

        /**
         * Send a product to Ventata
         *
         * @access	    public
         * @param           array  product
         * @param           string  operationType
         * @return	    string
         */
        public function sendProductToVentata($product, $operationType = 'create')
        {
                //operationType can be create, update or delete
                //build out the product in the data array
                $data = array(
                    'Cost' => 0,
                    'DateCreated' => '/Date(' . date('U', strtotime($product['products_date_added'])) . '+0000)/',
                    'Description' => $product['description'],
                    'MANUCODE' => $product['model'],
                    'Name' => $product['name'],
                    'Price' => $product['price'],
                    'SKU' => $product['sku'],
                    'StoreCode' => $product['id'],
                    'Strategy' => 'Unlimited Supply',
                );
                if ($operationType == 'delete' || $operationType == 'get')
                {
                        return $this->_request($data, 'product/' . $product['id'], $operationType);
                }
                else
                        return $this->_request($data, 'product', $operationType);
        }

        /**
         * Send multiple products to Ventata
         *
         * @access	    public
         * @param           array  products
         * @param           string  operationType
         * @return	    string
         */
        public function sendMultipleProductsToVentata($products, $operationType = 'create')
        {
                //operationType can be create, update or delete
                //build out the product in the data array
                $data = array();
                foreach ($products as $product)
                {
                        if (!isset($product['name']))
                                continue;
                        $data[] = array(
                            'Cost' => 0,
                            'DateCreated' => '/Date(' . date('U', strtotime($product['products_date_added'])) . '+0000)/',
                            'Description' => $product['description'],
                            'MANUCODE' => $product['model'],
                            'Name' => $product['name'],
                            'Price' => $product['price'],
                            'SKU' => $product['sku'],
                            'StoreCode' => $product['id'],
                            'Strategy' => 'Unlimited Supply',
                        );
                }
                return $this->_request($data, 'products/list', $operationType);
        }

        /**
         * Send an order to Ventata
         *
         * @access	    public
         * @param           array  order
         * @return	    string
         */
        public function sendOrderToVentata($order)
        {
                //build out the order in the data array
                $data = array();
                $data['DateCreated'] = "/Date(" . date('U', strtotime($order['date_purchased'])) . '+0000)/';
                $data['ExternalOrderId'] = $order['order_id'];
                $data['ShippingCost'] = $order['shipping_cost'];
                $data['SubTotal'] = $order['subtotal'];
                $data['Taxes'] = $order['taxes'];
                $data['TotalPrice'] = $order['total_price'];

                //build out the order details in the data['OrderDetails'] array
                $data['OrderDetails'] = array();
                foreach ($order['OrderDetails'] as $orderDetail)
                {
                        $tempData = array(
                            'CostPerItem' => $orderDetail['products_price'],
                            'ManuCode' => $orderDetail['products_model'],
                            'Quantity' => $orderDetail['products_quantity'],
                            'PricePaid' => $orderDetail['PricePaid'],
                            'StoreCode' => $orderDetail['StoreCode']
                        );

                        array_push($data['OrderDetails'], $tempData);
                }

                return $this->_request($data, 'order');
        }

        /**
         * Send multiple orders to Ventata
         *
         * @access	    public
         * @param           array  orders
         * @return	    string
         */
        public function sendMultipleOrdersToVentata($orders)
        {
                //build out the order in the data array
                $orderList = array();
                foreach ($orders as $order)
                {
                        $data = array();
                        $data['DateCreated'] = "/Date(" . date('U', strtotime($order['datePurchased'])) . '+0000)/';
                        $data['ExternalOrderId'] = $order['id'];
                        $data['ShippingCost'] = $order['shipping_cost'];
                        $data['SubTotal'] = $order['subtotal'];
                        $data['Taxes'] = $order['taxes'];
                        $data['TotalPrice'] = $order['total_price'];

                        //build out the order details in the data['OrderDetails'] array
                        $data['Order_Details'] = array();
                        foreach ($order['OrderDetails'] as $orderDetail)
                        {
                                $tempData = array(
                                    'CostPerItem' => $orderDetail['products_price'],
                                    'ManuCode' => $orderDetail['products_model'],
                                    'Quantity' => $orderDetail['products_quantity'],
                                    'PricePaid' => $orderDetail['PricePaid'],
                                    'StoreCode' => $orderDetail['StoreCode']
                                );
                                array_push($data['Order_Details'], $tempData);
                                $orderList[] = $data;
                        }
                }//echo '<pre>';print_r($orderList);exit;
                return $this->_request($orderList, 'orders/list');
        }

        /**
         * Get the new price from Ventata for a given product
         *
         * @access	    public
         * @param           int  productId
         * @return	    int
         */
        public function getNewPriceFromVentata($productId)
        {
                $data = array();
                $result = $this->_request($data, 'product/' . $productId . '/price', 'get');
                $resultObj = json_decode($result);
                return $resultObj->{'Price'};
        }

        /**
         * Get the  Ventata ID of a local product
         *
         * @access	    public
         * @param           int  productId
         * @return	    int
         */
        public function getVentataProductIdFromLocalId($productId)
        {
                $data = array();
                $result = $this->_request($data, 'product/provider/' . $productId, 'get');
                $resultObj = json_decode($result);
                return $resultObj->Id;
        }

        /**
         * Get the  Ventata ID of a local order
         *
         * @access	    public
         * @param           int  orderId
         * @return	    int
         */
        public function getVentataOrderIdFromLocalId($productId)
        {
                $result = $this->_request($data, 'orders/provider' . $orderId, 'get');
                $resultObj = json_decode($result);
                return $resultObj->Id;
        }

}