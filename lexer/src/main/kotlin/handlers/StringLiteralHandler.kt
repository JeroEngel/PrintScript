package handlers

import Lexer
import Token
import TokenHandler
import TokenType
import TokenValue

class StringLiteralHandler : TokenHandler {
    override fun handle(currentChar: Char, lexer: Lexer): Token? {
        if (currentChar == '"' || currentChar == '\'') {
            val startChar = currentChar
            val start = lexer.position
            lexer.position++
            lexer.column++

            while (lexer.position < lexer.code.length && lexer.code[lexer.position] != startChar) {
                lexer.position++
                lexer.column++
            }

            // Check if the closing character matches the opening character
            if (lexer.position < lexer.code.length && lexer.code[lexer.position] == startChar) {
                lexer.position++
                lexer.column++
                val value = lexer.code.substring(start + 1, lexer.position - 1)
                return Token(TokenType.STRING, TokenValue.StringValue(value), lexer.line, lexer.column - value.length - 2)
            } else {
                // Handle mismatched string delimiters
                throw IllegalArgumentException("Mismatched string delimiters: started with $startChar but didn't close properly.")
            }
        }
        return null
    }
}
