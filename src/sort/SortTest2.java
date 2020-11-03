package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//국영수 문제
class Student implements Comparable<Student>{
    private String name;
    private int guk ,eng, math;

    public Student (String name, int guk, int eng, int math){
        this.name = name;
        this.guk = guk;
        this.eng = eng;
        this.math = math;
    }

    public String getName() {
        return name;
    }

    public int compareTo(Student other){
        // 점수가 모두 같을 경우 이름 오름차순
        if(this.guk == other.guk && this.eng == other.eng && this.math == other.math){
            return this.name.compareTo(other.name);
        }

        // 국어와 영어 점수가 같을경우 수학 점수 내림차순
        if(this.guk == other.guk && this.eng == other.eng){
            return Integer.compare(other.math, this.math);
        }

        // 국어 점수가 같을 경우 영어점수 오름차순
        if(this.guk == other.guk){
            return Integer.compare(this.eng, other.eng);
        }

        // 국어 점수 내림 차순
        return Integer.compare(other.guk, this.guk);
    }
}

// 국영수 문제
public class SortTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Student> list = new ArrayList<>();

        for(int i =0; i < n; i++){
            String name = sc.next();
            int guk = sc.nextInt();
            int eng = sc.nextInt();
            int math = sc.nextInt();

            list.add(new Student(name, guk, eng, math));
        }

        Collections.sort(list);

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).getName());
        }
    }
}
