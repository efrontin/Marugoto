package fr.evrard.marugoto

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import fr.evrard.marugoto.Fragment.MainFragment
import fr.evrard.marugoto.Tools.toastMsg
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_main.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.share
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    companion object{
        const val NAME = "NAME"
        const val NUMBER = "NUMBER"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        replaceFragment(MainFragment(),R.id.mainContent)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
//            var intent = Intent(this, LessonActivity::class.java)
//            intent.putExtra(NAME, "toto")
//            startActivity(intent)


        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

//    override fun onResume() {
//        super.onResume()
////        title_experience.setOnClickListener { view ->
////            val intent = Intent(this, LessonActivity::class.java)
////            startActivity(intent)
////        }
//    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true

            R.id.action_coffee -> {
                toastMsg("On peut en parler autour d'un café")
                return true
            }
//            R.id.action_coffee -> {
//                Toast.makeText(this, "On peut en parler autour d'un café", Toast.LENGTH_LONG).show()
//                return true
//            }
            else -> return super.onOptionsItemSelected(item)
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {

            R.id.experience -> {
                startActivity<LessonActivity>()
            }

            R.id.nav_hobbies -> {

            }
            R.id.nav_share -> {
                share("Application mobile de mon CV sous Android","CV Android")
            }
            R.id.nav_linkedin -> {
                browse("https://www.linkedin.com/in/evrard-frontin/")
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun replaceFragment(frag:Fragment,vue:Int){
        supportFragmentManager.beginTransaction().replace(vue, frag).commit()
    }

}
