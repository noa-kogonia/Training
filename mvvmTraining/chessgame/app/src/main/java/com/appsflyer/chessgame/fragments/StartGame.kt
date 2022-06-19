package com.appsflyer.chessgame.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.appsflyer.chessgame.databinding.FragmentStartGameBinding
import com.appsflyer.chessgame.interfaces.OnStartNewGameClick

class StartGame(val onStartNewGameClick:OnStartNewGameClick) : Fragment() {
    private var _binding: FragmentStartGameBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartGameBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.startGameBtn.setOnClickListener {onStartNewGameClick.onStartNewGameClick()}
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}