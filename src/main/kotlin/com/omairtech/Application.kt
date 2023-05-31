package com.omairtech

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import java.util.Date

// https://start.ktor.io/ => to create new project

fun main(args: Array<String>) : Unit = io.ktor.server.netty.EngineMain.main(args)


fun Application.module(){
    routing {
        get("/") {
//            call.respondText("Hello, World!")
            call.respondText {
                return@respondText "Hello, World! 1 ${Date().time}"
            }
        }
    }
}