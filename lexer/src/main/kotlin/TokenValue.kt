sealed class TokenValue {
    data class StringValue(val value: String) : TokenValue()
    data class NumberValue(val value: Double) : TokenValue()
    data class BooleanValue(val value: Boolean) : TokenValue()
    object NullValue : TokenValue()
}
