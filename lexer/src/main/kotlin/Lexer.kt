
import handlers.*
import handlers.IdentifierOrKeywordHandler

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
        ParenthesisHandler(),
        ColonAndTypeHandler(),
        ArithmeticOperatorHandler(),
    )

    fun tokenize(): List<Token> {
        val tokens = mutableListOf<Token>()

        while (position < code.length) {
            val currentChar = code[position]
            var matched = false

            for (handler in handlers) {
                val token = handler.handle(currentChar, this)
                if (token != null) {
                    tokens.add(token)
                    matched = true
                    break
                }
            }

            if (!matched && !currentChar.isWhitespace()) {
                val unknownToken = Token(TokenType.UNKNOWN, TokenValue.StringValue(currentChar.toString()), line, column)
                throw IllegalArgumentException("Unknown token found: $unknownToken")
            }
        }

        return tokens
    }
}
