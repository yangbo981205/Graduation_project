package com.example.graduatioproject_android.tools;

public class Global_variable {
    public static String USERNAME=null;
    public static String THEME_PICTURE=null;
    public static String THEME_SETALPHA=null;
    public static String THEME_FONT_COLOR=null;


    /**
     * 更换主题颜色对于字体颜色
     * **/
    void setTheme(String theme){
        if(theme == null){
            THEME_FONT_COLOR = "#FFFFFF";
        }
    }

}
