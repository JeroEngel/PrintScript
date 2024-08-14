package org.example.visitor

import IdentifierNode
import PrintStatementNode
import ProgramNode
import StringLiteralNode
import VariableDeclarationNode
import org.example.*

interface ASTVisitor {
    fun visit(programNode: ProgramNode)
    fun visit(variableDeclarationNode: VariableDeclarationNode)
    fun visit(printStatementNode: PrintStatementNode)
    fun visit(identifierNode: IdentifierNode)
    fun visit(stringLiteralNode: StringLiteralNode)
}
