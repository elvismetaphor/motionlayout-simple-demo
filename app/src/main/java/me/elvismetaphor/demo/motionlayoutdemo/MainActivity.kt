package me.elvismetaphor.demo.motionlayoutdemo

import android.os.Bundle
import android.support.constraint.motion.MotionLayout
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.ceil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            motion_container.transitionToEnd()
        }

        motion_container.setTransitionListener(
                object: MotionLayout.TransitionListener {
                    override fun onTransitionChange(motionLayout: MotionLayout?,
                                                    startId: Int,
                                                    endId: Int,
                                                    progress: Float) {
                        seekbar.progress = ceil(progress * 100.0).toInt()
                    }

                    override fun onTransitionCompleted(layout: MotionLayout?, id: Int) {}
                }
        )
    }
}
