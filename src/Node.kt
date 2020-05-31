
data class Node(val value: Any?, val children: List<Node> = emptyList()) {

    override fun toString(): String {
        val buffer = StringBuilder(50)
        print(buffer, "", "")
        return buffer.toString()
    }

    private fun print(buffer: StringBuilder, prefix: String, childrenPrefix: String) {
        buffer.append(prefix)
        buffer.append(value)
        buffer.append('\n')
        val it: Iterator<Node> = children.iterator()
        while (it.hasNext()) {
            val next = it.next()
            if (it.hasNext()) {
                next.print(buffer, "$childrenPrefix├── ", "$childrenPrefix│   ")
            } else {
                next.print(buffer, "$childrenPrefix└── ", "$childrenPrefix    ")
            }
        }
    }
}
