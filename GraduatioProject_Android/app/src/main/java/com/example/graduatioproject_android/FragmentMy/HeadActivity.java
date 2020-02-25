package com.example.graduatioproject_android.FragmentMy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.graduatioproject_android.R;
import com.example.graduatioproject_android.tools.FragmentManager;

public class HeadActivity extends AppCompatActivity {

    private static final int IMAGE = 1;
    private TextView exitChangeTV=null;
    private EditText changeNicknameET=null;
    private Button selectPhotoBtn=null;
    private Button affirmChangeBtn=null;
    private ImageView HeadChangeIV=null;
    private String path=null;
    private MyListener myListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);
        getWindow().setStatusBarColor(0xff4f4f4f);

        exitChangeTV=(TextView)findViewById(R.id.exitChangeTV);
        changeNicknameET=(EditText)findViewById(R.id.changeNicknameET);
        selectPhotoBtn=(Button)findViewById(R.id.selectPhotoBtn);
        affirmChangeBtn=(Button)findViewById(R.id.affirmChangeBtn);
        HeadChangeIV=(ImageView)findViewById(R.id.HeadChangeIV);
        myListener=new MyListener();

        exitChangeTV.setOnClickListener(myListener);
        selectPhotoBtn.setOnClickListener(myListener);
        affirmChangeBtn.setOnClickListener(myListener);
    }
    private class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case (R.id.exitChangeTV):
                    Intent exit_jumpIntent=new Intent(HeadActivity.this, FragmentManager.class);
                    startActivity(exit_jumpIntent);
                    finish();
                    break;
                case (R.id.selectPhotoBtn):
                    if(ContextCompat.checkSelfPermission(HeadActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(HeadActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);//运行时申请权限
                    }else {
                        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(intent, IMAGE);
                    }
                    break;
                case (R.id.affirmChangeBtn):
                    //提交服务器


                    break;
                default:
                    break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE && resultCode == Activity.RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            String [] filePathColumns = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
            c.moveToFirst();
            path = c.getString(c.getColumnIndex(MediaStore.Images.Media.DATA));
            int columnIndex = c.getColumnIndex(filePathColumns[0]);
            String imagePath = c.getString(columnIndex);
            showImage(imagePath);
            c.close();
        }
    }
    /**
     * 加载图片
     * */
    private void showImage(String imagePath){
        Bitmap bm = BitmapFactory.decodeFile(imagePath);
        HeadChangeIV.setImageBitmap(bm);
    }
}
