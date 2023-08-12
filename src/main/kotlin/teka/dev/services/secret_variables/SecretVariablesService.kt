package teka.dev.services.secret_variables

object SecretVariablesService : SecretVariables {
    private val secretVariables: SecretVariables = DotenvSecretVariables()

    override fun get(name: SecretVariableName): String? = secretVariables.get(name)


    override fun get(name: SecretVariableName, defaultValue: String): String? = secretVariables.get(name, defaultValue)

    override fun require(name: SecretVariableName): String = secretVariables.require(name)
}