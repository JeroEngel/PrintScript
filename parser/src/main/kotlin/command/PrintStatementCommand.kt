package command

import ASTNode
import IdentifierNode
import PrintStatementNode
import StringLiteralNode
import Token
import TokenType
import org.example.errorCheckers.syntactic.PrintSyntaxErrorChecker

class PrintStatementCommand : ParseCommand {
    override fun execute(tokens: List<Token>): ASTNode{
        val errorChecker = PrintSyntaxErrorChecker()

        if (!errorChecker.check(tokens)) {
            throw RuntimeException("Syntax error in print statement")
        }
        // Get the expression token
        //agregar metodo que agarra solo los tokens que son argumentos
        //si el size de eso es >1 entonces el expression node va a tener referencia a un operadorNode
        //ese operadorNode va a tener un left y un right que van a ser los argumentos
        
        val expressionToken = tokens[2]
        //
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
