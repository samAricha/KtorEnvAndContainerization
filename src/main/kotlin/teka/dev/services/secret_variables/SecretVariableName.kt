package teka.dev.services.secret_variables

enum class SecretVariableName(val value: String) {
    ServerPort("APP_PORT"),
    ServerHost("APP_HOST"),
    AtApiKey("AT_API_KEY"),
    AtApiUserName("AT_USER_NAME_KEY")

//    data class DynamicEnvVariable(val myEnvVariable:String) : SecretVariableName(value = myEnvVariable),
}