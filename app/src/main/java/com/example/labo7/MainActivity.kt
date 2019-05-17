package com.example.labo7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.labo7.ViewModels.GithubRepoViewModel
import com.example.labo7.database.GithubRepo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(GithubRepoViewModel::class.java)

        bt_add.setOnClickListener{
            val name = et_name.text.toString()
            if(name.isEmpty() && name.isNotBlank()){
                viewModel.insert(GithubRepo(name))
            }
        }

        viewModel.gettAll().observe(this, Observer {repos ->
            Log.d("LISTA","________________________________________")
            for(repo in repos){
                Log.d("LISTA",repo.name)
            }
        })
    }
}
