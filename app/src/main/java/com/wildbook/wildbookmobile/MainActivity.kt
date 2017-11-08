package com.wildbook.wildbookmobile

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*
import java.io.ByteArrayOutputStream
import java.io.FileInputStream

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


    }

    /*
        Detects valid file endings for images. Currently checks for .jpg and .png
    */
    private fun isImage(fileName : String) : Boolean {
        val splitFilename  = fileName.split(".".toRegex())
        val fileEnding = splitFilename[1]
        if (fileEnding.equals("jpeg") || fileEnding.equals("png")) {
            return true
        }
        return false
    }
    //this gets a thumbnail image to display
    //figure out how to do exception handling here
    private fun getBitMap(path : String) : Bitmap{
        var imgThumbBitMap:Bitmap
        //might change to 50 if the items appear to big
        //make sure this matches the imageview size in image_list_layout
        val THUMBNAIL_SIZE = 64
        val fis = FileInputStream(path)
        imgThumbBitMap = BitmapFactory.decodeStream(fis)
        imgThumbBitMap = Bitmap.createScaledBitmap(imgThumbBitMap,
                THUMBNAIL_SIZE, THUMBNAIL_SIZE, false)
        val byteArOutStream = ByteArrayOutputStream()
        //add something to handle png later
        //not sure if PNG can also be used with Bitmap.CompressFormat
        imgThumbBitMap.compress(Bitmap.CompressFormat.JPEG, 100, byteArOutStream)




        return imgThumbBitMap
    }

}
