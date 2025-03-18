package ui;
/*
게임 오프닝!
로딩바(옆에 0%~100% 표시 . 소수점 2번째 자리까지!)

 */
public class Starting {
    public static void main(String[] args) {
        System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃GAME START▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
        System.out.println(
                "           _         _  _      \n" +
                        "           | |_  ___ | || | ___ \n" +
                        "           | . |/ ._>| || |/ . \\\n" +
                        "           |_|_|\\___.|_||_|\\___/"
        );
        System.out.println("로딩 중 ...");
        showProgressBar();
        System.out.println("\n \n게임 시작!");
    }

    private static void showProgressBar(){
        int total = 48;

        for (int i=0; i<=total; i++){
            double percent = (i*100.0)/total;
            String formattedPercent = String.format("%.2f",percent);
            String progressBar = ProgressBar(i, total);
            System.out.print("\r"+progressBar+" "+formattedPercent+"%");

            try{
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private static void clearLoadingText(){
        String blank = " ".repeat(50);
        System.out.println("\r"+blank+"\r");
    }

    private static String ProgressBar(int current, int total){
        return "[" + "▃".repeat(current) + " ".repeat(total-current) + "]";
    }

}
