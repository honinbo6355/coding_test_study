package programmers.solution;

// 풀이1
//public class CompressString {
//	public int solution(String s) {
//        String resultStr = s;
//
//        // 길이 1부터 시작, s/2 만큼 반복
//        for (int i=1; i<=s.length()/2; i++) {
//            int count = 0;
//            int size;
//            String repeatStr = s.substring(0, i);
//            String compressStr = "";
//            for (size = 0; size+i<=s.length(); size+=i) {
//                String substr = s.substring(size, size+i);
//                if (repeatStr.equals(substr)) { // 반복되는 문자열인 경우
//                    count++;
//                } else { // 다른 문자열인 경우
//                    if (count > 1) {
//                        compressStr += String.valueOf(count);
//                    }
//                    compressStr += repeatStr;
//                    repeatStr = substr;
//                    count = 1;
//                }
//            }
//            // 마지막 문자열 검증 작업
//            if (count > 1) {
//                compressStr += String.valueOf(count);
//            }
//            compressStr += s.substring(size-i);
//
//            if (resultStr.length() > compressStr.length()) { // 더 짧은 압축 문자열인 경우
//                resultStr = compressStr;
//            }
//        }
//        return resultStr.length();
//    }
//
//    public static void main(String[] args) {
//    		CompressString compressString = new CompressString();
//
//        System.out.println(compressString.solution("ababcdcdababcdcd"));
//    }
//}

// 풀이2
public class CompressString {
    public static void main(String[] args) {
        CompressString c = new CompressString();
        System.out.println(c.solution("aabbaccc"));
        System.out.println(c.solution("ababcdcdababcdcd"));
        System.out.println(c.solution("abcabcdede"));
        System.out.println(c.solution("abcabcabcabcdededededede"));
        System.out.println(c.solution("xababcdcdababcdcd"));
    }

    public int solution(String s) {
        int len = s.length();
        int answer = s.length();

        for (int i=len/2; i>=1; i--) {
            int count = 1;
            String checkStr = s.substring(0, i);
            StringBuffer sb = new StringBuffer();

            for (int j=i; j<=len; j+=i) {
                if (j+i > len) {
                    if (count > 1) {
                        sb.append(count);
                    }
                    sb.append(checkStr);
                    sb.append(s.substring(j));
                    break;
                }

                if (checkStr.equals(s.substring(j, j+i))) {
                    count++;
                } else {
                    if (count > 1) {
                        sb.append(count);
                    }
                    sb.append(checkStr);
                    checkStr = s.substring(j, j+i);
                    count = 1;
                }
            }
            answer = Math.min(answer, sb.toString().length());
        }

        return answer;
    }
}
