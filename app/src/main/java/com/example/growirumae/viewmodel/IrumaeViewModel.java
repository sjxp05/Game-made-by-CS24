package com.example.growirumae.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.growirumae.data.irumaeDB.Irumae;
import com.example.growirumae.data.IrumaeRepository;

import java.util.List;

public class IrumaeViewModel extends AndroidViewModel {
    private final IrumaeRepository repository;
    private final List<Irumae> allData; // UI에서 관찰할 수 있는 데이터

    // ViewModel이 만들어질 때 Repository를 초기화함
    public IrumaeViewModel(@NonNull Application application) {
        super(application);
        repository = new IrumaeRepository(application); // repository 객체생성
        allData = repository.getAll(); // repository에서 전체 데이터를 받아옴
    }

    // MainActivity 에서 전체 데이터를 읽을 수 있도록 반환
    public List<Irumae> getAll() {
        return allData;
    }

    // ViewModel을 통해 새로운 데이터 삽입 요청
    public void insert(Irumae data) {
        repository.insert(data); // Repository에 위임
    }

    // ViewModel을 통해 데이터 삭제 요청
    public void delete(Irumae data) {
        repository.delete(data);
    }

    // ViewModel을 통해 데이터 수정 요청
    public void update(Irumae data) {
        repository.update(data);
    }

    //특정 id의 정보 불러오기 요청
    public LiveData<Irumae> getByID(int id) {
        return repository.getByID(id);
    }

    // 필요시 메소드 추가 예정
}
