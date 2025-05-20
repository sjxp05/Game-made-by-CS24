package com.example.growirumae.data.irumaeDB;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.*;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

/*
DataBase 생성하는 클래스
<사용개념 : java 디자인패턴 - 싱글톤>
ROOM DATABASE 관련 내용 참고
 */
@Database(entities = {Irumae.class}, version = 2, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class DBIrumae extends RoomDatabase {
    private static DBIrumae instance;

    public abstract DaoIrumae daoIrumae();

    public static synchronized DBIrumae getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            DBIrumae.class, "irumae_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}