package com.babic.filip.kotlinandroidtalks.ui.edit

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import com.babic.filip.kotlinandroidtalks.common.constants.KEY_NOTE
import com.babic.filip.kotlinandroidtalks.data_objects.KotlinNote

/**
 * Created by Filip Babic @cobe
 */
class EditNoteActivity : AppCompatActivity() {

    companion object {

        fun launchIntent(from: Context, note: KotlinNote): Intent {
            val intent = Intent(from, EditNoteActivity::class.java)
            intent.putExtra(KEY_NOTE, note)

            return intent
        }
    }
}