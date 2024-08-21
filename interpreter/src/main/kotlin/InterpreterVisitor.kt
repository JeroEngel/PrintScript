import org.example.visitor.ASTVisitor

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

    override fun visit(numberLiteralNode: NumberLiteralNode) {
        // No hay procesamiento adicional para números literales
    }

    override fun visit(binaryExpressionNode: BinaryExpressionNode) {
        binaryExpressionNode.accept(this)
    }

    override fun visit(printStatementNode: PrintStatementNode) {
        val value = evaluateExpression(printStatementNode.expression)
        println(value)
    }

    override fun visit(identifierNode: IdentifierNode) {
        // Obtener valor de la variable si es necesario
    }

    override fun visit(stringLiteralNode: StringLiteralNode) {
        // No hay procesamiento adicional para strings literales
    }

    // Método auxiliar para evaluar una expresión
    private fun evaluateExpression(expression: ExpressionNode): Any? {
        return when (expression) {
            is IdentifierNode -> context.getVariable(expression.name)
            is StringLiteralNode -> expression.value
            is NumberLiteralNode -> expression.value
            is BinaryExpressionNode -> {
                val leftValue = evaluateExpression(expression.left)
                val rightValue = evaluateExpression(expression.right)

                when (expression.operator) {
                    TokenType.SUM -> {
                        when {
                            leftValue is String && rightValue is String -> leftValue + rightValue
                            leftValue is Double && rightValue is Double -> leftValue + rightValue
                            leftValue is String && rightValue is Double -> leftValue + rightValue.toString()
                            leftValue is Double && rightValue is String -> leftValue.toString() + rightValue
                            else -> throw IllegalArgumentException("Operación de suma no soportada para tipos: ${leftValue?.javaClass?.name} y ${rightValue?.javaClass?.name}")
                        }
                    }
                    TokenType.SUBTRACT -> (leftValue as Double) - (rightValue as Double)
                    TokenType.MULTIPLY -> (leftValue as Double) * (rightValue as Double)
                    TokenType.DIVIDE -> (leftValue as Double) / (rightValue as Double)
                    else -> throw IllegalArgumentException("Operador binario inesperado: ${expression.operator}")
                }
            }
            else -> throw IllegalArgumentException("Tipo de expresión no soportada: ${expression::class.java.simpleName}")
        }
    }
}