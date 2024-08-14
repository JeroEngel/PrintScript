class ExecutionContext {
    val variables = mutableMapOf<String, Any?>()

    fun addVariable(name: String, value: Any?) {
        variables[name] = value
    }
    fun getVariable(name: String): Any? {
        return variables[name]
    }
}