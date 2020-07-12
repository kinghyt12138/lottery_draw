package com.example.lottery_draw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    //抽奖名单
    var names= listOf<String>("巫婷","肖明瑛","刘晓","吕飒飒")
    //定时器  每隔一段时间切换一次名字
    lateinit var timer:Timer
    //索引
    var index=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init(){
        //设置默认显示第一个人
        mNameTextView.text=names[index]
        //给按钮添加点击事件
        mStartButton.setOnClickListener{
            //判断标题是start还是stop
            if(mStartButton.text.toString()=="Start"){
                mStartButton.text="Stop"
                //创建定时器
                timer=Timer()
                //分配定时任务
                timer.schedule(object : TimerTask() {
                    override fun run() {
                        //判断是否越界并赋值
                        index = if (index+1>names.size-1) 0 else index+1
                        //取出对应的名字
                        mNameTextView.text=names[index]
                    }
                },0,100)
            }else{
                mStartButton.text="Start"
                //取消定时器
                timer.cancel()
            }
        }
    }
}
