import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import Lexer
class LexerTests  {
    @Test
    fun `test tokenize`() {
        val code = "let name = Kotlin ; let value = Kotlin2 ; "
        val lexer = Lexer(code)
        val tokens = lexer.tokenize()
        assertEquals(10, tokens.size)
        assertEquals("let", tokens[0].value)
        assertEquals("name", tokens[1].value)
        assertEquals("=", tokens[2].value)
        assertEquals("Kotlin", tokens[3].value)
        println(tokens)
    }
}