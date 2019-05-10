package fr.evrard.marugoto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import fr.evrard.marugoto.Fragment.LessonFragment
import fr.evrard.marugoto.Tools.showText
import kotlinx.android.synthetic.main.activity_lesson.*


class LessonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)
        replaceFragment(LessonFragment(),R.id.lessonContent)
        showText(MainActivity.NAME)

        btn_check.setOnClickListener{
            if (validate()){
                var intent = Intent(this, DataActivity::class.java)
                intent.putExtra(MainActivity.NAME, lessonText.editableText.toString())
                intent.putExtra(MainActivity.NUMBER,Integer.valueOf(numberText.editableText.toString()))
                startActivity(intent)
            }
        }


    }

    private fun validate(): Boolean{
        var res = true
        if (lessonText.text.toString().isEmpty()){
            lessonText.error = "Vous devez remplir ce champ"
            res = false
        }
        if (numberText.text.toString().isEmpty()){
            numberText.error = "Vous devez remplir ce champ"
            res = false
        }
        return res
    }


    fun replaceFragment(frag: Fragment, vue:Int){
        supportFragmentManager.beginTransaction().replace(vue, frag).commit()
    }


}
