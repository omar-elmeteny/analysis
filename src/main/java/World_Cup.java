import java.util.ArrayList;

/**
 * Wprld_Cup
 */
public final class World_Cup {

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
        int incrementationOddMinusPrevEven = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE;
        for (int i = 0; i < keys.length - 1; i += 2) {
            int difference = keys[i + 1] - keys[i];
            max1 = max1 > 0 ? max1 + difference : difference;
            if (incrementationOddMinusPrevEven < max1) {
                incrementationOddMinusPrevEven = max1;
            }
        }
        // display(oddMinusNextEven);
        int incrementationOddMinusNextEven = Integer.MIN_VALUE;
        max1 = Integer.MIN_VALUE;
        for (int i = 1; i < keys.length - 1; i += 2) {
            int difference = keys[i] - keys[i + 1];
            max1 = max1 > 0 ? max1 + difference : difference;
            if (incrementationOddMinusNextEven < max1) {
                incrementationOddMinusNextEven = max1;
            }
        }
        return sumOfElementsInEven + max(0, incrementationOddMinusNextEven, incrementationOddMinusPrevEven);
    }

    public static int[] alphaRec(int[] keys) {
        if (keys.length < 2) {
            return new int[] { -1, -1 };
        }
        
        int incrementationOddMinusPrevEven = Integer.MIN_VALUE;
        int[] incrementationOddMinusPrevEvenRange = new int[] { -1, -1 };
        int[] max1Range = new int[] { -1, -1 };
        int max1 = Integer.MIN_VALUE;
        for (int i = 0; i < keys.length - 1; i += 2) {
            int difference = keys[i + 1] - keys[i];
            int[] newRange = new int[] { i, i + 1 };
            if (max1 > 0) {
                max1 = max1 + difference;
                max1Range = new int[] { max1Range[0], newRange[1] };
            } else {
                max1 = difference;
                max1Range = newRange;
            }
            if (incrementationOddMinusPrevEven < max1) {
                incrementationOddMinusPrevEven = max1;
                incrementationOddMinusPrevEvenRange = max1Range;
            }
            
        }
        // display(oddMinusNextEven);
        int incrementationOddMinusNextEven = Integer.MIN_VALUE;
        int[] incrementationOddMinusNextEvenRange = new int[] { -1, - 1 };
        max1Range = new int[] { -1, -1 };
        max1 = Integer.MIN_VALUE;
        for (int i = 1; i < keys.length - 1; i += 2) {
            int difference = keys[i] - keys[i + 1];
            int[] newRange = new int[] { i, i + 1 };
            if (max1 > 0) {
                max1 = max1 + difference;
                max1Range = new int[] { max1Range[0], newRange[1] };
            } else {
                max1 = difference;
                max1Range = newRange;
            }
            if (incrementationOddMinusNextEven < max1) {
                incrementationOddMinusNextEven = max1;
                incrementationOddMinusNextEvenRange = max1Range;
            }
        }

        if (incrementationOddMinusNextEven > incrementationOddMinusPrevEven) {
            if (incrementationOddMinusNextEven <= 0) {
                return new int[] { -1, -1 };
            }
            return incrementationOddMinusNextEvenRange;
        } else {
            if (incrementationOddMinusPrevEven <= 0) {
                return new int[] { -1, -1 };
            }
            return incrementationOddMinusPrevEvenRange;
        }
    }

    public static int max(int x, int y) {
        return (x > y) ? x : y;
    }

    public static int max(int x, int y, int z) {
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


