package teka.dev.services.secret_variables

import teka.dev.dotenv

class DotenvSecretVariables: SecretVariables {
    override fun get(name: SecretVariableName): String? {
        return dotenv[name.value]
    }

    override fun get(name: SecretVariableName, defaultValue: String): String {
        return dotenv[name.value] ?: defaultValue
    }

    override fun require(name: SecretVariableName): String {
        return get(name) ?: throw IllegalArgumentException("'${name.value}' env variable required")
    }
}