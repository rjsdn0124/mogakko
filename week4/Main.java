import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        long[][] count = new long[length][10];
        long sum = 0;
        for(int i = 0; i < length; i++){
            for(int j = 0; j < 10; j++){
                if(i == 0){
                    count[i][j] = 1;
                }else{
                    if(j == 0){
                        count[i][j] = count[i - 1][1] % 1000000000;
                        continue;
                    }
                    if(j == 9){
                        count[i][j] = count[i - 1][8] % 1000000000;
                        continue;
                    }
                    count[i][j] = (count[i - 1][j - 1] + count[i - 1][j + 1]) % 1000000000;
                }
            }
        }
        for(int i = 1; i < 10; i++){
            sum += count[length - 1][i];
        }
        System.out.println(sum % 1000000000);
    }
}
