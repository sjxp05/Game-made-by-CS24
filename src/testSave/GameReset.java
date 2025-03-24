package testSave;

import java.io.File;
import java.util.Scanner;

public class GameReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("게임 데이터를 초기화하시겠습니까? (Y/N): ");
        String input = scanner.nextLine().trim().toUpperCase();

        if (input.equals("Y")) {
            deleteSaveFile();
        } else {
            System.out.println("초기화 취소됨.");
        }

        scanner.close();
    }

    public static void deleteSaveFile() {
        File saveFile = new File("game.sav");

        if (saveFile.exists()) {
            if (saveFile.delete()) {
                System.out.println("✅ 저장된 게임 데이터가 삭제되었습니다.");
            } else {
                System.out.println("⚠ 파일 삭제 실패!");
            }
        } else {
            System.out.println("⚠ 삭제할 저장 데이터가 없습니다.");
        }
    }
}

