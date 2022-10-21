package com.zuanuniverse.webdemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import androidx.annotation.NonNull;

import com.gsls.gt.GT;
import com.tencent.smtt.sdk.QbSdk;

public class MyWeb extends GT.GT_WebView.AnnotationWebView{

    public MyWeb(@NonNull Activity context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override
    public void loadProgress(int progress) {
        super.loadProgress(progress);
        GT.logt("progress:" + progress);
        if (progress == 100) {
            GT.logt("url:" + url);

        }

    }

    @Override
    protected void initView(Context context, WebView webView) {
        super.initView(context, webView);
        setCache(false);
        GT.logt("初始化:" + jsToAndroidName);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        GT.logt("Web已被销毁");//drawChild
    }


    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        boolean ret = super.drawChild(canvas, child, drawingTime);
        canvas.save();
        Paint paint = new Paint();
        paint.setColor(0x7fff0000);
        paint.setTextSize(24.f);
        paint.setAntiAlias(true);
        canvas.drawText(this.getContext().getPackageName() + "-pid:"
                + android.os.Process.myPid(), 10, 50, paint);
        canvas.drawText("Sys Core", 10, 100, paint);
        canvas.drawText(Build.MANUFACTURER, 10, 150, paint);
        canvas.drawText(Build.MODEL, 10, 200, paint);
        canvas.restore();
        return ret;
    }
}
