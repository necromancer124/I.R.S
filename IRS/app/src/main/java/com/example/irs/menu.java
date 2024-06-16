package com.example.irs;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class menu extends AppCompatActivity {
    private Context context = this;
    private Button p1 ;
    private Button p2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toast.makeText(context, "sponsored by raid shadow legends", Toast.LENGTH_LONG).show();

        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);

        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent big = new Intent(menu.this, Disabled.class);
                startActivity(big);
            }
        });

        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ok = new Intent(menu.this, MainActivity.class);
                startActivity(ok);
            }
        });
    }

}
