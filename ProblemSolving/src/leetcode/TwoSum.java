package leetcode;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;

                int sum = nums[i] + nums[j];
                if (sum == target) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(intToString(twoSum(new int[]{2, 7, 11, 5}, 9)));
        System.out.println(intToString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(intToString(twoSum(new int[]{3, 3}, 6)));
    }

    public static String intToString(int[] num) {
        String s = "[";
        int i;
        for (i = 0; i < num.length - 1; i++) {
            s += num[i] + ",";
        }
        s += num[i] + "]";
        return s;
    }

}
