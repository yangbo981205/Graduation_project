package com.graduationproject.controller;


import com.graduationproject.biz.EnvironmentBiz;
import com.graduationproject.biz.NodeBiz;
import com.graduationproject.biz.implement.EnvironmentBizImplement;
import com.graduationproject.entity.Environment;
import com.graduationproject.entity.Node;
import jdk.nashorn.internal.parser.JSONParser;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HardwareController {

    private static String result = null;
    private static Environment environment;

    /**
     * main方法中获取数据
     * */
    public static void main(String[] args) {
        String url = "http://192.168.87.130/cgi-bin/node.cgi";
        while(true){
            try {
                URL oracle = new URL(url);
                URLConnection urlConnection = oracle.openConnection();//或HttpURLConnection connect = (HttpURLConnection) connection.openConnection();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                while((result = bufferedReader.readLine()) != null){
                    AnalysisResult(result);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
            } catch (IOException e) {
                e.printStackTrace();
            }

            /**
             * 循环获取数据，8秒
             * */
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 解析result中获取到的数据,并存入数据库
     * */
    private static void AnalysisResult(String str){
        environment=new Environment();

        /**
         * 解析获取到的数据，并set到对象
         * */
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        environment.setTime(simpleDateFormat.format(new Date()));

        JSONArray jsonArray=JSONArray.fromObject(str);
        System.out.println(jsonArray);

        for(int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject= JSONObject.fromObject(jsonArray.get(i));

            if(jsonObject.get("macAddr").equals("DCE15305004B1200")){
                System.out.println("DCE15305004B1200是协调器");
            }
            if(jsonObject.get("macAddr").equals("1DE25305004B1200")){
                System.out.println("1DE25305004B1200是人体红外传感器");
                JSONArray infraredJsonArray=JSONArray.fromObject(jsonObject.get("funcList"));
                JSONObject infraredJsonObject=JSONObject.fromObject(infraredJsonArray.get(0));
                System.out.println(infraredJsonObject.get("data"));
            }
            if(jsonObject.get("macAddr").equals("DBDD5305004B1200")){
                System.out.println("DBDD5305004B1200是燃气传感器");
                JSONArray gasJsonArray=JSONArray.fromObject(jsonObject.get("funcList"));
                JSONObject gasJsonObject=JSONObject.fromObject(gasJsonArray.get(0));
                environment.setSmokescope(String.valueOf(gasJsonObject.get("data")));
            }
            if(jsonObject.get("macAddr").equals("56DD5305004B1200")){
                System.out.println("56DD5305004B1200是温湿度传感器");
                JSONArray environmentJsonArray=JSONArray.fromObject(jsonObject.get("funcList"));
                JSONObject temperatureJsonObject=JSONObject.fromObject(environmentJsonArray.get(0));
                JSONObject humidityJsonObject=JSONObject.fromObject(environmentJsonArray.get(1));
                environment.setTemperature(String.valueOf(temperatureJsonObject.get("data")));
                environment.setHumidity(String.valueOf(humidityJsonObject.get("data")));
            }
            if(jsonObject.get("macAddr").equals("AD625305004B1200")){
                System.out.println("AD625305004B1200是控制器");
            }
        }


        /**
         * 存数据库,独立于dao层
         * */
        System.out.println(environment.getTime());
        System.out.println(environment.getTemperature());
        System.out.println(environment.getHumidity());
        System.out.println(environment.getSmokescope());
        JDBCConnect(environment);

    }


    /**
     * 加载数据库驱动
     * */
    private static void JDBCConnect(Environment environment){
        String DBurl = "jdbc:mysql://127.0.0.1:3306/graduation_project?&useSSL=false&serverTimezone=UTC";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection(DBurl, "root", "050014");
            if (!connection.isClosed()) {
                System.out.println("数据库连接成功");
                String sql = "INSERT into environment values(?,?,?,?)";
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setString(1, environment.getTime());
                pst.setString(2, environment.getTemperature());
                pst.setString(3, environment.getHumidity());
                pst.setString(4, environment.getSmokescope());

                int result = pst.executeUpdate();
                //添加信息结果处理
                if(result == 1){
                    System.out.println("数据库添加信息成功");
                }else {
                    System.out.println("数据库添加信息不成功哦！！");
                }
                //关闭
                pst.close();
            }
            connection.close();
        }catch (ClassNotFoundException cne){
            cne.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }



    /**
     * 硬件控制方法
     * */
    public String SendControl(String control){
        String url = "http://192.168.87.130/cgi-bin/send_node.cgi/?type=11&id=3&data=0";
        String respond=null;

        try{
            URL oracle = new URL(url+control);
            URLConnection urlConnection = oracle.openConnection();//或HttpURLConnection connect = (HttpURLConnection) connection.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            while((respond = bufferedReader.readLine()) != null){
                respond = bufferedReader.readLine();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }

        return respond;
    }


}
