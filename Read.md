# ShoppingCart
### Creating order with a product
URL POST http://localhost:8080/api/carts
Content-Type Application/Json
Input payload:-
{
	"countryCode":"US",
	"currency":"USD",
	"products": [
		{
			"id":"11530621-5905-4d75-8317-db282c498c6f",
			"description":"Apple iPhone 12",
			"category":"ELECTRONICS",
			"price":"7325.05",
			"created":"2121-05-07T20:30:00",
			"updated":"2121-05-07T20:30:00"
		}
	
	],
	"created":"2121-05-07T20:30:00",
	"updated":"2121-05-07T20:30:00",
	"userId":"jai"
}
Response:-Product has been added in order

### Getting order details:-
URL GET http://localhost:8080/api/carts
Content-Type Application/Json
Response:-
{
    "userId": "jai",
    "countryCode": "US",
    "currency": "USD",
    "created": "2121-05-07T20:30:00",
    "updated": "2121-05-07T20:30:00",
    "products": [
        {
            "id": "11530621-5905-4d75-8317-db282c498c6f",
            "description": "Apple iPhone 12",
            "category": "ELECTRONICS",
            "price": 7325.05,
            "created": "2121-05-07T20:30:00",
            "updated": "2121-05-07T20:30:00"
        }
    ]
}

#### Updating product in order:-
URL PUT localhost:8080/api/carts/{cartId}/products
here {cartId} is product id ie 11530621-5905-4d75-8317-db282c498c6f
Content-Type Application/Json
Input Payload:-
{
	"countryCode":"US",
	"currency":"USD",
	"products": [
		{
			"id":"11530621-5905-4d75-8317-db282c498ctf",
			"description":"Fan",
			"category":"ELECTRICAL",
			"price":"7325.50",
			"created":"2121-05-07T20:30:00",
			"updated":"2121-08-07T20:30:00"
		}
	
	],
	"created":"2121-05-07T20:30:00",
	"updated":"2121-08-07T20:30:00",
	"userId":"jai"
}
response:-Product has been updated

#### Deleting product in order:-
URL DELETE localhost:8080/api/carts/{cartId}/products
here {cartId} is product id ie 11530621-5905-4d75-8317-db282c498c6f
Content-Type Application/Json

response:-Product has been deleted

#### Getting a particular product :-
URL DELETE localhost:8080/api/carts/{cartId}/products
here {cartId} is product id ie 11530621-5905-4d75-8317-db282c498c6f
Content-Type Application/Json

response:-
{
    "id": "11530621-5905-4d75-8317-db282c498c6f",
    "description": "Apple iPhone 12",
    "category": "ELECTRONICS",
    "price": 7325.05,
    "created": "2121-05-07T20:30:00",
    "updated": "2121-05-07T20:30:00"
}
