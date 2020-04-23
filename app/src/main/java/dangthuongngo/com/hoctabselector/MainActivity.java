package dangthuongngo.com.hoctabselector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TabHost tabHost;
    EditText edtUser,edtPass;
    Button btnLogin, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    addControl();
    addEvent();

    }

    private void addEvent() {
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if(tabId.equals("t1"))
                {
                    Toast.makeText(MainActivity.this,"Bạn chọn tab đăng nhập",Toast.LENGTH_LONG).show();
                }
                else if(tabId.equals("t2"))
                {
                    Toast.makeText(MainActivity.this,"Bạn chọn tab hướng dẫn",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLiDangNhap();
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void xuLiDangNhap() {
        Toast.makeText(MainActivity.this,"user="+edtUser.getText().toString()
        +";password"+edtPass.getText().toString()
        ,Toast.LENGTH_LONG).show();
    }

    private void addControl() {
        tabHost =  findViewById(R.id.tabhost);
        tabHost.setup();

        //tạo đối thượng cho tab, có id là t1
        TabHost.TabSpec tab1=tabHost.newTabSpec("t1");
        //thiết lập nội dung layout
        tab1.setContent(R.id.tab1);
        //thiết lập tiêu đề cho tab
        tab1.setIndicator("Đăng Nhập");
        //
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2=tabHost.newTabSpec("t2");
        tab2.setContent(R.id.tab1);
        tab2.setIndicator("HƯớng Dẫn");
        tabHost.addTab(tab2);

        edtUser=findViewById(R.id.edtUser);
        edtPass=findViewById(R.id.edtPass);
        btnLogin=findViewById(R.id.btnLogin);
        btnExit=findViewById(R.id.btnExit);
    }

}
