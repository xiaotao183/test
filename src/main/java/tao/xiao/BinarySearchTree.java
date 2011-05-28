package tao.xiao;

public class BinarySearchTree {
	private Node root;

	protected static class Node {
		private int element;
		private Node left;
		private Node right;

		Node(int element) {
			this.element = element;
		}
	}

	public BinarySearchTree() {
	}

	public boolean insert(int value) {
		try {
			root = insert(root, value);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	protected Node insert(Node node, int value) {
		if (node == null) {
			node = new Node(value);
		} else {
			if (value == node.element) {
				throw new IllegalArgumentException();
			} else if (value < node.element) {
				node.left = insert(node.left, value);
			} else {
				node.right = insert(node.right, value);
			}
		}
		
		return node;
	}

	public void printTree() {
		printTree(getRoot(), "", getRoot() == null ? 0 : getRoot().element);
	}

	protected Node getRoot() {
		return root;
	}

	protected void printTree(Node node, String ancenstor, int parent) {
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
	
	protected int treeDepth(Node node) {
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
	
	public int findMin() {
		Node minNode = findMin(getRoot());
		
		if (minNode == null) {
			return 0;
		} else {
			return minNode.element;
		}
	}
	
	protected Node findMin(Node node) {
		if (node == null) {
			return null;
		} else if (node.left == null) {
			return node;
		}else {
			return findMin(node.left);
		}
	}
	
	public int findMax() {
		Node maxNode = findMax(getRoot());
		
		if (maxNode == null) {
			return 0;
		} else {
			return maxNode.element;
		}
	}
	
	protected Node findMax(Node node) {
		if (node == null) {
			return null;
		} else if (node.right == null) {
			return node;
		}else {
			return findMax(node.right);
		}
	}
	
	public boolean delete(int value) {
		try {
			root = delete(root, value);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}
	
	protected Node delete(Node node, int value) {
		if (node == null) {
			throw new IllegalArgumentException();
		} else {
			if (value < node.element) {
				node.left = delete(node.left, value);
			} else if (value > node.element) {
				node.right = delete(node.right, value);
			} else {
				if (node.left == null) {
					node = node.right;
				} else if (node.right == null) {
					node = node.left;
				} else {
					Node rightMinNode = findMin(node.right);
					node.element = rightMinNode.element;
					node.right = delete(node.right, node.element);
				}
			}
			
			return node;
		}
	}
}
