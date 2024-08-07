package org.example.lexer.handlers

import Lexer
import org.example.lexer.Keywords
import org.example.lexer.Token
import org.example.lexer.TokenHandler
import org.example.lexer.TokenType

class IdentifierOrKeywordHandler : TokenHandler {
    override fun handle(currentChar: Char, lexer: Lexer): Token? {
        if (currentChar.isLetter()) {
            val start = lexer.position
            while (lexer.position < lexer.code.length && lexer.code[lexer.position].isLetterOrDigit()) {
                lexer.position++
                lexer.column++
            }
            val word = lexer.code.substring(start, lexer.position)
            val type = if (Keywords.isKeyword(word)) TokenType.KEYWORD else TokenType.IDENTIFIER
            return Token(type, word, lexer.line, lexer.column - word.length)
        }
        return null
    }
}