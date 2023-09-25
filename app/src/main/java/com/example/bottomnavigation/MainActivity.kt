package com.example.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(HomeFragment())
        bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.mHome -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.mMessages -> {
                    loadFragment(MessagesFragment())
                    true
                }
                R.id.mFeed -> {
                    loadFragment(FeedFragment())
                    true
                }

                R.id.mProfile -> {
                    loadFragment(ProfileFragment())
                    true
                }

                else -> {
                    super.onOptionsItemSelected(it)

                }
            }
        }
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.flFragments,fragment)
        transaction.commit()
    }

}