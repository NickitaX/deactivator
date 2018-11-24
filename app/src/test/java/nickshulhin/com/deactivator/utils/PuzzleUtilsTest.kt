package nickshulhin.com.deactivator.utils

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class PuzzleUtilsTest {
    @Test
    fun preparePuzzleTest() {
        //Given
        val expected = mutableMapOf<Int, MutableMap<Int, Int>>()
        expected[1] = mutableMapOf(Pair(1, 2))
        expected[2] = mutableMapOf(Pair(1, 1))
        expected[3] = mutableMapOf(Pair(1, 3))
        //When
        val result = PuzzleUtils.preparePuzzle(3, 3)
        //Then
        assertEquals(expected.size, result.size)
    }
}
