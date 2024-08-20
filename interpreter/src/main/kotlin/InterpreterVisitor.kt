
class InterpreterVisitor : ASTVisitor {

    val context = ExecutionContext()

    override fun visit(programNode: ProgramNode) {
        for (statement in programNode.statements) {
            statement.accept(this)
        }
    }

    override fun visit(variableDeclarationNode: VariableDeclarationNode) {
        val value = evaluateExpression(variableDeclarationNode.value)
        context.addVariable(variableDeclarationNode.identifier.name, value)
    }

    override fun visit(assignationNode: AssignationNode) {
        val value = evaluateExpression(assignationNode.value)
        context.addVariable(assignationNode.identifier.name, value)
    }

    override fun visit(printStatementNode: PrintStatementNode) {
        val value = evaluateExpression(printStatementNode.expression)
        println(value)
    }

    override fun visit(identifierNode: IdentifierNode) {
        // Handle visiting IdentifierNode if necessary (e.g., for future extensions)
    }

    override fun visit(stringLiteralNode: StringLiteralNode) {
        // Handle visiting StringLiteralNode if necessary (e.g., for future extensions)
    }

    // Helper method to evaluate an expression node
    private fun evaluateExpression(expression: ExpressionNode): Any? {
        return when (expression) {
            is IdentifierNode -> context.getVariable(expression.name)
            is StringLiteralNode -> expression.value
            else -> null // Add more cases if there are more expression types
        }
    }
}
