package org.example.lexer.handlers

import lexer.Lexer
import org.example.lexer.Token
import org.example.lexer.TokenHandler
import org.example.lexer.TokenType

class ParenthesisHandler : TokenHandler {
    override fun handle(currentChar: Char, lexer: Lexer): Token? {
        return when (currentChar) {
            '(' -> {
                lexer.position++
                lexer.column++
                Token(TokenType.LEFT_PARENTHESIS, "(", lexer.line, lexer.column - 1)
            }
            ')' -> {
                lexer.position++
                lexer.column++
                Token(TokenType.RIGHT_PARENTHESIS, ")", lexer.line, lexer.column - 1)
            }
            else -> null
        }
    }
}