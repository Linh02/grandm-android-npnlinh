package oltest.appmt.mycalculator

//import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var number1: Double = 0.0
    var number2: Double = 0.0
    var result: Double = 0.0

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        events()
    }

    private fun events() {
        btnAddition.setOnClickListener {
            cal("+")
        }

        btnSubtraction.setOnClickListener {
            cal("-")
        }

        btnMultiplication.setOnClickListener {
            cal("*")
        }

        btnDivision.setOnClickListener {
            cal("/")
        }
    }

    private fun cal(type: String) {
        tvResult.text = "Kết quả: 0"
        if (etNumber1.text.isEmpty()) {
            etNumber1.requestFocus()
            Toast.makeText(this@MainActivity, "Vui lòng nhập số thứ nhất", Toast.LENGTH_SHORT).show()
            return
        }

        if (etNumber2.text.isEmpty()) {
            etNumber2.requestFocus()
            Toast.makeText(this, "Vui lòng nhập số thứ hai", Toast.LENGTH_SHORT).show()
            return
        }

        number1 = etNumber1.text.toString().toDouble()
        number2 = etNumber2.text.toString().toDouble()

        result = when (type) {
            "+" -> number1 + number2
            "-" -> number1 - number2
            "*" -> number1 * number2
            "/" -> number1 / number2
            else -> 0.0
        }

        tvResult.text = "Kết quả: ${result.toString()}"
    }

}