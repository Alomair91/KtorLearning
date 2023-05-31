package com.omairtech

import com.omairtech.plugins.configureRouting
import io.ktor.application.*

// https://start.ktor.io/ => to create new project

fun main(args: Array<String>) : Unit = io.ktor.server.netty.EngineMain.main(args)


fun Application.module(){
    configureRouting()
}