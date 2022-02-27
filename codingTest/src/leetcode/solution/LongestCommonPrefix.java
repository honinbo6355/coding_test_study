package leetcode.solution;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        String answer = "";

        for (int i=0; i<strs[0].length(); i++) {
            String subStr = strs[0].substring(0, i+1);

            for (int j=1; j<strs.length; j++) {
                if (strs[j].length() < i+1) {
                    return answer;
                }

                String compareSubStr = strs[j].substring(0, i+1);

                if (!subStr.equals(compareSubStr)) {
                    return answer;
                }
            }
            answer = subStr;
        }

        return answer;
    }

    // leetcode 솔루션 중 하나인 수평 스캐닝 방식.
//    public String longestCommonPrefix(String[] strs) {
//        if (strs.length == 0) return "";
//        String prefix = strs[0];
//        for (int i=1; i<strs.length; i++) {
//            while (strs[i].indexOf(prefix) != 0) {
//                prefix = prefix.substring(0, prefix.length()-1);
//                if (prefix.isEmpty()) return "";
//            }
//        }
//        return prefix;
//    }

    public static void main(String[] args) {
    		LongestCommonPrefix lcp = new LongestCommonPrefix();

        System.out.println(lcp.longestCommonPrefix(new String[] {"flower","flow","flight"}));
    }
}
