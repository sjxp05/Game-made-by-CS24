package com.example.growirumae;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.*;
import java.util.concurrent.Executors;

import static com.example.growirumae.data.irumaeDB.Major.*;

import com.example.cs24game.R;
import com.example.growirumae.data.irumaeDB.*;

/*

 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //room db 인스턴스 생성 & dao 객체 생성
        DBIrumae db = Room.databaseBuilder(getApplicationContext(),
                        DBIrumae.class, "irumae-db")
                .fallbackToDestructiveMigration() //데이터 버전업시 기존 데이터 삭제
                .allowMainThreadQueries() //메인 스레드에서 db 접근 허용
                .build();
        DaoIrumae daoIrumae = db.daoIrumae();


        //data 읽고 가져오기
        Executors.newSingleThreadExecutor().execute(() -> {
//            Irumae irumae1 = new Irumae("이루매1", "지히");
//            irumae1.setMajor(COMPUTER_SCIENCE);
//            daoIrumae.insert(irumae1);

            runOnUiThread(() -> {  // 💡 메인 스레드에서 실행!
                List<Irumae> irumaeList = daoIrumae.getAll();
                for (Irumae m : irumaeList) {
                    Log.d("Test", "Hi! " + m.getRumaeName() + "'s " + m.getPlayerName() + ", id: " + m.getId() + ", major:" + m.getMajor());
                }
            });
        });
    }
}