package org.example.lexer.handlers

import lexer.Lexer
import org.example.lexer.Token
import org.example.lexer.TokenHandler
import org.example.lexer.TokenType

class SemicolonHandler : TokenHandler {
    override fun handle(currentChar: Char, lexer: Lexer): Token? {
        if (currentChar == ';') {
            lexer.position++
            lexer.column++
            return Token(TokenType.SEMICOLON, ";", lexer.line, lexer.column - 1)
        }
        return null
    }
}