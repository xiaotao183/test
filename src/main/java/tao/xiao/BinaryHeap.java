package tao.xiao;

import org.apache.commons.lang.ArrayUtils;

public class BinaryHeap {
    private int[] heap;
    private int heapSize;

    public BinaryHeap() {
    }

    public void buildHeap(final int[] elements) {
        if (elements != null) {
            heap = new int[elements.length + 1];
            heapSize = heap.length - 1;
            heap[0] = Integer.MAX_VALUE;

            for (int i = 0; i < elements.length; i++) {
                heap[i + 1] = elements[i];
            }

            for (int i = elements.length / 2; i > 0; i--) {
                percolateDown(i);
            }
        }
    }

    private void percolateDown(final int index) {
        if (getLeftChildIndex(index) <= heapSize) {
            int maxChildIndex = getMaxChildIndex(index);

            if (heap[index] < heap[maxChildIndex]) {
                swap(index, maxChildIndex, heap);
                percolateDown(maxChildIndex);
            }
        }
    }

    private int getMaxChildIndex(final int parentIndex) {
        if (getRightChildIndex(parentIndex) <= heapSize) {
            if (heap[getLeftChildIndex(parentIndex)] > heap[getRightChildIndex(parentIndex)]) {
                return getLeftChildIndex(parentIndex);
            } else {
                return getRightChildIndex(parentIndex);
            }
        } else {
            return getLeftChildIndex(parentIndex);
        }
    }

    private int getLeftChildIndex(final int parentIndex) {
        return 2 * parentIndex;
    }

    private int getRightChildIndex(final int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private void swap(final int from, final int to, final int[] array) {
        int tmp = array[to];
        array[to] = array[from];
        array[from] = tmp;
    }

    public void insert(final int element) {
        if (!ArrayUtils.isEmpty(heap)) {
            if (heapSize < heap.length - 1) {
                int i = ++heapSize;
                for (; heap[i / 2] < element; i /= 2) {
                    heap[i] = heap[i / 2];
                }

                heap[i] = element;
            }
        }
    }

    public int deleteMax() {
        if (!ArrayUtils.isEmpty(heap)) {
            int max = heap[1];
            swap(1, heapSize--, heap);
            percolateDown(1);

            return max;
        }

        return Integer.MAX_VALUE;
    }

    public void print() {
        if (heap != null) {
            for (int i = 1; i <= heapSize; i++) {
                System.out.print(heap[i] + ",");
            }
        }
    }

    public static void main(final String[] args) {
        BinaryHeap bh = new BinaryHeap();
        bh.buildHeap(new int[] { 4, 5, 1, 6, 9, 9, 2, 7, 8, 3, 11, 10 });
        bh.print();
        System.out.println();
        System.out.println(bh.deleteMax());
        bh.print();
        System.out.println();
        
        bh.insert(200);
        bh.print();
    }
}
