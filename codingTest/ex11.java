// 성적이 낮은 순서로 학생 출력
// 정렬 기준 재정의 

import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Student> students = new ArrayList<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            students.add(new Student(name, score));
        }

        Collections.sort(students);

        for(int i = 0; i < students.size(); i++){
            bw.write(students.get(i).getName() + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

class Student implements Comparable<Student>{

    private String name;
    private int score;

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName(){
        return this.name;
    }

    public int getScore(){
        return this.score;
    }

    @Override
    public int compareTo(Student other){
        if(this.score < other.score){
            return -1;
        }
        return 1;
    }
}
