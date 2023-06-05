package ru.alexkubrick.neco_lesson_26_recyclerview_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.alexkubrick.neco_lesson_26_recyclerview_2.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    private var indexImage = 0
    private var imageId = R.drawable.disney1
    private val imageIdList = listOf(
        R.drawable.disney1,
        R.drawable.disney2,
        R.drawable.disney3,
        R.drawable.disney4,
        R.drawable.disney5
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()
    }

    private fun initButtons() = with(binding) {
        bNext. setOnClickListener {
            indexImage++
            if(indexImage > imageIdList.size - 1) indexImage = 0
            imageId = imageIdList[indexImage]
            imageView.setImageResource(imageId)
        }
        bDone.setOnClickListener {
            val princess = Princess(imageId, edTitle.text.toString(), edDisc.text.toString())
            val editIntent = Intent().apply {
                putExtra("princess", princess)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }
}