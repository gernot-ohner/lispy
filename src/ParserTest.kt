import org.junit.jupiter.api.Assertions.*

internal class ParserTest {

    @org.junit.jupiter.api.Test
    fun parseToList() {
        val input: String = getSampleInput()
        val expected = getSampleList()
        val parser = Parser()
        val actual = parser.astToList(parser.parse(input))

        assertEquals(expected, actual)
    }


    @org.junit.jupiter.api.Test
    fun parse() {
        val input: String = getSampleInput()
        val expected = getSampleAst()
        val parser = Parser()
        val actual = parser.parse(input)
        println("Expected:\n$expected")
        println("Actual  :\n$actual")

        assert(expected.toString() == actual.toString())
    }


}
