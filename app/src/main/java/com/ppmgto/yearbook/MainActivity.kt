package com.ppmgto.yearbook

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ppmgto.yearbook.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private val adapter = PersonAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.peopleRv.layoutManager = GridLayoutManager(this, 2)
        binding.peopleRv.adapter = adapter
        val list = mutableListOf<Person>()
        list.add(Person("vasko", R.drawable.azis) {
            // TODO open a Fragment with the person info
        })
        list.add(Person("vasko1", R.drawable.azis) {})
        list.add(Person("vasko2", R.drawable.azis) {})
        list.add(Person("vasko3", R.drawable.azis) {})
        list.add(Person("vasko4", R.drawable.azis) {})
        list.add(Person("vasko5", R.drawable.azis) {})
        list.add(Person("vasko6", R.drawable.azis) {})
        list.add(Person("vasko7", R.drawable.azis) {})
        list.add(Person("vasko8", R.drawable.azis) {})
        list.add(Person("vasko9", R.drawable.azis) {})
        adapter.submitList(list)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
            || super.onSupportNavigateUp()
    }
}