# Spring Boot-h2db

The Spring Boot-h2db application allows you to add and retrieve user details and also parses the JSON object and calculates the frequency of words in a given string.

## Running Locally

1. git clone https://github.com/divyaashritha/springboot-h2db.git
2. cd springboot-h2db
3. Open Eclipse 
   - File -> Import -> Existing Maven Project -> Navigate to springboot-h2db folder
   - Select the project
3. Run as JavaApplication
4. Navigate to localhost:8080.

### Requirements

* [Maven](https://maven.apache.org/) - Dependency Management
* [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit 
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* [Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation).
* [github](https://github.com/) - Free and Open-Source distributed version control system.

### Swagger UI

[Swagger UI](https://github.com/swagger-api/swagger-ui).
View Swagger UI at http://localhost:8080/swagger-ui.html

### Database

Uses a H2 in memory database.


### CRUD end points

|Endpoint                                   | HTTP   | Action     | Description                            
|-------------------------------------------|--------|------------|-------------------------------------|
|/frequencyCount                            | POST   | Create     | Creates a string with list of words |
|/list                                      | GET    | Show       | Lists all Users                     |
|/findUser?id=(param)                       | GET    | Show       | Lists Unique user                   |
|/User                                      | POST   | Create     | Creates user                        |



### POST  /frequencyCount

Using Postman/Insomnia set the request type to POST and input URL as 

~~~
localhost:8080/frequencyCount
~~~

Sample Input.

~~~
{
	"para" : "beta alpha gamma delta alpha"
	
}
~~~

Once you send the request the Output will look like- sorted order:

~~~
[
    {
        "w": "alpha",
        "n": 2
    },
    {
        "w": "beta",
        "n": 1
    },
    {
        "w": "delta",
        "n": 1
    },
    {
        "w": "gamma",
        "n": 1
    }
]
~~~

### POST  /user

This Rest call will insert the data into user table. 

~~~
localhost:8080/user
~~~

Sample Input

~~~
{
	"firstName" : "Divya" ,
	"lastName" : "Ash",
	"email" : "test@mailinator.com",
	"password" : "*****"
}
~~~
once you send the request , we will get 200 if its successfull.

### GET /findUser?id=(param)

Get unique user based on user ID.

~~~
localhost:8080/findUser?id=1
~~~

Once you send the request sample will be as follows:

~~~
{
  "id": 1,
  "firstName" : "Divya" ,
  "lastName" : "Ash",
  "email" : "test@mailinator.com",
  "password" : "*****"
}
~~~

### GET /list

Lists all user values.

~~~
localhost:8080/list
~~~

Once you send the request sample will be as follows:

~~~
[
    {
      "id": 1,
      "firstName" : "Divya" ,
      "lastName" : "Ash",
      "email" : "test@mailinator.com",
      "password" : "*****"
    },
    {
      "id": 2,
      "firstName" : "divyaashritha" ,
      "lastName" : "Duggimpudi",
      "email" : "test_divya@mailinator.com",
      "password" : "*****"
    }
]
~~~

### JaCoCo Report
For code coverage report to be generated we can run the below command in CLI with the pom.xml directory path

```
mvn test
mvn jacoco:report
```
