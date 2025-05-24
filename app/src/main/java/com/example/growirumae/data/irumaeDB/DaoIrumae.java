package com.example.growirumae.data.irumaeDB;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import java.util.*;

/*
데이터베이스에 새로운 이루매 테이블 추가/ 이루매 정보 업데이트 / 이루매 삭제 등을 관리하는 인터페이스
 */
@Dao
public interface DaoIrumae {
    @Insert
    void insert(Irumae irumae);

    @Update
    void update(Irumae irumae);

    @Delete
    void delete(Irumae irumae);

    @Query("SELECT * FROM irumae_table where id = :id LIMIT 1")
        //id 기준으로 1테이블만 검색
    LiveData<Irumae> getById(int id);

    @Query("SELECT * FROM irumae_table ORDER BY id DESC")
        //모든 테이블 id 순으로 가져오기
    List<Irumae> getAll();

}
