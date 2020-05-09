package com.graduationproject.controller;


import com.graduationproject.biz.*;
import com.graduationproject.entity.Comfortable;
import com.graduationproject.entity.Environment;
import com.graduationproject.entity.UserSet;
import com.graduationproject.entity.Users;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@Controller("androidController")
@RequestMapping("/android")
public class AndroidController {

    @Autowired
    private AdminBiz adminBiz;
    @Autowired
    private ComfortableBiz comfortableBiz;
    @Autowired
    private EnvironmentBiz environmentBiz;
    @Autowired
    private InformationBiz informationBiz;
    @Autowired
    private NodeBiz nodeBiz;
    @Autowired
    private GlobalBiz globalBiz;
    @Autowired
    private OpinionBiz opinionBiz;
    @Autowired
    private UsersBiz usersBiz;
    @Autowired
    private UserSetBiz userSetBiz;

    /**
     * Android登录验证
     * */
    @RequestMapping(value="/login",produces="text/html;charset=UTF-8;")
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response){
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        //Map<String, Object> map = new HashMap<String, Object>();
        JSONObject jsonObject=new JSONObject();
        Users users = globalBiz.users_login(username, password);
        if(users!=null){
            jsonObject.put("state","1");
            jsonObject.put("result","登陆成功！");
            jsonObject.put("username",users.getUsername());
            jsonObject.put("nickname",users.getNickname());
        }else{
            jsonObject.put("state","0");
            jsonObject.put("result","用户名或密码错误！");
        }
        //JSONObject jsonObject = JSONObject.fromObject(map);
        return jsonObject.toString();
    }


    /**
     * Android注册
     * */
    @RequestMapping(value="/register",produces="text/html;charset=UTF-8;")
    @ResponseBody
    public String register(HttpServletRequest request, HttpServletResponse response){
        String nickname=request.getParameter("nickname");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String phone=request.getParameter("phone");
        String email=request.getParameter("email");

        JSONObject jsonObject=new JSONObject();
        /**
         * 检查是否重复
         * */
        Users checkUsers = usersBiz.get(username);

        if(checkUsers==null){
            Users users = new Users();
            users.setNickname(nickname);
            users.setUsername(username);
            users.setPassword(password);
            users.setPhone(phone);
            users.setEmail(email);
            usersBiz.add(users);
            jsonObject.put("state","1");
            jsonObject.put("result","注册成功！");
        }else{
            jsonObject.put("state","0");
            jsonObject.put("result","用户名重复！");
        }

        return jsonObject.toString();
    }


    /**
     * Android获取用户设置环境区间
     * */
    @RequestMapping(value="/getcomfortableenvironment",produces="text/html;charset=UTF-8;")
    @ResponseBody
    public String getcomfortableenvironment(HttpServletRequest request, HttpServletResponse response){
        String username=request.getParameter("username");
        JSONObject jsonObject=new JSONObject();

        Comfortable comfortable = comfortableBiz.get(username);
        if(comfortable==null){
            Comfortable newComfortable=new Comfortable();
            newComfortable.setUsername(username);
            newComfortable.setMax_humidity("null");
            newComfortable.setMax_temperature("null");
            newComfortable.setMin_humidity("null");
            newComfortable.setMin_temperature("null");
            newComfortable.setSmokescope("80");
            comfortableBiz.add(newComfortable);

            Comfortable firstComfortable = comfortableBiz.get(username);
            jsonObject.put("result",firstComfortable);

        }else{
            jsonObject.put("result",comfortable);
        }

        return jsonObject.toString();
    }

    /**
     * Android更改环境调节设置
     * */
    @RequestMapping(value="/saveenvironmentset",produces="text/html;charset=UTF-8;")
    @ResponseBody
    public String saveenvironmentset(HttpServletRequest request, HttpServletResponse response){
        String username=request.getParameter("username");
        String maxTem=request.getParameter("maxTem");
        String minTem=request.getParameter("minTem");
        String maxHum=request.getParameter("maxHum");
        String minHum=request.getParameter("minHum");

        JSONObject jsonObject=new JSONObject();
        Comfortable comfortable=new Comfortable();
        comfortable.setUsername(username);
        comfortable.setMin_temperature(minTem);
        comfortable.setMin_humidity(minHum);
        comfortable.setMax_humidity(maxHum);
        comfortable.setMax_temperature(maxTem);
        comfortable.setSmokescope("80");

        comfortableBiz.edit(comfortable);
        jsonObject.put("state","1");

        return jsonObject.toString();
    }

    /**
     * Android获取用户设置
     * */
    @RequestMapping(value="/getusersset",produces="text/html;charset=UTF-8;")
    @ResponseBody
    public String getusersset(HttpServletRequest request, HttpServletResponse response){
        String username=request.getParameter("username");

        JSONObject jsonObject=new JSONObject();
        UserSet userSet=userSetBiz.get(username);
        if(userSet==null){
            UserSet newUserSet=new UserSet();
            newUserSet.setUsername(username);
            newUserSet.setVoice("voice");
            newUserSet.setTheme("theme");
            userSetBiz.add(newUserSet);

            UserSet firstUserSet=userSetBiz.get(username);
            jsonObject.put("result",firstUserSet);
        }else{
            jsonObject.put("result",userSet);
        }

        return jsonObject.toString();
    }

    /**
     * 保存用户theme设置
     * */
    @RequestMapping(value="/uploadtheme",produces="text/html;charset=UTF-8;")
    @ResponseBody
    public String uploadtheme(HttpServletRequest request, HttpServletResponse response){
        String username=request.getParameter("username");
        String theme=request.getParameter("theme");

        JSONObject jsonObject=new JSONObject();
        UserSet userSet=new UserSet();
        userSet.setUsername(username);
        userSet.setTheme(theme);
        userSet.setVoice(userSetBiz.get(username).getVoice());
        userSetBiz.edit(userSet);
        jsonObject.put("state","1");
        return jsonObject.toString();
    }

    /**
     * 保存用户theme设置
     * */
    @RequestMapping(value="/uploadvoice",produces="text/html;charset=UTF-8;")
    @ResponseBody
    public String uploadvoice(HttpServletRequest request, HttpServletResponse response){
        String username=request.getParameter("username");
        String voice=request.getParameter("voice");

        JSONObject jsonObject=new JSONObject();
        UserSet userSet=new UserSet();
        userSet.setUsername(username);
        userSet.setTheme(userSetBiz.get(username).getTheme());
        userSet.setVoice(voice);
        userSetBiz.edit(userSet);
        jsonObject.put("state","1");
        return jsonObject.toString();
    }

    /**
     * Android用户获取环境信息
     * */
    @RequestMapping(value="/environment",produces="text/html;charset=UTF-8;")
    @ResponseBody
    public String environment(){
        JSONObject jsonObject=new JSONObject();
        List<Environment> list =environmentBiz.getLimit();
        jsonObject.put("result",list);
        return jsonObject.toString();
    }

    /**
     * Android用户控制执行器
     * */
    @RequestMapping(value="/control",produces="text/html;charset=UTF-8;")
    @ResponseBody
    public String control(HttpServletRequest request, HttpServletResponse response){
        HardwareController hardwareController=new HardwareController();
        String controlMessage=request.getParameter("controlMessage");
        JSONObject jsonObject=new JSONObject();
        String result;

        switch (controlMessage) {
            case "10":
                result=hardwareController.SendControl("a");
                jsonObject.put("result",result);
                break;
            case "11":
                result=hardwareController.SendControl("b");
                jsonObject.put("result",result);
                break;
            case "12":
                result=hardwareController.SendControl("c");
                jsonObject.put("result",result);
                break;
            case "13":
                result=hardwareController.SendControl("d");
                jsonObject.put("result",result);
                break;
            case "14":
                result=hardwareController.SendControl("e");
                jsonObject.put("result",result);
                break;
            case "15":
                result=hardwareController.SendControl("f");
                jsonObject.put("result",result);
                break;
            default:
                result=hardwareController.SendControl(controlMessage);
                jsonObject.put("result",result);
                break;
        }
        return jsonObject.toString();
    }

    /**
     * Android自动控制功能实现
     * */
    @RequestMapping(value="/autocontrol",produces="text/html;charset=UTF-8;")
    @ResponseBody
    public String autocontrol(HttpServletRequest request, HttpServletResponse response){
        String username=request.getParameter("username");
        Comfortable comfortable=comfortableBiz.get(username);
        List<Environment> environmentList=environmentBiz.getLimit();
        JSONArray jsonArray=JSONArray.fromObject(environmentList);
        JSONObject jsonObject=JSONObject.fromObject(jsonArray.get(0));
        HardwareController hardwareController=new HardwareController();
        int controlMessage=0;

        if(Float.valueOf(String.valueOf(jsonObject.get("temperature")))>Float.valueOf(comfortable.getMax_temperature().substring(0,comfortable.getMax_temperature().indexOf("℃")))){
            controlMessage=controlMessage+4;
        }
        if(Float.valueOf(String.valueOf(jsonObject.get("smokescope")))>Float.valueOf(comfortable.getSmokescope())){
            controlMessage=controlMessage+8;
        }

        if(controlMessage==11){
            hardwareController.SendControl("b");
        }else{
            hardwareController.SendControl(String.valueOf(controlMessage));
        }

        return jsonObject.toString();
    }



    /**
     * Android户外模式节点
     * */
    @RequestMapping(value="/outdoor",produces="text/html;charset=UTF-8;")
    @ResponseBody
    public String outdoor(){
        JSONObject jsonObject=new JSONObject();
        String url = "http://192.168.87.130/cgi-bin/node.cgi";
        String result=null;
        try {
            URL oracle = new URL(url);
            URLConnection urlConnection = oracle.openConnection();//或HttpURLConnection connect = (HttpURLConnection) connection.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            while((result = bufferedReader.readLine()) != null){
                jsonObject.put("result",result);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

}
