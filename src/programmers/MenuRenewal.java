package programmers;

import java.util.*;

// 프로그래머스 메뉴 리뉴얼 문제
class MenuRenewal {
    private static List<String> combination;

    public String[] solution(String[] orders, int[] course) {
        String[] answer;
        combination = new ArrayList<>();

        // 주문 순회
        for (int i = 0; i < orders.length; i++) {
            // 주문에 포함된 음식들
            char[] orders_char = orders[i].toCharArray();
            // XY, YX와 같이 두종류로 나올수있으므로 정렬해서 배제시킴
            Arrays.sort(orders_char);

            // 주문에 포함된 음식 순회
            for (int index = 0; index < orders_char.length - 1; index++) {

                // 코스로 만들고 싶은 음식 개수와 함께 DFS
                for (int j = 0; j < course.length; j++) {
                    dfs(orders_char, index, 1, course[j], String.valueOf(orders_char[index]));
                }
            }
        }

        Map<String, Integer> map = new HashMap<>();
        // 중복되지 않는 경우 1, 중복되는 경우는 +1 - 중복을 카운트하고 제거
        for (String key : combination) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // 많은 주문에 포함된 코스순으로 정렬 - 내림차순
        List<String> keySetList = new ArrayList<>(map.keySet());
        keySetList.sort((o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        List<String> ansList = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            int max_value = 0;

            // 코스 후보군 순회
            for (String key : keySetList) {
                // 코스가 최소 2주문이상에 포함되었고 만들고자하는 코스의 개수와 같은 경우
                if (map.get(key) >= 2 && key.length() == course[i]) {
                    // key 리스트가 정렬되어 있기 때문에 다음 값은 최대가 같은 수 이다.
                    // > 조건은 처음에 0과 비교하기 때문에 있는 조건
                    if (map.get(key) >= max_value) {
                        ansList.add(key);
                        max_value = map.get(key);
                    }
                }
            }
        }
        Collections.sort(ansList);
        answer = new String[ansList.size()];
        ansList.toArray(answer);

        return answer;
    }

    public static void dfs(char[] arr, int idx, int length, int course, String str) {
        // 코스에 추가한 음식의 길이와 원하는 코스의 길이가 같아진 경우
        if (length == course) {
            combination.add(str);
        }

        // 코스에 음식을 추가
        for (int i = idx + 1; i < arr.length; i++) {
            dfs(arr, i, length + 1, course, str + arr[i]);
        }
    }
}