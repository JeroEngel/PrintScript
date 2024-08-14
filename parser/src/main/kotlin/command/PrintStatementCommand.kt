package command

import ASTNode
import IdentifierNode
import PrintStatementNode
import StringLiteralNode
import Token
import TokenType
import org.example.error.PrintSyntaxErrorChecker

class PrintStatementCommand : ParseCommand {
    override fun execute(tokens: List<Token>): ASTNode{
        val errorChecker = PrintSyntaxErrorChecker()

        if (!errorChecker.checkSyntax(tokens)) {
            throw RuntimeException("Syntax error in print statement")
        }
        // Get the expression token
        val expressionToken = tokens[2]
        val expressionNode = when (expressionToken.type) {
            TokenType.IDENTIFIER -> IdentifierNode(expressionToken.value, expressionToken.line, expressionToken.column)
            TokenType.STRING -> StringLiteralNode(expressionToken.value, expressionToken.line, expressionToken.column)
            else -> throw RuntimeException("Unexpected token type in print statement")
        }
        // Create PrintStatementNode and return
        val printNode = PrintStatementNode(expressionNode, expressionToken.line, expressionToken.column)

        return printNode
    }
}
