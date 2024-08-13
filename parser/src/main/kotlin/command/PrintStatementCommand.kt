package command

import ASTNode
import IdentifierNode
import PrintStatementNode
import StringLiteralNode
import Token
import TokenType

class PrintStatementCommand : ParseCommand {
    override fun execute(tokens: List<Token>, startIndex: Int): Pair<ASTNode, Int> {
        // Ensure the '(' token is present
        if (tokens[startIndex+1].type != TokenType.LEFT_PARENTHESIS) {
            throw RuntimeException("Expected '(' token")
        }

        // Get the expression token
        val expressionToken = tokens[startIndex + 2]
        val expressionNode = when (expressionToken.type) {
            TokenType.IDENTIFIER -> IdentifierNode(expressionToken.value, expressionToken.line, expressionToken.column)
            TokenType.STRING -> StringLiteralNode(expressionToken.value, expressionToken.line, expressionToken.column)
            else -> throw RuntimeException("Unexpected token type inside print: ${expressionToken.type}")
        }

        // Ensure the ')' token is present
        if (tokens[startIndex + 3].type != TokenType.RIGHT_PARENTHESIS) {
            throw RuntimeException("Expected ')' token")
        }

        // Create PrintStatementNode and return
        val printNode = PrintStatementNode(expressionNode, expressionToken.line, expressionToken.column)
        return Pair(printNode, startIndex + 5) // Adjust the index based on the structure of tokens
    }
}
