package handlers

import Lexer
import Token
import TokenHandler
import TokenType

class ArithmeticOperatorHandler : TokenHandler {
    override fun handle(currentChar: Char, lexer: Lexer): Token? {
        return when (currentChar) {
            '+' -> {
                lexer.position++
                lexer.column++
                Token(TokenType.PLUS, "+", lexer.line, lexer.column - 1)
            }
            '-' -> {
                lexer.position++
                lexer.column++
                Token(TokenType.MINUS, "-", lexer.line, lexer.column - 1)
            }
            '*' -> {
                lexer.position++
                lexer.column++
                Token(TokenType.MULTIPLY, "*", lexer.line, lexer.column - 1)
            }
            '/' -> {
                lexer.position++
                lexer.column++
                Token(TokenType.DIVIDE, "/", lexer.line, lexer.column - 1)
            }
            else -> null
        }
    }
}
