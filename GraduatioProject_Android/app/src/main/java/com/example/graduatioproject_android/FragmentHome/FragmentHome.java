package com.example.graduatioproject_android.FragmentHome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.graduatioproject_android.FragmentHome.RealtimeEnvironment.FragmentRealtimeEnvironment;
import com.example.graduatioproject_android.FragmentHome.RecordEnvironment.FragmentRecordEnvironment;
import com.example.graduatioproject_android.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.graduatioproject_android.tools.GlobalVariable.ISVISIBLE;


public class FragmentHome extends Fragment {

    private LinearLayout linearLayout=null;
    private TextView RealtimeEnvironment=null;
    private TextView RecordEnvironment=null;
    private ViewPager ChildViewpager=null;
    private MyListener myListener=null;

    private FragmentTransaction fragmentTransaction;
    private List<Fragment> fragmentList_1;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);

        linearLayout=(LinearLayout) view.findViewById(R.id.layout);
        RealtimeEnvironment=(TextView) view.findViewById(R.id.RealtimeEnvironment);
        RecordEnvironment=(TextView) view.findViewById(R.id.RecordEnvironment);
        ChildViewpager=(ViewPager) view.findViewById(R.id.ChildViewpager);
        myListener=new MyListener();

        linearLayout.getBackground().setAlpha(255);
        RealtimeEnvironment.setOnClickListener(myListener);
        RecordEnvironment.setOnClickListener(myListener);

        // 获取片段管理器
        FragmentManager fragmentManager = getChildFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentList_1 = new ArrayList<Fragment>();
        Fragment fragment1 = new FragmentRealtimeEnvironment();
        Fragment fragment2 = new FragmentRecordEnvironment();
        fragmentList_1.add(fragment1);
        fragmentList_1.add(fragment2);

        ChildViewpager.setAdapter(new FragmentHome.MyFragmentPagerAdapter(fragmentManager,fragmentList_1));//设置适配器

        /**
         * Viewpager的事件监听
         * 滑动Viewpager时改变顶部按钮
         * */
        ChildViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }
            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        RealtimeEnvironment.setSelected(true);
                        RecordEnvironment.setSelected(false);
                        break;
                    case 1:
                        ISVISIBLE=true;
                        RealtimeEnvironment.setSelected(false);
                        RecordEnvironment.setSelected(true);
                        break;
                    default:
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });

        RealtimeEnvironment.setSelected(true);
        ChildViewpager.setCurrentItem(0, true);
        return  view;
    }

    /**
     * 按钮事件监听
     * */
    private class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case(R.id.RealtimeEnvironment):
                    setSelected();
                    RealtimeEnvironment.setSelected(true);
                    ChildViewpager.setCurrentItem(0, true);
                    break;
                case(R.id.RecordEnvironment):
                    setSelected();
                    ISVISIBLE=true;
                    RecordEnvironment.setSelected(true);
                    ChildViewpager.setCurrentItem(1, true);
                    break;
                default:
                    break;
            }
        }
    }


    /**
     * 重置所有TextView未选中状态
     * */
    private void setSelected(){
        RealtimeEnvironment.setSelected(false);
        RecordEnvironment.setSelected(false);
    }


    /**
     * 设置适配器
     * */
    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        List<Fragment> list;
        public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.list = list;
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
}
