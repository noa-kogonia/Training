package com.appsflyer.chessgame.pieces

abstract class Piece() {
    abstract val color:String
    abstract val appears: Boolean
    abstract val resourceID: Int
}