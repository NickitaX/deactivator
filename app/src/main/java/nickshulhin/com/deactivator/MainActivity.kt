package nickshulhin.com.deactivator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import nickshulhin.com.deactivator.utils.PuzzleUtils
import nickshulhin.com.deactivator.view.TileRow
import nickshulhin.com.deactivator.view.TileSet


class MainActivity : AppCompatActivity() {

    lateinit var puzzle: MutableMap<Int, MutableMap<Int, Int>>
    lateinit var tileSet: TileSet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createTileSet()
        setUpDeactivateButton()
    }

    fun setUpDeactivateButton() {
        val deactivateButton = findViewById<Button>(R.id.deactivate_button)
        deactivateButton.setOnClickListener{
            val r = isSolutionCorrect(puzzle, tileSet.tileRows)
        }
    }

    fun createTileSet() {
        val mainLayout = findViewById<LinearLayout>(R.id.main_game_layout)
        puzzle = PuzzleUtils.preparePuzzle(3, 3)
        tileSet = TileSet(this).createTileSet(mainLayout, 3, 3, puzzle)
    }

    fun isSolutionCorrect(task: MutableMap<Int, MutableMap<Int, Int>>, answer: MutableMap<Int, TileRow>): Boolean{
        var correct = true
        task.forEach {
            index, map ->
            run {
                if (answer[index]!!.tileRowState != map) {
                    correct = false
                }
            }
        }
        return correct
    }
}
