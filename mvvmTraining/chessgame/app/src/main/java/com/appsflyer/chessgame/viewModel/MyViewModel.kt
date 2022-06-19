package com.appsflyer.chessgame.viewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.appsflyer.chessgame.pieces.BluePiece
import com.appsflyer.chessgame.pieces.OrangePiece
import com.appsflyer.chessgame.pieces.Piece

class MyViewModel : ViewModel() {
    private val players: MutableLiveData<Array<Array<Piece?>>> by lazy {
        MutableLiveData<Array<Array<Piece?>>>().also {
            loadPlayers()
        }
    }

    fun getPlayers(): LiveData<Array<Array<Piece?>>>{
        return players
    }

    private fun loadPlayers() {
        val boardInit = Array(4) { Array<Piece?>(4) { null } }
        for (i in 0..3) {
            for (j in 0..3) {
                if(i == 0){
                    boardInit[i][j] = BluePiece()
                }
                if(i == 3){
                    boardInit[i][j] = OrangePiece()
                }
            }
        }
        players.postValue(boardInit)
    }
}