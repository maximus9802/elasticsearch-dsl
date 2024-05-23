Elasticsearch DSL with Springboot
=================================


Prerequisites
-------------

Before you start, ensure you have the following installed on your machine:

    Docker
    Docker Compose

Getting Started
---------------

Step 1: Start the services
    
    docker-compose up -d

Step 2: Verify Elasticsearch

To verify that Elasticsearch is running, you can send a request to `http://localhost:9200` using `curl` or your web browser

    curl -X GET "localhost:9200/"

Step 3: Access Kibana

You can access Kibana by navigating to `http://localhost:5601` in your browser. Log in using the username and password that were set up in the docker-compose.

Step 4: Import data to Elasticsearch

Open `Dev Tools` in Kibana. Run `PUT /bank/_doc` with content of file `accounts.json` in `src/main/resource/data` directory. 
