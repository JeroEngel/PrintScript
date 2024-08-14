package org.example.command

import ASTNode
import AssignationNode
import IdentifierNode
import StringLiteralNode
import Token
import command.ParseCommand
import org.example.error.AssignationSyntaxErrorChecker

class AssignationCommand : ParseCommand {
    override fun execute(tokens: List<Token>): ASTNode {

        val errorChecker = AssignationSyntaxErrorChecker()
        if (!errorChecker.checkSyntax(tokens)) {
            throw RuntimeException("Syntax error in assignation statement")
        }

        val identifierToken = tokens[0]
        val valueToken = tokens[2]

        val identifierNode = IdentifierNode(identifierToken.value, identifierToken.line, identifierToken.column)
        val valueNode = StringLiteralNode(valueToken.value, valueToken.line, valueToken.column)

        val assignationNode = AssignationNode(identifierNode, valueNode, identifierToken.line, identifierToken.column)

        return assignationNode
    }
}