package com.example.graduatioproject_android.FragmentMy;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.graduatioproject_android.LoginAndRegister.LoginActivity;
import com.example.graduatioproject_android.R;

public class FragmentMy extends Fragment {

    private ImageView headIv=null;
    private TextView nicknameTv=null;
    private TextView numbernameTv=null;
    private TextView themeTv=null;
    private TextView voiceTv=null;
    private TextView informTv=null;
    private LinearLayout accountLl=null;
    private LinearLayout sosLl=null;
    private LinearLayout helpLl=null;
    private LinearLayout aboutLl=null;
    private Button exitloginBtn=null;
    private Button sectionBtn=null;
    private MyListener myListener=null;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, null);

        headIv=(ImageView) view.findViewById(R.id.headIV);
        nicknameTv=(TextView) view.findViewById(R.id.nickname);
        numbernameTv=(TextView) view.findViewById(R.id.numbername);
        themeTv=(TextView) view.findViewById(R.id.themeTV);
        voiceTv=(TextView) view.findViewById(R.id.voiceTV);
        informTv=(TextView) view.findViewById(R.id.informTV);
        sosLl=(LinearLayout) view.findViewById(R.id.sosLL);
        accountLl=(LinearLayout) view.findViewById(R.id.accountLL);
        helpLl=(LinearLayout) view.findViewById(R.id.helpLL);
        aboutLl=(LinearLayout) view.findViewById(R.id.aboutLL);
        sectionBtn=(Button) view.findViewById(R.id.sectionBtn);
        exitloginBtn=(Button) view.findViewById(R.id.exitloginBtn);
        myListener=new MyListener();

        headIv.setOnClickListener(myListener);
        themeTv.setOnClickListener(myListener);
        voiceTv.setOnClickListener(myListener);
        informTv.setOnClickListener(myListener);
        sosLl.setOnClickListener(myListener);
        accountLl.setOnClickListener(myListener);
        helpLl.setOnClickListener(myListener);
        aboutLl.setOnClickListener(myListener);
        sectionBtn.setOnClickListener(myListener);
        exitloginBtn.setOnClickListener(myListener);
        return view;
    }

    private class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case(R.id.headIV):
                    Intent head_jumpIntent=new Intent(getActivity(), HeadActivity.class);
                    startActivity(head_jumpIntent);
                    break;
                case(R.id.themeTV):
                    break;
                case(R.id.voiceTV):
                    break;
                case(R.id.informTV):
                    break;
                case(R.id.sosLL):
                    break;
                case(R.id.accountLL):
                    break;
                case(R.id.helpLL):
                    break;
                case(R.id.aboutLL):
                    break;
                case(R.id.sectionBtn):
                    break;
                case(R.id.exitloginBtn):
                    Intent exit_jumpIntent=new Intent(getActivity(), LoginActivity.class);
                    startActivity(exit_jumpIntent);
                    getActivity().finish();
                    break;
                default:
                    break;
            }
        }
    }
}