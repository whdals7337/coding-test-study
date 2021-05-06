package programmers;

import java.util.HashMap;
import java.util.Map;

// 프로그래머스 호텔 방 배정 문제
class HotelRoomArrange {
    static Map<Long, Long> map = new HashMap<>();
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) {
            answer[i] = getEmptyRoom(room_number[i]);
        }
        return answer;
    }

    public long getEmptyRoom(long wantRoomNumber) {
        // 배정된 적 없는 경우
        if(!map.containsKey(wantRoomNumber)) {
            map.put(wantRoomNumber, wantRoomNumber + 1);
            return wantRoomNumber;
        }

        // 배정된 적 있는 경우
        long emptyRoom = getEmptyRoom(map.get(wantRoomNumber));
        map.put(wantRoomNumber, emptyRoom + 1);
        return emptyRoom;
    }
}