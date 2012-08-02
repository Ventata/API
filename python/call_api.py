import requests
import json

def make_request(method, url, api_key, data=None):

	if data:
		data = json.dumps(data)

	r = requests.request(
		method,
		url,
		headers={
			'Content-Type': 'application/json',
			'Accept': 'application/json'
		},
		params={'ApiKey': api_key},
		data=data
	)

	return (r.status_code, r.json)

def get(url, api_key, data):
	return make_request('get', url, api_key, data)

def post(url, api_key, data):
	return make_request('post', url, api_key, data)

def put(url, api_key, data):
	return make_request('put', url, api_key, data)

def delete(url, api_key, data):
	return make_request('delete', url, api_key, data)

