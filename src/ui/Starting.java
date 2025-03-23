package ui;
/*
게임 오프닝!
로딩바(옆에 0%~100% 표시 . 소수점 2번째 자리까지!)

+0319 edit : 로고 출력 시 한 줄 씩 출력(시간지연 추가)
 */
public class Starting {
    public static void main(String[] args) {
        String[] logo =
                {"              _         _  _      ",
                "             | |_  ___ | || | ___ ",
                "             | . |/ ._>| || |/ . \\",
                "             |_|_|\\___.|_||_|\\___/"};
        System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃GAME START▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");

        for (int i=0; i<4; i++){
            System.out.println(logo[i]);

            delay(500);
        }

        System.out.println("Loading ...");
        showProgressBar();
        System.out.println("\n로딩 완료!");
    }

    private static void showProgressBar(){
        int total = 48;

        for (int i=0; i<=total; i++){
            double percent = (i*100.0)/total;
            String formattedPercent = String.format("%.2f",percent);
            String progressBar = ProgressBar(i, total);
            System.out.print("\r"+progressBar+" "+formattedPercent+"%");

            delay(100);
        }
    }

    private static String ProgressBar(int current, int total){
        return "▃".repeat(current) + " ".repeat(total-current);
    }

    private static void delay(int ms){
        try{
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
