package leetcode.solution;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currentNode = new ListNode(0);
        ListNode resultNode = currentNode;

        int sum = 0;

        while (l1 != null || l2 != null) { // 두 노드 다 순회할때까지 반복
            sum = sum / 10; // 자릿값 올라가야할 경우를 위한 처리

            if (l1 != null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }

            currentNode.next = new ListNode(sum%10);
            currentNode = currentNode.next;
        }

        if (sum / 10 == 1) {
            currentNode.next = new ListNode(1);
        }

        return resultNode.next;
    }
}
