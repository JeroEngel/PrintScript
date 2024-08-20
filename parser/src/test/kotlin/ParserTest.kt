import org.example.Parser
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class ParserTests {

    private fun readSourceCodeFromFile(filename: String): String {
        return File("src/test/resources/$filename").readText()
    }
    @Test
    fun `test parse`() {
        // Read the source code from the file
        val code = readSourceCodeFromFile("testCodeIdentifier.txt")

        // Create a lexer and tokenize the source code
        val lexer = Lexer(code)
        val tokens = lexer.tokenize()

        // Create a parser and parse the tokens
        val parser = Parser()
        val ast = parser.parse(tokens)

        // Expected AST structure
        val expectedAst = ProgramNode(
            statements = listOf(
                VariableDeclarationNode(
                    identifier = IdentifierNode("name", 1, 5),
                    value = StringLiteralNode("Olive", 1, 14),
                    line = 1,
                    column = 5
                ),
                PrintStatementNode(
                    expression = IdentifierNode("name", 2, 7),
                    line = 2,
                    column = 7
                ),
                PrintStatementNode(
                    expression = StringLiteralNode("Hola mundo", 3, 9),
                    line = 3,
                    column = 9
                )
            )
        )

        // Assert that the AST produced by the parser matches the expected AST
        assertEquals(expectedAst, ast)
    }

    @Test
    fun `test parser declaration with pre made list of tokens`() {
        val tokens = listOf(
            Token(TokenType.LET, "let", 1, 1),
            Token(TokenType.IDENTIFIER, "name", 1, 5),
            Token(TokenType.COLON, ":", 1, 9),
            Token(TokenType.STRING_TYPE, "String", 1, 11),
            Token(TokenType.ASSIGN, "=", 1, 18),
            Token(TokenType.STRING, "Olive", 1, 20),

            Token(TokenType.SEMICOLON, ";", 1, 27),
        )

        // Create a parser and parse the tokens
        val parser = Parser()
        val ast = parser.parse(tokens)

        // Expected AST structure
        val expectedAst = ProgramNode(
            statements = listOf(
                VariableDeclarationNode(
                    identifier = IdentifierNode("name", 1, 5),
                    value = StringLiteralNode("Olive", 1, 20),
                    line = 1,
                    column = 5
                )
            )
        )
        // Assert that the AST produced by the parser matches the expected AST
        assertEquals(expectedAst, ast)
    }

    @Test
    fun `test parser print statement with pre made list of tokens`() {
        val tokens = listOf(
            Token(TokenType.PRINT, "print", 1, 1),
            Token(TokenType.LEFT_PARENTHESIS, "(", 1, 6),
            Token(TokenType.STRING, "Olive", 1, 7),
            Token(TokenType.RIGHT_PARENTHESIS, ")", 1, 13),
            Token(TokenType.SEMICOLON, ";", 1, 14),

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
            Token(TokenType.PRINT, "print", 1, 1),
            Token(TokenType.LEFT_PARENTHESIS, "(", 1, 6),
            Token(TokenType.STRING, "5", 1, 7),
            Token(TokenType.SUM, "+", 1, 13),
            Token(TokenType.STRING, "6", 8, 7),
            Token(TokenType.RIGHT_PARENTHESIS, ")", 1, 13),
            Token(TokenType.SEMICOLON, ";", 1, 14),

            )

        // Create a parser and parse the tokens
        val parser = Parser()
        val ast = parser.parse(tokens)
        println(ast)

        // Expected AST structure

        // Assert that the AST produced by the parser matches the expected AST
    }


}


