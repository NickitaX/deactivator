package nickshulhin.com.deactivator.utils

object Randomiser {
    fun spawnTileCode(): Int {
        return 1 + (Math.random() * ((3 - 1) + 1)).toInt()
    }
}