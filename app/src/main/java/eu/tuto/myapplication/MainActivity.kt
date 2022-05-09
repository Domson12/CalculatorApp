package eu.tuto.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import eu.tuto.myapplication.databinding.ActivityMainBinding
import org.w3c.dom.Text

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var isNewOp = true
    private var oldNum = ""
    private var operator = "+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun buttonEvent(view: View) {
        if (isNewOp){
            binding.workTV.text = ""
        }
        isNewOp = false
        var click: String = binding.workTV.text.toString()
        val select = view as Button
        when(select.id){
            binding.but1.id -> {click += "1"}
            binding.but2.id -> {click += "2"}
            binding.but3.id -> {click += "3"}
            binding.but4.id -> {click += "4"}
            binding.but5.id -> {click += "5"}
            binding.but6.id -> {click += "6"}
            binding.but7.id -> {click += "7"}
            binding.but8.id -> {click += "8"}
            binding.but9.id -> {click += "9"}
            binding.but0.id -> {click += "0"}
            binding.butDOT.id -> {click += "."}
        }
        binding.workTV.text = click
    }

    fun operatorEvent(view: View) {
        isNewOp = true
        oldNum = binding.workTV.text.toString()
        val select = view as Button
        when(select.id){
            binding.butTIM.id -> {operator = "*"}
            binding.butPLU.id -> {operator = "+"}
            binding.butMIN.id -> {operator = "-"}
            binding.butDIV.id -> {operator = "/"}
        }

    }

    fun equalEvent(view: View) {
        val newNumber = binding.workTV.text.toString()
        var result = 0.0
        when(operator){
            "+" -> {result = oldNum.toDouble() + newNumber.toDouble()}
            "*" -> {result = oldNum.toDouble() * newNumber.toDouble()}
            "/" -> {result = oldNum.toDouble() / newNumber.toDouble()}
            "-" -> {result = oldNum.toDouble() - newNumber.toDouble()}
        }
        binding.workTV.text = result.toString()
    }

    fun acEvent(view: View) {
        binding.workTV.text = "0"
        isNewOp = true
    }

    fun percentEvent(view: View) {
        val number = binding.workTV.text.toString().toDouble()/100
        binding.workTV.text = number.toString()
        isNewOp = true
    }
}
