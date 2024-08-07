import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import org.example.lexer.Token
import org.example.lexer.TokenType

class LexerTests  {
    @Test
    fun `test tokenize`() {
        val code = "let name = Kotlin ; let value = Kotlin2 ; "
        val lexer = Lexer(code)
        val tokens = lexer.tokenize()
        println(tokens)
        assertEquals(10, tokens.size)
        assertEquals("let", tokens[0].value)
        assertEquals("name", tokens[1].value)
        assertEquals("=", tokens[2].value)
        assertEquals("Kotlin", tokens[3].value)
        println(tokens)
    }
    @Test
    fun `test tokenize keywords`() {
        val code = "let String PrintLn"
        val lexer = Lexer(code)
        val tokens = lexer.tokenize()

        val expectedTokens = listOf(
            Token(TokenType.KEYWORD, "let", 1, 1),
            Token(TokenType.KEYWORD, "String", 1, 5),
            Token(TokenType.KEYWORD, "PrintLn", 1, 12)
        )

        assertEquals(expectedTokens, tokens)
    }

    @Test
    fun `test tokenize identifier`() {
        val code = "variable"
        val lexer = Lexer(code)
        val tokens = lexer.tokenize()

        val expectedTokens = listOf(
            Token(TokenType.IDENTIFIER, "variable", 1, 1)
        )

        assertEquals(expectedTokens, tokens)
    }

    @Test
    fun `test tokenize string literal`() {
        val code = "\"Hello, World!\""
        val lexer = Lexer(code)
        val tokens = lexer.tokenize()

        val expectedTokens = listOf(
            Token(TokenType.STRING_LITERAL, "\"Hello, World!\"", 1, 1)
        )

        assertEquals(expectedTokens, tokens)
    }

    @Test
    fun `test tokenize assignation`() {
        val code = "="
        val lexer = Lexer(code)
        val tokens = lexer.tokenize()

        val expectedTokens = listOf(
            Token(TokenType.ASSIGNATION, "=", 1, 1)
        )

        assertEquals(expectedTokens, tokens)
    }

    @Test
    fun `test tokenize semicolon`() {
        val code = ";"
        val lexer = Lexer(code)
        val tokens = lexer.tokenize()

        val expectedTokens = listOf(
            Token(TokenType.SEMICOLON, ";", 1, 1)
        )

        assertEquals(expectedTokens, tokens)
    }

    @Test
    fun `test tokenize mixed code`() {
        val code = """
            String name = "Olive";
            let myVar = 10;
            PrintLn(myVar);
        """.trimIndent()

        val lexer = Lexer(code)
        val tokens = lexer.tokenize()

        val expectedTokens = listOf(
            Token(TokenType.KEYWORD, "String", 1, 1),
            Token(TokenType.IDENTIFIER, "name", 1, 8),
            Token(TokenType.ASSIGNATION, "=", 1, 13),
            Token(TokenType.STRING_LITERAL, "\"Olive\"", 1, 15),
            Token(TokenType.SEMICOLON, ";", 1, 21),
            Token(TokenType.KEYWORD, "let", 2, 1),
            Token(TokenType.IDENTIFIER, "myVar", 2, 5),
            Token(TokenType.ASSIGNATION, "=", 2, 11),
            Token(TokenType.IDENTIFIER, "10", 2, 13),
            Token(TokenType.SEMICOLON, ";", 2, 15),
            Token(TokenType.KEYWORD, "PrintLn", 3, 1),
            Token(TokenType.IDENTIFIER, "myVar", 3, 9),
            Token(TokenType.SEMICOLON, ";", 3, 14)
        )

        assertEquals(expectedTokens, tokens)
    }
}