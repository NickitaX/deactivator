package nickshulhin.com.deactivator

import android.content.Intent
import android.net.Uri
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
        setUpContributeAndCreatorButtons()
    }

    fun showScoreIfFinished(){
        val score = intent.getStringExtra("SCORE")
        val scoreFinishedLabel = findViewById<TextView>(R.id.score_label_finished)
        if(!score.isNullOrEmpty()) {
            scoreFinishedLabel.text = "${score} score? That's it? You are weak..."
        }
    }

    fun setUpContributeAndCreatorButtons() {
        val contributeButton: Button = findViewById(R.id.contribute_button)
        val creatorButton: Button = findViewById(R.id.creator_button)
        contributeButton.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/NickitaX/deactivator")))
        }
        creatorButton.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://nickshulhin.com")))
        }

    }

    private fun setUpNewGameButton() {
        val newGameButton: Button = findViewById(R.id.start_game_button)
        newGameButton.setOnClickListener {
            startActivity(Intent(it.context, MainActivity::class.java))
        }
    }
}
