package com.omairtech.modules.routings

import com.omairtech.modules.routings.routes.configureHomeRouting
import io.ktor.application.*
fun Application.configureRouting() {
    configureHomeRouting()
}