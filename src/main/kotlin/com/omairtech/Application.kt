package com.omairtech

import com.omairtech.modules.modules
import io.ktor.server.engine.*
import io.ktor.server.netty.*

// https://start.ktor.io/ => to create new project

//fun main(args: Array<String>) : Unit = io.ktor.server.netty.EngineMain.main(args)

fun main() {
//    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module).start(wait = true)
    embeddedServer(Netty, port = 8080, watchPaths = listOf("classes", "resources") ){
        modules()
    }.start(wait = true)
}
