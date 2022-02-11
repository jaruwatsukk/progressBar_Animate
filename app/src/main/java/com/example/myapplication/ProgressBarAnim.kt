package com.example.myapplication

import android.content.Context
import android.graphics.PorterDuff
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.ProgressBar
import androidx.core.content.ContextCompat

class ProgressBarAnim(
    private val context: Context,
    private val progressBar: ProgressBar,
    private val from: Float,
    private val to: Float
) :
    Animation() {
    override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
        super.applyTransformation(interpolatedTime, t)
        val value = from + (to - from) * interpolatedTime
//        when {
//            (value > 60) -> {
//                progressBar.indeterminateDrawable.setColorFilter(
//                    ContextCompat.getColor(
//                        context,
//                        R.color.Green
//                    ),
//                    PorterDuff.Mode.MULTIPLY
//                );
//            }
//            (value < 60 && value > 30) -> {
//                progressBar.indeterminateDrawable.setColorFilter(
//                    ContextCompat.getColor(
//                        context,
//                        R.color.Orange
//                    ),
//                    PorterDuff.Mode.MULTIPLY
//                );
//            }
//            (value < 30) -> {
//                progressBar.indeterminateDrawable.setColorFilter(
//                    ContextCompat.getColor(
//                        context,
//                        R.color.Red
//                    ),
//                    PorterDuff.Mode.MULTIPLY
//                );
//            }
//
//        }
        progressBar.progress = value.toInt()
    }
}