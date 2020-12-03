package com.example.demo_task_kotlin


import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
private const val cameraRequest=42

class MainActivity : AppCompatActivity() {

lateinit var toggle:ActionBarDrawerToggle

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         bottomNavigationView.background=null
       toggle= ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.mItem1 -> Toast.makeText(applicationContext,"Clicked text 1",Toast.LENGTH_SHORT).show()
                R.id.mItem2 -> Toast.makeText(applicationContext,"Clicked text 2",Toast.LENGTH_SHORT).show()
                R.id.mItem3 -> Toast.makeText(applicationContext,"Clicked text 3",Toast.LENGTH_SHORT).show()
            }
            true
        }


        val mFab = findViewById<FloatingActionButton>(R.id.fab)
        mFab.setOnClickListener {
           // Toast.makeText(this@MainActivity, "FAB is clicked...", Toast.LENGTH_LONG).show()
           val intent=Intent(this,CamActivity::class.java)
            startActivity(intent)
           // val takeIntent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
           // startActivityForResult(takeIntent, cameraRequest)
           // finish()
            //val takeIntent= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            //if (takeIntent.resolveActivity(this.packageManager)!=null){
              //  startActivityForResult(takeIntent, cameraRequest)}
          //  else{
              //  Toast.makeText(this, "Unable to open camera", Toast.LENGTH_LONG).show()
           // }

        }


         }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){

            return true
        }
        return super.onOptionsItemSelected(item)
    }

}





