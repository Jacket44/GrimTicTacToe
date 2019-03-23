package com.example.grimtictactoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.Validators.not
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_game.*
import kotlin.random.Random.Default.nextBoolean


class GameActivity : AppCompatActivity() {

    var points1 = 0
    var points2 = 0
    var board = arrayOfNulls<Boolean>(25)
    var playerturn = true // true = player 1 turn  false = player 2 turn

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        whoGoesFirst()

    }

    fun onClick(view: View){

        if (playerturn){
            findViewById<Button>(view.id).text = "X"
            val number = resources.getResourceName(view.id).takeLast(2).toInt()

            setArray(number, playerturn)
            if(checkWin(playerturn) == true){
                points1++
                textView.text = "Player 1 : $points1"
            }
            textView.text = "Player 1 : ${checkWin(playerturn)}"
            playerturn = false

        }
        else {
            findViewById<Button>(view.id).text = "O"
            val number = resources.getResourceName(view.id).takeLast(2).toInt()

            setArray(number, playerturn)
            if(checkWin(playerturn) == false){
                points2++
                textView2.text = "Player 2 : $points2"
            }
            textView2.text = "Player 2 : ${checkWin(playerturn)}"
            playerturn = true

        }


    }

    private fun setArray(id: Int, value: Boolean){
        when(id){
            in  0..4  -> board[id]    = value
            in 10..14 -> board[id-5]  = value
            in 20..24 -> board[id-10] = value
            in 30..34 -> board[id-15] = value
            in 40..44 -> board[id-20] = value
        }
    }

    private fun checkWin(player : Boolean): Boolean {
        /*
        if (board[0] == board[6] == board[12] == board[18] == board[24] == player) {
            return player
        }
        if (board[4] == board[8] == board[12] == board[16] == board[20] == player) {
            return player
        }

        if (board[0] == board[1] == board[2] == board[3] == board[4] == player) {
            return player
        }
        if (board[5] == board[6] == board[7] == board[8] == board[9] == player) {
            return player
        }
        if (board[10] == board[11] == board[12] == board[13] == board[14] == player) {
            return player
        }
        if (board[15] == board[16] == board[17] == board[18] == board[19] == player) {
            return player
        }
        if (board[20] == board[21] == board[22] == board[23] == board[24] == player) {
            return player
        }

        if (board[0] == board[5] == board[10] == board[15] == board[20] == player) {
            return player
        }
        if (board[1] == board[6] == board[11] == board[16] == board[21] == player) {
            return player
        }
        if (board[2] == board[7] == board[12] == board[17] == board[22] == player) {
            return player
        }
        if (board[3] == board[8] == board[13] == board[18] == board[23] == player) {
            return player
        }
        if (board[4] == board[9] == board[14] == board[19] == board[24] == player) {
            return player
        }
      */
        return player.not()
    }
    private fun whoGoesFirst(){
        playerturn = nextBoolean()
    }





}
