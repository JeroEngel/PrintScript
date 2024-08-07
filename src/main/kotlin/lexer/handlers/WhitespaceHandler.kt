package org.example.lexer.handlers

import Lexer
import org.example.lexer.Token
import org.example.lexer.TokenHandler

class WhitespaceHandler : TokenHandler {
    override fun handle(currentChar: Char, lexer: Lexer): Token? {
        if (currentChar.isWhitespace()) {
            if (currentChar == '\n') {
                lexer.line++
                lexer.column = 1
            } else {
                lexer.column++
            }
            lexer.position++
            return null
        }
        return null
    }
}