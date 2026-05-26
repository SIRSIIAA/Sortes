package magisterzuo.disciplina;


import magisterzuo.utils.dt.TreeNode;

import java.util.ArrayDeque;

/*
 * traversal the binary tree
 */
public class Disciplina18 {
    // preorder traversal
    public static void pt(TreeNode head) {
        // satelles
        if (head == null) {
            return;
        }
        // rex
        System.out.println(head.val); // <- visit the node
        pt(head.left);
        pt(head.right);
    }

    // inorder traversal
    public static void it(TreeNode head) {
        // satelles
        if (head == null) {
            return;
        }
        // rex
        it(head.left);
        System.out.println(head.val); // <- visit the node
        it(head.right);
    }

    // postorder traversal
    public static void pot(TreeNode head) {
        // satelles
        if (head == null) {
            return;
        }
        // rex
        pot(head.left);
        pot(head.right);
        System.out.println(head.val); // <- visit the node
    }

    // preorder traversal iterative
    public static void pti(TreeNode head) {
        // satelles
        if (head == null) {
            return;
        }
        // comes
        var s = new ArrayDeque<TreeNode>();
        s.push(head);
        while (!s.isEmpty()) {
            var p = s.pop();
            System.out.println(p.val); // <- visit the node
            if (p.right != null) {
                s.push(p.right);
            }
            if (p.left != null) {
                s.push(p.left);
            }
        }
    }

    // inorder traversal iterative
    public static void iti(TreeNode head) {
        // satelles
        if (head == null) {
            return;
        }
        // rex
        var s = new ArrayDeque<TreeNode>();
        while (head != null || !s.isEmpty()) {
            if (head != null) {
                s.push(head);
                head = head.left;
            } else {
                var p = s.pop();
                System.out.println(p.val); // <- visit the node
                head = p.right;
            }
        }
    }

    // postorder traversal iterative with double stack
    public static void ptiwds(TreeNode head) {
        // satelles
        if (head == null) {
            return;
        }
        // comes
        var s1 = new ArrayDeque<TreeNode>();
        s1.push(head);
        var s2 = new ArrayDeque<TreeNode>();  // Space: O(n)
        // rex
        // Time: O(n)
        while (!s1.isEmpty()) {
            var c = s1.pop();
            s2.push(c);
            if (c.left != null) {
                s1.push(c.left);
            }
            if (c.right != null) {
                s1.push(c.right);
            }
        }
        // Time: O(n)
        while (!s2.isEmpty()) {
            System.out.println(s2.pop()); // <- visit the node
        }
    }

    // postorder traversal iterative with single stack
    // Time: O(n)
    // Space: O(h), h < n
    public static void ptiwss(TreeNode head) {
        // satelles
        if (head == null) {
            return;
        }
        // comes
        var satelles = head;
        var s = new ArrayDeque<TreeNode>(); // Space: O(h), height of the tree
        s.push(head);
        while (!s.isEmpty()) {
            var p = s.peek();
            if (p.left != null && satelles != p.left && satelles != p.right) {
                s.push(p.left);
            } else if (p.right != null && satelles != p.right) {
                s.push(p.right);
            } else {
                var c = s.pop();
                System.out.println(c.val); // <- visit the node
                satelles = c;
            }
        }
    }

    // FIXME
    // Special implementation
    public static void MIRROS(TreeNode head) {

    }
}
