package tao.xiao;

import java.util.ArrayList;
import java.util.List;

public class OlympicCandles {
    public static void main(final String[] args) {
        System.out.println(new OlympicCandles().numberOfNights(new int[] {2, 2, 2}));
        System.out.println(new OlympicCandles().numberOfNights(new int[] {2, 2, 2, 4}));
        System.out.println(new OlympicCandles().numberOfNights(new int[] {5, 2, 2, 1}));
        System.out.println(new OlympicCandles().numberOfNights(new int[] {1, 2, 3, 4, 5, 6}));
        System.out.println(new OlympicCandles().numberOfNights(new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(new OlympicCandles().numberOfNights(new int[] {1, 1}));
        System.out.println(new OlympicCandles().numberOfNights(new int[] {0}));
    }
    
    public int numberOfNights(final int[] candles) {
        BinaryHeap binaryHeap = new BinaryHeap();
        binaryHeap.buildHeap(candles);

        List<Integer> lightingCandles = new ArrayList<Integer>();
        int night = 1;
        boolean isNoMoreCandles = false;

        while (!isNoMoreCandles) {
            lightingCandles.clear();

            for (int i = 0; i < night; i++) {
                int max = binaryHeap.deleteMax();

                if (max == 0) {
                    isNoMoreCandles = true;
                    night --;
                    break;
                }

                max--;
                lightingCandles.add(max);
            }

            if (!isNoMoreCandles) {
                for (Integer element : lightingCandles) {
                    binaryHeap.insert(element);
                }
                
                night++;
            }
        }

        return night;
    }
}
