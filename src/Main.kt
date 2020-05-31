fun main() {
    val sampleInput = getSampleInput()
    Parser().parse(sampleInput);

}


fun getSampleInput(): String {
    return "(first (list 1 (+ 2 3) 9))"
}

fun getSampleList(): List<Any> {
    return listOf("first", listOf("list", 1, listOf("+", 2, 3), 9))
}

fun getSampleAst(): Node {
    return Node(
            "first",
            listOf(
                    Node(
                            "list",
                            listOf(
                                    Node(1),
                                    Node(
                                            "+",
                                            listOf(
                                                    Node(2),
                                                    Node(3)
                                            )
                                    ),
                                    Node(9)
                            )
                    ))
    )
}

