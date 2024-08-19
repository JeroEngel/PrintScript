package command

import ASTNode
import IdentifierNode
import StringLiteralNode
import Token
import VariableDeclarationNode
import org.example.errorCheckers.syntactic.VariableDeclarationSyntaxErrorChecker

class VariableDeclarationStatementCommand : ParseCommand {

    override fun execute(tokens: List<Token>): ASTNode {

        val errorChecker = VariableDeclarationSyntaxErrorChecker()
        if (!errorChecker.check(tokens)) {
            throw RuntimeException("Syntax error in variable declaration statement")
        }

        val identifierToken = tokens[1]
        val valueToken = tokens[5]

        val identifierNode = IdentifierNode(identifierToken.value, identifierToken.line, identifierToken.column)
        val valueNode = StringLiteralNode(valueToken.value, valueToken.line, valueToken.column)

        val variableNode = VariableDeclarationNode(identifierNode, valueNode, identifierToken.line, identifierToken.column)

        return variableNode
    }
}
