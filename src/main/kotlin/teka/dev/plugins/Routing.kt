package teka.dev.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import teka.dev.services.secret_variables.SecretVariableName
import teka.dev.services.secret_variables.SecretVariablesService

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World! ${SecretVariablesService.get(SecretVariableName.AtApiKey)}")

        }
    }
}
