# spring-cloud-microservices
Microservices using Spring Cloud


# API Gateway
In Microservices architecture, services communicate with each other. There are some common features that we want service call to implement which can be achieved using API Gateway

Features
  - Authentication, Authorization and Security
  - Rate Limits
  - Fault Tolerance
  - Service Aggregation


# Important Urls
These are the important Urls which is required to run these project in this repo.

Config Server
http://localhost:8888/limits-service/dev
http://localhost:8888/limits-service/qa
http://localhost:8888/limits-service

Eureka
http://localhost:8761

Limits Service
http://localhost:8080/limits
http://localhost:8082/limits

Currency Exchange Service
http://localhost:8000/currency-exchange/USD/to/INR

Currency Conversion Service
http://localhost:8100/currency-converter/EUR/to/INR/quantity/1000
http://localhost:8100/currency-converter-feign/EUR/to/INR/quantity/1000 (with Feign)

API Gateway
http://localhost:8765/currency-exchange-service/currency-exchange/EUR/to/INR
http://localhost:8765/currency-conversion-service/currency-converter-feign/EUR/to/INR/quantity/1000

Zipkin
http://localhost:9411

Hystrix
http://localhost:8080/hystrix-example

Spring Cloud Bus
http://localhost:8082/actuator/refresh (without spring bus)
http://localhost:8080/actuator/bus-refresh (This is the url with spring bus implemented)


