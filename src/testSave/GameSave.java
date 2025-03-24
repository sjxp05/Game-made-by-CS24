package testSave;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GameSave {
    public static void saveGame(Player player) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("game.sav"))) { // try-with-resources 문
            oos.writeObject(player);
            System.out.println("✅ 게임 진행 상황이 저장되었습니다!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

