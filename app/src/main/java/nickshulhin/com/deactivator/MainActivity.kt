package nickshulhin.com.deactivator

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import nickshulhin.com.deactivator.utils.PuzzleUtils
import nickshulhin.com.deactivator.model.TileRow
import nickshulhin.com.deactivator.view.TileSet
import android.os.CountDownTimer
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {

    lateinit var puzzle: MutableMap<Int, MutableMap<Int, Int>>
    lateinit var tileSet: TileSet
    lateinit var gameTimer: CountDownTimer
    lateinit var loadingPuzzleTimer: CountDownTimer
    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initiatePuzzle()
        setUpDeactivation()
        startPuzzle()
    }

    fun startTimer(){
        val timeProgressBar = findViewById<ProgressBar>(R.id.progress_time)
        timeProgressBar.progressTintList = ColorStateList.valueOf(Color.WHITE);
        val scoreLabel = findViewById<TextView>(R.id.score_label)
        scoreLabel.text = "SCORE: ${score}"
        gameTimer = object : CountDownTimer(20000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeProgressBar.progress += 5
            }
            override fun onFinish() {
                val intent = Intent(applicationContext, MenuActivity::class.java).apply {
                    putExtra("SCORE", score.toString())
                }
                gameTimer.cancel()
                loadingPuzzleTimer.cancel()
                startActivity(intent)
            }
        }.start()
    }

    fun setUpDeactivation() {
        val scoreLabel = findViewById<TextView>(R.id.score_label)
        val deactivateButton = findViewById<Button>(R.id.deactivate_button)
        deactivateButton.setOnClickListener{
            if (isSolutionCorrect(puzzle, tileSet.tileRows)) {
                score += 1000
                scoreLabel.text = "SCORE: ${score}"
                startPuzzle()
            } else {
                scoreLabel.text = "WRONG CODE"
            }
        }
    }

    fun startPuzzle() {
        val scoreLabel = findViewById<TextView>(R.id.score_label)
        initiatePuzzle()
        loadingPuzzleTimer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                scoreLabel.text = "${millisUntilFinished/1000}"
            }
            override fun onFinish() {
                scoreLabel.text = "SCORE: ${0}"
                randomizePuzzle()
                startTimer()
            }
        }.start()

    }

    fun initiatePuzzle() {
        val mainLayout = findViewById<LinearLayout>(R.id.main_game_layout)
        puzzle = PuzzleUtils.preparePuzzle(3, 3)
        tileSet = TileSet(this).createTileSet(mainLayout, 3, 3, puzzle)
    }

    fun randomizePuzzle() {
        val mainLayout = findViewById<LinearLayout>(R.id.main_game_layout)
        tileSet = TileSet(this).createTileSet(mainLayout, 3, 3, PuzzleUtils.preparePuzzle(3, 3))
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
