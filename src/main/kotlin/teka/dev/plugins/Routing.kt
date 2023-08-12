package teka.dev.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import teka.dev.dotenv

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World! ${dotenv["API_KEY"]}")

        }
    }
}
