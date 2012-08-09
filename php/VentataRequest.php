<?php

// ------------------------------------------------------------------------

/**
 * Ventata HTTP Request Handler Class
 *
 * @package                  Ventata API
 * @subpackage          Library
 * @category                 Library
 * @author		        Can Ince
 */
// ------------------------------------------------------------------------

abstract class VentataRequest
{

        protected $_storeApiKey = NULL;
        protected $_curl = FALSE;
        private $_debug = FALSE;
        private $_outputFile;

        /**
         * Constructor
         *
         * @access	    public
         * @param           string  apiKey
         */
        public function __construct($apiKey)
        {
                if (!isset($apiKey) || $apiKey == NULL)
                        die('Connection Error: You need to enter your store API Key');
                $this->_setApiKey($apiKey);
                $this->_cURLInit();
        }

        /**
         * Destructor
         */
        public function __destruct()
        {
                $this->_cURLClose();
        }

        /**
         * Set Debug Mode
         *
         * @access	    public
         * @param           string  mode
         * @return	    boolean
         */
        public function setDebug($outputFile = FALSE)
        {
                if ($outputFile !== FALSE)
                {
                        $this->_debug = TRUE;
                        $this->_outputFile = $outputFile;
                }
                return TRUE;
        }

        /**
         * Set the API Key
         *
         * @access	    protected
         * @param           string  apiKey
         * @return	    boolean
         */
        protected function _setApiKey($apiKey)
        {
                $this->_storeApiKey = $apiKey;
                return TRUE;
        }

        /**
         * Process cURL Request
         *
         * @access	    protected
         * @param           array  $data
         * @return	    string
         */
        protected function _request($data, $URI, $type = 'create')
        {
                if (!isset($data) || !is_array($data))
                        return 'Request Error: No data input';
                if (!isset($URI) || $URI == NULL)
                        return 'Request Error: No operation specified.';
                $dataString = json_encode($data);
                if ($this->_debug === TRUE)
                {
                        file_put_contents((dirname(__FILE__) . '/tests/' . $this->_outputFile . '.json'), $dataString);
                }
                $url = 'https://api.ventata.com/' . $URI . '?ApiKey=' . $this->_storeApiKey;

                curl_setopt($this->_curl, CURLOPT_URL, $url);
                curl_setopt($this->_curl, CURLOPT_HTTPHEADER, array('Content-Type: application/json'));
                curl_setopt($this->_curl, CURLOPT_VERBOSE, TRUE);
                curl_setopt($this->_curl, CURLOPT_RETURNTRANSFER, TRUE);
              
                switch ($type)
                {
                        case 'create':
                                curl_setopt($this->_curl, CURLOPT_POST, TRUE);
                                curl_setopt($this->_curl, CURLOPT_POSTFIELDS, $dataString);
                                break;

                        case 'update':

                                $fp = fopen('php://temp/maxmemory:256000', 'w');
                                if (!$fp)
                                {
                                        return ('System Error: could not open temp memory data');
                                }
                                fwrite($fp, $dataString);
                                fseek($fp, 0);
                                curl_setopt($this->_curl, CURLOPT_BINARYTRANSFER, TRUE);
                                curl_setopt($this->_curl, CURLOPT_PUT, TRUE);
                                curl_setopt($this->_curl, CURLOPT_INFILE, $fp);
                                curl_setopt($this->_curl, CURLOPT_INFILESIZE, strlen($dataString));
                                break;

                        case 'delete':
                                curl_setopt($this->_curl, CURLOPT_CUSTOMREQUEST, 'DELETE');
                                break;

                        case 'get':
                               curl_setopt($this->_curl, CURLOPT_HTTPGET, TRUE);
                                break;

                        default:
                                return 'Type Error: Specify create, update or delete';
                                break;
                }

                $result = curl_exec($this->_curl);
                return $result;
        }

        /**
         * Init cURL connection
         *
         * @access	    protected
         */
        protected function _cURLInit()
        {
                if ($this->_curl == FALSE)
                        $this->_curl = curl_init();
        }

        /**
         * close cURL connection
         *
         * @access	    protected
         */
        protected function _cURLClose()
        {
                if ($this->_curl != FALSE)
                        curl_close($this->_curl);
        }

}