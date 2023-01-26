Important thing related to MongoConfiguration.
Most tutorials, Stackoverlow, says that its only needed to extend AbstractReactiveMongoConfiguration, override one method, add EnableReactiveMongoRepositories and Configuration annotation.
This only works for the scenario, when you have default MongoDB installation without authentication, just for PET project purpose. But *its not applicable for PRODUCTION DBs*.
In case you have non-default port, this configuration does not work. Even if you create MongoClient bean - it wonna work. ReactiveMongoRepository will use another MongoClient bean that was not provided by you!
I spent up to 3 days (not full of course, but 3-4 hours per day), to understand what was wrong. Firstly, I thought that issue was with Mongo instance configuration, but any changes made to MongoClient URI did not help.
Then, I just started Mongo with non-default Mongo port, config file had proper mongo port - and it did not work. So, the issue was with Spring configuration.
All tutorials, Stackoverlow answers were just - use default configuration! Again, its only good for homegrown PET project. So, it is not answer.
After couple hours of debugging, I caught the place default MongoClientSettings were provided. Client settings were taken from empty MongoConfigurationSupport.configureClientSettings method.
As it was stated in the JavaDoc: you can override it in order to customize it. So, I did and interaction with Mongo started to work smoothly with authentication support of course.
But default MongoClient was still created. So, I had two MongoClients: correct one that started to work after overriding the method and default MongoClient with default settings or your own MongoClient bean with provided Mongo settings.
I didn't need two clients, so I disabled MongoReactiveAutoConfiguration after that I had only one proper configured client across application.