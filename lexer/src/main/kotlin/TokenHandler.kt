import Lexer
import Token

interface TokenHandler {
    fun handle(currentChar: Char, lexer: Lexer): Token?
}

