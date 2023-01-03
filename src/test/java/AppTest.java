import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    TestValues[] testValues = {
            new TestValues(new int[] { 1, 2 }, 0, 1, 2), // 0
            new TestValues(new int[] { 2, 1 }, -1, -1, 2), // 1
            new TestValues(new int[] { 1, 2, 3 }, 0, 1, 5), // 2
            new TestValues(new int[] { 1, 3, 2 }, 0, 1, 5), // 3
            new TestValues(new int[] { 3, 1, 2 }, -1, -1, 5), // 4
            new TestValues(new int[] { 3, 2, 1 }, 1, 2, 5), // 5
            new TestValues(new int[] { 1, 2, 3, 4 }, 0, 3, 6), // 6
            new TestValues(new int[] { 1, 2, 4, 3 }, 0, 1, 6),  // 7
            new TestValues(new int[] { 1, 3, 2, 4 }, 0, 3, 7),  // 8
            new TestValues(new int[] { 1, 3, 4, 2 }, 0, 1, 7),  // 9
            new TestValues(new int[] { 3 }, -1, -1, 3),     // 10
            new TestValues(new int[] { 3, 1, 2, 1 }, -1, -1, 5), // 11
            //new TestValues(new int[] { 1, 7, 3, 4, 7, 6, 2, 9 }, -1, -1, 26), // 12
            new TestValues(new int[] { 2, 1, 5, 7, 1, 1 }, 3, 4, 14), // 13
            new TestValues(new int[] { 2, 4, 1, 7, 1, 1 }, 1, 4, 13), // 14
            new TestValues(new int[] { 5, 6, 6, 5, 5, 6 }, 0, 1, 17), // 15
            new TestValues(new int[] { 1, 2, 3, 4, 8, 7, 5, 6 }, 0, 7, 19), // 16
            new TestValues(new int[] { 1, 2, 3, 4, 8, 7, 6, 5 }, 0, 3, 20), // 17
            new TestValues(new int[] { 1, 2, 3, 4, 5, 6, 8, 7 }, 0, 5, 20), // 18
            new TestValues(new int[] { 1, 2, 3, 4, 5, 7, 8, 6 }, 0, 5, 21), // 19


    };

    @Test
    public void testAlpha() {
        // for (int i = 0; i < testValues.length; i++) {
        //     runAlphaTest(i);
        // }

         runAlphaTest(12);
    }

    @Test
    public void testAlphaRec() {
        // for (int i = 0; i < testValues.length; i++) {
        //     runAlphaRecTest(i);
        // }

        runAlphaRecTest(15);
    }

    private void runAlphaRecTest(int i) {
        TestValues testValue = testValues[i];
        int[] output = World_Cup.alphaRec(testValue.testArray);
        assertEquals(2, output.length);
        assertEquals(testValue.lo, output[0], String.format("failed %d failed: alpha lo", i));
        assertEquals(testValue.hi, output[1], String.format("failed %d failed: alpha hi", i));
    }

    private void runAlphaTest(int i) {
        TestValues testValue = testValues[i];
        int output = World_Cup.alpha(testValue.testArray);
        assertEquals(testValue.output, output, String.format("failed %d failed: alpha output", i));
    }
}

class TestValues {
    int[] testArray;
    int lo;
    int hi;
    int output;

    public TestValues(int[] testArray, int lo, int hi, int output) {
        this.testArray = testArray;
        this.lo = lo;
        this.hi = hi;
        this.output = output;
    }
}