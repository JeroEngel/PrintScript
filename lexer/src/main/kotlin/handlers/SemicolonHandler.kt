package handlers

import Lexer
import Token
import TokenHandler
import TokenType

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