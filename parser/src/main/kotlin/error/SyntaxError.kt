package org.example.error

import Token

interface SyntaxError {
    fun checkSyntax(tokens : List<Token>) : Boolean
}