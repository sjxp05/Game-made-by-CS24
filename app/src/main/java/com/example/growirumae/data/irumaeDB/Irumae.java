package com.example.growirumae.data.irumaeDB;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.*;

/*
1 이루매 1 테이블 ..
그 테이블의 구조(entity)와 게터세터를 만들어놓은 클래스
 */
@Entity(tableName = "irumae_table")
public class Irumae {
    @PrimaryKey(autoGenerate = true)
    private int id; // 자동부여 기본키
    @NonNull
    private String rumaeName, playerName; //루매이름, 플레이어이름은 null 불가
    private Major major; //Major.enum 에 가능학과 지정(무결성보장)
    private int intelligence = 0;
    private int energy = 0;
    private int stress = 0;

    public Irumae(@NonNull String rumaeName, @NonNull String playerName) {
        this.rumaeName = rumaeName;
        this.playerName = playerName;
        this.intelligence = 10;
        this.energy = 100;
        this.stress = 0;
    }

    // (Level) Getter & Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getRumaeName() {
        return rumaeName;
    }

    public void setRumaeName(@NonNull String rumaeName) {
        this.rumaeName = rumaeName;
    }

    @NonNull
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(@NonNull String playerName) {
        this.playerName = playerName;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getStress() {
        return stress;
    }

    public void setStress(int stress) {
        this.stress = stress;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Irumae)) {
            return false;
        }

        Irumae compare = (Irumae) obj;

        if (this.id != compare.getId()) {
            return false;
        } else if (!this.rumaeName.equals(compare.getPlayerName())) {
            return false;
        } else if (!this.playerName.equals(compare.getPlayerName())) {
            return false;
        } else if (!Converters.fromEnum(this.major).equals(Converters.fromEnum(compare.getMajor()))) {
            return false;
        } else if (this.intelligence != compare.getIntelligence()) {
            return false;
        } else if (this.energy != compare.getEnergy()) {
            return false;
        } else if (this.stress != compare.getStress()) {
            return false;
        } else {
            return true;
        }
    }
}
