package com.example.switchproject

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.TextView
import com.example.switchproject.databinding.FragmentOptimismBinding


class OptimismFragment : Fragment() {

    private var _binding: FragmentOptimismBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOptimismBinding.inflate(inflater, container, false)
        val view = binding.root


        try {

            val animator = ObjectAnimator.ofFloat(binding.cardviewZenitsu, "translationX", 0f, -350f)
            animator.duration = 2000
            animator.interpolator = AccelerateDecelerateInterpolator()
            animator.start()

            val animatorSet = AnimatorSet()
            animatorSet.startDelay = 2000
            animatorSet.start()

            animatorSet.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)

                    activity?.let {
                        displayTextWordByWord(100,binding.textViewNameZenitsu, it.getString(R.string.name_of_zenitsu_txt)) {
                            Handler(Looper.getMainLooper()).postDelayed({
                                displayTextWordByWord(30,binding.textViewStoryLong, it.getString(R.string.zenitsu_story_txt))
                            }, 250)
                        }

                    }


                }
            })

        }catch (e: Exception){
            e.printStackTrace()
        }





        return view
    }

    fun displayTextWordByWord(delay: Long, textView: TextView, fullText: String, onComplete: () -> Unit = {}) {
        textView.text = ""
        val words = fullText.split(" ")
        //val delay = 40L
        var currentIndex = 0

        val handler = Handler(Looper.getMainLooper())
        handler.post(object : Runnable {
            override fun run() {
                if (currentIndex < words.size) {
                    textView.text = textView.text.toString() + " " + words[currentIndex]
                    currentIndex++
                    handler.postDelayed(this, delay)
                }else {
                    onComplete() // İlk textView'in yazımı bittiğinde ikinciye geç
                }
            }
        })

    }

}