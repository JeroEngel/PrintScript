package org.example.lexer.handlers

import Lexer
import org.example.lexer.Token
import org.example.lexer.TokenHandler
import org.example.lexer.TokenType

class AssignationHandler : TokenHandler {
    override fun handle(currentChar: Char, lexer: Lexer): Token? {
        if (currentChar == '=') {
            lexer.position++
            lexer.column++
            return Token(TokenType.ASSIGNATION, "=", lexer.line, lexer.column)
        }
        return null
    }
}
