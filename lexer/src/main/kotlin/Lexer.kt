import handlers.*
import org.example.lexer.handlers.IdentifierOrKeywordHandler

class Lexer(val code: String) {
    var position = 0
    var line = 1
    var column = 1

    private val handlers = listOf(
        WhitespaceHandler(),
        IdentifierOrKeywordHandler(),
        StringLiteralHandler(),
        AssignationHandler(),
        SemicolonHandler(),
        NumberHandler(),
        ParenthesisHandler()
    )

    fun tokenize(): List<Token> {
        val tokens = mutableListOf<Token>()

        while (position < code.length) {
            var matched = false
            val currentChar = code[position]

            for (handler in handlers) {
                val token = handler.handle(currentChar, this)
                if (token != null) {
                    tokens.add(token)
                    matched = true
                    break
                }
            }

            if (!matched && !currentChar.isWhitespace()){
                tokens.add(Token(TokenType.UNKNOWN, currentChar.toString(), line, column))
                position++
                column++
            }
        }

        return tokens
    }
}
