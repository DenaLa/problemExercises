package maxLevelSum;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {

	public static void main(String[] args) {
		
		TreeNode r = new TreeNode(0);
		
		TreeNode lr = new TreeNode(-8);
		TreeNode ll = new TreeNode(7);
		TreeNode l = new TreeNode(7,ll,lr);
		
		TreeNode root = new TreeNode(1,l,r);
		
		System.out.println(maxLevelSum(root));
	}
	
	public static int maxLevelSum(TreeNode root) {
        int level = 1, maxLevel = 1, maxSum = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSum = 0, levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = level;
            }
            level++;
        }

        return maxLevel;
    }
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode() {
			
		}
		
		TreeNode(int val) { 
			this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }

}
