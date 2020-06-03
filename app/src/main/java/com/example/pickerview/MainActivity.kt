package com.example.pickerview

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bigkoo.pickerview.builder.OptionsPickerBuilder
import com.bigkoo.pickerview.listener.OnOptionsSelectListener
import com.hjq.toast.ToastUtils
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val country = mutableListOf("台灣")

    val city = mutableListOf(mutableListOf("台北", "台中", "高雄"))


    val taipei = mutableListOf("文山", "信義", "松山")
    val taichung = mutableListOf("西屯", "南屯", "北屯")
    val kaohsiung = mutableListOf("新興", "前鎮", "楠梓")
    val region = mutableListOf(mutableListOf(taipei, taichung, kaohsiung))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        click()


    }

    fun init() {

        /*wv_location.adapter = arrayWheelAdapter
        wv_location.setOnItemSelectedListener(OnItemSelectedListener {
            Toast.makeText(this,city[it],Toast.LENGTH_SHORT).show()
        })*/

        ToastUtils.init(this.application)
        ToastUtils.setView(R.layout.item_toast)
    }


    fun click() {
        bt_pickerview.setOnClickListener(View.OnClickListener {
            val pvOptions =
                OptionsPickerBuilder(this@MainActivity,
                    OnOptionsSelectListener { option1, option2, options3, v -> //返回的分别是三个级别的选中位置

                        val tx: String =
                            country[option1] + "/" + city[option1][option2] + "/" + region[option1][option2][options3]

                        ToastUtils.show(tx)
                        // Toast.makeText(this,tx,Toast.LENGTH_SHORT).show()
                    }).build<String>()

            pvOptions.setPicker(country, city, region)
            pvOptions.show()
        })
    }

}

