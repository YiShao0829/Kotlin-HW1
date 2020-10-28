package com.example.hw3

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var ed_name:EditText
    lateinit var tv_text: TextView
    lateinit var tv_name:TextView
    lateinit var tv_winner:TextView
    lateinit var tv_mmora:TextView
    lateinit var tv_cmora:TextView
    lateinit var btn_scissor: RadioButton
    lateinit var btn_stone:RadioButton
    lateinit var btn_paper:RadioButton
    lateinit var btn_mora: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //連結xml的元件
        ed_name = findViewById(R.id.ed_name)
        tv_text = findViewById(R.id.tv_text)
        tv_name = findViewById(R.id.tv_name)
        tv_winner = findViewById(R.id.tv_winner)
        tv_mmora = findViewById(R.id.tv_mmora)
        tv_cmora = findViewById(R.id.tv_cmora)
        btn_scissor = findViewById(R.id.btn_scissor)
        btn_stone = findViewById(R.id.btn_stone)
        btn_paper = findViewById(R.id.btn_paper)
        btn_mora = findViewById(R.id.btn_mora)
        btn_mora.setOnClickListener{
            if (ed_name.length() < 1)
                tv_text.setText("請輸入玩家姓名")
            else {
                //顯示玩家姓名與我方出拳
                tv_name.setText(String.format("名字\n%s", ed_name.getText().toString()))
                if (btn_scissor.isChecked())
                    tv_mmora.setText("我方出拳\n剪刀")
                else if (btn_stone.isChecked())
                    tv_mmora.setText("我方出拳\n石頭")
                else
                    tv_mmora.setText("我方出拳\n布")
                //Ramdom()產生介於0~1間不含1的亂數，乘3產生0~2當作電腦的出拳
                val computer = (Math.random() * 3).toInt()
                if (computer == 0)
                    tv_cmora.setText("電腦出拳\n剪刀")
                else if (computer == 1)
                    tv_cmora.setText("電腦出拳\n石頭")
                else
                    tv_cmora.setText("電腦出拳\n布")
                //用三個判斷式判斷並顯示猜拳結果
                if (btn_scissor.isChecked() && computer == 2 || btn_stone.isChecked() && computer == 0 || btn_paper.isChecked() && computer == 1)
                {
                    tv_winner.setText("勝利者\n" +ed_name.getText().toString())
                    tv_text.setText("恭喜你獲勝了！！！")
                }
                else if (btn_scissor.isChecked() && computer == 1 || btn_stone.isChecked() && computer == 2 || btn_paper.isChecked() && computer == 0)
                {
                    tv_winner.setText("勝利者\n電腦")
                    tv_text.setText("可惜，電腦獲勝了！")
                }
                else {
                    tv_winner.setText("勝利者\n平手")
                    tv_text.setText("平局，請再試一次！")
                }
            }
        }
    }
}
