package nickshulhin.com.deactivator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        setUpNewGameButton()
    }

    private fun setUpNewGameButton() {
        val newGameButton: Button = findViewById(R.id.new_game_button)
        newGameButton.setOnClickListener {
            startActivity(Intent(it.context, MainActivity::class.java))
        }
    }
}
