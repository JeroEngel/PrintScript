package org.example.errorCheckers.syntactic

import Token
import TokenType
import org.example.errorCheckers.ErrorChecker

class PrintSyntaxErrorChecker : ErrorChecker {
    override fun check(tokens: List<Token>): Boolean {
        checkNecessaryTokens(tokens)
        checkNecessaryTokensOrder(tokens)
        checkArgsOrder(getArguments(tokens))
        return true
    }

    private fun checkNecessaryTokens(tokens: List<Token>) {
        if (tokens.size < 3) {
            throw RuntimeException("Missing args in print statement")
        }
        val tokenTypes = tokens.map { it.type }
        val printTokenTypes = listOf(TokenType.PRINT, TokenType.LEFT_PARENTHESIS, TokenType.RIGHT_PARENTHESIS)

        for (tokenType in printTokenTypes){
            if (tokenType !in tokenTypes) {
                throw RuntimeException("Missing token $tokenType in print statement")
            }
        }
    }

    private fun checkNecessaryTokensOrder(tokens: List<Token>) {
        val statementTokenTypes = tokens.map { it.type }
        val printTokenTypes = listOf(TokenType.PRINT, TokenType.LEFT_PARENTHESIS, TokenType.RIGHT_PARENTHESIS)
        var bool = false
        for (tokenType in printTokenTypes) {
            for( statementTokenType in statementTokenTypes){
                if( tokenType ==  statementTokenType){
                    bool = printTokenTypes.indexOf(tokenType) <= printTokenTypes.indexOf(statementTokenType)
                }
            }
        }
        if (!bool) {
            throw RuntimeException("Unexpected token order in print statement")
        }
    }
    private fun checkArgsOrder(args: List<Token>) {
        if (args.size % 2 == 0) {
            throw RuntimeException("Invalid number of arguments in print statement")
        }
        val argsTokenTypes = args.map { it.type }
        if (args.size > 1){
            for (i in 1 until args.size step 2) {
                if (argsTokenTypes[i] != TokenType.ARITHMETIC_OP || argsTokenTypes[i] != TokenType.EQUALS) {
                    throw RuntimeException("Invalid arithmetic operator in print statement")
                }
            }
            for (i in args.indices step 2) {
                if (argsTokenTypes[i] != TokenType.IDENTIFIER && argsTokenTypes[i] != TokenType.NUMBER && argsTokenTypes[i] != TokenType.STRING) {
                    throw RuntimeException("Invalid argument in print statement")
                }
            }
        }
    }

    private fun getArguments(tokens: List<Token>): List<Token> {
        val leftParenthesis = tokens.indexOf(tokens.find { it.type == TokenType.LEFT_PARENTHESIS })
        val rightParenthesis = tokens.indexOf(tokens.find { it.type == TokenType.RIGHT_PARENTHESIS })
        return tokens.subList(leftParenthesis + 1, rightParenthesis - 1)
    }

}