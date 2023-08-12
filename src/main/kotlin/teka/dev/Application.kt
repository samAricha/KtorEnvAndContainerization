package teka.dev

import io.github.cdimascio.dotenv.dotenv
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import teka.dev.plugins.*

val dotenv = dotenv {
    ignoreIfMissing = true
}

fun main() {
    println("environment variable: ${dotenv["API_KEY"]}")
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
        host = "0.0.0.0"
        port = 8080
    }
    developmentMode = true
}
