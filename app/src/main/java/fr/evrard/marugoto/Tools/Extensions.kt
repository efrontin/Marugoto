package fr.evrard.marugoto.Tools

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.toastMsg(message:String){

    Toast.makeText(this,message,  Toast.LENGTH_LONG).show()

}

fun AppCompatActivity.showText(text:String){
    Toast.makeText(this,text, Toast.LENGTH_SHORT).show()
}