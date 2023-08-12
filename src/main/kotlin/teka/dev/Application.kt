package teka.dev

import io.github.cdimascio.dotenv.dotenv
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import teka.dev.plugins.*

fun main() {
    val env = dotenv {
        ignoreIfMissing = true
    }
    println("environment variable: ${env["API_KEY"]}")
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureRouting()
}
