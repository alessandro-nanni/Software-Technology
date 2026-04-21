= Catalog Service
== Controller Responsibility
Right now, your `CatalogController.java` file is a bit messy because it mixes up UI routing, like returning HTML view names, with JSON API endpoints using `@ResponseBody`. I think a good fix would be to split this up into two separate controllers: you can use a `@Controller` for serving the HTML templates and a `@RestController` to handle the JSON data communication between services. Also, you should really move all that manual cookie and JWT checking logic out of the controller entirely since it adds way too much boilerplate code.

== Authentication
Currently, your controller is manually looping through cookies in almost every method just to find the JWT and user ID. You could improve this by setting up Spring Security with a `OncePerRequestFilter` to intercept the requests, check the JWT, and fill the `SecurityContext`. Another idea from your post-milestone tasks is to just let the API Gateway handle token validation. The gateway would check the JWT and pass the request along with an `X-User-Id` HTTP header. Then, in your controller methods, you can simply grab it using `@RequestHeader("X-User-Id") Long userId`.

= Metadata Service
== Fragile Data Synchronization
In the `MetadataService`, you are currently using a `@PostConstruct` script to manually assign IDs that perfectly match the ones in the Catalog service. This is pretty fragile because the microservices don't share a database, meaning there are no foreign key constraints to prevent ID mismatches. So if the Catalog service ever updates an ID, your Metadata service will just be stuck with orphaned data. To fix this, your Catalog service could send an asynchronous event to ActiveMQ when a new movie is added, and the Metadata service can listen for that event to create a matching placeholder record.

= Progress Service
== Non persistant data
Since your `ProgressService` is just saving user progress in a `Map<Long, Map<Long, Progress>> progressMap`, every time your app restarts, everyone completely loses their watch progress. You should update the `Progress` model with `@Entity` and `@Id` annotations. Then, you can create a progress repository to save everything to an H2 database so the data survives restarts.

== Duplicated Code in ProgressService
There's some duplicated code where you have two `setProgressById` loops.One takes a String state and the other takes an Enum. They both run the exact same 12 lines of map manipulation logic. You could just have the String version convert its input into an Enum, and then call the Enum version of the method.

= Rating Service
== Non persistant data
Just like the progress service, you are storing all the rating data in memory (`RatingService` uses an `ArrayList` and `RatingConsumer` stores summaries in a `ConcurrentHashMap`). If the service restarts, all of this is lost. To fix this, could to mark both `Rating` and `RatingSummary` as `@Entity` classes and save them to a real database using their own repositories.

== Mixing Concerns (Consumer acting as a Service)
Your `RatingConsumer` class is acting as both a message listener and a database service. It exposes methods like `getAllSummaries()`, which basically means your `RatingSummaryController` is treating the ActiveMQ listener like a data store. You could separate these concerns so the message consumer's only job is to receive messages and write them to the database. Then, you can create a proper `RatingSummaryService` to handle fetching the data from the DB.