package testSave;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class GameLoad {
    public static Player loadGame() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("game.sav"))) {
            return (Player) ois.readObject();  // 🔹 저장된 Player 객체 읽어오기
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("⚠ 저장된 게임 데이터가 없습니다.");
            return null;
        }
    }
}

