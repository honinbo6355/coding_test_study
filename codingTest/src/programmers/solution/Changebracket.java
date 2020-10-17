package programmers.solution;

public class Changebracket {
	// "균형잡힌 괄호 문자열"의 인덱스 반환
    public int balancedIndex(String p) {
    		int cnt = 0;
    		int idx = 0;
    		
    		for (int i=0; i<p.length(); i++) {
    			if (p.charAt(i) == '(') {
    				cnt++;
    			} else {
    				cnt--;
    			}
    			
    			if (cnt == 0) {
    				idx = i;
    				break;
    			}
    		}
    		return idx;
    }
    
    //	"올바른 괄호 문자열"인지 판단
    public boolean checkProper(String p) {
    		int cnt = 0;
    		
    		for (int i=0; i<p.length(); i++) {
    			if (p.charAt(i) == '(') {
    				cnt++;
    			} else {
    				cnt--;
    			}
    			
    			if (cnt < 0) {
    				return false;
    			}
    		}
    		return true;
    }
    
	public String solution(String p) {
        if ("".equals(p)) {
        		return "";
        }
        int idx = balancedIndex(p);
        String u = p.substring(0, idx+1);
        String v = p.substring(idx+1);
        
        if (checkProper(u)) {
        		return u += solution(v);
        } else {
        		String newStr = "(";
        		newStr += solution(v);
        		newStr += ")";
        		u = u.substring(1, u.length()-1);
        		
        		for (int i=0; i<u.length(); i++) {
        			if (u.charAt(i) == '(') {
        				newStr += ')';
        			} else {
        				newStr += '(';
        			}
        		}
        		return newStr;
        }
    }
	
	public static void main(String[] args) {
		Changebracket c = new Changebracket();
		String p = "()))((()";
		System.out.println(c.solution(p));
	}
}
