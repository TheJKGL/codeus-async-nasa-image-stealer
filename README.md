# Async nasa image stealer with CompletableFuture API and RestClient API.
### Implementation steps:
1. Stay in `develop` branch and navigate to `assignment`  package and implement `ImageStealerController` with two appropriate endpoints:
    * POST /mars/pictures/largest/sol/{sol}
    * GET /mars/pictures/largest/command/{commandUuid}
2. Implement all methods in `ImageStealerServiceImpl`.  Don`t forget to use custom Exceptions in appropriate place.
3. Validate your result:
    * Max image for /mars/pictures/largest/sol/401
    * Should be [max image](https://mars.nasa.gov/msl-raw-images/msss/00401/mhli/0401MH0003190000105062R00_DXXX.jpg)

### Optional: 
Use a message broker to make the service more resilient to load
* When processing a POST request, publish the appropriate command to a message broker, for example, RabbitMQ
* Run the image search logic by listening to messages from the corresponding queue