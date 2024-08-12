package handlers

import Lexer
import Token
import TokenHandler


class LetHandler : TokenHandler {
    override fun handle(currentChar: Char, lexer: Lexer): Token? {
        if (currentChar == 'l' && lexer.code.startsWith("let", lexer.position)) {
            val startColumn = lexer.column
            lexer.position += 3
            lexer.column += 3
            return Token(TokenType.KEYWORD, "let", lexer.line, startColumn)
        }
        return null
    }
}
