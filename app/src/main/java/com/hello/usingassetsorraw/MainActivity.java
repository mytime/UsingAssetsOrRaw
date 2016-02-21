package com.hello.usingassetsorraw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * assets 文件夹创建
 * assets 文件夹位置 工程/app/src/main/ assets ,
 * 在assets文件夹下可以可以创建目录结构
 * <p/>
 * 命令行操作assets,按住assets文件夹拖放到命令行窗口，
 * pwd 查看路径，mkdir 文件夹名  ：创建文件夹
 * <p/>
 * 访问assets内的文件方法是：getResources().getAssets().open("hello.txt")
 * <p/>
 * <p/>
 * raw 文件夹的创建
 * 右键main目录，创建android资源目录，资源类型是：raw
 * raw文件夹下不可以创建目录，只能应用目录内的资源id(R.raw.**)
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //访问assets文件夹内资源的方法

//        try {
//            outStr(getResources().getAssets().open("hello.txt"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //访问raw文件下资源方法
        outStr(getResources().openRawResource(R.raw.mytext));


    }

    private void outStr(InputStream inputStream){
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String str = "";
            while ((str = br.readLine()) != null) {

                System.out.println(str);

            }
            br.close();
            inputStream.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
