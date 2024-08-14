package command

import ASTNode
import IdentifierNode
import StringLiteralNode
import Token
import VariableDeclarationNode

class VariableDeclarationStatementCommand : ParseCommand {
    override fun execute(tokens: List<Token>): ASTNode {
        val identifierToken = tokens[1]
        val valueToken = tokens[3]

        val identifierNode = IdentifierNode(identifierToken.value, identifierToken.line, identifierToken.column)
        val valueNode = StringLiteralNode(valueToken.value, valueToken.line, valueToken.column)

        val variableNode = VariableDeclarationNode(identifierNode, valueNode, identifierToken.line, identifierToken.column)

        return variableNode
    }
}
