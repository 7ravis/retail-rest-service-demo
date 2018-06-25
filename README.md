# Retail REST Service Demo

## Description
Demo of a RESTful web service for retail products. The service aggregates product data from multiple sources and returns it as JSON to the caller.

## How to Use
1. From the [homepage](https://github.com/7ravis/retail-rest-service-demo), clone or download this repository. 
1. Open a new terminal and navigate to the parent directory containing `pom.xml`, or open the project in your preferred IDE.
1. Install Maven if you don't already have it (instructions can be found [here](https://maven.apache.org/install.html)).
1. If you are using the terminal, run `mvn install`, or from your IDE, build the project with Maven, using the "install" goal.
1. [Install MongoDB](https://docs.mongodb.com/manual/installation/).
1. Start MongoDB and populate it with [ProductPrice_MongoDbImpl](https://github.com/7ravis/retail-rest-service-demo/blob/master/retail-rest-service-demo/src/main/java/com/travrog/retailrestservicedemo/domain/ProductPrice_MongoDbImpl.java) objects for any ids you want to demo.
1. Check that you have an internet connection and that the ids you want to demo are valid by sending an HTTP GET request to `https://redsky.target.com/v2/pdp/tcin/{id}`, replacing `{id}` with the real id. A JSON document will be returned if the id is valid.
1. Run the application. You can do this by running the `retail-rest-service-demo/retail-rest-service-demo/target/retail-rest-service-demo-0.0.1-SNAPSHOT.jar` that you built during the Maven install goal, or by running [RetailRestServiceDemoApplication.java](https://github.com/7ravis/retail-rest-service-demo/blob/master/retail-rest-service-demo/src/main/java/com/travrog/retailrestservicedemo/RetailRestServiceDemoApplication.java) as a Java Application from your IDE.
1. If everything went as planned, you should be able to send HTTP GET and PUT requests to `http://localhost:8080/products/{id}`, replacing `{id}` with the real id. With PUT requests, you must include a JSON request body with the new price. Here is an example that you can copy/paste as a template:
```
{
"value": 150.99,
"currency_code": "USD"
}
```

## Unit Tests
The unit tests ran when you installed the project with Maven, but to rerun the unit tests without reinstalling the jar in your .m2 directory, you can use the terminal and run `mvn test` from the directory with the `pom.xml` file, or build the project from your IDE with Maven using the "test" goal (or run a specific class in `src/test/java/` from your IDE as a JUnit test).
