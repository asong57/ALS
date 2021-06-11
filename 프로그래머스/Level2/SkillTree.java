import java.util.HashMap;
import java.util.HashSet;

public class SkillTree {

    //다른사람의 풀이(단순)
    public int solution2(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skillTree : skill_trees) {
            String tempSkill = skillTree;

            for (int i = 0; i < skillTree.length(); i++) {
                String s = skillTree.substring(i, i+1);
                if (!skill.contains(s)) {
                    tempSkill = tempSkill.replace(s, ""); // 필수 스킬이 아닐 경우 공백으로 치환
                }
            }

            if (skill.indexOf(tempSkill) == 0)
                answer++;
        }

        return answer;
    }

    //내 풀이 (더 복잡)
    static HashMap<Character, Integer> hm;

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        hm = new HashMap<>();
        for (int i = 0; i < skill.length(); i++) {
            hm.put(skill.charAt(i), 0);
        }

        for (int i = 0; i < skill_trees.length; i++) {
            boolean isLearned = true;
            for (int j = 0; j < skill_trees[i].length(); j++) {
                if (hm.containsKey(skill_trees[i].charAt(j))) {
                    if (!checkIsLearned(j, skill_trees[i], skill)) {
                        isLearned = false;
                        break;
                    } else {
                        hm.put(skill_trees[i].charAt(j), 1);
                    }
                }
            }
            if (isLearned) {
                answer++;
            }
            for (int k = 0; k < skill.length(); k++) {
                hm.put(skill.charAt(k), 0);
            }
        }

        return answer;
    }

    public static boolean checkIsLearned(int index, String tree, String skill) {
        int i = 0;
        while (skill.charAt(i) != tree.charAt(index)) {
            if (hm.containsKey(skill.charAt(i)) && hm.get(skill.charAt(i)) == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution(skill, skill_trees));
    }
}
