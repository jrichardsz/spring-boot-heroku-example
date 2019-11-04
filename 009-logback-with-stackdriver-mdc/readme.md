# Spring boot logs and Stackdriver Logging with MDC

This post is the same ad previous at 95%:

https://github.com/jrichardsz/spring-boot-templates/tree/master/008-logback-with-stackdriver-enhancer

There are minimal changes:

**Github repository folder**

You must use this folder https://github.com/jrichardsz/spring-boot-templates/tree/master/009-logback-with-stackdriver-mdc

**MDC instead Logback enhancer**

In this article, I will show you the use of Mapped Diagnostic Context (MDC) to improve the application logging.

The basic idea of Mapped Diagnostic Context is to provide a way to **enrich** or add **metadata** to our log messages with pieces of information that could be not available in the scope where the logging actually occurs, but that can be indeed useful to better track the execution of the program.

**Servlet Filter**

**LoggingFilter.java** is the replacement for **ExampleEnhancer.java**. This filter will be executed before your rest controller, so you can access or modify headers. In this example I added a simple **uuid** and **app** data to our logs:

```
MDC.put("uuid", uuid);
MDC.put("app", "api-rest");
```

You will see this values in entry log details instead the values created by **ExampleEnhancer.java**

![https://raw.githubusercontent.com/jrichardsz/static_resources/master/logging/stack-driver-logging-entry-log-details.png](https://raw.githubusercontent.com/jrichardsz/static_resources/master/logging/stack-driver-logging-entry-log-details.png)

That's all. The entire post is the same :D

# Recommended lectures

- https://www.baeldung.com/mdc-in-log4j-2-logback
- https://medium.com/@d.lopez.j/spring-boot-setting-a-unique-id-per-request-dd648efef2b
