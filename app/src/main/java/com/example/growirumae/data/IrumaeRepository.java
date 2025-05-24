package com.example.growirumae.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.growirumae.data.irumaeDB.DBIrumae;
import com.example.growirumae.data.irumaeDB.DaoIrumae;
import com.example.growirumae.data.irumaeDB.Irumae;

import java.util.List;

public class IrumaeRepository {
    private final DaoIrumae daoIrumae;
    private final List<Irumae> allData;

    // db 인스턴스 가져오기, dao 초기화
    public IrumaeRepository(Application application) {
        DBIrumae db = DBIrumae.getInstance(application);
        daoIrumae = db.daoIrumae();
        allData = daoIrumae.getAll();
    }

    // ViewModel이 전체 데이터를 가져갈 수 있도록 제공
    public List<Irumae> getAll() {
        return allData;
    }

    //삽입,수정,삭제 (백그라운드 스레드)
    public void insert(Irumae irumae) {
        DBIrumae.databaseWriteExecutor.execute(() -> daoIrumae.insert(irumae));
    }

    public void delete(Irumae irumae) {
        DBIrumae.databaseWriteExecutor.execute(() -> daoIrumae.delete(irumae));
    }

    public void update(Irumae irumae) {
        DBIrumae.databaseWriteExecutor.execute(() -> daoIrumae.update(irumae));
    }

    //특정 아이디의 모든 데이터 가져오기
    public LiveData<Irumae> getByID(int id) {
        return daoIrumae.getById(id);
    }
    // 필요시 메소드 추가.
}