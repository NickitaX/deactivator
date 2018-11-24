package nickshulhin.com.deactivator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import nickshulhin.com.deactivator.utils.PuzzleUtils
import nickshulhin.com.deactivator.view.TileSet


class MainActivity : AppCompatActivity() {

    val puzzle: MutableMap<Int, MutableMap<Int, Int>> = PuzzleUtils.preparePuzzle(3, 3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createTileSet()
    }

    fun createTileSet() {
        val mainLayout = findViewById<LinearLayout>(R.id.main_game_layout)
        TileSet(this).createTileSet(mainLayout, 3, 3, puzzle)
    }
}
