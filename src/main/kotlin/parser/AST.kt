package org.example.parser

class AST(val type: String, val identifier: String, val function: String, val value: String, val start : Int, val end : Int){
    override fun toString(): String {
        return "AST(type='$type', identifier='$identifier', function='$function', value='$value', start=$start, end=$end)"
    }
}