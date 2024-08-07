package org.example.lexer


enum class TokenType {
    KEYWORD,
    IDENTIFIER,
    STRING_LITERAL,
    ASSIGNATION,
    SEMICOLON,
    WHITESPACE,
    UNKNOWN,
    NUMBER,
    LEFT_PARENTHESIS,
    RIGHT_PARENTHESIS,
    OPERATOR,
    STRING_TYPE
}