package tao.xiao;

public class TreeDriver {

	public static void main(String[] args) {
		// testBST();
		testAVL();
	}

	private static void testBST() {
		System.out.println("--------------BST--------------");

		BinarySearchTree bst = new BinarySearchTree();
		bst.printTree();

		System.out.println("insert 20:" + bst.insert(20));
		System.out.println("insert 10:" + bst.insert(10));
		System.out.println("insert 1:" + bst.insert(1));
		System.out.println("insert 11:" + bst.insert(11));
		System.out.println("insert 12:" + bst.insert(12));
		System.out.println("insert 30:" + bst.insert(30));
		System.out.println("insert 25:" + bst.insert(25));
		System.out.println("insert 40:" + bst.insert(40));
		System.out.println("insert 35:" + bst.insert(35));
		System.out.println("insert 50:" + bst.insert(50));
		System.out.println("insert 50:" + bst.insert(50));

		bst.printTree();

		System.out.println("tree depth" + bst.treeDepth());

		System.out.println("insert 36:" + bst.insert(36));
		bst.printTree();
		System.out.println("tree depth" + bst.treeDepth());

		System.out.println("find min" + bst.findMin());
		System.out.println("find max" + bst.findMax());

		System.out.println("delete 100" + bst.delete(100));
		bst.printTree();

		System.out.println("delete 20" + bst.delete(20));
		bst.printTree();

		System.out.println("----------------end---------------");
	}

	private static void testAVL() {
		System.out.println("--------------AVL--------------");

		AVLTree avl = new AVLTree();
		avl.printTree();

		System.out.println("insert 1:" + avl.insert(1));
		System.out.println("insert 2:" + avl.insert(2));
		System.out.println("insert 3:" + avl.insert(3));
		System.out.println("insert 4:" + avl.insert(4));
		System.out.println("insert 5:" + avl.insert(5));
		System.out.println("insert 6:" + avl.insert(6));
		System.out.println("insert 7:" + avl.insert(7));

		avl.printTree();

		System.out.println("tree depth:" + avl.treeDepth());

		System.out.println("insert 16:" + avl.insert(16));
		System.out.println("insert 15:" + avl.insert(15));
		System.out.println("insert 14:" + avl.insert(14));
		System.out.println("insert 13:" + avl.insert(13));
		System.out.println("insert 12:" + avl.insert(12));
		System.out.println("insert 11:" + avl.insert(11));
		System.out.println("insert 10:" + avl.insert(10));
		System.out.println("insert 9:" + avl.insert(9));
		System.out.println("insert 8:" + avl.insert(8));

		avl.printTree();

		System.out.println("tree depth:" + avl.treeDepth());
		
		System.out.println("find 1:" + avl.find(1));
		System.out.println("find 11:" + avl.find(11));
		System.out.println("find 100:" + avl.find(100));

		System.out.println("----------------end---------------");
	}
}
