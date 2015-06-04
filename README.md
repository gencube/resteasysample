resteasysample
====

Sample Code of publishing a RestEasy 3.0.11.Final and 3.0.9.Final 
Person Service.
Currently RestEasy Library has a bug which I had filed a Jira Case:
https://issues.jboss.org/browse/RESTEASY-1180


Build instructions
-------------------

```
git clone https://github.com/gencube/resteasysample.git
cd resteasysample
mvn clean package
```

Run the Service
----------------

```
java -cp target/mrs-all-jar-with-dependencies.jar jetty.JettyServer
2015-06-04 14:40:52.555:INFO::main: Logging initialized @223ms
2015-06-04 14:40:52.674:INFO:oejs.Server:main: jetty-9.2.z-SNAPSHOT
2015-06-04 14:40:52.859:INFO:oejw.StandardDescriptorProcessor:main: NO JSP Support for /mrs, did not find org.eclipse.jetty.jsp.JettyJspServlet
log4j:WARN No appenders could be found for logger (org.jboss.resteasy.spi.ResteasyDeployment).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
2015-06-04 14:40:53.195:INFO:oejsh.ContextHandler:main: Started o.e.j.w.WebAppContext@528931cf{/mrs,file:/home/mattong/wkspc-git/resteasysample/src/main/webapp,AVAILABLE}
2015-06-04 14:40:53.227:INFO:oejs.ServerConnector:main: Started ServerConnector@4879f913{HTTP/1.1}{0.0.0.0:8080}
2015-06-04 14:40:53.228:INFO:oejs.Server:main: Started @901ms
```

Test the Service
-----------------
```
curl http://localhost:8080/mrs/api/persons/
Could not find MessageBodyWriter for response object of type: ...
```

TODO
-----------------
* Waiting for RestEasy Bug to be resolved or someone pointing out a missing library/settings.

