package org.example.error

import Token
import java.time.temporal.IsoFields

class VariableDeclarationSyntaxErrorChecker : SyntaxError {
    override fun checkSyntax(tokens: List<Token>): Boolean {
        val index = 0
        if(tokens.size != 6) {
            return false
        }

        if (tokens[index].type != TokenType.LET) {
            return false
        }
        if (tokens[index + 1].type != TokenType.IDENTIFIER) {
            return false
        }
        if (tokens[index + 2].type != TokenType.COLON) {
            return false
        }
        if (tokens[index + 3].type != TokenType.NUMBER_TYPE && tokens[index + 3].type != TokenType.STRING_TYPE) {
            return false
        }
        if (tokens[index + 4].type != TokenType.ASSIGN) {
            return false
        }
        if (tokens[index + 5].type != TokenType.IDENTIFIER && tokens[index + 5].type != TokenType.NUMBER && tokens[index + 5].type != TokenType.STRING) {
            return false
        }

        return true
    }
}