package nickshulhin.com.deactivator.utils

object PuzzleUtils {
    fun preparePuzzle(rows: Int, columns: Int): MutableMap<Int, MutableMap<Int, Int>> {
        val puzzle = mutableMapOf<Int, MutableMap<Int, Int>>()
        for (r in 1..rows) {
            val puzzleColumn: MutableMap<Int, Int> = mutableMapOf()
            for (c in 1..columns) {
                puzzleColumn[c] = Randomiser.spawnTileCode()
            }
            puzzle[r] = puzzleColumn
        }
        return puzzle
    }
}