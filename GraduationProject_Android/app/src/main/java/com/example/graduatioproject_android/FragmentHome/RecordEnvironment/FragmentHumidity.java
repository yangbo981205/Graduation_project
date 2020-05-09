package com.example.graduatioproject_android.FragmentHome.RecordEnvironment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.graduatioproject_android.R;
import com.example.graduatioproject_android.tools.JSONTOOL;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;

import static com.example.graduatioproject_android.tools.GlobalVariable.SERVERIP;
import static com.example.graduatioproject_android.tools.GlobalVariable.environmentMap;

public class FragmentHumidity extends Fragment {

    private ListView HumidityListView=null;
    private LineChart humidityLineChart=null;
    List<DataSet> humidityList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_humidity, null);

        HumidityListView=(ListView)view.findViewById(R.id.humidity_ListView);
        humidityLineChart=(LineChart)view.findViewById(R.id.humidityLineChart);


        Timer timer=new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                getData();
                initLineChart();
            }
        }, 0,10000);

        return  view;
    }

    /**
     * 从服务器获取数据
     * */
    private void getData(){
        OkHttpUtils.post()
                .url("http://"+SERVERIP+":8080/graduationproject/android/environment")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        Toast.makeText(getActivity(), "服务器错误，请检查网络连接！", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(Call call, String s) {
                        List<HashMap<String,String>> getMap= JSONTOOL.analyze_some_json("["+s+"]");
                        List<HashMap<String,String>> map = JSONTOOL.analyze_some_json(getMap.get(0).get("result"));
                        humidityList.clear();
                        for(int i=0;i<map.size();i++){
                            DataSet dataSet=new DataSet(String.valueOf(i+1),map.get(i).get("time"),map.get(i).get("humidity"));
                            humidityList.add(dataSet);
                        }
                        AdapterHumidity adapterHumidity=new AdapterHumidity(humidityList,getContext());
                        HumidityListView.setAdapter(adapterHumidity);
                    }
                });
    }

    /**
     * 初始化图表数据
     */
    private void initLineChart(){
        //temperatureLineChart.animateXY(200, 200); // 呈现动画
        Description description = new Description();
        description.setText("时间"); //自定义描述
        humidityLineChart.setDescription(description);
        Legend legend = humidityLineChart.getLegend();
        legend.setTextColor(Color.WHITE);
        setYAxis();
        setXAxis();
        setData();
    }

    /**
     * 设置Y轴数据
     */
    private void setYAxis(){
        YAxis yAxisLeft = humidityLineChart.getAxisLeft();// 左边Y轴
        yAxisLeft.setDrawAxisLine(true); // 绘制Y轴
        yAxisLeft.setDrawLabels(true); // 绘制标签
        yAxisLeft.setAxisMaxValue(100); // 设置Y轴最大值
        yAxisLeft.setAxisMinValue(0); // 设置Y轴最小值
        yAxisLeft.setGranularity(3f); // 设置间隔尺寸
        yAxisLeft.setTextColor(Color.BLACK); //设置颜色
        yAxisLeft.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return (int)value  + "%";
            }
        });
        // 右侧Y轴
        humidityLineChart.getAxisRight().setEnabled(false); // 不启用
    }


    /**
     * 设置X轴数据
     */
    private void setXAxis(){
        // X轴
        XAxis xAxis = humidityLineChart.getXAxis();
        xAxis.setDrawAxisLine(false); // 不绘制X轴
        xAxis.setDrawGridLines(false); // 不绘制网格线
        // 模拟X轴标签数据

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Date nowDate = new Date();

        final String[] times = new String[]{simpleDateFormat.format(nowDate), XDate(nowDate).get(0), XDate(nowDate).get(1),  XDate(nowDate).get(2),  XDate(nowDate).get(3),  XDate(nowDate).get(4)};
        xAxis.setLabelCount(times.length); // 设置标签数量
        xAxis.setTextColor(Color.GREEN); // 文本颜色
        xAxis.setTextSize(10f); // 文本大小为18dp
        xAxis.setGranularity(1f); // 设置间隔尺寸
        // 使图表左右留出点空位
        xAxis.setAxisMinimum(-0.1f); // 设置X轴最小值
        //设置颜色
        xAxis.setTextColor(Color.BLACK);
        // 设置标签的显示格式
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return times[(int) value];
            }
        });
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); // 在底部显示
    }

    /**
     * 填充数据
     */
    private void setData(){
        // 数据
        final List<Entry> humidity = new ArrayList<>();
        final List<Float> humidityData = new ArrayList<>();
        OkHttpUtils.post()
                .url("http://"+SERVERIP+":8080/graduationproject/android/environment")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        Toast.makeText(getActivity(), "服务器错误，请检查网络连接！", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onResponse(Call call, String s) {
                        List<HashMap<String,String>> getMap= JSONTOOL.analyze_some_json("["+s+"]");
                        List<HashMap<String,String>> map = JSONTOOL.analyze_some_json(getMap.get(0).get("result"));
                        for(int i=0;i<6;i++){
                            humidityData.add(Float.valueOf(map.get(i).get("humidity")));
                        }
                        for (int i=0;i<humidityData.size(); i++) {
                            humidity.add(new Entry(i, humidityData.get(i)));
                        }
                        // 2. 分别通过每一组Entry对象集合的数据创建折线数据集
                        LineDataSet lineDataSet1 = new LineDataSet(humidity, "实时湿度数据");
                        lineDataSet1.setCircleRadius(5); //设置点圆的半径
                        lineDataSet1.setDrawCircleHole(false); // 不绘制圆洞，即为实心圆点
                        // 值的字体大小为12dp
                        lineDataSet1.setValueTextSize(12f);
                        //将每一组折线数据集添加到折线数据中
                        LineData lineData = new LineData(lineDataSet1);
                        //设置颜色
                        lineData.setValueTextColor(Color.BLACK);
                        //将折线数据设置给图表
                        humidityLineChart.setData(lineData);

                    }
                });
    }


    /**
     * X轴时间计算
     * */
    private List<String> XDate(Date date){
        List<String> list=new ArrayList<>();
        Date returnDate;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        for(int i=0;i<5;i++){
            calendar.add(Calendar.SECOND,-10);
            returnDate=calendar.getTime();
            calendar.setTime(returnDate);
            list.add(simpleDateFormat.format(returnDate));
        }
        return list;
    }

}
