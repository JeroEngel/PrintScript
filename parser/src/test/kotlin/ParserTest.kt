import org.example.Parser
import org.junit.jupiter.api.Test


class ParserTest {
    private val tokens = listOf( Token(TokenType.KEYWORD, "let", 1, 1), Token(TokenType.IDENTIFIER, "name", 1, 5), Token(
        TokenType.ASSIGNATION, "=", 1, 10), Token(TokenType.STRING_LITERAL, "Kotlin", 1, 12), Token(TokenType.SEMICOLON, ";", 1, 18), Token(
        TokenType.KEYWORD, "let", 1, 20), Token(TokenType.IDENTIFIER, "value", 1, 24), Token(TokenType.ASSIGNATION, "=", 1, 30), Token(
        TokenType.STRING_LITERAL, "Kotlin2", 1, 32), Token(TokenType.SEMICOLON, ";", 1, 39) )
    private val parser = Parser()

    @Test
    fun `test parse`() {
        val ast = parser.parse(tokens)
        println(ast)
        println(ast[0].type)
    }
}