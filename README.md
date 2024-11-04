# Async nasa image stealer with CompletableFuture API and RestClient API.

> Please set up the timer and start doing the following tasks !!!
> 
> Solution is available in `completed` branch

**Warmup [15 min]**: Remove n-th node from the end of Linked List

1. Clone a project https://github.com/TheJKGL/codeus-async-nasa-image-stealer/tree/develop
2. Switch to `develop` branch and navigate to `src/main/java/com/practice/warmup` package.
3. Implement `RemoveNthNodeFromEndOfList.removeNthFromEnd`. Documentation is available.
4. Validate your solution using Unit Tests from `test` directory.

Solve the task using  any other programming language. Take source code from [leetcode](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)



**Assignment [45 min]**: Async nasa image stealer with CompletableFuture API and RestClient API.

**Objective:**

- Create an asynchronous web service that finds the largest image by day of the Mars mission
- The user makes a POST request to your service at a specific URL, for example /mars/pictures/largest/sol/{sol}, passing the sol parameter in the path variable and receives the commandUuid identifier in response.
- The service finds the largest picture from that mission day and makes it available to the client via the appropriate link: GET to /mars/pictures/largest/command/{commandUuid}

**Resources:**

Implement the logic for finding the largest image using the open [NASA API](https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=14&api_key=DEMO_KEY):

> **sol** - this is a parameter that defines the day of the mission (in fact, it is a sunny day on Mars, which NASA uses to divide the days of the mission)
> 
> 
> **api_key** - the demo key may not work, you can generate a personal key [here](https://api.nasa.gov/?ref=hackernoon.com)
> 

**Implementation steps:**

1. Stay in `develop` branch and navigate to `src/main/java/com/practice/assignment` package and implement `ImageStealerController` with two appropriate endpoints:
    - POST /mars/pictures/largest/sol/{sol}
    - GET /mars/pictures/largest/command/{commandUuid}
2. Implement all methods in `ImageStealerServiceImpl`. Don`t forget to use custom Exceptions in appropriate place.
3. Validate your result:
    - Max image for /mars/pictures/largest/sol/401
    - Should be [max image](https://mars.nasa.gov/msl-raw-images/msss/00401/mhli/0401MH0003190000105062R00_DXXX.jpg)

**Optional**: Use a message broker to make the service more resilient to load (optional):

- When processing a POST request, publish the appropriate command to a message broker, for example, RabbitMQ
- Run the image search logic by listening to messages from the corresponding queue
