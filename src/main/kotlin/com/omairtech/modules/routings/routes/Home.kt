package com.omairtech.modules.routings.routes

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.serialization.Serializable
import java.util.*

fun Application.configureHomeRouting() {
    // you can use one of these implementations:
//    install(Routing){
//        get("/") {
//            call.respondText("Hello World!! ${Date().time}")
//        }
//    }
    routing {
        // http://127.0.0.1:8080/assets/images/*.*
        // http://127.0.0.1:8080/assets/htmlWelcome
        // http://127.0.0.1:8080/assets/txtWelcome
        static(remotePath = "assets") {
            resources(resourcePackage = "images") // import all the images in the folder name images
            resource(remotePath = "htmlWelcome", resource = "html/welcome.html")
            resource(remotePath = "txtWelcome", resource = "txt/welcome.txt")
        }

        // http://127.0.0.1:8080
        get("/") {
            call.respondText("Hello World! ${Date().time}")
        }

        // http://127.0.0.1:8080/home
        route(path = "/home", method = HttpMethod.Get) {
            handle {
                call.respondText("Hello World!!! ${Date().time}")
            }
        }

        // http://127.0.0.1:8080/home/Admin
        get("/home/{userName}") {
            val userName = call.parameters["userName"]
            val connection = call.request.header("Connection")
            if (userName == "Admin") {
                call.response.header("CustomHeader", "Admin")
                call.respond(message = "Hello $userName", status = HttpStatusCode.OK)
            }
            call.respondText("Hello $userName! ${Date().time} - $connection")
        }

        // http://127.0.0.1:8080/user?name=Mohammed&age=12
        get("/user") {
            val name = call.request.queryParameters["name"]
            val age = call.request.queryParameters["age"]
            call.respondText("Hello $name! I'm $age years old")
        }

        // http://127.0.0.1:8080/person
        get("/person") {
            val person = Person(name = "Jon", age = 23)
            try {
                call.respond(message = person, status = HttpStatusCode.OK)

            } catch (e: Exception) {
                call.respond(message = e.message.toString(), status = HttpStatusCode.BadRequest)

            }
        }

        // http://127.0.0.1:8080/redirect
        get("/redirect") {
            call.respondRedirect(url = "/moved", permanent = false)
        }
        get("/moved") {
            call.respondText("redirect to moved")
        }
    }
}

@Serializable
data class Person(val name: String, val age: Int)