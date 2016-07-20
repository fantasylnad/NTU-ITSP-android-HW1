package com.hci.lab430.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by lab430 on 16/7/20.
 */
public class PokemonWelcomeActivity extends AppCompatActivity implements View.OnClickListener,RadioGroup.OnCheckedChangeListener {

    TextView infoText;
    EditText nameEditText;
    RadioGroup optionGroup;
    CheckBox hideCheckBox; // 可以使用這個成員變數來記住抓到的Checkbox物件
    int selectedOptionIndex = 0;

    String[] pokemonNames = new String[]{
            "小火龍",
            "傑尼龜",
            "妙蛙種子"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_welcome);

        infoText = (TextView)findViewById(R.id.info_text);
        nameEditText = (EditText)findViewById(R.id.name_editText);

        Button confirmBtn = (Button)findViewById(R.id.confirm_btn);
        confirmBtn.setOnClickListener(this);

        optionGroup = (RadioGroup)findViewById(R.id.option_radioGrp);
        optionGroup.setOnCheckedChangeListener(this);

        // 實作類似以上的步驟去找到相對應的Checkbox元件
        // 並設定listener去listen被勾取的事件（可參考Button以及OptionGroup）
        // 設定TextView的text可以參考onClick裡infoText的邏輯

    }


    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if(viewId == R.id.confirm_btn) {
            infoText.setText(String.format("你好, 訓練家%s 歡迎來到神奇寶貝的世界 你的第一個夥伴是%s", nameEditText.getText(), pokemonNames[selectedOptionIndex]));
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
        int radioGrpId = radioGroup.getId();
        if(radioGrpId == optionGroup.getId()) {
            switch(checkId) {
                case R.id.option1:
                    selectedOptionIndex = 0;
                    break;
                case R.id.option2:
                    selectedOptionIndex = 1;
                    break;
                case R.id.option3:
                    selectedOptionIndex = 2;
                    break;
            }
        }
    }

}
