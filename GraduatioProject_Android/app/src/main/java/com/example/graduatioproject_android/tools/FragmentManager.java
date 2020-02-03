package com.example.graduatioproject_android.tools;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.graduatioproject_android.FragmentControl.FragmentControl;
import com.example.graduatioproject_android.FragmentHome.FragmentHome;
import com.example.graduatioproject_android.FragmentMy.FragmentMy;
import com.example.graduatioproject_android.FragmentOutdoor.FragmentOutdoor;
import com.example.graduatioproject_android.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentManager extends FragmentActivity {

    private TextView homeTv=null;
    private TextView controlTv=null;
    private TextView outdoorTv=null;
    private TextView myTv=null;
    private ViewPager myViewpager=null;
    private MyListener myListener=null;
    private long mPressedTime = 0;

    private FragmentTransaction fragmentTransaction;
    private List<Fragment> fragmentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_manager);

        homeTv=(TextView) findViewById(R.id.homeTV);
        controlTv=(TextView) findViewById(R.id.controlTV);
        outdoorTv=(TextView) findViewById(R.id.outdoorTV);
        myTv=(TextView) findViewById(R.id.myTV);
        myViewpager=(ViewPager)findViewById(R.id.myViewpager);

        myListener=new MyListener();
        homeTv.setOnClickListener(myListener);
        controlTv.setOnClickListener(myListener);
        outdoorTv.setOnClickListener(myListener);
        myTv.setOnClickListener(myListener);

        // 获取片段管理器
        androidx.fragment.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentList = new ArrayList<Fragment>();
        Fragment fragment1 = new FragmentHome();
        Fragment fragment2 = new FragmentControl();
        Fragment fragment3 = new FragmentOutdoor();
        Fragment fragment4 = new FragmentMy();
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
        fragmentList.add(fragment3);
        fragmentList.add(fragment4);

        myViewpager.setAdapter(new MyFragmentPagerAdapter(fragmentManager,fragmentList));//设置适配器

        homeTv.setSelected(true);
        myViewpager.setCurrentItem(0, true);

        /**
         * Viewpager的事件监听
         * 滑动Viewpager时改变底部按钮
         * */
        myViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }
            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        homeTv.setSelected(true);
                        controlTv.setSelected(false);
                        outdoorTv.setSelected(false);
                        myTv.setSelected(false);
                        break;
                    case 1:
                        homeTv.setSelected(false);
                        controlTv.setSelected(true);
                        outdoorTv.setSelected(false);
                        myTv.setSelected(false);
                        break;
                    case 2:
                        homeTv.setSelected(false);
                        controlTv.setSelected(false);
                        outdoorTv.setSelected(true);
                        myTv.setSelected(false);
                        break;
                    case 3:
                        homeTv.setSelected(false);
                        controlTv.setSelected(false);
                        outdoorTv.setSelected(false);
                        myTv.setSelected(true);
                        break;
                    default:
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });
    }

    /**
     * 按钮事件监听
     * */
    private class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case (R.id.homeTV):
                    setSelected();
                    homeTv.setSelected(true);
                    myViewpager.setCurrentItem(0, true);
                    break;
                case(R.id.controlTV):
                    setSelected();
                    controlTv.setSelected(true);
                    myViewpager.setCurrentItem(1, true);
                    break;
                case (R.id.outdoorTV):
                    setSelected();
                    outdoorTv.setSelected(true);
                    myViewpager.setCurrentItem(2, true);
                    break;
                case(R.id.myTV):
                    setSelected();
                    myTv.setSelected(true);
                    myViewpager.setCurrentItem(3, true);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 设置适配器
     * */
    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        List<Fragment> list;
        public MyFragmentPagerAdapter(androidx.fragment.app.FragmentManager fragmentManager, List<Fragment> fragmentList) {
            super(fragmentManager);
            this.list = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }
        @Override
        public int getCount() {
            return list.size();
        }
    }

    /**
     * 重置所有TextView未选中状态
     * */
    private void setSelected(){
        homeTv.setSelected(false);
        controlTv.setSelected(false);
        outdoorTv.setSelected(false);
        myTv.setSelected(false);
    }

    /**
     * 双击退出
     * */
    @Override
    public void onBackPressed() {
        long mNowTime = System.currentTimeMillis();
        if((mNowTime - mPressedTime) > 2000){
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            mPressedTime = mNowTime;
        }
        else{
            this.finish();
            System.exit(0);
        }
    }
}
