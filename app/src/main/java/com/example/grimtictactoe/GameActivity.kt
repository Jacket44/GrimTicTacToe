package com.example.grimtictactoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game.*
import kotlin.random.Random.Default.nextBoolean


class GameActivity : AppCompatActivity() {

    var pointsX = 0
    var pointsO = 0
    var board = arrayOfNulls<Boolean>(25)
    private var playerturn = true // true = player 1 turn  false = player 2 turn

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        whoGoesFirst()

    }

    fun onClick(view: View) {

        if (playerturn) {
            val number = resources.getResourceName(view.id).takeLast(2).toInt()
            if(board[setBoardId(number)] == null){
                findViewById<Button>(view.id).text = "X"
                board[setBoardId(number)] = playerturn
            }

            if(checkWin()){
                Toast.makeText(this, "Player one won!", Toast.LENGTH_LONG).show()
                clearBoard()
                pointsX++
                textView.text = "Player1: $pointsX"
            }

            checkDraw()
            playerturn = false


        } else {
            val number = resources.getResourceName(view.id).takeLast(2).toInt()
            if(board[setBoardId(number)] == null){
                findViewById<Button>(view.id).text = "O"
                board[setBoardId(number)] = playerturn
            }
            if(checkWin().not()){
                Toast.makeText(this, "Player two won!", Toast.LENGTH_LONG).show()
                clearBoard()
                pointsO++
                textView2.text = "Player2: $pointsO"
            }
            checkDraw()

            playerturn = true


        }


    }

    private fun setBoardId(id: Int) : Int {
        when (id) {
            in 0..4 -> return id
            in 10..14 -> return (id-5)
            in 20..24 -> return (id-10)
            in 30..34 -> return (id-15)
            in 40..44 -> return (id-20)
        }
        return -1
    }


    private fun setArray(id: Int, value: Boolean) {
        when (id) {
            in 0..4 -> board[id] = value
            in 10..14 -> board[id - 5] = value
            in 20..24 -> board[id - 10] = value
            in 30..34 -> board[id - 15] = value
            in 40..44 -> board[id - 20] = value
        }
    }

    private fun checkWin(): Boolean {
        // Ugly mess. Need to change it.
        val leftDiag = arrayOf(0, 6, 12, 18, 24)

        if (board[0] == playerturn && board[6] == playerturn && board[12] == playerturn && board[18] == playerturn && board[24] == playerturn) {
                return playerturn
        }
        if (board[4] == playerturn && board[8] == playerturn && board[12] == playerturn && board[16] == playerturn && board[20] == playerturn) {
            return playerturn
        }

        if (board[0] == playerturn && board[5] == playerturn && board[10] == playerturn && board[15] == playerturn && board[20] == playerturn) {
            return playerturn
        }
        if (board[1] == playerturn && board[6] == playerturn && board[11] == playerturn && board[16] == playerturn && board[21] == playerturn) {
            return playerturn
        }
        if (board[2] == playerturn && board[7] == playerturn && board[12] == playerturn && board[17] == playerturn && board[22] == playerturn) {
            return playerturn
        }
        if (board[3] == playerturn && board[8] == playerturn && board[13] == playerturn && board[18] == playerturn && board[23] == playerturn) {
            return playerturn
        }
        if (board[4] == playerturn && board[9] == playerturn && board[14] == playerturn && board[19] == playerturn && board[24] == playerturn) {
            return playerturn
        }

        if (board[0] == playerturn && board[1] == playerturn && board[2] == playerturn && board[3] == playerturn && board[4] == playerturn) {
            return playerturn
        }
        if (board[5] == playerturn && board[6] == playerturn && board[7] == playerturn && board[8] == playerturn && board[9] == playerturn) {
            return playerturn
        }
        if (board[10] == playerturn && board[11] == playerturn && board[12] == playerturn && board[13] == playerturn && board[14] == playerturn) {
            return playerturn
        }
        if (board[15] == playerturn && board[16] == playerturn && board[17] == playerturn && board[18] == playerturn && board[19] == playerturn) {
            return playerturn
        }
        if (board[20] == playerturn && board[21] == playerturn && board[22] == playerturn && board[23] == playerturn && board[24] == playerturn) {
            return playerturn
        }

        return playerturn.not()
    }

    fun checkDraw(): Boolean{
        for(i in 0..24){
            if(board[i] == null) {return false}
        }
        Toast.makeText(this, "Draw!", Toast.LENGTH_LONG).show()
        clearBoard()
        return true
    }

    private fun whoGoesFirst() {
        playerturn = nextBoolean()
    }

    private fun clearBoard(){
        val idList = arrayOf(
            button00.id, button01.id, button02.id, button03.id, button04.id,
            button10.id, button11.id, button12.id, button13.id, button14.id,
            button20.id, button21.id, button22.id, button23.id, button24.id,
            button30.id, button31.id, button32.id, button33.id, button34.id,
            button40.id, button41.id, button42.id, button43.id, button44.id)

        board = arrayOfNulls(25)

        for(i in idList){
            findViewById<Button>(i).text = ""
        }
    }

    fun reset(){
        pointsX = 0
        pointsO = 0
        textView.text = "Player1: $pointsX"
        textView2.text = "Player2: $pointsO"
        clearBoard()
    }


}
