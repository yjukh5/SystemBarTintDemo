package teffy.demo.systembartint;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.readystatesoftware.systembartint.SystemBarTintManager;

public class BaseActivity extends AppCompatActivity {


    protected int getStatusBarColor() {
        return R.color.colorAccent;
    }

    private SystemBarTintManager tintManager;

    /**
     * 设置状态栏背景状态
     */

    protected void setStatusBar(boolean fullscreen, int color) {

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().setStatusBarColor(getResources().getColor(color));
//            return;
//        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

//            setTranslucentStatus(true);//需要的话开启这个设置

            if (tintManager == null) {
                tintManager = new SystemBarTintManager(this);
                tintManager.setStatusBarTintEnabled(true);
            }
            tintManager.setStatusBarTintResource(color);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBar(true, getStatusBarColor());
    }



    /**
     * //android:fitsSystemWindows="true"
     * 为了不在各个rootview中添加这个属性，用代码动态控制
     */

    private void setRootViewFitSystemWindows(){
        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this
                .findViewById(android.R.id.content)).getChildAt(0);
        viewGroup.setFitsSystemWindows(true);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        setRootViewFitSystemWindows();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        setRootViewFitSystemWindows();
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        setRootViewFitSystemWindows();
    }
}
