package com.example.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button set,Clear,TextSizeP,TextSizeM,RD;
    private TextView text;
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        set=(Button)findViewById(R.id.set);
        Clear=(Button)findViewById(R.id.button2);
        TextSizeP=(Button)findViewById(R.id.button3);
        TextSizeM=(Button)findViewById(R.id.button4);
        RD=(Button)findViewById(R.id.button5);
        text=(TextView)findViewById(R.id.textView);
        input=(EditText)findViewById(R.id.editText2);
        text.setMovementMethod(new ScrollingMovementMethod());
    }

    int size=35,strF=0,colorC=0;
    String []base=new String[1];
    String ViewT="",temp="";
    StringBuffer displays=new StringBuffer();

    public void setText(View v){
        ViewT=input.getText().toString();
        base= Arrays.copyOf(base,base.length+1);
        base[strF++]=String.valueOf(ViewT);

        int [][]RGBB=new int[5][3];
        RGBB[0][0]=255;RGBB[0][1]=0;RGBB[0][2]=0;//red
        RGBB[1][0]=255;RGBB[1][1]=165;RGBB[1][2]=0;//orange
        RGBB[2][0]=255;RGBB[2][1]=255;RGBB[2][2]=0;//yellow
        RGBB[3][0]=0;RGBB[3][1]=255;RGBB[3][2]=0;//green
        RGBB[4][0]=0;RGBB[4][1]=255;RGBB[4][2]=255;//blue
        displays.insert(0,ViewT);
        temp=displays.toString();
        SpannableStringBuilder style = new SpannableStringBuilder(displays);
        int temp=0;
        for(int k=strF-1;k>=0;k--){
            style.setSpan(new ForegroundColorSpan(Color.rgb(RGBB[(colorC)%5][0],RGBB[(colorC)%5][1],RGBB[(colorC++)%5][2])),temp,base[k].length()+temp, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
            temp+=base[k].length();
        }
        text.setText(style);
        text.setTextSize(size);
    }

    public void ClearBut(View v){
        input.setText("");
    }

    public void Sizeplus(View v){
        size+=5;
        text.setTextSize(size);
    }

    public void Sizemin(View v){
        size-=5;
        text.setTextSize(size);
    }

    public void ReverseB(View v){
        int [][]RGBB=new int[5][3];
        RGBB[0][0]=255;RGBB[0][1]=0;RGBB[0][2]=0;//red
        RGBB[1][0]=255;RGBB[1][1]=165;RGBB[1][2]=0;//orange
        RGBB[2][0]=255;RGBB[2][1]=255;RGBB[2][2]=0;//yellow
        RGBB[3][0]=0;RGBB[3][1]=255;RGBB[3][2]=0;//green
        RGBB[4][0]=0;RGBB[4][1]=255;RGBB[4][2]=255;//
        StringBuffer str2=new StringBuffer();
        for(int i=0;i<strF;i++)
            str2.append(base[i]);
        displays=new StringBuffer(str2);
        SpannableStringBuilder style = new SpannableStringBuilder(displays);
        int temp=0;
        for(int k=0;k<strF;k++){
            style.setSpan(new ForegroundColorSpan(Color.rgb(RGBB[(colorC)%5][0],RGBB[(colorC)%5][1],RGBB[(colorC++)%5][2])),temp,base[k].length()+temp, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
            temp+=base[k].length();
        }
        text.setText(style);
        text.setTextSize(size);
    }
}