package tao.xiao;

public class BinaryHeap {
	private int[] heap;

	public BinaryHeap() {
	}

	public void buildHeap(int[] elements) {
		if (elements != null) {
			heap = new int[elements.length + 1];
			for (int i = 0; i < elements.length; i++) {
				heap[i + 1] = elements[i];
			}

			for (int i = elements.length / 2; i > 0; i--) {
				percolateDown(i);
			}
		}
	}

	private void percolateDown(int index) {
		if (getLeftChildIndex(index) < heap.length) {
			int maxChildIndex = getMaxChildIndex(index);

			if (heap[index] < heap[maxChildIndex]) {
				swap(index, maxChildIndex, heap);
				percolateDown(maxChildIndex);
			}
		}
	}

	private int getMaxChildIndex(int parentIndex) {
		if (getRightChildIndex(parentIndex) < heap.length) {
			if (heap[getLeftChildIndex(parentIndex)] > heap[getRightChildIndex(parentIndex)]) {
				return getLeftChildIndex(parentIndex);
			} else {
				return getRightChildIndex(parentIndex);
			}
		} else {
			return getLeftChildIndex(parentIndex);
		}
	}

	private int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex;
	}

	private int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}

	private void swap(int from, int to, int[] array) {
		int tmp = array[to];
		array[to] = array[from];
		array[from] = tmp;
	}

	public void print() {
		if (heap != null) {
			for (int i = 1; i < heap.length; i++) {
				System.out.print(heap[i]);
			}
		}
	}

	public static void main(String[] args) {
		BinaryHeap bh = new BinaryHeap();
		bh.buildHeap(new int[] { 4, 5, 1, 6, 9, 9, 2, 7, 8, 3 });
		bh.print();
	}
}
