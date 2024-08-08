import org.example.Parser
import org.junit.jupiter.api.Test

class InterpreterTests {
    @Test
    fun `test interpret`() {
        val code = "let name = Kotlin ; let value = Kotlin2 ; "
        val lexer = Lexer(code)
        val parser = Parser()
        val interpreter = Interpreter(parser.parse(lexer.tokenize()))
        val a = interpreter.interpret()
        println(a)
    }
}