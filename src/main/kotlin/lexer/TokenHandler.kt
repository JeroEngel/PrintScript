package org.example.lexer

import Lexer

interface TokenHandler {
    fun handle(currentChar: Char, lexer: Lexer): Token?
}
