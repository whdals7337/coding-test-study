package programmers;

import java.util.*;

// 프로그래머스 베스트 앨범 문제
class Song implements Comparable<Song>{
    int idx;
    int count;

    public Song(int idx, int count) {
        this.idx = idx;
        this.count = count;
    }

    public int compareTo(Song other) {
        if(this.count == other.count) {
            return Integer.compare(this.idx, other.idx);
        }
        return Integer.compare(other.count, this.count);
    }
}

class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genre_total = new HashMap<>(); // 장르 , 장르별 총 재생 횟수
        HashMap<String, ArrayList<Song>> genre_songs = new HashMap<>(); // 장르, 장르에 속한 노래
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < genres.length; i++) {
            String name = genres[i]; // 장르
            int count = plays[i]; // 재생 횟수

            // 장르별 총 재생 횟수 등록
            if(genre_total.containsKey(name)) {
               genre_total.put(name, genre_total.get(name) + count);
            } else {
                genre_total.put(name, count);
            }

            // 장르별 노래 등록
            if(genre_songs.containsKey(name)) {
                genre_songs.get(name).add(new Song(i, count));
            }else {
                ArrayList<Song> arr = new ArrayList<>();
                arr.add(new Song(i, count));
                genre_songs.put(name, arr);
            }
        }

        // 장르별 총 재생 횟수를 내림차순으로 정렬
        List<Map.Entry<String, Integer>> list_total = new ArrayList<>(genre_total.entrySet());
        list_total.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        // 정렬된 장르를 순회
        for(Map.Entry<String, Integer> map : list_total) {
            // 해당 잘르에 속한 노래 목록
            ArrayList<Song> songs = genre_songs.get(map.getKey());
            // 정렬 (횟수에 따라서, 횟수가 같으면 인덱스 순)
            Collections.sort(songs);

            // 노래 목록을 순회하면서 최대 2개 까지 선택
            int index = 0;
            for (Song song : songs) {
                if(index > 1) break;
                result.add(song.idx);
                index++;
            }
        }

        // ArrayList -> int[]
        int[] answer = new int[result.size()];
        int index = 0;
        for(Integer idx : result) {
            answer[index] = idx;
            index++;
        }

        return answer;
    }
}