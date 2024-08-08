package org.example.lexer

object Keywords {
    private val keywords = mutableSetOf("let", "PrintLn", "String")

    fun initialize(vararg words: String) {
        keywords.addAll(words)
    }

    fun isKeyword(word: String): Boolean {
        return keywords.contains(word)
    }
}