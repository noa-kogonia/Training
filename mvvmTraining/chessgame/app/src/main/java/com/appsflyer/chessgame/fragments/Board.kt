package com.appsflyer.chessgame.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.GridLayout
import android.widget.ImageView
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.appsflyer.chessgame.Cell
import com.appsflyer.chessgame.databinding.FragmentBoardBinding
import com.appsflyer.chessgame.pieces.BluePiece
import com.appsflyer.chessgame.pieces.OrangePiece
import com.appsflyer.chessgame.pieces.Piece
import com.appsflyer.chessgame.viewModel.MyViewModel

class Board : Fragment(){
    private var _binding: FragmentBoardBinding? = null
    private val binding get() = _binding!!
    private val model: MyViewModel by activityViewModels()
    private val cellMatrix = Array(4) { Array<Cell?>(4){null} }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBoardBinding.inflate(inflater, container, false)
        val view = binding.root
        val gridLayout = binding.gridLayout
        gridLayout.rowCount = 4
        gridLayout.columnCount = 4
        colorBoard(gridLayout)
        startGameBoardInit(cellMatrix)
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Other code to setup the activity...

        // Create the observer which updates the UI.
        val boardObserver = Observer<Array<Array<Piece>>> {startBoard ->
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
//        model.currentName.observe(this, nameObserver)
    }

    private fun colorBoard(gridLayout:GridLayout){
        for (i in 0..3) {
            for (j in 0..3) {
                val square = FrameLayout(this.requireContext()).apply {
                    if(i % 2 == j % 2){
                        setBackgroundColor(Color.WHITE)
                    }
                    else {
                        setBackgroundColor(Color.BLACK)
                    }
                }
                val param = GridLayout.LayoutParams(
                    GridLayout.spec(
                        GridLayout.UNDEFINED, GridLayout.FILL, 1f
                    ),
                    GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f)
                )
                square.layoutParams = param
                gridLayout.addView(square)
                cellMatrix[i][j] = Cell(square)
            }
        }
    }

    private fun startGameBoardInit(cellMat:Array<Array<Cell?>>){
        for (i in 0..3) {
            for (j in 0..3) {
                if(i == 0){
                    cellMat[i][j]!!.piece = OrangePiece()
                }
                if(i == 3){
                    cellMat[i][j]!!.piece = BluePiece()
                }
                cellMat[i][j]!!.piece?.let {
                    val cellFrame = cellMat[i][j]!!.frame
                    val imageView =ImageView(this.requireContext())
                    imageView.setImageResource(it.resourceID)
                    cellFrame.addView(imageView)
                }
            }
        }
    }


}