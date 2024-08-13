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
}
