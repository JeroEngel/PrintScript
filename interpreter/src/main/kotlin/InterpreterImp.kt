class InterpreterImp {

    private var context = ExecutionContext()
    private val semanticChecker = SemanticCheckerVisitor(this)
    private val interpreterVisitor = InterpreterVisitor(this)

    fun interpret(programNode: ProgramNode) {
        programNode.accept(interpreterVisitor)
    }
    fun getContext(): ExecutionContext {
        return context
    }
    fun updateContext(newContext: ExecutionContext) {
        context = newContext
    }
}
