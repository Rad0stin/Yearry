package com.ppmgto.yearbook

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.recyclerview.widget.GridLayoutManager
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
        list.add(Person("Александра", R.drawable.azis)
        {
            openFragment("Александра", R.drawable.azis, "no number", "v_bGEN8pxkU", "Русо гладно няма")
        })
        list.add(Person("Александър Б", R.drawable.azis) {})
        list.add(Person("Александър К", R.drawable.azis) {})
        list.add(Person("Александър О", R.drawable.azis) {})
        list.add(Person("Александър Ц", R.drawable.azis) {})
        list.add(Person("Андрей", R.drawable.azis) {})
        list.add(Person("Боил", R.drawable.azis) {})
        list.add(Person("Витан", R.drawable.azis) {})
        list.add(Person("Дани", R.drawable.dani) {
            openFragment("Дани", R.drawable.dani, "0877050610", "v_bGEN8pxkU", "Kupon bez Azis e kat meso bez oriz")

        })
        list.add(Person("Евгени", R.drawable.azis) {})
        list.add(Person("Елизабета", R.drawable.azis) {})
        list.add(Person("Елия", R.drawable.azis) {})
        list.add(Person("Кристина", R.drawable.azis) {})
        list.add(Person("Мария", R.drawable.azis) {})
        list.add(Person("Мартин М", R.drawable.minev) {
            openFragment("Мартин М", R.drawable.minev, "0878100021", "v_bGEN8pxkU", "Kupon bez Djena e kat heroin bez vena")
        })
        list.add(Person("Мартин В", R.drawable.azis) {})
        list.add(Person("Ники Х", R.drawable.azis) {})
        list.add(Person("Ники Й", R.drawable.azis) {})
        list.add(Person("Петър", R.drawable.azis) {})
        list.add(Person("Преслав", R.drawable.azis) {})
        list.add(Person("Радо", R.drawable.azis) {})
        list.add(Person("Симеон", R.drawable.azis) {})
        list.add(Person("Сияна", R.drawable.azis) {})
        list.add(Person("Слави", R.drawable.azis) {})
        list.add(Person("Хана", R.drawable.azis) {})
        list.add(Person("Цвети", R.drawable.azis) {})
        adapter.submitList(list)
    }

    private fun openFragment(name: String, pic: Int, number: String, songId: String, desc: String) {
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        val bundle = Bundle()
        bundle.putString("name", name)
        bundle.putInt("pic", pic)
        bundle.putString("number", number)
        bundle.putString("songId", songId)
        bundle.putString("desc", desc)

        val fragobj = FirstFragment()
        fragobj.setArguments(bundle)

        fragmentTransaction.replace(
            R.id.nav_host_fragment_content_main,
            fragobj,
            "second fragment"
        ) //My second Fragment
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
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

    private var navController: NavController? = null

    override fun onSupportNavigateUp(): Boolean {
        navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController!!.navigateUp(appBarConfiguration)
            || super.onSupportNavigateUp()
    }
}