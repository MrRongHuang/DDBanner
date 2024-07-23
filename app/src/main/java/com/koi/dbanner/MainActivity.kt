package com.koi.dbanner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.koi.dbanner.adapter.ImageAdapter
import com.koi.dbanner.bean.DataBean
import com.youth.banner.Banner
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.util.LogUtils

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 二次修改提交22
        val banner = findViewById<Banner<*, ImageAdapter>>(R.id.banner)
        val data = DataBean.testData2
        //自定义的图片适配器，也可以使用默认的BannerImageAdapter
        val adapter = ImageAdapter(data)
        banner.setAdapter(adapter) //              .setCurrentItem(0,false)
            //添加生命周期观察者
            .addBannerLifecycleObserver(this) //设置指示器
            .setIndicator(CircleIndicator(this))
            .setOnBannerListener { data: Any, position: Int ->
                Snackbar.make(banner, (data as DataBean).title.toString(), Snackbar.LENGTH_SHORT)
                    .show()
                LogUtils.d("position：$position")
            }
    }
}