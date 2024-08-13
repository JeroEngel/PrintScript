package command

import ASTNode
import IdentifierNode
import StringLiteralNode
import Token
import TokenType
import VariableDeclarationNode

class VariableDeclarationCommand : ParseCommand {
    override fun execute(tokens: List<Token>, startIndex: Int): Pair<ASTNode, Int> {
        val identifierToken = tokens[startIndex + 1]
        val valueToken = tokens[startIndex + 3]

        val identifierNode = IdentifierNode(identifierToken.value, identifierToken.line, identifierToken.column)
        val valueNode = StringLiteralNode(valueToken.value, valueToken.line, valueToken.column)

        val variableNode = VariableDeclarationNode(identifierNode, valueNode, identifierToken.line, identifierToken.column)
        return Pair(variableNode, startIndex + 5)  // Ajusta el índice según la estructura de tokens
    }
}
