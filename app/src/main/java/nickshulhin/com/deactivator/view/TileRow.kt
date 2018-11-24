package nickshulhin.com.deactivator.view

import android.content.Context
import android.widget.LinearLayout
import android.widget.RelativeLayout
import nickshulhin.com.deactivator.R

class TileRow(context: Context) : RelativeLayout(context) {

    val tileRowState = mutableMapOf<Int, Int>()

    init {
        inflate(context, R.layout.tile_row_layout, this)
    }

    fun build(tiles: Int, rowValues: MutableMap<Int, Int>): TileRow {
        val tileHolder = findViewById<LinearLayout>(R.id.tile_holder)
        for (i in 1..tiles) {
            tileRowState[i] = rowValues[i]!!
            val tilePuzzle = rowValues[i]!!
            val tile = Tile(context, tilePuzzle)
            tile.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT)
            tile.setOnClickListener {
                tile.incrementCode()
                tileRowState.replace(i, tile.code)
            }
            tileHolder.addView(tile)
        }
        return this
    }
}