import org.example.AST

class Interpreter(private val ast: List<AST>){
    private val variables = mutableMapOf<String, String>()

    fun interpret() : Map<String, String>{
        for(node in ast){
            if(node.function == TokenType.ASSIGNATION){
                variables[node.identifier] = node.value
            }
            else if(node.function == TokenType.PRINT){
                println(variables[node.identifier])
            }
            else if(node.function == TokenType.DECLARATION){
                variables[node.identifier] = node.value
            }
        }
        return variables
    }
}