package com.example.lab3hw

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_RPS.setOnClickListener{
            if(ed_InputTextName.length()<1){
                tv_Hint.text = "請輸入玩家姓名";
            }
            else{
                tv_NameView.setText(String.format("名字\n%s",ed_InputTextName.text.toString()));
                if(btn_scissors.isChecked){
                    tv_Myturn.setText("我方出拳\n剪刀");
                }
                else if(btn_rock.isChecked) {
                    tv_Myturn.setText("我方出拳\n石頭");
                }
                else {
                    tv_Myturn.setText("我方出拳\n布");
                }

                val computer:Int = (Math.random()*3).toInt();
                if(computer == 0){
                    tv_COMturn.setText("電腦出拳\n剪刀");
                }
                else if(computer == 1) {
                    tv_COMturn.setText("電腦出拳\n石頭");
                }
                else {
                    tv_COMturn.setText("電腦出拳\n布");
                }

                if((btn_scissors.isChecked && computer == 2) ||
                    (btn_rock.isChecked()&& computer == 0) ||
                    (btn_paper.isChecked() && computer ==1)){
                    tv_Winner.setText("勝利者\n" + ed_InputTextName.getText().toString());
                    tv_Hint.setText("恭喜你獲勝了");
                }
                else if((btn_scissors.isChecked && computer == 1) ||
                    (btn_rock.isChecked()&& computer == 2) ||
                    (btn_paper.isChecked() && computer ==0)){
                    tv_Winner.setText("勝利者\n電腦");
                    tv_Hint.setText("可惜，電腦獲勝了!");
                }
                else {
                    tv_Winner.text = "勝利者\n平手";
                    tv_Hint.text = "平局，請再試一次";
                }
            }
        }
    }

}