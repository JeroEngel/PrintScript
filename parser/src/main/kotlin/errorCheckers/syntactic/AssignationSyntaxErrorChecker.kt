package org.example.errorCheckers.syntactic

import Token
import org.example.errorCheckers.ErrorChecker

class AssignationSyntaxErrorChecker : ErrorChecker {
    override fun check(tokens: List<Token>): Boolean {
        val index = 0
        if(tokens.size != 3) {
            return false
        }
        if (tokens[index].type != TokenType.IDENTIFIER) {
            return false
        }
        if (tokens[index + 1].type != TokenType.ASSIGN) {
            return false
        }
        if (tokens[index + 2].type != TokenType.IDENTIFIER && tokens[index + 2].type != TokenType.NUMBER && tokens[index + 2].type != TokenType.STRING) {
            return false
        }
        return true
    }
}