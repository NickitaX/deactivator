package nickshulhin.com.deactivator.view

import android.content.Context
import android.widget.LinearLayout
import nickshulhin.com.deactivator.OnFullTileSetStateChangeListener
import nickshulhin.com.deactivator.OnTileStateChangedListener

class TileSet(val context: Context) {

    val fullTileSetState = mutableMapOf<Int, MutableMap<Int, Int>>()

    fun createTileSet(layout: LinearLayout, rows: Int, columns: Int, listener: OnFullTileSetStateChangeListener) {
        for (i in 1..rows) {
            val tileRow = TileRow(context).build(columns, object : OnTileStateChangedListener{
                override fun tilesChanged(tileSetState: MutableMap<Int, Int>) {
                    fullTileSetState[i] = tileSetState
                    listener.onFullTileSetStateChanged(fullTileSetState)
                }
            })
            tileRow.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT)
            layout.addView(tileRow)
        }
    }
}
