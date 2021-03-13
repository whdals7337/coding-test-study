package programmers;

import java.util.ArrayList;

// 프로그래머스 - 모의고사 문제
class Exam {

    static ArrayList<Integer> list = new ArrayList<>();
    static int[] arr1 = {1,2,3,4,5};
    static int[] arr2 = {2,1,2,3,2,4,2,5};
    static int[] arr3 = {3,3,1,1,2,2,4,4,5,5};
    static int[] scores = new int[2];

    public int[] solution(int[] answers) {
        scores[0] = getScore(arr1, answers);
        scores[1] = getScore(arr2, answers);
        scores[2] = getScore(arr3, answers);

        int max = maxScore(scores);

        settingBestStudent(max);

        return convertIntegerListToIntArr(list);
    }

    static int getScore(int[] check, int[] answers) {
        int score = 0;
        int length = check.length;
        for(int i = 0; i < answers.length; i++) {
            score += SameAnswerCount(answers[i], check[i % length]);
        }
        return score;
    }

    static int SameAnswerCount(int a, int b) {
        if(a == b) {
            return 1;
        }
        return 0;
    }

    static void settingBestStudent(int max) {
        int index = 1;
        for (int score : scores) {
            addScore(score, max, index);
            index++;
        }
    }

    static void addScore(int max, int score, int index) {
        if(score == max) {
            list.add(index);
        }
    }

    static int maxScore(int[] scores) {
        int max = 0;
        for(int score : scores) {
            max = Math.max(max, score);
        }
        return max;
    }

    static int[] convertIntegerListToIntArr(ArrayList<Integer> list) {
        int idx = 0;
        int[] bests = new int[list.size()];
        for (Integer integer : list) {
            bests[idx] = integer;
            idx++;
        }
        return bests;
    }
}