import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class SolutionTest(private val expected: List<Int>,
                   private val input: List<Int>) {

    private val soln = RadixSort()

    companion object {
        @Parameterized.Parameters
        @JvmStatic
        fun param() = arrayOf(
                arrayOf(listOf(12,21,24,41), listOf(24,12,41,21))
        )
    }

    @Test
    fun test() {
        soln.sort(input)
        assertEquals(expected, input)
    }

}
