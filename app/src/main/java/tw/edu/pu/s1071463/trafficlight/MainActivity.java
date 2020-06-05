package tw.edu.pu.s1071463.trafficlight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //設定全螢幕顯示
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        //設定螢幕為橫式
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_main);

        Button btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et1 = findViewById(R.id.et1);
                EditText et2 = findViewById(R.id.et2);
                EditText et3 = findViewById(R.id.et3);
                String green_str = et1.getText().toString();
                String yellow_str = et2.getText().toString();
                String ren_str = et3.getText().toString();
                if(green_str.equals("") || yellow_str.equals("") || ren_str.equals("")){
                    Toast.makeText(MainActivity.this, "燈號的秒數不能為空白", Toast.LENGTH_LONG).show();
                }else if(green_str.equals("0") || yellow_str.equals("0") || ren_str.equals("0")){
                    Toast.makeText(MainActivity.this, "燈號的秒數不能為0", Toast.LENGTH_LONG).show();
                }else{
                    Intent it = new Intent();
                    it.setClass(MainActivity.this, GameActivity.class);
                    it.putExtra("greenLight", green_str);
                    it.putExtra("yellowLight", yellow_str);
                    it.putExtra("redLight", ren_str);
                    startActivity(it);
                    finish();
                }
            }
        });
    }

    public void StartGame(View v){
//        Intent it = new Intent();
//        EditText et1 = findViewById(R.id.et1);
//        EditText et2 = findViewById(R.id.et2);
//        EditText et3 = findViewById(R.id.et3);
//        String green_str = et1.getText().toString();
//        String yellow_str = et2.getText().toString();
//        String ren_str = et3.getText().toString();
//        it.setClass(this, GameActivity.class);
//        it.putExtra("greenLight", green_str);
//        it.putExtra("yellowLight", yellow_str);
//        it.putExtra("redLight", ren_str);
//        startActivity(it);
//        finish();
    }

    public void EndApp(View v){
        finish();
    }

}
