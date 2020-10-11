public class Main {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

        ListNode ln = new ListNode(1);
        ln.next = new ListNode(2);
        ln.next.next = new ListNode(3);

        System.out.println( rotateRight(ln,5) );

    }

//       k
// 1,2,3 0
// 3,1,2 1  <- first iter
// 2,3,1 2
// 1,2,3 3
// 3,1,2 4
// 2,1,3 5

//1- make circular LL, connect tail to head
//3,1,2,3,1,2,3, ...
//2- move tail len-k from left to right (3-5%3=1)
//1,2,3,1
//discard tail [we need to move one more to right to discard tail that we added earlier] to get head
//head = tail.next, note that tail points to 3:
//head:2,1,3,1,2,3  tail:3,1,2,3
//make tail point to null to cut out of circular LL

        public static ListNode rotateRight(ListNode head, int k) {

            if(head == null) return null;
            int listNum = 1;
            ListNode tail = head;

            //find tail and count listNum
            while(tail.next != null){
                listNum++;
                tail = tail.next;
            }
            tail.next = head;
            int newHeadIndex = listNum - k % listNum;

            for(int i = 0; i < newHeadIndex; i++){
                tail = tail.next;
            }

            head = tail.next;
            tail.next = null;

            return head;
        }

    }
    