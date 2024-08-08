package org.example.parser

import org.example.lexer.Token
import org.example.lexer.TokenType
import kotlin.reflect.typeOf

class Parser {
    fun parse(tokens: List<Token>): List<AST> {
        val ast = mutableListOf<AST>()
        var i = 0
        val temporalTokens = mutableListOf<Token>()
        for (token in tokens) {
            if (token.type == TokenType.SEMICOLON) {
                ast.add(createAST(temporalTokens))
                temporalTokens.clear()
            } else {
                temporalTokens.add(token)
            }
        }
        return ast
    }

    private fun createAST(temporalTokens: MutableList<Token>): AST {
        var type = ""
        var identifier = ""
        var function = TokenType.UNKNOWN
        var value = ""
        var start = 0
        var end = 0
        var isAssignation = false
        for (token in temporalTokens) {
            if (token.type == TokenType.STRING_TYPE) {
                type = token.value
            }
            if (token.type == TokenType.IDENTIFIER) {
                if (isAssignation) {
                    value = token.value
                } else {
                    identifier = token.value
                }
            }
            if (token.type == TokenType.STRING_LITERAL) {
                value = token.value
            }
            if (token.type == TokenType.ASSIGNATION) {
                function = token.type
                isAssignation = true
            }
            if (token.type == TokenType.NUMBER) {
                value = token.value
            }
        }
        start = temporalTokens[0].column
        end = temporalTokens[temporalTokens.size - 1].column
        return AST(type, identifier, function, value, start, end)
    }
}