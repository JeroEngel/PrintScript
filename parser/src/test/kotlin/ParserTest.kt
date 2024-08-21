import org.example.Parser
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class ParserTests {

    private fun readSourceCodeFromFile(filename: String): String {
        return File("src/test/resources/$filename").readText()
    }

    @Test
    fun `test parser declaration with pre made list of tokens`() {
        val tokens = listOf(
            Token(TokenType.LET, TokenValue.StringValue("let"), 1, 1),
            Token(TokenType.IDENTIFIER,TokenValue.StringValue("name"), 1, 5),
            Token(TokenType.COLON, TokenValue.StringValue(":"), 1, 9),
            Token(TokenType.STRING_TYPE,TokenValue.StringValue("String"), 1, 11),
            Token(TokenType.ASSIGN, TokenValue.StringValue("="), 1, 18),
            Token(TokenType.STRING, TokenValue.StringValue("Olive"), 1, 20),
            Token(TokenType.SEMICOLON, TokenValue.StringValue(";"), 1, 27),
            Token(TokenType.IDENTIFIER, TokenValue.StringValue("name"), 2, 1),
            Token(TokenType.ASSIGN, TokenValue.StringValue("="), 2, 5),
            Token(TokenType.STRING, TokenValue.StringValue("Juan"), 2, 7),
            Token(TokenType.SEMICOLON, TokenValue.StringValue(";"), 2, 12),
        )

        // Create a parser and parse the tokens
        val parser = Parser()
        val ast = parser.parse(tokens)
        println(ast)

        // Expected AST structure
        //val expectedAst = ProgramNode(
       //     statements = listOf(
         //       VariableDeclarationNode(
           //         identifier = IdentifierNode("name", 1, 5),
             //       value = StringLiteralNode("Olive", 1, 20),
               //     line = 1,
                 //   column = 5
                //)
           // )
        //)
        // Assert that the AST produced by the parser matches the expected AST
        //assertEquals(expectedAst, ast)
    }

    @Test
    fun `test parser print statement with pre made list of tokens`() {
        val tokens = listOf(
            Token(TokenType.PRINT, TokenValue.StringValue("print"), 1, 1),
            Token(TokenType.LEFT_PARENTHESIS, TokenValue.StringValue("("), 1, 6),
            Token(TokenType.STRING, TokenValue.StringValue("Olive"), 1, 7),
            Token(TokenType.RIGHT_PARENTHESIS, TokenValue.StringValue(")"), 1, 13),
            Token(TokenType.SEMICOLON, TokenValue.StringValue(";"), 1, 14),

        )

        // Create a parser and parse the tokens
        val parser = Parser()
        val ast = parser.parse(tokens)

        // Expected AST structure
        val expectedAst = ProgramNode(
            statements = listOf(
                PrintStatementNode(
                    expression = StringLiteralNode("Olive", 1, 7),
                    line = 1,
                    column = 7
                )
            )
        )
        // Assert that the AST produced by the parser matches the expected AST
        assertEquals(expectedAst, ast)
    }

    @Test
    fun `test parser print statement with pre made list of tokens part 2`() {
        val tokens = listOf(
            Token(TokenType.PRINT, TokenValue.StringValue("print"), 1, 1),
            Token(TokenType.LEFT_PARENTHESIS, TokenValue.StringValue("("), 1, 6),
            Token(TokenType.NUMBER, TokenValue.NumberValue(5.0), 1, 7),
            Token(TokenType.SUM, TokenValue.StringValue("+"), 1, 13),
            Token(TokenType.NUMBER, TokenValue.NumberValue(6.0), 8, 7),
            Token(TokenType.RIGHT_PARENTHESIS, TokenValue.StringValue(")"), 1, 13),
            Token(TokenType.SEMICOLON, TokenValue.StringValue(";"), 1, 14),
            )

        // Create a parser and parse the tokens
        val parser = Parser()
        val ast = parser.parse(tokens)
        println(ast)

        // Expected AST structure

        // Assert that the AST produced by the parser matches the expected AST
    }


}


