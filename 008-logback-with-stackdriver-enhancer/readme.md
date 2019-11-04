# Spring boot logs and Stackdriver Logging with Logback Enhancer

Log management is one of the main task to keep in mind when an application is delivered to our clients. In this post I can show you how send your spring boot logs to [Google Stackdriver Logging](https://cloud.google.com/logging/)

Google Stackdriver is a flexible and convenient way for log management allowing you to store, search, analyze, monitor, and alert on log data and events from Google Cloud Platform and Amazon Web Services (AWS).

In official page says **Google Cloud Platform and Amazon Web Services (AWS).**, but after my simple test, I can say :

> You can use Google Stackdriver Logging to store, search, analyze, monitor, and alerts  for any application in any environment cloud or on-premisse.

Let's start!!

# Google Configurations

Google Stackdriver Logging is a Google Service, so in order to use it, you need to create the classic project in [https://console.cloud.google.com](https://console.cloud.google.com).


**Select or create a GCP project.**

Note: If you don't plan to keep the resources that you create in this procedure, create a project instead of selecting an existing project. After you finish these steps, you can delete the project, removing all resources associated with the project.

[Go to the project selector page](https://console.cloud.google.com/projectselector2/home/dashboard?_ga=2.256990859.-1875927730.1570883781)

**Go to the project selector page**

Make sure that billing is enabled for your Google Cloud Platform project. Learn how to enable billing.

**Enable the Stackdriver Logging API.**

[ENABLE API](https://console.cloud.google.com/flows/enableapi?apiid=logging.googleapis.com&_ga=2.256990859.-1875927730.1570883781)

**Create one service account key**

Go to **Apis & Services** option in https://console.cloud.google.com and click on **create credentials** option and choose **service account key**.

In the next form, select **new service account** option, enter a service name, choose json file and select appropriate role.  For this post, I selected : **Logging >> Logging Admin**

![https://raw.githubusercontent.com/jrichardsz/static_resources/master/logging/create-service-account-for-stack-driver-logging.png](https://raw.githubusercontent.com/jrichardsz/static_resources/master/logging/create-service-account-for-stack-driver-logging.png)

# Java and Spring boot

This part is it's like taking candy from a baby. In java , logs is a very common task. There are some core libraries like **java.util.logging** and third party libraries like logback and my well loved **log4j**.

[google official java documentation](https://cloud.google.com/logging/docs/setup/java) and it's [official github repository](https://github.com/GoogleCloudPlatform/java-docs-samples) shows java.util.logging and logback, but due to spring-boot and logback love affair, I made this post using **logback**

To make this post quickly, you just need to clone my git-repository

- https://github.com/jrichardsz/spring-boot-templates/tree/master/008-logback-with-stackdriver-enhancer

It has just 3 relevant files:

**Application.java** , the classic main entry point for spring boot. Also this class have a basic rest controller to test our logger.

In each endpoint request, I send to log:

```
logger.info("starting endpoint controller");
logger.info("endpoint controller has completed");
```

**ExampleEnhancer.java**, this class is required to add labels (i.e metadata) to each log entry. In another post I will use **MDC** instead this class for better access to spring context.

**logback.xml**, minimal configuration for logback. console, file and google appenders are configured.

In this logback.xml file, a main part is forgotten in official documentation:

```
<credentialsFile>/../../service-account-key-for-stackdriver-logging.json</credentialsFile>
```

You can set the absoluthe path of your **service account key** previously created and exported in json format.


# Run and enjoy it

Just run the spring-boot project as you like, and test it with **curl localhost:8080/some/endpoint**. You must see the console and file log similar to this:

![https://raw.githubusercontent.com/jrichardsz/static_resources/master/logging/console-spring-boot-log.png](https://raw.githubusercontent.com/jrichardsz/static_resources/master/logging/console-spring-boot-log.png)

Finally if you go to https://console.cloud.google.com/logs/viewer , select the related project and choose **GAE Application** (yes, this is missing in official documentation), you will see something like this:

![https://raw.githubusercontent.com/jrichardsz/static_resources/master/logging/stack-driver-logging-spring-boot-log.png](https://raw.githubusercontent.com/jrichardsz/static_resources/master/logging/stack-driver-logging-spring-boot-log.png)

As you can compare, the entry logs are the same in console, file and stack driver logging platform.

If you click on the log related to each request (not the tomcat log), you will see this:

![https://raw.githubusercontent.com/jrichardsz/static_resources/master/logging/stack-driver-logging-entry-log-details.png](https://raw.githubusercontent.com/jrichardsz/static_resources/master/logging/stack-driver-logging-entry-log-details.png)

With two json branchs to highlight:

- **labels** with the data or metadata added in **ExampleEnhancer.java**
- **textPayload** with the string sent to log.

That's all.
