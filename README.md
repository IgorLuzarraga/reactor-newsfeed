REACTIVE NEWS FEED WITH REACTOR
==============

Spring Boot application that implements a reactive News Feed using the
project Reactor.
The GUI is made using the framework vaadin.

Modules:
========
- Spring Boot
- Vaadin - Java web framework - https://vaadin.com
- Project Reactor

Build the jar:
-------------------------
./gradlew build

Run the jar:
-------------------------
java -jar build/libs/reactor-newsfeed-0.0.1-SNAPSHOT.jar

How to use the application:
-------------------------
Connect to the server via http://localhost:8080, choose between 
Publisher (send the news) and Subscriber (receive the news) 
and start sending news.
One publisher and one or more subscribers are required.

You can see that the application is reactive, when any time one 
user sends a message the other users are automatically updated.

