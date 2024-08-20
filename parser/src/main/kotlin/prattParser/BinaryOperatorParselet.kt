class BinaryOperatorParselet(private val precedence: Int) : InfixParselet {
    override fun parse(parser: PrattParser, left: ExpressionNode, token: Token): ExpressionNode {
        val right = parser.parseExpression(precedence)
        if (token.value == "+") { return BinaryExpressionNode(left, TokenType.SUM, right,token.line, token.column)}
        if (token.value == "-"){return BinaryExpressionNode(left, TokenType.SUBTRACT, right,token.line, token.column)}
        if (token.value == "*"){return BinaryExpressionNode(left, TokenType.MULTIPLY, right,token.line, token.column)}
        if (token.value == "/") {return BinaryExpressionNode(left, TokenType.DIVIDE, right,token.line, token.column) }
        else{ throw IllegalArgumentException("Unexpected token type in binary operator parselet")}
    }

    override fun precedence(): Int = precedence
}

object Precedence {
    const val SUM = 1
    const val PRODUCT = 2
}

