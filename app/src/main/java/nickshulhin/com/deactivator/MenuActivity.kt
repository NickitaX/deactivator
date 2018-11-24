package nickshulhin.com.deactivator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        setUpNewGameButton()
        showScoreIfFinished()
    }

    fun showScoreIfFinished(){
        val score = intent.getStringExtra("SCORE")
        val scoreFinishedLabel = findViewById<TextView>(R.id.score_label_finished)
        if(!score.isNullOrEmpty()) {
            scoreFinishedLabel.text = "${score} score? That's it? You are weak..."
        }

    }

    private fun setUpNewGameButton() {
        val newGameButton: Button = findViewById(R.id.start_game_button)
        newGameButton.setOnClickListener {
            startActivity(Intent(it.context, MainActivity::class.java))
        }
    }
}
