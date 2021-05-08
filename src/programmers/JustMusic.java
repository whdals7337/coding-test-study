package programmers;

// 프로그래머스 방금그곡 문제
class JustMusic {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxTime = 0;
        m = convert(m);
        for (String musicinfo : musicinfos) {
            String[] split = musicinfo.split(",");

            // 재생 시간
            int time = playTime(split[0], split[1]);

            // 재생 시간 동안 음악
            String fullMusic = FullMusicByPlayTime(convert(split[3]), time);

            // 기억하는 멜로디를 포함하고 재생 시간이 기존보다 긴 경우
            if (fullMusic.contains(m) && time > maxTime) {
                answer = split[2];
                maxTime = time;
            }
        }
        return answer;
    }

    // #이 붙은 경우 사용하지않는 다른 문자로 대체
    static String convert(String str) {
        return str.replace("C#", "c").replace("D#", "d")
                .replace("F#", "f").replace("G#", "g")
                .replace("A#", "a");
    }

    static int playTime(String startTime, String endTime) {
        String[] startTimeSplit = startTime.split(":");
        String[] endTimeSplit = endTime.split(":");
        return  (Integer.parseInt(endTimeSplit[0]) - Integer.parseInt(startTimeSplit[0])) * 60
                + (Integer.parseInt(endTimeSplit[1]) - Integer.parseInt(startTimeSplit[1]));
    }

    static String FullMusicByPlayTime(String music, int time) {
        if (music.length() >= time) {
            return music.substring(0, time);
        }

        StringBuilder temp = new StringBuilder();
        for (int i = 0; i <= time; i++) {
            temp.append(music.charAt(i % music.length()));
        }
        return temp.toString();
    }
}