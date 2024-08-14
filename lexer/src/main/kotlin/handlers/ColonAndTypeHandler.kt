package handlers

import Lexer
import Token
import TokenHandler
import TokenType

class ColonAndTypeHandler : TokenHandler {
    override fun handle(currentChar: Char, lexer: Lexer): Token? {
        return when {
            currentChar == ':' -> {
                lexer.position++
                lexer.column++
                Token(TokenType.COLON, ":", lexer.line, lexer.column - 1)
            }
            lexer.code.startsWith("String", lexer.position) -> {
                lexer.position += 6
                lexer.column += 6
                Token(TokenType.STRING_TYPE, "String", lexer.line, lexer.column - 6)
            }
            lexer.code.startsWith("Number", lexer.position) -> {
                lexer.position += 6
                lexer.column += 6
                Token(TokenType.NUMBER_TYPE, "Number", lexer.line, lexer.column - 6)
            }
            else -> null
        }
    }
}

