To add eureka client go to spring initalize and add
eureka client as dependency copy all those dependency here
and now our service will find eureka server at default
port 8761 in same network if found it will register 
itself.

Now to call other service what we do is we make our rest template
annotated with @LoadBalanced this makes resttemplate to discover 
server and get other service via name and then make call
to that service. all this step annotation do. So we do not need to do
anything.

we use eureka.client.serviceUrl.defaultZone: http://localhost:8123/eureka/
in application properties to tell the location of eureka server
note localhost:8123/ gives us a UI to see registerd instances
but locahost:8123/eureka/ is the link which client uses to register
itself or send heartbeats if needed.