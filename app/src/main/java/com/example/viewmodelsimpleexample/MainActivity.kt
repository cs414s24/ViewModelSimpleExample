package com.example.viewmodelsimpleexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    var score = 0

    // Create an instance of our ViewModel
    // lateinit allows us to declare a variable first and then initialize it
    // at some point in the future during our program's execution cycle.
    lateinit var viewModel: ScoreViewModel

    lateinit var scoreTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scoreTextView = findViewById(R.id.tv_number)


        //ViewModelProvider returns an existing ViewModel if one exists, or it creates a new one if it
        // does not already exist. It will ensure that the same instance is retained across configuration
        // changes (like screen rotations) as long as the associated lifecycle owner (this) remains alive.
        //
        // Get an instance of our ViewModel using context(this)
        // and then get the score

        viewModel = ViewModelProvider(this)[ScoreViewModel::class.java]
        scoreTextView.text = viewModel.score.toString()

    }

    fun addOneButton(view: View) {
        //score++
        //tv_number.text = score.toString()

        // call the increaseScore function to increase the score in viewmodel
        viewModel.increaseScore()
        // display the updated score
        scoreTextView.text = viewModel.score.toString()
    }

    fun resetButton(view: View) {
        //score = 0
        //tv_number.text = score.toString()

        // call the resetScore function to reset the score in viewmodel
        viewModel.resetScore()
        // display the score
        scoreTextView.text = viewModel.score.toString()
    }
}