package org.example

import InterpreterVisitor
import ProgramNode

class InterpreterImp {

    private val visitor = InterpreterVisitor()

    fun interpret(programNode: ProgramNode) {
        programNode.accept(visitor)
    }
}
