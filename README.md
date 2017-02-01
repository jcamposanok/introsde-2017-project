# introsde-2017-project
University of Trento | Introduction to Service Design and Engineering - Final Project

## Introduction

This solution aims to provide an **integrated profile** across multiple fitness data providers. 
The information registered through the different apps and devices will be gathered together and summarized, in order to provide a complete dashboard with the most relevant information about food and exercise.

## Architecture

The architecture of the solution has been divided into three clearly distinguished **layers** that perform independent functions. Even if the source code is located inside the same repository, these are separate Java modules, which interact with each other only through REST and SOAP web services. These layers and subcomponents are represented in the graph below:

![System architecture](arch.png)

### External provider management layer (package [external](/external))
As a proof of concept, an MVP of the solution has been built by integrating 
two external providers: **Fatsecret**, a food and diet managing app; and **Misfit**, a wearable wristwatch device which tracks physical activity and sleep. All the information retrieved from these two providers is real and was registered during the past few weeks, after testing different kinds of fitness and wellbeing applications.

For authentication purposes, Fatsecret and Misfit require the use of OAuth 
v1.0 and v2.0, respectively. Therefore, local credential management had to 
be implemented at this level, in order to query and retrieve the necessary data. The OAuth v1.0 authentication is performed with the Scribe Java library, while OAuth v2.0 uses the Jersey 2 OAuth client implementation. Both mechanisms provide an authentication token which is stored locally for future use. In a local installation, SQLite will be used as default storage engine, but once deployed to Heroku, the code will automatically detect the appropriate system environment variables and switch to Postgres.

Another advantage provided by this layer is that it can translate 
the original JSON-only or XML-only APIs of the external providers into any 
of those two formats, and pass it on to the next layers of the solution. 
This is achieved by adding JAXB and Jackson annotations to the Bean classes 
located inside the “external.entity” package, which allow to unmarshal 
the JSON/XML into Java code and vice-versa. 

The following table summarizes the REST services supported by 
the external layer. All the paths indicated are relative to the API endpoint (e.g. http://introsde-jcamposanok-e.herokuapp.com/api/). 
 The return format (i.e. “application/json” or “application/xml”) must be specified through the “Accept” header in the request.

> **Legend:**
>
> []: parameters
>
> ?: optional
>
> ()+: either one or the other, but not both

Service | Description
--------|------------
fatsecret/food-diary/month [date?] | Shows a summary of the nutritional information for an entire month. If date is not specified, the current month is taken by default
fatsecret/food-diary [(date, food_entry_id)+] | Shows all the food consumed on a specific, or one single entry of the food diary, selected by its ID. Either date or ID can be specified, but not both.
misfit/user | Shows the profile information of the Misfit user account
misfit/activity/summary [start, end] | Shows a summary of the physical activity performed in the date range specified
misfit/activity/goals [start, end] | Shows a list of the physical activity per day, calories burned vs. goal, for the entire date range specified

The methods listed above have been implemented for test purposes, but more of them are available in each of the provider APIs. These could be implemented with minimal effort, by reusing the resource classes available in the external layer. For the complete list of operations available for Misfit and Fatsecret visit the following URLs:

- https://build.misfit.com/docs/cloudapi/api_references
- https://platform.fatsecret.com/api/Default.aspx?screen=rapih


### Integration and business process layer (package [integration](/integration))

The integration layer implements a **REST client** and a **SOAP server**, to illustrate how both JAX-RS and JAX-WS can work together in the same solution, without affecting each other. One of the services located inside this layer deals with the business logic of integrating both internal and external data. Therefore, it has the task to translate one single incoming request from the application user into multiple outgoing requests to the provider APIs, or vice-versa. 

An example of this type of operation can be found in the *getUserCalories* method of the SOAP server endpoint (package “integration.server.soap”). This service collects the nutritional information from Fatsecret about food calories gained, and combines it with the calorie consumption through physical exercise, obtained from the Misfit device. This orchestration process allows to get a unified perspective of the calories “coming in and out” of the body, providing a valuable insight for the end user. From a technical perspective, this is also a good example of how JSON and XML based services can be merged into a single result.

A summary of the WS endpoints enabled in this layer, as well as the WSDL file can be found in the following link:

- http://introsde-jcamposanok-i.herokuapp.com/ws


### Presentation layer (package [presentation](/presentation))
This layer does not perform any complex logical operations, but simply calls the SOAP web services implemented in the integration layer and assembles the user interface by inserting various results obtained on demand. This gives the flexibility to create thin clients for any kind of device and platform, based on mashups of the different services available. For this exercise, a web application interface has been developed using Bootstrap and Mustache template engine, but this could be replicated into a desktop or mobile application as well. 

**The Dashboard** has two main sections: The first column shows the information about the wearable devices owned by the user, which was originally obtained from the Misfit API by the external layer, analysed and processed by the integration layer and formatted by the presentation layer. The second column refers to the getUserCalories service mentioned in the previous section, obtained originally from the two external providers by separate requests to each API. This has some new information aggregated about the results for calorie consumption in the entire month. The presentation layer can simply review the values provided by the service and depending on the result (i.e. good balance between nutrition and exercise) chooses the appropriate messages and formating options to present in the UI. For instance, if the number of calories consumed by physical exercise (tracked by Misfit) was higher than the number of calories gained by eating (tracked by Fatsecret), the interface will display a motivational encouraging message in green color. For the opposite scenario, the interface will switch to red color and display a friendly reminder about the need for healthier habits.

You can access a live version of the dashboard at the following URL:

- https://introsde-jcamposanok-p.herokuapp.com/dashboard
