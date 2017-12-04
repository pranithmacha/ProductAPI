# TargetProductAPI
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
    
                                       
Product Name API
Python 2.7
Flask 0.12.2
install pip - https://packaging.python.org/guides/installing-using-linux-tools/
install virtualenv - https://packaging.python.org/guides/installing-using-pip-and-virtualenv/

