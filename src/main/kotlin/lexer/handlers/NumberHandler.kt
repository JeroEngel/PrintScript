package org.example.lexer.handlers

import lexer.Lexer
import org.example.lexer.Token
import org.example.lexer.TokenHandler
import org.example.lexer.TokenType

class NumberHandler : TokenHandler {
    override fun handle(currentChar: Char, lexer: Lexer): Token? {
        if (currentChar.isDigit()) {
            val start = lexer.position
            while (lexer.position < lexer.code.length && lexer.code[lexer.position].isDigit()) {
                lexer.position++
                lexer.column++
            }
            val number = lexer.code.substring(start, lexer.position)
            return Token(TokenType.NUMBER, number, lexer.line, lexer.column - number.length)
        }
        return null
    }
}