
import org.example.visitor.ASTVisitor

class InterpreterVisitor : ASTVisitor {

    val context = ExecutionContext()
    override fun visit(programNode: ProgramNode) {
        for (statement in programNode.statements) {
            statement.accept(this)
        }
    }

    override fun visit(variableDeclarationNode: VariableDeclarationNode) {
        context.addVariable(variableDeclarationNode.identifier.name, variableDeclarationNode.value.value)
    }

    override fun visit(printStatementNode: PrintStatementNode) {
        val expression = printStatementNode.expression
        if (expression is IdentifierNode) {
            val value = context.getVariable(expression.name)
            println(value)
        } else if (expression is StringLiteralNode) {
            println(expression.value)
        }
    }

    override fun visit(identifierNode: IdentifierNode) {
    }

    override fun visit(stringLiteralNode: StringLiteralNode) {
    }
}
