package nickshulhin.com.deactivator

interface OnTileStateChangedListener {
    fun tilesChanged(tileSetState: MutableMap<Int, Int>)
}

