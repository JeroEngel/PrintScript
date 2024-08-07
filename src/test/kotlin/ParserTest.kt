import org.example.lexer.Token
import org.example.lexer.TokenType
import org.example.lexer.TokenType.*
import org.example.parser.Parser
import org.junit.jupiter.api.Test

class ParserTest {
    private val tokens = listOf( Token(KEYWORD, "let", 1, 1), Token(IDENTIFIER, "name", 1, 5), Token(ASSIGNATION, "=", 1, 10), Token( STRING_LITERAL, "Kotlin", 1, 12), Token(SEMICOLON, ";", 1, 18), Token(KEYWORD, "let", 1, 20), Token(IDENTIFIER, "value", 1, 24), Token(ASSIGNATION, "=", 1, 30), Token( STRING_LITERAL, "Kotlin2", 1, 32), Token(SEMICOLON, ";", 1, 39) )
    private val parser = Parser()

    @Test
    fun `test parse`() {
        val ast = parser.parse(tokens)
        println(ast)
        println(ast[0].type)
    }
}