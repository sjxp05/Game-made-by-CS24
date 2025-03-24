package testSave;

import java.io.File;

public class GameDelete {
    public static void deleteSaveFile() {
        File saveFile = new File("game.sav"); // 저장된 파일 객체 생성

        if (saveFile.exists()) {  // 파일이 존재하는지 확인
            if (saveFile.delete()) {  // 🔹 파일 삭제 시도
                System.out.println("✅ 저장된 게임 데이터가 삭제되었습니다.");
            } else {
                System.out.println("⚠ 파일 삭제 실패!");
            }
        } else {
            System.out.println("⚠ 삭제할 저장 데이터가 없습니다.");
        }
    }

    public static void main(String[] args) {
        deleteSaveFile();  // 테스트 실행
    }
}

