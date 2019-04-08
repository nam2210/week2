package com.example.exercise2

import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by nampham on 4/8/19.
 */

class Utils{
    companion object {
        fun generateColorIdFromIndex(index: Int) = when (index) {
            0 -> R.color.pink
            1 -> R.color.purple
            2 -> R.color.indigo
            3 -> R.color.blue
            4 -> R.color.teal
            5 -> R.color.green
            else -> R.color.purple
        }
    }
}