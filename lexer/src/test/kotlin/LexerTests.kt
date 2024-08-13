import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import java.io.File

class LexerTests {

    private fun readSourceCodeFromFile(filename: String): String {
        return File("src/test/resources/$filename").readText()
    }

    @Test
    fun `test tokenize`() {
        val code = readSourceCodeFromFile("testCode1.txt")
        val lexer = Lexer(code)
        val tokens = lexer.tokenize()
        println(tokens)
        assertEquals(5, tokens.size)  // Update to expect 14 tokens
        assertEquals(TokenType.LET, tokens[0].type)
        assertEquals("let", tokens[0].value)
        assertEquals(TokenType.IDENTIFIER, tokens[1].type)
        assertEquals("name", tokens[1].value)
        assertEquals(TokenType.ASSIGN, tokens[2].type)
        assertEquals("=", tokens[2].value)
        assertEquals(TokenType.STRING, tokens[3].type)
        assertEquals("Olive", tokens[3].value)
        // Add similar assertions for the remaining tokens
    }

    @Test
    fun `test tokenize2`() {
        val code =  readSourceCodeFromFile("testCodeIdentifier.txt")
        val lexer = Lexer(code)
        val tokens = lexer.tokenize()
        println(tokens)

        val expectedTokens = listOf(
            Token(TokenType.LET, "let", 1, 1),
            Token(TokenType.IDENTIFIER, "name", 1, 5),
            Token(TokenType.ASSIGN, "=", 1, 10),
            Token(TokenType.STRING, "\"Olive\"", 1, 12),
            Token(TokenType.SEMICOLON, ";", 1, 19),
            Token(TokenType.PRINT, "print", 2, 1),
            Token(TokenType.LEFT_PARENTHESIS, "(", 2, 6),
            Token(TokenType.IDENTIFIER, "name", 2, 7),
            Token(TokenType.RIGHT_PARENTHESIS, ")", 2, 11),
            Token(TokenType.SEMICOLON, ";", 2, 12),
            Token(TokenType.PRINT, "print", 3, 1),
            Token(TokenType.LEFT_PARENTHESIS, "(", 3, 6),
            Token(TokenType.STRING, "\"Hola mundo\"", 3, 7),
            Token(TokenType.RIGHT_PARENTHESIS, ")", 3, 19),
            Token(TokenType.SEMICOLON, ";", 3, 20)
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
        // Continue checking for other tokens..
}
