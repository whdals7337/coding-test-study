package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

interface Event {
    public String getEventMessage(Map<String, String> nickNames);
}

class Enter implements Event {
    private String id;

    public Enter(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String getEventMessage(Map<String, String> nickNames) {
        String nickname = nickNames.get(id);
        return nickname + "님이 들어왔습니다.";
    }
}

class Leave implements Event {
    String id;

    public Leave(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String getEventMessage(Map<String, String> nickNames) {
        String nickname = nickNames.get(id);
        return nickname + "님이 나갔습니다.";
    }
}

// 프로그래머스 오픈채팅방 문제
class OpenChat {
    public String[] solution(String[] record) {
        Map<String, String> nickNames = new HashMap<>();
        ArrayList<Event> events = new ArrayList<>();
        for (String s : record) {
            String[] split = s.split(" ");

            if(split[0].equals("Enter")) {
                nickNames.put(split[1], split[2]);
                Event enter = new Enter(split[1]);
                events.add(enter);
            }
            else if(split[0].equals("Leave")) {
                Event leave = new Leave(split[1]);
                events.add(leave);
            }
            else if(split[0].equals("Change")) {
                nickNames.put(split[1], split[2]);
            }
        }
        String[] answer = new String[events.size()];
        for (int i = 0; i< events.size(); i++) {
            answer[i] = events.get(i).getEventMessage(nickNames);
        }
        return answer;
    }
}