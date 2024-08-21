import org.example.visitor.ASTVisitor

class SemanticCheckerVisitor(private val interpreter: InterpreterImp) : ASTVisitor {

    override fun visit(programNode: ProgramNode) {
        for (statement in programNode.statements) {
            statement.accept(this)
        }
    }

    override fun visit(variableDeclarationNode: VariableDeclarationNode) {
        if (interpreter.getContext().hasVariable(variableDeclarationNode.identifier.name)) {
            throw RuntimeException("Error semántico: La variable '${variableDeclarationNode.identifier.name}' ya está declarada.")
        }
    }

    override fun visit(assignationNode: AssignationNode) {
        if (!interpreter.getContext().hasVariable(assignationNode.identifier.name)) {
            throw RuntimeException("Error semántico: La variable '${assignationNode.identifier.name}' no está declarada.")
        }
    }

    override fun visit(numberLiteralNode: NumberLiteralNode) {}

    override fun visit(binaryExpressionNode: BinaryExpressionNode) {
        val leftType = evaluateExpressionType(binaryExpressionNode.left)
        val rightType = evaluateExpressionType(binaryExpressionNode.right)
        if (binaryExpressionNode.operator == TokenType.SUM) {
            if (leftType != rightType) {
                throw RuntimeException("Error semántico: No se puede sumar ${leftType} con ${rightType}.")
            }
        } else {
            if (leftType != "Double" || rightType != "Double") {
                throw RuntimeException("Error semántico: Operación no permitida con tipos no numéricos.")
            }
        }
    }

    override fun visit(printStatementNode: PrintStatementNode) {
        printStatementNode.expression.accept(this)
    }

    override fun visit(identifierNode: IdentifierNode) {
        if (!interpreter.getContext().hasVariable(identifierNode.name)) {
            throw RuntimeException("Error semántico: La variable '${identifierNode.name}' no está declarada.")
        }
    }

    override fun visit(stringLiteralNode: StringLiteralNode) {}

    private fun evaluateExpressionType(expression: ExpressionNode): String {
        return when (expression) {
            is IdentifierNode -> interpreter.getContext().getVariable(expression.name)?.javaClass?.simpleName ?: "Unknown"
            is StringLiteralNode -> "String"
            is NumberLiteralNode -> "Double"
            is BinaryExpressionNode -> evaluateExpressionType(expression.left)
            else -> throw IllegalArgumentException("Tipo de expresión no soportada: ${expression::class.java.simpleName}")
        }
    }
}