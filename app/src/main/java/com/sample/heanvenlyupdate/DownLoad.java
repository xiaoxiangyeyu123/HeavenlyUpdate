package com.sample.heanvenlyupdate;


import com.heavenly.updateapk.main.HeavenlyUpadate;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;

/**
 * Created by hasee on 2017/6/18.
 */

public class DownLoad {
    private String url;

    public DownLoad(String url) {
        this.url = url;
    }

    public void xUitlsDownLoad(final HeavenlyUpadate heavenlyUpadate) {
        heavenlyUpadate.startUpdate();
        final RequestParams params = new RequestParams(url);
        params.setSaveFilePath(heavenlyUpadate.getPath());
        params.setAutoResume(true);
        params.setAutoRename(false);
        params.setCancelFast(true);

        x.http().get(params, new Callback.ProgressCallback<File>() {
            @Override
            public void onSuccess(File result) {
                heavenlyUpadate.onSuccess(result.getAbsolutePath());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                heavenlyUpadate.onError();
            }

            @Override
            public void onCancelled(CancelledException cex) {
                heavenlyUpadate.onCancelled();
            }

            @Override
            public void onFinished() {
            }

            @Override
            public void onWaiting() {
            }

            @Override
            public void onStarted() {
            }

            @Override
            public void onLoading(long total, long current, boolean isDownloading) {
                heavenlyUpadate.onLoading(total, current);
            }
        });

    }
}

