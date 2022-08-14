
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    
    public static Boolean isDay(int year){
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;

    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 현재 날짜 입력 받음.
        String[] current = br.readLine().split(" ");
        int currentYear = Integer.parseInt(current[0]);
        int currentMouth = Integer.parseInt(current[1]);
        int currentDay = Integer.parseInt(current[2]);

        // 마지막 날짜 입력 받음.
        String[] last = br.readLine().split(" ");
        int lastYear = Integer.parseInt(last[0]);
        int lastMonth = Integer.parseInt(last[1]);
        int lastDay = Integer.parseInt(last[2]);

        int dDay = 0;

        // 날짜가 오버 되었다면 "gg" 출력
        if(currentYear+1000 < lastYear || currentYear+1000 == lastYear && currentMouth<lastMonth
                ||currentYear+1000==lastYear && currentMouth==lastMonth && currentDay<=lastDay){
            System.out.println("gg");



            // 아니라면
        } else {

            // 반복문을 통해 D-Day 카운트
            while(true){
                currentDay++;
                dDay++;

                if(currentDay > 31 && (currentMouth == 1 || currentMouth == 3 || currentMouth == 5 || currentMouth ==7||
                        currentMouth == 8 || currentMouth == 10 || currentMouth == 12 )){
                    currentMouth++;
                    currentDay = 1;
                }else if( currentDay > 30 && (currentMouth == 4 || currentMouth == 6 || currentMouth == 9 ||
                        currentMouth == 11)){
                    currentMouth++;
                    currentDay = 1;
                }else if(currentDay > 29 &&currentMouth == 2 && isDay(currentYear)){
                    currentMouth++;
                    currentDay = 1;
                }else if(currentDay > 28 &&currentMouth == 2 && !isDay(currentYear)) {
                    currentMouth++;
                    currentDay = 1;
                }

                if (currentMouth > 12) {
                    currentYear++;
                    currentMouth = 1;
                }

                if(currentYear == lastYear && currentMouth == lastMonth && currentDay == lastDay){
                    System.out.println("D-"+dDay);
                    break;
                }


            }

        }
    }
}
