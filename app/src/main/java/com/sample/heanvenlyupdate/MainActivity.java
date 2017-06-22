package com.sample.heanvenlyupdate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.heavenly.updateapk.main.HeavenlyUpadate;


public class MainActivity extends AppCompatActivity {
    private final String url = "http://101.106.238.11/files/1215000001FE2AEE/imtt.dd.qq.com/16891/8C3E058EAFBFD4F1EFE0AAA815250716.apk";
    private RadioButton rb_xutils;
    private HeavenlyUpadate heavenlyUpadate;
    private DownLoad downLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initView();

    }

    private void init() {
        heavenlyUpadate = HeavenlyUpadate.getInstance()
                .init(this)
                .setDownLoadManager(false)
                .setUpadeUrl(url)
                .setFileName(System.currentTimeMillis() + ".apk")
                .setTitle("下载进度")
                .setProviderName(getApplicationInfo().packageName + ".fileProvider")
                .requestPermission(MainActivity.this, 100);
        downLoad = new DownLoad(url);
    }

    private void initView() {
        rb_xutils = (RadioButton) findViewById(R.id.rb_xutils);

    }


    public void DownLoad(View view) {
        if (rb_xutils.isChecked()) {
            downLoad.xUitlsDownLoad(heavenlyUpadate);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        heavenlyUpadate.removeUpdate();
    }
}
