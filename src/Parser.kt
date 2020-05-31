class Parser {
    private val opRegex = Regex("[\\w+]+")
    private val exprRegex = Regex("\\(.*\\)|[\\w+]+")


    fun parse(string: String): Node {
        if (!validExpression(string)) throw IllegalArgumentException("Not a valid expression")

        val withoutParens = removeParens(string)
        val op = opRegex.find(withoutParens)?.value ?: throw IllegalArgumentException()
        val rest = withoutParens.removePrefix(op)
        val children = exprRegex.findAll(rest).toList().map { parse(it.value) }

        return Node(op, children)
    }

    private fun validExpression(string: String): Boolean {
        return true
    }

    private fun removeParens(string: String): String {
        return if (string.first() == '(' && string.last() == ')') {
            string.substring(1, string.length - 1)
        } else {
            string
        }
    }

    fun astToList(ast: Node): List<Any?> {
        return if (ast.children.isNotEmpty()) {
            listOf(ast.value, ast.children.flatMap { astToList(it) })
        } else {
            listOf(ast.value)
        }
    }
}
