package programmers.solution;

// 풀이1
//import java.util.*;
//
//public class OpenChatRoom {
//    public String[] solution(String[] record) {
//        Map<String, String> map = new HashMap<>();
//        map.put("Enter", "들어왔습니다.");
//        map.put("Leave", "나갔습니다.");
//
//        List<Message> messages = new ArrayList<>();
//
//        for (String str : record) {
//            String[] arr = str.split(" ");
//            if (arr.length == 3) {
//                map.put(arr[1], arr[2]);
//            }
//            if ("Change".equals(arr[0])) {
//                continue;
//            }
//            messages.add(new Message(arr[0], arr[1]));
//        }
//
//        String[] answer = new String[messages.size()];
//
//        for (int i=0; i<messages.size(); i++) {
//            answer[i] = String.format("%s님이 %s", map.get(messages.get(i).getId()), map.get(messages.get(i).getAction()));
//        }
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        OpenChatRoom openChatRoom = new OpenChatRoom();
//        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
//
//        System.out.println(openChatRoom.solution(record));
//    }
//}
//
//class Message {
//    String action;
//    String id;
//
//    Message(String action, String id) {
//        this.action = action;
//        this.id = id;
//    }
//
//    public String getAction() {
//        return action;
//    }
//
//    public String getId() {
//        return id;
//    }
//}

// 풀이2
import java.util.*;

public class OpenChatRoom {
    public static void main(String[] args) {
        OpenChatRoom o = new OpenChatRoom();
        System.out.println(Arrays.toString(o.solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"})));
    }

    public String[] solution(String[] record) {
        Map<String, String> users = new HashMap<>();
        List<String> answer = new ArrayList<>();

        for (String r : record) {
            String[] commands = r.split(" ");

            if (commands[0].equals("Enter") || commands[0].equals("Change")) {
                users.put(commands[1], commands[2]);
            }
        }

        for (String r : record) {
            String[] commands = r.split(" ");

            if (commands[0].equals("Enter")) {
                answer.add(users.get(commands[1])+"님이 들어왔습니다.");
            } else if (commands[0].equals("Leave")) {
                answer.add(users.get(commands[1])+"님이 나갔습니다.");
            }
        }

        return answer.toArray(new String[0]);
    }
}
