package com.example.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.myapplication.fragments.*
import com.example.myapplication.fragments.adapter.*
import kotlinx.android.synthetic.main.activity_news_acc2.*
import java.sql.Types.NULL


class newsAcc : AppCompatActivity() {

    var drawerLayout: DrawerLayout? = null
    var actionBarDrawerToggle: ActionBarDrawerToggle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_acc2)
        setuptabs()
    }

    private fun setuptabs() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addfragment(Entertainment(), "Entertainment")
        adapter.addfragment(
            Health(),
            "Health"
        )
        adapter.addfragment(Buisness(), "Buisness")
        adapter.addfragment(General(), "General")
        adapter.addfragment(Sports(), "Sports")
        adapter.addfragment(Technology(), "Technology")

        vpager.adapter = adapter
        tab_layout.setupWithViewPager(vpager)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.item, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.nav_UK -> {
                Toast.makeText(this, "USA selected", Toast.LENGTH_LONG).show()
                true
            }
            R.id.nav_FRANCE -> {
                Toast.makeText(this, "USA selected", Toast.LENGTH_LONG).show()
                true
            }
            R.id.nav_GERMANY -> {
                Toast.makeText(this, "USA selected", Toast.LENGTH_LONG).show()
                true
            }
            R.id.nav_RUSSIA -> {
                Toast.makeText(this, "USA selected", Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}