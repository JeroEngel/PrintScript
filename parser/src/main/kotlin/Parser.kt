package org.example

import ProgramNode
import StatementNode
import Token
import TokenType
import command.PrintStatementCommand
import command.VariableDeclarationCommand

class Parser {

    private val commands = mapOf(
        TokenType.LET to VariableDeclarationCommand(),
        TokenType.PRINT to PrintStatementCommand()
    )

    fun parse(tokens: List<Token>): ProgramNode {
        val statements = mutableListOf<StatementNode>()
        var index = 0
        while (index < tokens.size) {
            val token = tokens[index]
            val command = commands[token.type]
            if (command != null) {
                val (node, newIndex) = command.execute(tokens, index)
                if (node is StatementNode) {
                    statements.add(node)
                }
                index = newIndex
            } else {
                throw RuntimeException("Token inesperado en la línea ${token.line}, columna ${token.column}: ${token.type}")
            }
        }

        return ProgramNode(statements)
    }
}
