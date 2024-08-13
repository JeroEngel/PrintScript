package org.example

import ProgramNode
import visitor.PrintVisitor

class InterpreterImp {

    private val visitor = PrintVisitor()

    fun interpret(programNode: ProgramNode) {
        programNode.accept(visitor)
    }
}
