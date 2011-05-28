package tao.xiao;



public class AVLTree {
	private AVLNode root;

	protected static class AVLNode {
		private int height;
		private int element;
		private AVLNode left;
		private AVLNode right;

		AVLNode(int element) {
			this.element = element;
			height = 0;
		}
	}

	public AVLTree() {
	}

	private int height(AVLNode node) {
		if (node == null) {
			return -1;
		} else {
			return node.height;
		}
	}

	public boolean insert(int value) {
		try {
			root = insert(root, value);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	protected AVLNode insert(AVLNode node, int value) {
		if (node == null) {
			node = new AVLNode(value);
		} else {
			if (value < node.element) {
				node.left = insert(node.left, value);

				if (height(node.left) - height(node.right) == 2) {
					if (value < node.left.element) {
						node = singleRotationWithLeft(node);
					} else {
						node = doubleRotationWithLeft(node);
					}
				}
			} else if (value > node.element) {
				node.right = insert(node.right, value);

				if (height(node.right) - height(node.left) == 2) {
					if (value > node.right.element) {
						node = singleRotationWithRight(node);
					} else {
						node = doubleRotationWithRight(node);
					}
				}

			} else {
				throw new IllegalArgumentException();
			}
		}

		node.height = Math.max(height(node.left), height(node.right)) + 1;
		return node;
	}

	private AVLNode singleRotationWithLeft(AVLNode node) {
		AVLNode temp = node.left;
		node.left = temp.right;
		temp.right = node;

		node.height = Math.max(height(node.left), height(node.right)) + 1;
		temp.height = Math.max(node.height, height(temp.left)) + 1;

		return temp;
	}

	private AVLNode singleRotationWithRight(AVLNode node) {
		AVLNode temp = node.right;
		node.right = temp.left;
		temp.left = node;

		node.height = Math.max(height(node.left), height(node.right)) + 1;
		temp.height = Math.max(node.height, height(temp.right)) + 1;

		return temp;
	}

	private AVLNode doubleRotationWithLeft(AVLNode node) {
		node.left = singleRotationWithRight(node.left);

		return singleRotationWithLeft(node);
	}

	private AVLNode doubleRotationWithRight(AVLNode node) {
		node.right = singleRotationWithLeft(node.right);

		return singleRotationWithRight(node);
	}
	
	public void printTree() {
		printTree(getRoot(), "", getRoot() == null ? 0 : getRoot().element);
	}

	protected AVLNode getRoot() {
		return root;
	}

	protected void printTree(AVLNode node, String ancenstor, int parent) {
		if (node == null) {
			System.out.println(parent + ":" + ancenstor + ":empty node");
		} else {
			System.out.println(parent + ":" + ancenstor + ":root:" + node.element);
			printTree(node.left, "left", node.element);
			printTree(node.right, "right", node.element);
		}
	}
	
	public int treeDepth() {
		return treeDepth(getRoot());
	}
	
	protected int treeDepth(AVLNode node) {
		int leftTreeDepth = 0;
		int rightTreeDepth = 0;
		
		if (node == null) {
			return 0;
		} else {
			leftTreeDepth = treeDepth(node.left);
			rightTreeDepth = treeDepth(node.right);
			
			return Math.max(leftTreeDepth, rightTreeDepth) + 1;
		}
	}
	
	public boolean find(int value) {
		AVLNode node = find(root, value);
		
		if (node == null) {
			return false;
		} else {
			return true;
		}
	}
	
	private AVLNode find(AVLNode node, int value) {
		if (node == null) {
			return null;
		} else {
			if (value == node.element) {
				return node;
			} else if (value < node.element) {
				return find(node.left, value);
			} else {
				return find(node.right, value);
			}
		}
	}
}
