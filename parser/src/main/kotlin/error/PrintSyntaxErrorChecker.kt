package org.example.error

import Token

class PrintSyntaxErrorChecker : SyntaxError {
    override fun checkSyntax(tokens: List<Token>): Boolean {
        if (tokens.size != 4) {
            return false
        }
        val index = 0

        if (tokens[index].type != TokenType.PRINT) {
            return false
        }
        if (tokens[index + 1].type != TokenType.LEFT_PARENTHESIS) {
            return false
        }
        if (tokens[index + 2].type != TokenType.IDENTIFIER && tokens[index + 2].type != TokenType.STRING) {
            return false
        }
        if (tokens[index + 3].type != TokenType.RIGHT_PARENTHESIS) {
            return false
        }
        return true
    }
}