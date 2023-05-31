package com.omairtech.plugins

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import java.util.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World! ${Date().time}")
        }
    }
}