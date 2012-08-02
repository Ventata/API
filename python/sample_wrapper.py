from call_api import get, post, put, delete
import json

class VentataAPI:
	BASE_URL = 'https://api.ventata.com/'

	def __init__(self, api_key):
		self.api_key = api_key
	
	def get(self, endpoint, data=None):
		return get(VentataAPI.BASE_URL + endpoint, self.api_key, data)
	
	def post(self, endpoint, data=None):
		return post(VentataAPI.BASE_URL + endpoint, self.api_key, data)

	def put(self, endpoint, data=None):
		return put(VentataAPI.BASE_URL + endpoint, self.api_key, data)

	def delete(self, endpoint, data=None):
		return delete(VentataAPI.BASE_URL + endpoint, self.api_key, data)


if __name__ == '__main__':

        #enter the company api key you receive after signing up with us here:
	COMPANY_API_KEY = ''
	
	ventata_api = VentataAPI(COMPANY_API_KEY)
	
	#create a store
	data = {
                'Name': 'My Awesome TShirt Store',
                'URL': 'https://myTShirtStoreOnline.com/'
        }	
	http_code,response_json = ventata_api.post('store', data)	
	print('Created product: (press Enter to continue)')
	print(json.dumps(response_json, indent=4))
	raw_input()

        #get the API key associated with your store
	STORE_API_KEY = response_json[0]['ApiKey']

        #use that new store API key to perform the store related requests
	ventata_api = VentataAPI(STORE_API_KEY)

	#get a store id from the first store associated with this API key
	http_code,response_json = ventata_api.get('store')
	store_id = response_json[0]['Id']

	#create product
	data = {
		'Cost': 4.5,
		'CurrentSupply': 0,
		'DateAvailable': '/Date(-62135596800000+0000)/',
		'DateCreated': '/Date(1338874208950+0000)/',
		'DateExpires': '/Date(-62135596800000+0000)/',
		'Description': 'The most amazing Nirvana t-shirt anyone will ever own',
		'MANUCODE': 'TSHIRT120',
		'MaxPrice': 0,
		'MinPrice': 0,
		'Name': 'New testing',
		'Price': 10,
		'SKU': 'SHIRT-1',
		'StartingSupply': 0,
		'StoreId': store_id,
		'Strategy': 'Unlimited Supply'
	}
	http_code,response_json = ventata_api.post('product', data)
	print('Created product: (press Enter to continue)')
	print(json.dumps(response_json, indent=4))
	raw_input()

	#place order
	product_id = response_json['Id']
	data = {
		'StoreId': store_id,
		'ExternalOrderId': '193758-0',
		'SubTotal': 10,
		'ShippingCost': 3.5,
		'Taxes': 0,
		'TotalPrice': 13.5,
		'OrderDetail': [
			{
				'ProductId': product_id,
				'StoreCode': 'SHIRT-1',
				'ManuCode': 'TSHIRT120',
				'Quantity': 1,
				'CostPerItem': 10,
				'PricePaid': 10
			}
		],
		'DateCreated': '/Date(1224043200000+0000)/'
	}
	http_code,response_json = ventata_api.post('order', data)
	print('New order: (press Enter to continue)')
	print(json.dumps(response_json, indent=4))
	raw_input()

	#get a new price
	http_code,response_json = ventata_api.get('product/' + product_id + '/price')
	new_price = response_json[0]['Price']
	print(new_price)
