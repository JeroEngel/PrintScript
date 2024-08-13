package visitor

import IdentifierNode
import PrintStatementNode
import ProgramNode
import StringLiteralNode
import VariableDeclarationNode
import org.example.*

class PrintVisitor : ASTVisitor {
    override fun visit(programNode: ProgramNode) {
        for (statement in programNode.statements) {
            statement.accept(this)
        }
    }

    override fun visit(variableDeclarationNode: VariableDeclarationNode) {
    }

    override fun visit(printStatementNode: PrintStatementNode) {
        printStatementNode.expression.accept(this)
    }

    override fun visit(identifierNode: IdentifierNode) {
        println(identifierNode.name)
    }

    override fun visit(stringLiteralNode: StringLiteralNode) {
        println(stringLiteralNode.value)
    }
}
