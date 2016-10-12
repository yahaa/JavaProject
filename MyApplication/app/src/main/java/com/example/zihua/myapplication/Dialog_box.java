package com.example.zihua.myapplication;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class Dialog_box extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_box);
        //注意注意，这里的AlertDialog对话框是依附于Activity的，同时点击其它地方和返回都会消失，必须使用一个setCancelable方法
        // 再次注意注意，AlertDialog还有一个特点就是会自动调用dismiss方法，也就是说不管怎么样，它都会自动关闭。那就比较烦人了，
        // 必须加入try里面的代码才能使其无法关闭，代码来自网上
        final AlertDialog.Builder builder = new AlertDialog.Builder(Dialog_box.this);
        View view = LayoutInflater.from(Dialog_box.this).inflate(R.layout.confirm_main,null);
        builder.setTitle("请输入验证密码").setView(view).setPositiveButton("确定", null).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        }).setCancelable(false);
        final AlertDialog alertDialog= builder.create();
        alertDialog.show();
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText confirmMessage = (EditText)findViewById(R.id.confirmMessage);
                if(confirmMessage==null || confirmMessage.getText().toString().length() == 0 ){
                    alertDialog.setTitle("密码为空，请重新输入。");
                }
                else if(confirmMessage.getText().equals("123456")){
                    alertDialog.dismiss();
                }
                else
                    alertDialog.setTitle("密码错误，请重新输入。");
            }
        });
    }
}