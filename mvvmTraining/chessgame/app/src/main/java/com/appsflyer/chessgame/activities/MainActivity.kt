package com.appsflyer.chessgame.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.appsflyer.chessgame.R
import com.appsflyer.chessgame.databinding.FragmentStartGameBinding
import com.appsflyer.chessgame.fragments.Board
import com.appsflyer.chessgame.fragments.StartGame
import com.appsflyer.chessgame.interfaces.OnStartNewGameClick


class MainActivity : AppCompatActivity(), OnStartNewGameClick {
    private lateinit var binding: FragmentStartGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            val f = StartGame(this)
            val t: FragmentTransaction = supportFragmentManager.beginTransaction()
            t.replace(R.id.fragmentHolder, f).commit()
        }

//        val model: MyViewModel by viewModels()
//        model.getPlayers().observe(this, Observer<List<Piece>>{ users ->
//            // update UI
//        })
    }

    override fun onStartNewGameClick() {
        val f = Board()
        val t: FragmentTransaction = supportFragmentManager.beginTransaction()
        t.replace(R.id.fragmentHolder, f).commit()
    }
}