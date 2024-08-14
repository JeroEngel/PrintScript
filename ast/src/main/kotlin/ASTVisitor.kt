interface ASTVisitor {
    fun visit(programNode: ProgramNode)
    fun visit(variableDeclarationNode: VariableDeclarationNode)
    fun visit(printStatementNode: PrintStatementNode)
    fun visit(identifierNode: IdentifierNode)
    fun visit(stringLiteralNode: StringLiteralNode)
    fun visit(assignationNode: AssignationNode)
}
