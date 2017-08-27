package org.vamsu.interview.solutions.linkedlists;

import org.vamsu.interview.solutions.utils.ListNodeUtils;
import org.vamsu.interview.solutions.utils.PrintUtils;

public class AddTwoNumbersSolution {
    public static void main(String args[]) {
        AddTwoNumbersSolution twoNumbersSolution = new AddTwoNumbersSolution();
        ListNode l1 = ListNodeUtils.create(new int[]{2, 4, 3});
        ListNode l2 = ListNodeUtils.create(new int[]{5, 6, 4});
        ListNode addTwoNumResult = twoNumbersSolution.solve(l1, l2);
        PrintUtils.prettyPrint("AddTwoNumbersSolution Result", addTwoNumResult);

        l1 = ListNodeUtils.create(new int[]{1, 8});
        l2 = ListNodeUtils.create(new int[]{0});
        addTwoNumResult = twoNumbersSolution.solve(l1, l2);
        PrintUtils.prettyPrint("AddTwoNumbersSolution Result", addTwoNumResult);
    }

    public ListNode solve(ListNode l1, ListNode l2) {
        return solve(l1, l2, 0);
    }

    private ListNode solve(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            if (carry > 0) {
                return new ListNode(carry);
            }
            return null;
        }
        int sum = carry;
        if (l1 != null) {
            sum += l1.val;
        }
        if (l2 != null) {
            sum += l2.val;
        }
        int val = sum % 10;
        carry = sum / 10;
        ListNode result = new ListNode(val);
        result.next = solve(l1 != null ? l1.next : null, l2 != null ? l2.next : null, carry);
        return result;
    }
}
