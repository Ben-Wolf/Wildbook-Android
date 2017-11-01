package com.wildbook.wildbookmobile

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


    }

    /*
        Detects valid file endings for images. Currently checks for .jpeg and .png
    */
    private fun isImage(fileName : String) : Boolean {
        val splitFilename  = fileName.split(".".toRegex())
        val fileEnding = splitFilename[1]
        if (fileEnding == "jpeg" || fileEnding == "png") {
            return true
        }
        return false
    }

}
