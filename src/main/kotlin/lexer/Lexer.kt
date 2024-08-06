
import org.example.lexer.Token
import org.example.lexer.TokenType

class Lexer(private val code: String) {

    private var position = 0
    private var line = 1
    private var column = 1

    private val keywords = setOf("let", "PrintLn", "String")

    fun tokenize(): List<Token> {
        val tokens = mutableListOf<Token>()

        while (position < code.length) {
            val currentChar = code[position]

            when {
                currentChar.isWhitespace() -> {
                    if (currentChar == '\n') {
                        line++
                        column = 1
                    } else {
                        column++
                    }
                    position++
                }

                currentChar.isLetter() -> {
                    val start = position
                    while (position < code.length && code[position].isLetterOrDigit()) {
                        position++
                        column++
                    }
                    val word = code.substring(start, position)
                    val type = when {
                        keywords.contains(word) -> TokenType.KEYWORD
                        else -> TokenType.IDENTIFIER
                    }
                    tokens.add(Token(type, word, line, column - word.length))
                }

                currentChar == '"' -> {
                    val start = position
                    position++
                    column++
                    while (position < code.length && code[position] != '"') {
                        position++
                        column++
                    }
                    position++
                    column++
                    val value = code.substring(start, position)
                    tokens.add(Token(TokenType.STRING_LITERAL, value, line, column - value.length))
                }

                currentChar == '=' -> {
                    tokens.add(Token(TokenType.ASSIGNATION, "=", line, column))
                    position++
                    column++
                }

                currentChar == ';' -> {
                    tokens.add(Token(TokenType.SEMICOLON, ";", line, column))
                    position++
                    column++
                }

                else -> {
                    tokens.add(Token(TokenType.UNKNOWN, currentChar.toString(), line, column))
                    position++
                    column++
                }
            }
        }

        return tokens
    }
}
