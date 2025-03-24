package testSave;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player;

        //저장된 데이터 불러오기
        player = GameLoad.loadGame();

        if (player == null) {
            //저장된 데이터가 없으면 새 플레이어 생성
            System.out.println("새 게임을 시작합니다.");
            player = new Player("플레이어1", 1000);
            player.addAnimal(new Animal("강아지", 2));
            player.addAnimal(new Animal("고양이", 1));
        } else {
            System.out.println("✅ 저장된 게임 데이터를 불러왔습니다!");
        }

        // 🔹 현재 상태 출력
        player.showInfo();

        // 🔹 게임 저장 테스트
        System.out.print("\n게임을 저장하시겠습니까? (Y/N): ");
        String input = scanner.nextLine().trim().toUpperCase();

        if (input.equals("Y")) {
            GameSave.saveGame(player);
        }

        System.out.println("게임을 종료합니다!");
        scanner.close();
    }
}

