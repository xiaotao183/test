package tao.xiao;

public class Practice {
    public static void main(final String[] args) {
        System.out.println(new Practice().maxSubarray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }

    public int maxSubarray(final int[] array) {
        int maxSoFar = 0;
        int maxEndingHere = 0;

        for (Integer element : array) {
            maxEndingHere = Math.max(0, maxEndingHere + element);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
