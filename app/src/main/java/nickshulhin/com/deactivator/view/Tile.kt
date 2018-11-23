package nickshulhin.com.deactivator.view

import android.content.Context
import android.widget.ImageView
import android.widget.RelativeLayout
import nickshulhin.com.deactivator.R

class Tile(context: Context, var code: Int) : RelativeLayout(context) {

    init {
        inflate(context, R.layout.tile_layout, this)
    }

    fun swapIcon(code: Int) {
        val iconView: ImageView = findViewById(R.id.tile_icon)
        when (code) {
            1 -> iconView.setImageResource(R.drawable.tile_icon_1)
            2 -> iconView.setImageResource(R.drawable.tile_icon_2)
            3 -> iconView.setImageResource(R.drawable.tile_icon_3)
            else -> iconView.setImageResource(0)
        }
    }

    fun incrementCode() {
        if (code >= 3) {
            code = 1
        } else{
            code += 1
        }
        swapIcon(code)
    }
}