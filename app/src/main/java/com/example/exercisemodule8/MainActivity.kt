package com.example.exercisemodule8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    private var numClicks : Int = 0
    private lateinit var layout: ConstraintLayout
    private lateinit var editText: EditText
    private lateinit var btnChangeImage: Button
    private lateinit var txtName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layout = findViewById(R.id.background)
        editText = findViewById(R.id.ed_text_name)
        btnChangeImage = findViewById(R.id.btn_change_image)
        txtName = findViewById(R.id.txt_name)


        btnChangeImage.setOnClickListener {
            numClicks++

            val userName = editText.text.toString()

            txtName.text = "Usuário: $userName, cliques: $numClicks"

            changeBackgroundImage()
        }
    }

    private fun changeBackgroundImage(){

        val images = listOf(
            R.mipmap.background_1,
            R.mipmap.background_2,
            R.mipmap.background_3
        )

        val imageIndex = numClicks % images.size

        layout.setBackgroundResource(images[imageIndex])
    }
}