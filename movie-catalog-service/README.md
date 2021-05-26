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