import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < 60; j++){
                for(int k = 0; k < 60; k++){
                    if( check(i,j,k) ) cnt++;
                }
            }
        }

        System.out.println(cnt);
        br.close();
    }

    // 특정 시각 안에 '3'이 포함되어 있는지의 여부
    public static boolean check(int a, int b, int c){
        if(a % 10 == 3 || b / 10 == 3 || b % 10 == 3 || c / 10 == 3 || c % 10 == 3 )
            return true;
        return false;
    }
}
