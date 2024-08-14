enum class TokenType {

    // LITERAL TYPES
    NUMBER,
    STRING,  // Renombrado de STRING_LITERAL a STRING para consistencia

    // KEYWORDS
    LET,
    PRINT,

    // IDENTIFIER
    IDENTIFIER,
    STRING_TYPE,
    NUMBER_TYPE,

    // OPERATORS
    ASSIGN,  // Renombrado de ASSIGNATION a ASSIGN para consistencia

    // SYMBOLS
    SEMICOLON,
    COLON,
    LEFT_PARENTHESIS,
    RIGHT_PARENTHESIS,

    // WHITESPACE

    // MISC
    UNKNOWN
}