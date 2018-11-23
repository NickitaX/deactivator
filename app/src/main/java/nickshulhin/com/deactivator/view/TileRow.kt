package nickshulhin.com.deactivator.view

import android.content.Context
import android.widget.LinearLayout
import android.widget.RelativeLayout
import nickshulhin.com.deactivator.OnTileStateChangedListener
import nickshulhin.com.deactivator.R
import nickshulhin.com.deactivator.utils.Randomiser

class TileRow(context: Context) : RelativeLayout(context) {

    val tileRowState = mutableMapOf<Int, Int>()

    init {
        inflate(context, R.layout.tile_row_layout, this)
    }

    fun build (tiles: Int, listener: OnTileStateChangedListener) : TileRow {
        val tileHolder = findViewById<LinearLayout>(R.id.tile_holder)
        for (i in 1..tiles) {
            val generatedCode = Randomiser.spawnTileCode()
            tileRowState[i] = generatedCode
            val tile = Tile(context, generatedCode)
            tile.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT)
            tile.setOnClickListener {
                tile.incrementCode()
                tileRowState.replace(i, tile.code)
                listener.tilesChanged(tileRowState)
            }
            tileHolder.addView(tile)
        }
        listener.tilesChanged(tileRowState)
        return this
    }
}