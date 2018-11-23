package nickshulhin.com.deactivator

interface OnFullTileSetStateChangeListener {
    fun onFullTileSetStateChanged(fullTileSet: MutableMap<Int, MutableMap<Int, Int>>)
}