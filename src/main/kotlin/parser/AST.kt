package org.example.parser

import org.example.lexer.TokenType

class AST(val type: String, val identifier: String, val function: TokenType, val value: String, val start : Int, val end : Int){
    override fun toString(): String {
        return "AST(type='$type', identifier='$identifier', function='$function', value='$value', start=$start, end=$end)"
    }
}