package student.rvc.edu.week7

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Bind objects
        var txtMessage = findViewById<EditText>(R.id.txtMessage)
        var btnSubmit = findViewById<Button>(R.id.btnSubmit)

        //Get focus on txtMessage at runtime
        txtMessage.requestFocus()

        //Submit button action
        btnSubmit.setOnClickListener {
            //Showing message by concatenating string and $(variable)
            //Adding toast message.
            Toast.makeText(this, "The Message is: ${txtMessage.text.toString()}",Toast.LENGTH_LONG) .show()

            //Hide keyboard
            hideKeyboard()

            //Clear txtMessage
            txtMessage.setText("")

            //Set focus back on txtMessage
            txtMessage.requestFocus()
        }

        //Hide keyboard when outside txtMessage
        findViewById<View>(android.R.id.content).setOnTouchListener { _, _ ->
            hideKeyboard()
            false
        }
    }

    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        catch (e: Exception) {
            //TODO: handle exception
        }
    }
}