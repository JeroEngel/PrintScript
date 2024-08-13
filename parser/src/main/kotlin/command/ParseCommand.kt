package command

import ASTNode
import Token

interface ParseCommand {
    fun execute(tokens: List<Token>, startIndex: Int): Pair<ASTNode, Int>
}