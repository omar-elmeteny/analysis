import java.util.ArrayList;

/**
 * Wprld_Cup
 */
public class World_Cup {

    public static int alpha(int[] keys) {
        if (keys.length == 0) {
            return 0;
        } else if (keys.length == 1) {
            return keys[0];
        }
        int sumOfElementsInEven = 0;
        for (int i = 0; i < keys.length; i++) {
            if ((i & 1) == 0) { // use bitwise AND to check if i is even instead of % 2 to imporve performance
                sumOfElementsInEven = sumOfElementsInEven + keys[i];
            }
        }
        int[] oddMinusPrevEven = new int[keys.length / 2];
        int[] oddMinusNextEven = new int[(keys.length - 1) / 2];
        for (int i = 0; i < keys.length - 1; i += 2) {
            int difference = keys[i + 1] - keys[i];
            oddMinusPrevEven[i >> 1] = difference; // using shift operator to divide by 2 to improve performance
        }
        // display(oddMinusPrevEven);
        for (int i = 1; i < keys.length - 1; i += 2) {
            int difference = keys[i] - keys[i + 1];
            oddMinusNextEven[i >> 1] = difference; // using shift operator to divide by 2 to improve performance
        }
        // display(oddMinusNextEven);
        long incrementationOddMinusPrevEven = getIncrementation(oddMinusPrevEven);
        long incrementationOddMinusNextEven = getIncrementation(oddMinusNextEven);
        return sumOfElementsInEven + (int) max(0, incrementationOddMinusNextEven, incrementationOddMinusPrevEven);
    }

    public static int[] alphaRec(int[] keys) {
        if (keys.length == 1) {
            return new int[] { -1, -1 };
        }
        ArrayList<Integer> oddMinusPrevEven = new ArrayList<>();
        ArrayList<Integer> oddMinusNextEven = new ArrayList<>();
        for (int i = 0; i < keys.length - 1; i += 2) {
            int difference = keys[i + 1] - keys[i];
            oddMinusPrevEven.add(difference);
        }
        for (int i = 1; i < keys.length - 1; i += 2) {
            int difference = keys[i] - keys[i + 1];
            oddMinusNextEven.add(difference);
        }
        Subrange range1;
        if (oddMinusPrevEven.size() != 0) {
            range1 = largestSubrange(oddMinusPrevEven);
        } else {
            range1 = new Subrange(new int[] { -1, -1 }, 0);
        }
        Subrange range2;
        if (oddMinusNextEven.size() != 0) {
            range2 = largestSubrange(oddMinusNextEven);
        } else {
            range2 = new Subrange(new int[] { -1, -1 }, 0);
        }
        Subrange range = compareSubranges(range1, range2, range2);
        int[] result = new int[] { -1, -1 };
        if (range.range[0] > -1 && range.range[1] > -1) {
            if (range.equals(range1)) {
                result[0] = range.range[0] * 2;
                result[1] = range.range[1] * 2 + 1;
            } else {
                result[0] = range.range[0] * 2 + 1;
                result[1] = range.range[1] * 2 + 2;
            }
        }
        return result;
    }

    private static Subrange largestSubrange(ArrayList<Integer> array) {
        return largestSubrangeHelper(array, 0, array.size() - 1);
    }

    private static Subrange largestSubrangeHelper(ArrayList<Integer> array, int i, int j) {
        if (i == j) {
            return new Subrange(new int[] { i, j }, array.get(i));
        }
        int mid = (i + j) / 2;
        Subrange range = compareSubranges(largestSubrangeHelper(array, i, mid),
                largestSubrangeHelper(array, mid + 1, j), maxCrossing(array, i, j, mid));
        return range;
    }

    private static Subrange maxCrossing(ArrayList<Integer> array, int i, int j, int mid) {
        Subrange rangeLeft = new Subrange(new int[] { -1, -1 }, 0);
        Subrange range = new Subrange(new int[] { -1, -1 }, 0);
        Subrange rangeRight = new Subrange(new int[] { -1, -1 }, 0);
        for (int k = mid; k >= i; k--) {
            range.sum = range.sum + array.get(k);
            if (range.sum > rangeLeft.sum) {
                rangeLeft.sum = range.sum;
                if (rangeLeft.range[1] == -1) {
                    rangeLeft.range[1] = k;
                } else {
                    rangeLeft.range[0] = k;
                }
            }
            // display(rangeLeft.range);
        }
        if (rangeLeft.range[1] != -1) {
            if (rangeLeft.range[0] == -1) {
                rangeLeft.range[0] = rangeLeft.range[1];
            }
        }
        range.sum = 0;
        for (int k = mid + 1; k <= j; k++) {
            range.sum = range.sum + array.get(k);
            if (range.sum > rangeRight.sum) {
                rangeRight.sum = range.sum;
                if (rangeRight.range[0] == -1) {
                    rangeRight.range[0] = k;
                } else {
                    rangeRight.range[1] = k;
                }
            }
            // display(rangeRight.range);
        }
        if (rangeRight.range[0] != -1) {
            if (rangeRight.range[1] == -1) {
                rangeRight.range[1] = rangeRight.range[0];
            }
        }
        range.sum = rangeLeft.sum + rangeRight.sum;
        range.range[0] = rangeLeft.range[0];
        range.range[1] = rangeRight.range[1];
        if (range.range[0] == -1) {
            range.range[0] = rangeRight.range[0];
        }
        if (range.range[1] == -1) {
            range.range[1] = rangeLeft.range[1];
        }
        return compareSubranges(rangeLeft, range, rangeRight);
    }

    public static Subrange compareSubranges(Subrange range1, Subrange range2, Subrange range3) {

        long maxSum = max(range1.sum, range2.sum, range3.sum);
        if (maxSum == range1.sum) {
            return range1;
        } else if (maxSum == range2.sum) {
            return range2;
        } else {
            return range3;
        }
    }

    private static long getIncrementation(int[] array) {
        long max1 = (int) Double.NEGATIVE_INFINITY;
        long max2 = (int) Double.NEGATIVE_INFINITY;
        for (int i = 0; i < array.length; i++) {
            max1 = max(max1 + array[i], array[i]);
            max2 = max(max1, max2);
            // System.out.println(max2);
        }
        return max2;
    }

    public static long max(long x, long y) {
        return (x > y) ? x : y;
    }

    public static long max(long x, long y, long z) {
        return max(max(x, y), z);
    }

    public static void display(ArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
        System.out.println();
    }

    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] keys = { 3 };
        // System.out.println(alpha(keys));
        display(alphaRec(keys));
    }

}

class Subrange {

    int[] range;
    int sum;

    Subrange(int[] range, int sum) {
        this.range = range;
        this.sum = sum;
    }

    public boolean equals(Subrange range) {
        return (this.range[0] == range.range[0] && this.range[1] == range.range[1] && this.sum == range.sum);
    }

}
