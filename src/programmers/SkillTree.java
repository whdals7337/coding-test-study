package programmers;

// 프로그래머스 스킬트리 문제
class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skillTree : skill_trees) {
            int learningIdx = 0;
            boolean isAble = true;
            for (char curSkill : skillTree.toCharArray()) {
                int skillIdx = skill.indexOf(curSkill);
                if (skillIdx == -1){
                    continue;
                }

                if (skillIdx != learningIdx) {
                    isAble = false;
                    break;
                }

                learningIdx++;
            }
            if (isAble)
                answer++;
        }
        return answer;
    }
}