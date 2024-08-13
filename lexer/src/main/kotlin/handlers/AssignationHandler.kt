package handlers

import Lexer
import Token
import TokenHandler
import TokenType

class AssignationHandler : TokenHandler {
    override fun handle(currentChar: Char, lexer: Lexer): Token? {
        if (currentChar == '=') {
            lexer.position++
            lexer.column++
            return Token(TokenType.ASSIGN, "=", lexer.line, lexer.column - 1)
        }
        return null
    }
}
