## How to use

### Before

#### Run Eureka-Server

```shell
$ export SPRING_PROFILES_ACTIVE=stand-alone && gradle eureka-server:bootRun
```

#### Run User-Server

```shell
    $ export SPRING_PROFILES_ACTIVE=stand-alone && gradle user-server:bootRun
```

#### Run Rest-Command-Server

```shell
    $ export SPRING_PROFILES_ACTIVE=stand-alone && gradle rest-command-server:bootRun
```

### Test

#### Create User

```shell
    curl -H "Content-Type: application/json" -X POST --data '{"userId":"userId"}' http://localhost:5000/api/user
```

#### Cause Exception

```shell
    curl -H "Content-Type: application/json" -X POST --data '{"userId":"userId"}' http://localhost:5000/api/user/exception
```    

I will get Exception: 

    {"exceptionType":"org.axonframework.messaging.RemoteHandlingException","message":"An exception was thrown by the remote message handling component: e.eson.common.user.exception.UserException: userId"}
    
Debug Rest-Command-Server's file e.esen.controller.UserController

```kotlin
@PostMapping("/exception")
fun exception(@RequestBody body: ExceptionUserReq): ResponseEntity<ExceptionUserRes> {
    try {
        commandGateway.sendAndWait<String>(ExceptionUserCommand(userId = body.userId))
    } catch (ex: Exception) {
        return ResponseEntity.ok(ExceptionUserRes(exceptionType = ex::class.qualifiedName!!, message = ex.message!!))
    }
    return ResponseEntity.ok().build()
}
```

My Custom Exception

```kotlin
class UserException : AbstractUserException {

    override val code: Int = 1

    constructor()

    constructor(userId: String) : super(userId = userId)

}
```

Catch the Exception, I can't get my custom exception : UserException, It catch org.axonframework.messaging.RemoteHandlingException.I can't get more info with the exception. I wanna get the exception code , But I failed.

