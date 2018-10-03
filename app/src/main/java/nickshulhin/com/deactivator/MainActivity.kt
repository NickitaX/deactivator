package nickshulhin.com.deactivator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import nickshulhin.com.deactivator.view.TileRow


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        populateViews()
    }

    fun populateViews() {
        val mainLayout = findViewById<LinearLayout>(R.id.main_game_layout)
        for (i in 1..3) {
            val tileRow = TileRow(this).build(3)
            tileRow.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT)
            mainLayout.addView(tileRow)
        }
    }
}
