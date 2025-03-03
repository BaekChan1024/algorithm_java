package algorithm.programmers;

public class p68936 {

    public class Count {
        public final int zero;
        public final int one;

        public Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

        public Count add(Count other) {
            return new Count(zero + other.zero, one + other.one);
        }
    }

    private Count calculate(int offsetX, int offsetY, int size, int[][] arr) {
        int h = size / 2;
        for (int y = offsetY; y < size + offsetY; y++) {
            for (int x = offsetX; x < size + offsetX; x++) {
                if (arr[y][x] != arr[offsetY][offsetX]) {
                    return calculate(offsetX, offsetY, h, arr)
                            .add(calculate(offsetX + h, offsetY, h, arr))
                            .add(calculate(offsetX, offsetY + h, h, arr))
                            .add(calculate(offsetX + h, offsetY + h, h, arr));
                }
            }
        }

        if (arr[offsetY][offsetX] == 1) {
            return new Count(0, 1);
        }
        return new Count(1, 0);
    }

    public int[] solution(int[][] arr) {
        Count count = calculate(0, 0, arr.length, arr);
        return new int[] {count.zero, count.one};
    }


}
