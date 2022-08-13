import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기 위한 인스턴스
        StringBuilder sb = new StringBuilder();


        int m = Integer.parseInt(br.readLine()); // 연산의 수 입력 받기
        Set<Integer> set = new HashSet<>(); // 중복 허용 X


        for (int i = 0; i < m; i++){
            String[] input = br.readLine().split(" ");


            switch (input[0]){
                case "all":
                    for (int j = 0; j < 20; j++){
                        set.add(j+1);
                    }
                    break;

                case "add":
                    set.add(Integer.parseInt(input[1]));
                    break;

                case "remove":
                    set.remove(Integer.parseInt(input[1]));
                    break;

                case "check":

                    if (set.contains(Integer.parseInt(input[1]))){
                        sb.append("1\n");
                    }else {
                        sb.append("0\n");
                    }
                    break;


                case "toggle":
                    if (set.contains(Integer.parseInt(input[1]))){
                        set.remove(Integer.parseInt(input[1]));

                    }else{
                        set.add(Integer.parseInt(input[1]));
                    }
                    break;


                case "empty":
                    set.clear();
                    break;


            }

        }
        System.out.print(sb);


    }
}
