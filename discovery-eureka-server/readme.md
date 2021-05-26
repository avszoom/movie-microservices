This is eureka server developed by netflix and included in spring boot umbrella.
It act as a phone book and other services register them self as client.

Now spring operate in client mode which means when someone wants to call other
service they first ask this eureka server about service and then server
responds back with service address and then client communicate with service directly

Now there is another model in which client just communicate with this server and tells
that please give this message to service A and server do this job on behalf of client.

1) we just need to add dependency in pom
2) Mark main application with @EnableEurekaServer

Caveat -

if java language is 11 then this eureka module throw some error related
to jaxb as jaxb was deperecate at level 9 or 10 hence doesnt come by default
while this library needs it so we need to include it in pom.

we need to add following property -

eureka.client.register-with-eureka=false   
eureka.client.fetch-registry=false

otherwise eureka server keep trying to connect to other server
and share registry with other and keep throwing error.

build and run -

1) build project as jar and run using java -jar
2) and at root url you will get url to see which client registered