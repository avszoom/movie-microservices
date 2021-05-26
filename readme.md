We are creating 3 microservices movie catalog service, movie-info service
and rating-data-service.

Here movie-catalog-service makes a synchronus call to other two service 
to fetch movie information and show it to user.

Build projects -

1) build each of these projects using mvn clean install
2) make sure jar is generated.

run project - 
1) run each of these projects using java -jar target/jar file

I have added swagger to check more info about api which can
be found at /swagger-ui.html