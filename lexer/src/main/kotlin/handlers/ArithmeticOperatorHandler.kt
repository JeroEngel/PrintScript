
package handlers

import Lexer
import Token
import TokenHandler
import TokenType
import TokenValue

class ArithmeticOperatorHandler : TokenHandler {
    override fun handle(currentChar: Char, lexer: Lexer): Token? {
        return when (currentChar) {
            '+' -> {
                lexer.position++
                lexer.column++
                Token(TokenType.SUM, TokenValue.StringValue("+"), lexer.line, lexer.column - 1)
            }
            '-' -> {
                lexer.position++
                lexer.column++
                Token(TokenType.SUBTRACT, TokenValue.StringValue("-"), lexer.line, lexer.column - 1)
            }
            '*' -> {
                lexer.position++
                lexer.column++
                Token(TokenType.MULTIPLY, TokenValue.StringValue("*"), lexer.line, lexer.column - 1)
            }
            '/' -> {
                lexer.position++
                lexer.column++
                Token(TokenType.DIVIDE, TokenValue.StringValue("/"), lexer.line, lexer.column - 1)
            }
            else -> null
        }
    }
}
