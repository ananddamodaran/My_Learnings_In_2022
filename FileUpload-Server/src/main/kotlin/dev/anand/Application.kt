package dev.anand

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import dev.anand.plugins.configureHTTP
import dev.anand.plugins.configureMonitoring
import dev.anand.plugins.configureRouting
import dev.anand.plugins.configureSerialization

fun main() {
    embeddedServer(Netty, port = 8080, host = "192.168.29.224") {
        configureRouting()
        configureHTTP()
        configureMonitoring()
        configureSerialization()
    }.start(wait = true)
}
