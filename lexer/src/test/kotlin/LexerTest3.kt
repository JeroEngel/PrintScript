import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import java.io.File

class LexerTest3 {

    private fun readSourceCodeFromFile(filename: String): String {
        return File("src/test/resources/$filename").readText()
    }

    @Test
    fun `test full code with types and operators`() {
        val code = readSourceCodeFromFile("testkk123.txt")
        val lexer = Lexer(code)
        val tokens = lexer.tokenize()

        // Imprimir los tokens generados por el lexer
        println("Tokens generados por el lexer:")
        tokens.forEach { println(it) }

        val expectedTokens = listOf(
            Token(TokenType.LET, "let", 1, 1),
            Token(TokenType.IDENTIFIER, "name", 1, 5),
            Token(TokenType.COLON, ":", 1, 9),
            Token(TokenType.STRING_TYPE, "String", 1, 11),
            Token(TokenType.ASSIGN, "=", 1, 18),
            Token(TokenType.STRING, "Olive", 1, 20),
            Token(TokenType.SEMICOLON, ";", 1, 27),
            Token(TokenType.LET, "let", 2, 1),
            Token(TokenType.IDENTIFIER, "age", 2, 5),
            Token(TokenType.COLON, ":", 2, 8),
            Token(TokenType.NUMBER_TYPE, "Number", 2, 10),
            Token(TokenType.ASSIGN, "=", 2, 17),
            Token(TokenType.NUMBER, "30", 2, 19),
            Token(TokenType.SEMICOLON, ";", 2, 21),
            Token(TokenType.LET, "let", 3, 1),
            Token(TokenType.IDENTIFIER, "result", 3, 5),
            Token(TokenType.ASSIGN, "=", 3, 12),
            Token(TokenType.NUMBER, "5", 3, 14),
            Token(TokenType.PLUS, "+", 3, 16),
            Token(TokenType.NUMBER, "10", 3, 18),
            Token(TokenType.MINUS, "-", 3, 21),
            Token(TokenType.NUMBER, "3", 3, 23),
            Token(TokenType.MULTIPLY, "*", 3, 25),
            Token(TokenType.NUMBER, "2", 3, 27),
            Token(TokenType.DIVIDE, "/", 3, 29),
            Token(TokenType.NUMBER, "1", 3, 31),
            Token(TokenType.SEMICOLON, ";", 3, 32)
        )

        assertEquals(expectedTokens.size, tokens.size, "Token count mismatch")

        for ((i, expectedToken) in expectedTokens.withIndex()) {
            val actualToken = tokens[i]
            assertEquals(expectedToken.type, actualToken.type, "Token type mismatch at index $i")
            assertEquals(expectedToken.value, actualToken.value, "Token value mismatch at index $i")
            assertEquals(expectedToken.line, actualToken.line, "Token line mismatch at index $i")
            assertEquals(expectedToken.column, actualToken.column, "Token column mismatch at index $i")
        }
    }
}
