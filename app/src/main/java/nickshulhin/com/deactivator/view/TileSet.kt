package nickshulhin.com.deactivator.view

import android.content.Context
import android.widget.LinearLayout
import nickshulhin.com.deactivator.model.TileRow

class TileSet(val context: Context) {

    val tileRows = mutableMapOf<Int, TileRow>()

    fun createTileSet(layout: LinearLayout, rows: Int, columns: Int, puzzle: MutableMap<Int, MutableMap<Int, Int>>): TileSet{
        layout.removeAllViews()
        for (i in 1..rows) {
            val rowPuzzle = puzzle[i]
            val tileRow = TileRow(context).build(columns, rowPuzzle!!)
            print(tileRow.tileRowState.toString())
            tileRows[i] = tileRow
            tileRow.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT)
            layout.addView(tileRow)
        }
        return this
    }
}
