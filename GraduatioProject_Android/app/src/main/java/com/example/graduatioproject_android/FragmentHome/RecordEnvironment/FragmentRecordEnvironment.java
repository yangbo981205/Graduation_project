package com.example.graduatioproject_android.FragmentHome.RecordEnvironment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import com.example.graduatioproject_android.R;
import com.example.graduatioproject_android.tools.NoScrollViewpager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.graduatioproject_android.tools.GlobalVariable.ISVISIBLE;


public class FragmentRecordEnvironment extends Fragment {

    private TextView Visible=null;
    private TextView Temperature=null;
    private TextView Humidity=null;
    private TextView Smog=null;
    private NoScrollViewpager RecordViewpager=null;

    private boolean isCreated=false;


    private MyListener myListener=null;

    private FragmentTransaction fragmentTransaction;
    private List<Fragment> fragmentList_1;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_record_environment, null);

        Visible=(TextView) view.findViewById(R.id.Visible);
        Temperature=(TextView) view.findViewById(R.id.Temperature);
        Humidity=(TextView) view.findViewById(R.id.Humidity);
        Smog=(TextView) view.findViewById(R.id.Smog);
        RecordViewpager=(NoScrollViewpager) view.findViewById(R.id.RecordViewpager);
        RecordViewpager.setNoScroll(false);

        ISVISIBLE=true;
        inVisible();
        myListener=new MyListener();
        Visible.setOnClickListener(myListener);
        Temperature.setOnClickListener(myListener);
        Humidity.setOnClickListener(myListener);
        Smog.setOnClickListener(myListener);

        // 获取片段管理器
        FragmentManager fragmentManager = getChildFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentList_1 = new ArrayList<Fragment>();
        Fragment fragment1 = new FragmentTemperature();
        Fragment fragment2 = new FragmentHumidity();
        Fragment fragment3 = new FragmentSmog();
        fragmentList_1.add(fragment1);
        fragmentList_1.add(fragment2);
        fragmentList_1.add(fragment3);

        RecordViewpager.setAdapter(new FragmentRecordEnvironment.MyFragmentPagerAdapter(fragmentManager,fragmentList_1));

        /**
         * Viewpager的事件监听
         * 滑动Viewpager时改变底部按钮
         * */
        RecordViewpager.setOnPageChangeListener(new NoScrollViewpager.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }
            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        Temperature.setSelected(true);
                        Humidity.setSelected(false);
                        Smog.setSelected(false);
                        break;
                    case 1:
                        Temperature.setSelected(false);
                        Humidity.setSelected(true);
                        Smog.setSelected(false);
                        break;
                    case 2:
                        Temperature.setSelected(false);
                        Humidity.setSelected(false);
                        Smog.setSelected(true);
                        break;
                    default:
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });


        Temperature.setSelected(true);
        RecordViewpager.setCurrentItem(0, true);
        return  view;
    }

//    /**
//     * 刷新fragment
//     * */
//    @Override
//    public void onHiddenChanged(boolean hidden) {
//        if (hidden){
//            isVisibled();//进行刷新操作
//        }
//        super.onHiddenChanged(hidden);
//    }

    /**
     * 按钮事件监听
     * */
    private class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case(R.id.Visible):
                    if(ISVISIBLE==true){
                        ISVISIBLE=false;
                        Visible.setSelected(true);
                    }else{
                        ISVISIBLE=true;
                        Visible.setSelected(false);
                    }
                    isVisibled();
                    break;
                case(R.id.Temperature):
                    setSelected();
                    Temperature.setSelected(true);
                    RecordViewpager.setCurrentItem(0, true);
                    break;
                case(R.id.Humidity):
                    setSelected();
                    Humidity.setSelected(true);
                    RecordViewpager.setCurrentItem(1, true);
                    break;
                case(R.id.Smog):
                    setSelected();
                    Smog.setSelected(true);
                    RecordViewpager.setCurrentItem(2, true);
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
        Temperature.setSelected(false);
        Humidity.setSelected(false);
        Smog.setSelected(false);
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

    /**
     * 按钮显示、隐藏
     * */
    private void isVisibled(){
        if(ISVISIBLE==false){
            Smog.setVisibility(View.VISIBLE);
            Humidity.setVisibility(View.VISIBLE);
            Temperature.setVisibility(View.VISIBLE);
        }else{
            Temperature.setVisibility(View.INVISIBLE);
            Humidity.setVisibility(View.INVISIBLE);
            Smog.setVisibility(View.INVISIBLE);
        }
    }

    /**
     * 按钮隐藏
     * */
    public void inVisible(){
        Temperature.setVisibility(View.INVISIBLE);
        Humidity.setVisibility(View.INVISIBLE);
        Smog.setVisibility(View.INVISIBLE);
    }

}
