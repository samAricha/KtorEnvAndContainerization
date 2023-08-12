package teka.dev

import io.github.cdimascio.dotenv.dotenv
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import teka.dev.plugins.*
import teka.dev.services.secret_variables.SecretVariableName
import teka.dev.services.secret_variables.SecretVariablesService

val dotenv = dotenv {
    ignoreIfMissing = true
}

fun main() {
    println("environment variable: ${SecretVariablesService.require(SecretVariableName.ServerPort).toInt()}")
    val appEnv = applicationEngineEnvironment {
        envConfig()
    }
    embeddedServer(Netty,appEnv).start(wait = true)
}


fun Application.module() {
    configureSerialization()
    configureRouting()
}
fun ApplicationEngineEnvironmentBuilder.envConfig() {
    module {
        module()
    }
    connector {
        host = SecretVariablesService.require(SecretVariableName.ServerHost)
        port = SecretVariablesService.require(SecretVariableName.ServerPort).toInt()
    }
    developmentMode = true
}
