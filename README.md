# ProductAPI

Product API consists of two services. Product API, a Spring Boot REST service which is used 
to get product details like product name and price. Product API gets product name from Product Name REST service 
which is a Python Flask REST service. 
                                                     
                                                     Product API 
Description

    Product API is REST service to get and update product details.

Tech Stack

    Java 1.8
    Spring Boot
    Cassandra 3.9
                                     
Setup

    Cassandra
        Download Cassandra from https://academy.datastax.com/planet-cassandra/cassandra
        Unzip the file
        Navigate to datastax-ddc-3.9.0/bin
        Run Cassandra server ./cassandra (on Linux)
        To create keyspace, tables and insert data, execute following command from bin folder in a new terminal tab
            ./cqlsh -f /Users/macha/Documents/JavaWorkspace/TargetProductAPI/data.cql
    
    Run Application
        Navigate to project root folder
        Download dependencies and build project by executing - mvn clean install
        To run the server, execute java -jar target/target-product-api.jar
        
            
Endpoints
     
    GET /products/{id} gets a product by product id
    PUT /products/{id} updates product price 


GET /products/{id}           

    This endpoint returns product details by product id. 

    Request
        GET /products/1234567
    Response
                    {
                         "id": 1234567,
                         "name": "big movie",
                         "current_price": {
                             "value": 999.87,
                             "currencyCode": "USD"
                         }
                     }
        
PUT /products/{id}           

    This endpoint updates price of a product by product id. 
    Request
        PUT /products/1234567
    
        payload {
                     "id": 1234567,
                     "name": "big movie",
                     "current_price": {
                         "value": 999.87,
                         "currencyCode": "USD"
                     }
                 }
        
    Response
        Http status 204 No content, indicating operation was successful
        Http status 400 Bad request, with ValidationException if price is not provided
        
                            
                                        Product Name API
Description           

    Product Name API is a Python Flask REST service to retreive product names. 
    
Tech Stack           

     Python 2.7 (can work with later versions)
     Flask 0.12.2
     
Setup   
     
     Needs Python installation

     install pip - https://packaging.python.org/guides/installing-using-linux-tools/
     install virtualenv - https://packaging.python.org/guides/installing-using-pip-and-virtualenv/
     
     Virtual environment
        Create a virtual environment target by executing virtualenv -v target
        To activate virtual environment, run commmand source target/bin/activate
     Installing packages
        Navigate to project_root/TargetProductNameService
        Install packages by running pip install -r requirements.txt
     Run server
        To run server, from the same folder, run commad python productnameservice.py
        Server runs at localhost on port 8100 http://127.0.0.1:8100/ 

GET /products/{id}           

    This endpoint returns product details by product id. 

    Request
        GET /products/1234567
    Response
                    {
                         "id": 1234567,
                         "name": "big movie",
                     }
        
          if the product information is not available, returns null for name 
        {
            "id": "123456711",
            "name": null
        }
POST /products/{id}           

    This endpoint updates price of a product by product id. 
    Request
        POST /products
    
        payload {
                     "id": 1234567,
                     "name": "big movie",
                 }
        
    Response
        Http status 201, indicating operation was successful
        Http status 400 Bad request, if name or id or both is not provided
