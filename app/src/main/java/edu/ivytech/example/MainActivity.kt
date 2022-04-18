package edu.ivytech.example

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import java.util.*

private const val extraKey = "EXTRA_KEY"
class MainActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context : Context, id : UUID) : Intent {
            val intent = Intent(context,MainActivity::class.java) //an intent for myself
            intent.putExtra(extraKey, id)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val id = intent.getSerializableExtra(extraKey) as UUID
        if(id != null) {
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
            val navController = navHostFragment.navController
            val bundle = Bundle()
            bundle.putSerializable("item_key", id)
            navController.navigate(R.id.detailFragment, bundle)
        }
    }
}