package com.example.growirumae.data.irumaeDB;

import androidx.room.TypeConverter;

/*
Major <-> String 변환기
 */
public class Converters {
    @TypeConverter
    public static Major fromString(String value) {
        return value == null ? null : Major.valueOf(value);
    }

    @TypeConverter
    public static String fromEnum(Major major) {
        return major == null ? null : major.name();
    }
}

