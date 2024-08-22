package handlers

import Lexer
import Token
import TokenHandler
import TokenType
import TokenValue

class NumberHandler : TokenHandler {
    override fun handle(currentChar: Char, lexer: Lexer): Token? {
        if (currentChar.isDigit()) {
            val start = lexer.position
            var hasDecimalPoint = false

            while (lexer.position < lexer.code.length &&
                (lexer.code[lexer.position].isDigit() || (!hasDecimalPoint && lexer.code[lexer.position] == '.'))) {

                if (lexer.code[lexer.position] == '.') {
                    hasDecimalPoint = true
                }

                lexer.position++
                lexer.column++
            }

            val number = lexer.code.substring(start, lexer.position).toDouble()
            return Token(
                TokenType.NUMBER,
                TokenValue.NumberValue(number),
                lexer.line,
                lexer.column - (lexer.position - start)
            )
        }
        return null
    }
}
