package com.omairtech.modules

import com.omairtech.modules.routings.configureRouting
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*


fun Application.modules(){

    // Show in Log: what kind of request our client has sent to out server and what endpoint out client has tried
    install(CallLogging)

    // Serialization and Deserialization
    install(ContentNegotiation){
        json()
    }

    configureRouting()
}