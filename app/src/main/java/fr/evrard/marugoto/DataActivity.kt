package fr.evrard.marugoto


import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_data.*
import kotlinx.android.synthetic.main.activity_lesson.*
import java.util.jar.Attributes

class DataActivity : AppCompatActivity() {

    private var mediaplayer: MediaPlayer? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        mediaplayer = MediaPlayer.create(this, R.raw.song)
        mediaplayer?.setOnPreparedListener {
            println("Ready to Go")
        }
        push_button.setOnTouchListener{_, event ->
            handleTouch(event)
            true
        }

        totoText.text = "NAME is ${intent.getStringExtra(MainActivity.NAME)}  et NUMBER ${intent.getIntExtra(MainActivity.NUMBER, 0)} "


        // Initializing a String Array
        val colors = arrayOf("Red","Green","Blue","Yellow","Black","Crimson","Orange")

        // Initializing an ArrayAdapter
        val adapter = ArrayAdapter(this, // Context
            android.R.layout.simple_spinner_item, // Layout
            colors // Array
        )

        // Set the drop down view resource
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

        // Finally, data bind the spinner object with adapter
        spinner.adapter = adapter;

        // Set an on item selected listener for spinner object
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long){
                // Display the selected item text on text view
                text_view.text = "Elément sélectionné : ${parent.getItemAtPosition(position).toString()}"
            }

            override fun onNothingSelected(parent: AdapterView<*>){
                // Another interface callback
            }
        }

    }
    private fun handleTouch(event: MotionEvent){
        when (event.action){
            MotionEvent.ACTION_DOWN ->{
                println("Down")
                mediaplayer?.start()
            }
            MotionEvent.ACTION_CANCEL, MotionEvent.ACTION_UP -> {
                println("Up or cancel")
                mediaplayer?.pause()
                mediaplayer?.seekTo(0)
            }
            else -> {
                println("other")
            }
        }
    }
}
