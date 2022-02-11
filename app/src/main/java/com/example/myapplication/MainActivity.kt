package com.example.myapplication


import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val progressDrawable: Drawable =
            binding.progressBar.getProgressDrawable().mutate()
        progressDrawable.setColorFilter(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.Green
            ), PorterDuff.Mode.SRC_IN
        )
        binding.progressBar.progressDrawable = progressDrawable

        val maxProgress = 100 * 100
        binding.progressBar.max = maxProgress
        val progressAnimator = ObjectAnimator.ofInt(binding.progressBar, "progress", maxProgress, 0)

        progressAnimator.addUpdateListener { valueAnimator ->
            if (valueAnimator.currentPlayTime in 4000..6999) {
                val progressDrawable: Drawable =
                    binding.progressBar.getProgressDrawable().mutate().also {
                        it.setColorFilter(
                            ContextCompat.getColor(
                                this@MainActivity,
                                R.color.Orange
                            ), PorterDuff.Mode.SRC_IN
                        )
                    }
                binding.progressBar.progressDrawable = progressDrawable
            }

            if (valueAnimator.currentPlayTime > 7000) {
                val progressDrawable: Drawable =
                    binding.progressBar.progressDrawable.mutate().also {
                        it.setColorFilter(
                            ContextCompat.getColor(
                                this@MainActivity,
                                R.color.Red
                            ), PorterDuff.Mode.SRC_IN
                        )
                    }
                binding.progressBar.progressDrawable = progressDrawable
            }
        }
        progressAnimator.duration = 10000
        progressAnimator.interpolator = LinearInterpolator()


        binding.button.setOnClickListener {
            progressAnimator.start()
        }
    }

}