package nickshulhin.com.deactivator.view

import android.content.Context
import android.widget.LinearLayout
import android.widget.RelativeLayout
import nickshulhin.com.deactivator.R

class TileRow(context: Context) : RelativeLayout(context) {
    init {
        inflate(context, R.layout.tile_row_layout, this)
    }

    fun build (tiles: Int) : TileRow {
        val tileHolder = findViewById<LinearLayout>(R.id.tile_holder)
        for (i in 1..tiles) {
            val tile = Tile(context)
            tile.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT)
            tile.setOnClickListener {
                tile.incrementCode()
            }
            tileHolder.addView(tile)
        }
        return this
    }
}