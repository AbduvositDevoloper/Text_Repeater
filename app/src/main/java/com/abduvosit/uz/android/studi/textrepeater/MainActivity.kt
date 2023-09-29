package com.abduvosit.uz.android.studi.textrepeater

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.ScrollView
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import java.util.Random


class MainActivity : AppCompatActivity() {
    private var text = ""
    private var a = 0.0
    private var b = 0.0

    private lateinit var nav: LinearLayout
    private lateinit var toolbar: LinearLayout
    private lateinit var vscroll: ScrollView
    private lateinit var title: TextView
    private lateinit var layout: LinearLayout
    private lateinit var textview1: TextView
    private lateinit var textview2: TextView
    private lateinit var linear3: LinearLayout
    private lateinit var linear_switches: LinearLayout
    private lateinit var materialbutton_repeat: MaterialButton
    private lateinit var linear_result: LinearLayout
    private lateinit var linear_buttons: LinearLayout
    private lateinit var textinputlayout1: TextInputLayout
    private lateinit var textinputlayout2: TextInputLayout
    private lateinit var edittext_text: EditText
    private lateinit var edittext_count: EditText

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private lateinit var switch_newline: Switch
    private lateinit var linear2: LinearLayout

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private lateinit var switch_index: Switch
    private lateinit var result: TextView
    private lateinit var materialbutton_copy: MaterialButton
    private lateinit var materialbutton_share: MaterialButton

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav = findViewById(R.id.nav)
        toolbar = findViewById(R.id.toolbar)
        vscroll = findViewById(R.id.vscroll)
        title = findViewById(R.id.title)
        layout = findViewById(R.id.layout)
        textview1 = findViewById(R.id.textview1)
        textview2 = findViewById(R.id.textview2)
        linear3 = findViewById(R.id.linear3)
        linear_switches = findViewById(R.id.linear_switches)
        materialbutton_repeat = findViewById(R.id.materialbutton_repeat)
        linear_result = findViewById(R.id.linear_result)
        linear_buttons = findViewById(R.id.linear_buttons)
        textinputlayout1 = findViewById(R.id.textinputlayout1)
        textinputlayout2 = findViewById(R.id.textinputlayout2)
        edittext_text = findViewById(R.id.edittext_text)
        edittext_count = findViewById(R.id.edittext_count)
        switch_newline = findViewById(R.id.switch_newline)
        linear2 = findViewById(R.id.linear2)
        switch_index = findViewById(R.id.switch_index)
        result = findViewById(R.id.result)
        materialbutton_copy = findViewById(R.id.materialbutton_copy)
        materialbutton_share = findViewById(R.id.materialbutton_share)


        materialbutton_repeat.setOnClickListener {
            result.text = ""
            a = edittext_count.text.toString().toDouble()
            b = 0.0
            if (switch_newline.isChecked) {
                if (switch_index.isChecked) {
                    for (_repeat181 in 0 until a.toInt()) {
                        if (b != a) {
                            result.text = """
     ${result.text}
     
     """.trimIndent() + (b + 1).toLong().toString() + ". " + edittext_text.text.toString()
                            b++
                        } else {
                            break
                        }
                    }
                } else {
                    for (_repeat200 in 0 until a.toInt()) {
                        if (b != a) {
                            result.text = """
                                ${result.text}
                                ${edittext_text.text}
                                """.trimIndent()
                            b++
                        } else {
                            break
                        }
                    }
                }
            } else {
                if (switch_index.isChecked) {
                    for (_repeat216 in 0 until a.toInt()) {
                        if (b != a) {
                            result.text = result.text.toString() + " " + (b + 1).toLong()
                                .toString() + ". " + edittext_text.text.toString()
                            b++
                        } else {
                            break
                        }
                    }
                } else {
                    for (_repeat235 in 0 until a.toInt()) {
                        if (b != a) {
                            result.text =
                                result.text.toString() + " " + edittext_text.text.toString()
                            b++
                        } else {
                            break
                        }
                    }
                }
            }
        }

        materialbutton_copy.setOnClickListener {
            (getSystemService(CLIPBOARD_SERVICE) as ClipboardManager).setPrimaryClip(
                ClipData.newPlainText("clipboard", result.text.toString())
            )
            Toast.makeText(this, "Text Copied", Toast.LENGTH_SHORT).show()
        }

        materialbutton_share.setOnClickListener {
            text = result.text.toString()
            val ShareIntent = Intent(Intent.ACTION_SEND)

            //Type
            ShareIntent.type = "text/plain"

            //Subject
            ShareIntent.putExtra(
                Intent.EXTRA_SUBJECT, "Text Repeater by Abduvosit"
            )

            //Body
            ShareIntent.putExtra(Intent.EXTRA_TEXT, text)
            startActivity(Intent.createChooser(ShareIntent, "Share via"))
        }
    }


}
