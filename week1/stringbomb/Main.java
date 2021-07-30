package mogakko.week1.stringbomb;
import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> result = new Stack<>();
        String str = br.readLine();
        String target = br.readLine();
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int tmp = 0;
        if(str.length() < target.length()){
            System.out.println(str);
        }else{
            for(int i = 0; i < str.length(); i++){
                result.push(str.charAt(i));
                if(str.charAt(i) == target.charAt(0)){
                    stack.push(tmp);
                    tmp = 1;
                    continue;
                }else if(!stack.isEmpty() && str.charAt(i) == target.charAt(tmp)){
                    tmp++;
                    if(tmp == target.length()){
                        for(int j = 0; j < tmp; j++){
                            result.pop();
                        }
                        tmp = stack.pop();
                    }
                    continue;
                }
                stack.clear();
                tmp = 0;
            }
            if(result.isEmpty()){
                System.out.println("FRULA");
            }else{
                for(char c : result){
                    sb.append(c);
                }
                System.out.println(sb.toString());
            }
        }
    }
}