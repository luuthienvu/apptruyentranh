package com.example.apptruyentranh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.apptruyentranh.database.databasedocTruyen;

public class MainDangNhap extends AppCompatActivity {


    EditText edtTaikhoan,edtMatkhau;
    Button btnDangNhap, btnDangKi;

    com.example.apptruyentranh.database.databasedocTruyen databasedocTruyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dang_nhap);
        
        AnhXa();


        databasedocTruyen = new databasedocTruyen(this);

        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDangNhap.this,MainDangKy.class);
                startActivity(intent);
            }
        });

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tentaikhoan = edtTaikhoan.getText().toString();
                String matkhau = edtMatkhau.getText().toString();

                Cursor cursor = databasedocTruyen.getData();


                while (cursor.moveToNext()){
                    String datatentaikhoan = cursor.getString(1);
                    String datamatkhau = cursor.getString(2);


                    if (datatentaikhoan.equals(tentaikhoan) && datamatkhau.equals(matkhau)){
                        int phanquyen = cursor.getInt(4);
                        int idd = cursor.getInt(0);
                        String gmail = cursor.getString(3);
                        String tentk = cursor.getString(1);


                        Intent intent = new Intent(MainDangNhap.this,MainDangKy.class);


                        intent.putExtra("phanq",phanquyen);
                        intent.putExtra("idd",idd);
                        intent.putExtra("gmail",gmail);
                        intent.putExtra("tentaikhoan",tentk);

                        startActivity(intent);
                    }
                }
                cursor.moveToFirst();
                cursor.close();

            }
        });
    }

    private void AnhXa() {
        edtMatkhau = findViewById(R.id.matkhau);
        edtTaikhoan = findViewById(R.id.taikhoan);
        btnDangKi = findViewById(R.id.dangki);
        btnDangNhap = findViewById(R.id.dangnhap);
    }

}