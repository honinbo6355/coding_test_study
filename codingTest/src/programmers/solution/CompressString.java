package programmers.solution;

public class CompressString {
	public int solution(String s) {
        String resultStr = s;

        // 길이 1부터 시작, s/2 만큼 반복
        for (int i=1; i<=s.length()/2; i++) {
            int count = 0;
            int size;
            String repeatStr = s.substring(0, i);
            String compressStr = "";
            for (size = 0; size+i<=s.length(); size+=i) {
                String substr = s.substring(size, size+i);
                if (repeatStr.equals(substr)) { // 반복되는 문자열인 경우
                    count++;
                } else { // 다른 문자열인 경우
                    if (count > 1) {
                        compressStr += String.valueOf(count);
                    }
                    compressStr += repeatStr;
                    repeatStr = substr;
                    count = 1;
                }
            }
            // 마지막 문자열 검증 작업
            if (count > 1) {
                compressStr += String.valueOf(count);
            }
            compressStr += s.substring(size-i);

            if (resultStr.length() > compressStr.length()) { // 더 짧은 압축 문자열인 경우
                resultStr = compressStr;
            }
        }
        return resultStr.length();
    }

    public static void main(String[] args) {
    		CompressString compressString = new CompressString();

        System.out.println(compressString.solution("ababcdcdababcdcd"));
    }
}
