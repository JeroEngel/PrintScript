import handlers.*
import org.example.lexer.handlers.IdentifierOrKeywordHandler
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HandlerTests {

    @Test
    fun `test LetHandler`() {
        val code = "let"
        val lexer = Lexer(code)
        val handler =LetHandler()

        val token = handler.handle(code[0], lexer)
        val expectedToken = Token(TokenType.KEYWORD, "let", 1, 1)

        assertEquals(expectedToken, token)
    }

    @Test
    fun `test AssignationHandler`() {
        val code = "="
        val lexer = Lexer(code)
        val handler = AssignationHandler()

        val token = handler.handle(code[0], lexer)
        val expectedToken = Token(TokenType.ASSIGNATION, "=", 1, 1)

        assertEquals(expectedToken, token)
    }

    @Test
    fun `test IdentifierOrKeywordHandler`() {
        val code = "variableName"
        val lexer = Lexer(code)
        val handler = IdentifierOrKeywordHandler()

        val token = handler.handle(code[0], lexer)
        val expectedToken = Token(TokenType.IDENTIFIER, "variableName", 1, 1)

        assertEquals(expectedToken, token)
    }

    @Test
    fun `test NumberHandler`() {
        val code = "12345"
        val lexer = Lexer(code)
        val handler = NumberHandler()

        val token = handler.handle(code[0], lexer)
        val expectedToken = Token(TokenType.NUMBER, "12345", 1, 1)

        assertEquals(expectedToken, token)
    }

    @Test
    fun `test ParenthesisHandler`() {
        val code = "("
        val lexer = Lexer(code)
        val handler = ParenthesisHandler()

        val token = handler.handle(code[0], lexer)
        val expectedToken = Token(TokenType.LEFT_PARENTHESIS, "(", 1, 1)

        assertEquals(expectedToken, token)
    }

    @Test
    fun `test SemicolonHandler`() {
        val code = ";"
        val lexer = Lexer(code)
        val handler = SemicolonHandler()

        val token = handler.handle(code[0], lexer)
        val expectedToken = Token(TokenType.SEMICOLON, ";", 1, 1)

        assertEquals(expectedToken, token)
    }

    @Test
    fun `test StringLiteralHandler`() {
        val code = "\"hello\""
        val lexer = Lexer(code)
        val handler = StringLiteralHandler()

        val token = handler.handle(code[0], lexer)
        val expectedToken = Token(TokenType.STRING_LITERAL, "\"hello\"", 1, 1)

        assertEquals(expectedToken, token)
    }

    @Test
    fun `test WhitespaceHandler`() {
        val code = " "
        val lexer = Lexer(code)
        val handler = WhitespaceHandler()

        val token = handler.handle(code[0], lexer)
        val expectedToken = null // Asumiendo que el WhitespaceHandler no devuelve un token

        assertEquals(expectedToken, token)
    }
}
