package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// 프로그래머스 불량 사용자 문제
class Users {
    private Set<Set<String>> resultSet;
    public int solution(String[] user_id, String[] banned_id) {
        resultSet = new HashSet<>();
        dfs(user_id, banned_id, new ArrayList<>());
        return resultSet.size();
    }

    public void dfs(String[] user_id, String[] banned_id, ArrayList<String> banner_list) {
        if (banner_list.size() == banned_id.length) {
            if(isPossibleBannedUsers(banner_list, banned_id)) {
                resultSet.add(new HashSet<>(banner_list));
            }
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if(!banner_list.contains(user_id[i])) {
                banner_list.add(user_id[i]);
                dfs(user_id, banned_id, banner_list);
                banner_list.remove(user_id[i]);
            }
        }
    }

    public boolean isPossibleBannedUsers(ArrayList<String> banner_list, String[] banner_id) {
        for(int i = 0; i < banner_list.size(); i++) {
            if(!isCorrectStringPattern(banner_list.get(i), banner_id[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean isCorrectStringPattern(String user_id, String pattern) {
        if (user_id.length() != pattern.length()) return false;

        for (int i = 0; i < user_id.length(); i++) {
            if(pattern.charAt(i) == '*') continue;

            if (user_id.charAt(i) != pattern.charAt(i)) return false;
        }
        return true;
    }
}