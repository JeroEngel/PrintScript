package org.example.lexer.handlers

import lexer.Lexer
import org.example.lexer.Token
import org.example.lexer.TokenHandler
import org.example.lexer.TokenType

class StringLiteralHandler : TokenHandler {
    override fun handle(currentChar: Char, lexer: Lexer): Token? {
        if (currentChar == '"') {
            val start = lexer.position
            lexer.position++
            lexer.column++
            while (lexer.position < lexer.code.length && lexer.code[lexer.position] != '"') {
                lexer.position++
                lexer.column++
            }
            lexer.position++
            lexer.column++
            val value = lexer.code.substring(start, lexer.position)
            return Token(TokenType.STRING_LITERAL, value, lexer.line, lexer.column - value.length)
        }
        return null
    }
}