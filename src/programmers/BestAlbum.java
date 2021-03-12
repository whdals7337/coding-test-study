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
            genre_total.put(name, genre_total.getOrDefault(name, 0) + count);

            // 장르별 노래 등록
            genre_songs.computeIfAbsent(name, s -> new ArrayList<>()).add(new Song(i, count));
        }

        // 장르별 총 재생 횟수를 내림차순으로 정렬
        List<String> keySetList = new ArrayList<>(genre_total.keySet());
        keySetList.sort((o1, o2) -> (genre_total.get(o2).compareTo(genre_total.get(o1))));

        // 정렬된 장르를 순회
        for(String key : keySetList) {
            // 해당 잘르에 속한 노래 목록
            ArrayList<Song> songs = genre_songs.get(key);
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