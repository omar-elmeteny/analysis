import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

class DPSolTest {
	Method alpha;

	public static Method initialize()
			throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Method method = null;

		try {
			// Change the name to your class name instead of DPSol
			Class<?> myClass = Class.forName("World_Cup");

			method = myClass.getMethod("alpha", int[].class);
		} catch (SecurityException e) {
		} catch (NoSuchMethodException e) {
		}

		return method;
	}

	@Test
	void test1()
			throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		this.alpha = initialize();
		alpha.invoke(null,new int [] {});
		long startTime = System.nanoTime();
		// Array of length 1000
		int x = (int) alpha.invoke(null, new int[] { 7, 9, 19, 9, 38, 29, 4, 54, 44, 14, 54, 38, 51, 46, 33, 32, 33, 12,
				25, 23, 19, 56, 14, 34, 48, 49, 0, 33, 25, 19, 19, 39, 44, 40, 1, 64, 25, 46, 47, 41, 65, 15, 48, 41, 0,
				11, 29, 60, 33, 19, 8, 43, 27, 24, 9, 21, 16, 51, 56, 5, 47, 29, 43, 23, 33, 56, 17, 50, 12, 46, 14, 35,
				0, 47, 28, 43, 24, 4, 19, 28, 1, 34, 10, 4, 43, 22, 65, 19, 52, 40, 6, 59, 35, 64, 2, 19, 13, 10, 1, 12,
				24, 37, 21, 60, 61, 63, 3, 34, 58, 45, 62, 53, 0, 53, 33, 58, 30, 0, 16, 1, 20, 50, 29, 41, 61, 21, 60,
				55, 45, 64, 27, 4, 32, 61, 4, 33, 45, 38, 20, 44, 14, 6, 19, 59, 57, 24, 1, 27, 35, 22, 51, 13, 59, 60,
				58, 22, 56, 31, 60, 48, 6, 19, 12, 38, 64, 25, 60, 3, 1, 34, 3, 51, 62, 33, 16, 4, 19, 1, 51, 23, 46, 1,
				61, 23, 22, 12, 48, 37, 24, 52, 9, 61, 55, 25, 9, 7, 46, 28, 50, 3, 55, 47, 48, 14, 7, 62, 5, 48, 10,
				54, 58, 64, 41, 31, 56, 11, 8, 13, 40, 20, 28, 1, 3, 51, 39, 47, 47, 2, 42, 16, 41, 26, 56, 31, 17, 39,
				19, 30, 55, 57, 56, 58, 58, 58, 39, 65, 1, 38, 9, 28, 6, 4, 23, 59, 12, 59, 63, 46, 65, 28, 41, 28, 44,
				11, 42, 29, 38, 46, 16, 39, 36, 64, 48, 21, 50, 36, 23, 20, 58, 8, 54, 35, 65, 13, 36, 56, 65, 56, 10,
				18, 38, 58, 54, 34, 0, 36, 35, 48, 37, 41, 29, 13, 41, 16, 32, 21, 28, 29, 14, 30, 16, 2, 59, 39, 38,
				21, 33, 49, 14, 19, 58, 41, 51, 61, 55, 39, 10, 9, 1, 0, 46, 18, 27, 63, 61, 61, 24, 32, 55, 64, 42, 45,
				39, 0, 18, 52, 48, 14, 35, 64, 10, 17, 8, 15, 60, 56, 39, 43, 56, 46, 26, 22, 65, 6, 59, 18, 59, 56, 49,
				20, 5, 54, 40, 52, 13, 32, 31, 28, 9, 45, 50, 41, 34, 43, 48, 7, 42, 51, 35, 40, 35, 44, 8, 50, 54, 20,
				8, 25, 49, 61, 44, 49, 44, 49, 46, 41, 63, 22, 16, 48, 15, 3, 36, 18, 47, 55, 53, 12, 35, 54, 8, 56, 17,
				0, 36, 15, 38, 12, 58, 40, 7, 41, 25, 26, 46, 61, 27, 63, 20, 14, 44, 26, 11, 60, 49, 41, 23, 42, 36,
				15, 58, 56, 14, 18, 24, 48, 61, 30, 12, 36, 41, 52, 9, 1, 54, 11, 9, 64, 0, 61, 29, 0, 34, 37, 2, 25,
				41, 43, 46, 7, 23, 57, 58, 55, 59, 45, 19, 63, 0, 14, 25, 54, 21, 33, 64, 32, 38, 62, 55, 4, 59, 2, 12,
				47, 54, 49, 44, 55, 26, 50, 65, 26, 27, 49, 37, 19, 30, 9, 31, 29, 41, 2, 28, 5, 60, 60, 16, 47, 65, 15,
				58, 44, 39, 47, 52, 34, 60, 49, 27, 21, 1, 41, 44, 39, 30, 41, 2, 64, 26, 0, 58, 46, 54, 38, 41, 40, 59,
				23, 41, 54, 52, 53, 26, 9, 61, 65, 13, 9, 56, 50, 3, 8, 20, 0, 0, 39, 25, 23, 31, 48, 15, 24, 19, 43,
				11, 49, 60, 14, 9, 55, 60, 30, 44, 10, 11, 55, 46, 53, 59, 10, 33, 53, 23, 60, 55, 50, 29, 8, 11, 49,
				16, 18, 33, 53, 24, 36, 53, 64, 19, 31, 53, 0, 31, 52, 13, 11, 29, 54, 56, 53, 56, 46, 27, 61, 10, 20,
				30, 58, 40, 7, 45, 18, 37, 65, 62, 40, 31, 8, 56, 59, 45, 2, 25, 31, 48, 63, 4, 19, 45, 4, 35, 60, 63,
				54, 60, 25, 11, 4, 24, 53, 11, 36, 20, 27, 61, 53, 54, 33, 26, 56, 52, 49, 27, 16, 26, 51, 31, 3, 64, 5,
				14, 44, 18, 56, 22, 63, 52, 39, 0, 44, 13, 53, 46, 60, 21, 48, 64, 5, 28, 37, 55, 31, 23, 49, 18, 64,
				36, 32, 62, 26, 26, 31, 45, 11, 12, 17, 32, 30, 51, 53, 10, 57, 16, 34, 0, 29, 34, 41, 19, 48, 64, 16,
				46, 20, 5, 57, 18, 30, 45, 1, 44, 35, 9, 0, 31, 58, 41, 31, 29, 61, 64, 5, 11, 64, 14, 46, 44, 22, 15,
				1, 57, 5, 2, 39, 52, 15, 45, 32, 50, 48, 44, 2, 34, 12, 61, 53, 28, 27, 14, 25, 57, 58, 16, 5, 25, 45,
				1, 40, 26, 17, 55, 41, 52, 21, 9, 31, 59, 27, 31, 0, 59, 23, 56, 19, 54, 30, 56, 39, 54, 17, 44, 59, 14,
				61, 30, 30, 0, 12, 20, 41, 21, 7, 3, 11, 4, 10, 61, 32, 60, 52, 18, 38, 3, 33, 40, 32, 7, 30, 47, 47,
				44, 49, 15, 57, 50, 14, 60, 54, 26, 45, 30, 36, 43, 22, 17, 31, 19, 10, 34, 21, 47, 48, 17, 13, 37, 4,
				27, 33, 50, 59, 56, 51, 40, 16, 60, 42, 29, 27, 51, 46, 64, 57, 58, 42, 42, 49, 32, 51, 18, 42, 52, 31,
				48, 8, 43, 16, 28, 19, 45, 17, 1, 21, 17, 39, 6, 16, 46, 65, 29, 20, 50, 36, 6, 24, 21, 4, 54, 2, 34,
				64, 18, 17, 24, 8, 9, 60, 36, 22, 13, 49, 7, 19, 59, 18, 47, 13, 52, 55, 7, 43, 61, 23, 16, 30, 54, 29,
				57, 30, 18, 39, 63, 28, 16, 61, 42, 55, 53, 44, 10, 47, 3, 57, 30, 32, 27, 46, 26, 15, 41, 31, 46, 40,
				2, 31, 18, 59, 56, 47, 31, 53, 56, 48, 58, 31, 41, 60, 18, 2, 36, 47 });
		long endTime = System.nanoTime();

		long totalTime = endTime - startTime;

		System.out.println(totalTime);

		assertEquals(17362, x);
		assertTimeLessThan(totalTime, 500000);

	}

	@Test
	void test2()
			throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		this.alpha = initialize();
		long startTime = System.nanoTime();

		int x = (int) alpha.invoke(null, new int[] { 65, 39, 61, 16, 30, 63, 33, 8, 14, 28, 63, 27, 11, 52, 5, 59, 40,
				1, 22, 25, 12, 8, 64, 45, 50, 3, 31, 56, 15, 49, 27, 31, 65, 10, 1, 32, 44, 20, 47, 23, 17, 24, 36, 35,
				40, 41, 12, 64, 7, 25, 29, 5, 21, 8, 55, 36, 62, 33, 12, 24, 62, 65, 51, 59, 65, 17, 53, 3, 54, 56, 31,
				35, 56, 3, 22, 23, 57, 5, 40, 53, 60, 2, 55, 59, 64, 2, 48, 45, 28, 40, 47, 7, 37, 18, 62, 57, 43, 32,
				40, 11, 18, 39, 6, 0, 6, 9, 11, 24, 11, 18, 6, 16, 58, 19, 61, 64, 30, 63, 59, 30, 16, 46, 40, 19, 1,
				59, 38, 64, 22, 35, 34, 53, 60, 21, 16, 28, 39, 30, 55, 13, 28, 10, 0, 55, 35, 38, 61, 60, 43, 61, 64,
				57, 50, 60, 52, 36, 52, 30, 35, 5, 14, 11, 25, 9, 55, 62, 11, 20, 17, 2, 8, 33, 25, 55, 48, 58, 16, 21,
				51, 52, 38, 13, 11, 40, 27, 47, 49, 56, 57, 59, 21, 57, 10, 54, 15, 40, 29, 40, 33, 34, 32, 7, 30, 17,
				20, 43, 19, 61, 37, 36, 20, 19, 20, 64, 14, 40, 18, 58, 43, 54, 1, 23, 39, 34, 12, 42, 40, 11, 15, 6,
				39, 13, 12, 30, 12, 54, 63, 21, 10, 27, 24, 9, 22, 59, 29, 10, 31, 64, 15, 44, 41, 20, 32, 19, 45, 65,
				6, 61, 46, 44, 58, 7, 18, 49, 31, 63, 7, 41, 0, 49, 15, 6, 13, 35, 58, 43, 65, 16, 61, 45, 13, 46, 50,
				8, 61, 18, 17, 56, 50, 9, 36, 9, 7, 0, 30, 21, 45, 56, 53, 12, 54, 44, 47, 61, 34, 36, 28, 8, 44, 27,
				14, 6, 61, 19, 13, 21, 1, 15, 63, 28, 20, 50, 26, 65, 41, 45, 23, 39, 55, 32, 44, 4, 49, 7, 30, 8, 9, 5,
				33, 55, 26, 19, 29, 47, 57, 40, 15, 43, 2, 36, 18, 5, 35, 6, 35, 45, 14, 1, 35, 28, 27, 6, 4, 10, 47,
				50, 58, 12, 53, 42, 17, 46, 19, 17, 12, 55, 65, 39, 61, 16, 30, 63, 33, 8, 14, 28, 63, 27, 11, 52, 5, 59, 40,
				1, 22, 25, 12, 8, 64, 45, 50, 3, 31, 56, 15, 49, 27, 31, 65, 10, 1, 32, 44, 20, 47, 23, 17, 24, 36, 35,
				40, 41, 12, 64, 7, 25, 29, 5, 21, 8, 55, 36, 62, 33, 12, 24, 62, 65, 51, 59, 65, 17, 53, 3, 54, 56, 31,
				35, 56, 3, 22, 23, 57, 5, 40, 53, 60, 2, 55, 59, 64, 2, 48, 45, 28, 40, 47, 7, 37, 18, 62, 57, 43, 32,
				40, 11, 18, 39, 6, 0, 6, 9, 11, 24, 11, 18, 6, 16, 58, 19, 61, 64, 30, 63, 59, 30, 16, 46, 40, 19, 1,
				59, 38, 64, 22, 35, 34, 53, 60, 21, 16, 28, 39, 30, 55, 13, 28, 10, 0, 55, 35, 38, 61, 60, 43, 61, 64,
				57, 50, 60, 52, 36, 52, 30, 35, 5, 14, 11, 25, 9, 55, 62, 11, 20, 17, 2, 8, 33, 25, 55, 48, 58, 16, 21,
				51, 52, 38, 13, 11, 40, 27, 47, 49, 56, 57, 59, 21, 57, 10, 54, 15, 40, 29, 40, 33, 34, 32, 7, 30, 17,
				20, 43, 19, 61, 37, 36, 20, 19, 20, 64, 14, 40, 18, 58, 43, 54, 1, 23, 39, 34, 12, 42, 40, 11, 15, 6,
				39, 13, 12, 30, 12, 54, 63, 21, 10, 27, 24, 9, 22, 59, 29, 10, 31, 64, 15, 44, 41, 20, 32, 19, 45, 65,
				6, 61, 46, 44, 58, 7, 18, 49, 31, 63, 7, 41, 0, 49, 15, 6, 13, 35, 58, 43, 65, 16, 61, 45, 13, 46, 50,
				8, 61, 18, 17, 56, 50, 9, 36, 9, 7, 0, 30, 21, 45, 56, 53, 12, 54, 44, 47, 61, 34, 36, 28, 8, 44, 27,
				14, 6, 61, 19, 13, 21, 1, 15, 63, 28, 20, 50, 26, 65, 41, 45, 23, 39, 55, 32, 44, 4, 49, 7, 30, 8, 9, 5,
				33, 55, 26, 19, 29, 47, 57, 40, 15, 43, 2, 36, 18, 5, 35, 6, 35, 45, 14, 1, 35, 28, 27, 6, 4, 10, 47,
				50, 58, 12, 53, 42, 17, 46, 19, 17, 12, 55, 65, 39, 61, 16, 30, 63, 33, 8, 14, 28, 63, 27, 11, 52, 5, 59, 40,
				1, 22, 25, 12, 8, 64, 45, 50, 3, 31, 56, 15, 49, 27, 31, 65, 10, 1, 32, 44, 20, 47, 23, 17, 24, 36, 35,
				40, 41, 12, 64, 7, 25, 29, 5, 21, 8, 55, 36, 62, 33, 12, 24, 62, 65, 51, 59, 65, 17, 53, 3, 54, 56, 31,
				35, 56, 3, 22, 23, 57, 5, 40, 53, 60, 2, 55, 59, 64, 2, 48, 45, 28, 40, 47, 7, 37, 18, 62, 57, 43, 32,
				40, 11, 18, 39, 6, 0, 6, 9, 11, 24, 11, 18, 6, 16, 58, 19, 61, 64, 30, 63, 59, 30, 16, 46, 40, 19, 1,
				59, 38, 64, 22, 35, 34, 53, 60, 21, 16, 28, 39, 30, 55, 13, 28, 10, 0, 55, 35, 38, 61, 60, 43, 61, 64,
				57, 50, 60, 52, 36, 52, 30, 35, 5, 14, 11, 25, 9, 55, 62, 11, 20, 17, 2, 8, 33, 25, 55, 48, 58, 16, 21,
				51, 52, 38, 13, 11, 40, 27, 47, 49, 56, 57, 59, 21, 57, 10, 54, 15, 40, 29, 40, 33, 34, 32, 7, 30, 17,
				20, 43, 19, 61, 37, 36, 20, 19, 20, 64, 14, 40, 18, 58, 43, 54, 1, 23, 39, 34, 12, 42, 40, 11, 15, 6,
				39, 13, 12, 30, 12, 54, 63, 21, 10, 27, 24, 9, 22, 59, 29, 10, 31, 64, 15, 44, 41, 20, 32, 19, 45, 65,
				6, 61, 46, 44, 58, 7, 18, 49, 31, 63, 7, 41, 0, 49, 15, 6, 13, 35, 58, 43, 65, 16, 61, 45, 13, 46, 50,
				8, 61, 18, 17, 56, 50, 9, 36, 9, 7, 0, 30, 21, 45, 56, 53, 12, 54, 44, 47, 61, 34, 36, 28, 8, 44, 27,
				14, 6, 61, 19, 13, 21, 1, 15, 63, 28, 20, 50, 26, 65, 41, 45, 23, 39, 55, 32, 44, 4, 49, 7, 30, 8, 9, 5,
				33, 55, 26, 19, 29, 47, 57, 40, 15, 43, 2, 36, 18, 5, 35, 6, 35, 45, 14, 1, 35, 28, 27, 6, 4, 10, 47,
				50, 58, 12, 53, 42, 17, 46, 19, 17, 12, 55, 65, 39, 61, 16, 30, 63, 33, 8, 14, 28, 63, 27, 11, 52, 5, 59, 40,
				1, 22, 25, 12, 8, 64, 45, 50, 3, 31, 56, 15, 49, 27, 31, 65, 10, 1, 32, 44, 20, 47, 23, 17, 24, 36, 35,
				40, 41, 12, 64, 7, 25, 29, 5, 21, 8, 55, 36, 62, 33, 12, 24, 62, 65, 51, 59, 65, 17, 53, 3, 54, 56, 31,
				35, 56, 3, 22, 23, 57, 5, 40, 53, 60, 2, 55, 59, 64, 2, 48, 45, 28, 40, 47, 7, 37, 18, 62, 57, 43, 32,
				40, 11, 18, 39, 6, 0, 6, 9, 11, 24, 11, 18, 6, 16, 58, 19, 61, 64, 30, 63, 59, 30, 16, 46, 40, 19, 1,
				59, 38, 64, 22, 35, 34, 53, 60, 21, 16, 28, 39, 30, 55, 13, 28, 10, 0, 55, 35, 38, 61, 60, 43, 61, 64,
				57, 50, 60, 52, 36, 52, 30, 35, 5, 14, 11, 25, 9, 55, 62, 11, 20, 17, 2, 8, 33, 25, 55, 48, 58, 16, 21,
				51, 52, 38, 13, 11, 40, 27, 47, 49, 56, 57, 59, 21, 57, 10, 54, 15, 40, 29, 40, 33, 34, 32, 7, 30, 17,
				20, 43, 19, 61, 37, 36, 20, 19, 20, 64, 14, 40, 18, 58, 43, 54, 1, 23, 39, 34, 12, 42, 40, 11, 15, 6,
				39, 13, 12, 30, 12, 54, 63, 21, 10, 27, 24, 9, 22, 59, 29, 10, 31, 64, 15, 44, 41, 20, 32, 19, 45, 65,
				6, 61, 46, 44, 58, 7, 18, 49, 31, 63, 7, 41, 0, 49, 15, 6, 13, 35, 58, 43, 65, 16, 61, 45, 13, 46, 50,
				8, 61, 18, 17, 56, 50, 9, 36, 9, 7, 0, 30, 21, 45, 56, 53, 12, 54, 44, 47, 61, 34, 36, 28, 8, 44, 27,
				14, 6, 61, 19, 13, 21, 1, 15, 63, 28, 20, 50, 26, 65, 41, 45, 23, 39, 55, 32, 44, 4, 49, 7, 30, 8, 9, 5,
				33, 55, 26, 19, 29, 47, 57, 40, 15, 43, 2, 36, 18, 5, 35, 6, 35, 45, 14, 1, 35, 28, 27, 6, 4, 10, 47,
				50, 58, 12, 53, 42, 17, 46, 19, 17, 12, 55 });
		long endTime = System.nanoTime();

		long totalTime = endTime - startTime;

		System.out.println(totalTime);

		assertEquals(25458, x);
		assertTimeLessThan(totalTime, 300000);
	}

	@Test
	void test3()
			throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		this.alpha = initialize();
		long startTime = System.nanoTime();
		// Array of length 1000
		int x = (int) alpha.invoke(null,
				new int[] { 43, 27, 65, 36, 55, 12, 19, 52, 36, 14, 41, 46, 40, 54, 38, 12, 42, 18, 35, 27, 37, 29, 22,
						54, 21, 5, 19, 55, 38, 8, 1, 61, 61, 10, 5, 25, 28, 4, 13, 7, 21, 61, 18, 34, 1, 56, 28, 49, 7,
						38, 43, 34, 34, 61, 61, 22, 38, 6, 50, 48, 58, 42, 21, 16, 0, 52, 13, 63, 57, 58, 35, 8, 30, 10,
						10, 1, 33, 53, 53, 10, 52, 53, 44, 24, 65, 61, 23, 28, 30, 0, 60, 63, 5, 13, 59, 62, 31, 33, 6,
						24, 19, 59, 23, 63, 34, 1, 41, 56, 4, 51, 2, 43, 47, 45, 58, 62, 2, 30, 6, 25, 35, 4, 36, 2, 1,
						7, 56, 35, 21, 2, 44, 29, 10, 26, 10, 20, 29, 12, 62, 52, 21, 33, 44, 62, 7, 56, 25, 32, 46, 21,
						29, 50, 7, 33, 14, 15, 52, 9, 28, 42, 12, 23, 19, 46, 22, 2, 22, 43, 46, 13, 56, 65, 43, 43, 10,
						22, 17, 59, 23, 30, 0, 49, 44, 61, 8, 52, 9, 53, 0, 29, 6, 57, 2, 14, 50, 57, 19, 64, 31, 30,
						29, 5, 46, 24, 17, 12, 65, 57, 62, 22, 28, 3, 55, 2, 36, 4, 31, 47, 13, 5, 24, 43, 30, 16, 61,
						41, 48, 2, 37, 48, 17, 52, 2, 63, 7, 12, 7, 10, 54, 12, 65, 47, 31, 1, 30, 38, 20, 38, 35, 58,
						21, 38, 10, 54, 61, 6, 1, 25, 8, 57, 46, 44, 9, 61, 54, 2, 53, 47, 41, 10, 13, 1, 7, 0, 21, 48,
						51, 43, 2, 5, 28, 4, 34, 38, 55, 0, 13, 4, 32, 50, 39, 47, 43, 27, 57, 10, 21, 58, 3, 65, 64, 5,
						23, 45, 60, 59, 8, 52, 15, 23, 57, 23, 9, 1, 53, 22, 54, 62, 56, 48, 51, 42, 27, 33, 55, 42, 45,
						41, 23, 45, 0, 61, 6, 56, 24, 5, 29, 38, 13, 24, 21, 24, 13, 21, 25, 44, 12, 12, 43, 27, 65, 36, 55, 12, 19, 52, 36, 14, 41, 46, 40, 54, 38, 12, 42, 18, 35, 27, 37, 29, 22,
						54, 21, 5, 19, 55, 38, 8, 1, 61, 61, 10, 5, 25, 28, 4, 13, 7, 21, 61, 18, 34, 1, 56, 28, 49, 7,
						38, 43, 34, 34, 61, 61, 22, 38, 6, 50, 48, 58, 42, 21, 16, 0, 52, 13, 63, 57, 58, 35, 8, 30, 10,
						10, 1, 33, 53, 53, 10, 52, 53, 44, 24, 65, 61, 23, 28, 30, 0, 60, 63, 5, 13, 59, 62, 31, 33, 6,
						24, 19, 59, 23, 63, 34, 1, 41, 56, 4, 51, 2, 43, 47, 45, 58, 62, 2, 30, 6, 25, 35, 4, 36, 2, 1,
						7, 56, 35, 21, 2, 44, 29, 10, 26, 10, 20, 29, 12, 62, 52, 21, 33, 44, 62, 7, 56, 25, 32, 46, 21,
						29, 50, 7, 33, 14, 15, 52, 9, 28, 42, 12, 23, 19, 46, 22, 2, 22, 43, 46, 13, 56, 65, 43, 43, 10,
						22, 17, 59, 23, 30, 0, 49, 44, 61, 8, 52, 9, 53, 0, 29, 6, 57, 2, 14, 50, 57, 19, 64, 31, 30,
						29, 5, 46, 24, 17, 12, 65, 57, 62, 22, 28, 3, 55, 2, 36, 4, 31, 47, 13, 5, 24, 43, 30, 16, 61,
						41, 48, 2, 37, 48, 17, 52, 2, 63, 7, 12, 7, 10, 54, 12, 65, 47, 31, 1, 30, 38, 20, 38, 35, 58,
						21, 38, 10, 54, 61, 6, 1, 25, 8, 57, 46, 44, 9, 61, 54, 2, 53, 47, 41, 10, 13, 1, 7, 0, 21, 48,
						51, 43, 2, 5, 28, 4, 34, 38, 55, 0, 13, 4, 32, 50, 39, 47, 43, 27, 57, 10, 21, 58, 3, 65, 64, 5,
						23, 45, 60, 59, 8, 52, 15, 23, 57, 23, 9, 1, 53, 22, 54, 62, 56, 48, 51, 42, 27, 33, 55, 42, 45,
						41, 23, 45, 0, 61, 6, 56, 24, 5, 29, 38, 13, 24, 21, 24, 13, 21, 25, 44, 12, 12, 43, 27, 65, 36, 55, 12, 19, 52, 36, 14, 41, 46, 40, 54, 38, 12, 42, 18, 35, 27, 37, 29, 22,
						54, 21, 5, 19, 55, 38, 8, 1, 61, 61, 10, 5, 25, 28, 4, 13, 7, 21, 61, 18, 34, 1, 56, 28, 49, 7,
						38, 43, 34, 34, 61, 61, 22, 38, 6, 50, 48, 58, 42, 21, 16, 0, 52, 13, 63, 57, 58, 35, 8, 30, 10,
						10, 1, 33, 53, 53, 10, 52, 53, 44, 24, 65, 61, 23, 28, 30, 0, 60, 63, 5, 13, 59, 62, 31, 33, 6,
						24, 19, 59, 23, 63, 34, 1, 41, 56, 4, 51, 2, 43, 47, 45, 58, 62, 2, 30, 6, 25, 35, 4, 36, 2, 1,
						7, 56, 35, 21, 2, 44, 29, 10, 26, 10, 20, 29, 12, 62, 52, 21, 33, 44, 62, 7, 56, 25, 32, 46, 21,
						29, 50, 7, 33, 14, 15, 52, 9, 28, 42, 12, 23, 19, 46, 22, 2, 22, 43, 46, 13, 56, 65, 43, 43, 10,
						22, 17, 59, 23, 30, 0, 49, 44, 61, 8, 52, 9, 53, 0, 29, 6, 57, 2, 14, 50, 57, 19, 64, 31, 30,
						29, 5, 46, 24, 17, 12, 65, 57, 62, 22, 28, 3, 55, 2, 36, 4, 31, 47, 13, 5, 24, 43, 30, 16, 61,
						41, 48, 2, 37, 48, 17, 52, 2, 63, 7, 12, 7, 10, 54, 12, 65, 47, 31, 1, 30, 38, 20, 38, 35, 58,
						21, 38, 10, 54, 61, 6, 1, 25, 8, 57, 46, 44, 9, 61, 54, 2, 53, 47, 41, 10, 13, 1, 7, 0, 21, 48,
						51, 43, 2, 5, 28, 4, 34, 38, 55, 0, 13, 4, 32, 50, 39, 47, 43, 27, 57, 10, 21, 58, 3, 65, 64, 5,
						23, 45, 60, 59, 8, 52, 15, 23, 57, 23, 9, 1, 53, 22, 54, 62, 56, 48, 51, 42, 27, 33, 55, 42, 45,
						41, 23, 45, 0, 61, 6, 56, 24, 5, 29, 38, 13, 24, 21, 24, 13, 21, 25, 44, 12, 12, 43, 27, 65, 36, 55, 12, 19, 52, 36, 14, 41, 46, 40, 54, 38, 12, 42, 18, 35, 27, 37, 29, 22,
						54, 21, 5, 19, 55, 38, 8, 1, 61, 61, 10, 5, 25, 28, 4, 13, 7, 21, 61, 18, 34, 1, 56, 28, 49, 7,
						38, 43, 34, 34, 61, 61, 22, 38, 6, 50, 48, 58, 42, 21, 16, 0, 52, 13, 63, 57, 58, 35, 8, 30, 10,
						10, 1, 33, 53, 53, 10, 52, 53, 44, 24, 65, 61, 23, 28, 30, 0, 60, 63, 5, 13, 59, 62, 31, 33, 6,
						24, 19, 59, 23, 63, 34, 1, 41, 56, 4, 51, 2, 43, 47, 45, 58, 62, 2, 30, 6, 25, 35, 4, 36, 2, 1,
						7, 56, 35, 21, 2, 44, 29, 10, 26, 10, 20, 29, 12, 62, 52, 21, 33, 44, 62, 7, 56, 25, 32, 46, 21,
						29, 50, 7, 33, 14, 15, 52, 9, 28, 42, 12, 23, 19, 46, 22, 2, 22, 43, 46, 13, 56, 65, 43, 43, 10,
						22, 17, 59, 23, 30, 0, 49, 44, 61, 8, 52, 9, 53, 0, 29, 6, 57, 2, 14, 50, 57, 19, 64, 31, 30,
						29, 5, 46, 24, 17, 12, 65, 57, 62, 22, 28, 3, 55, 2, 36, 4, 31, 47, 13, 5, 24, 43, 30, 16, 61,
						41, 48, 2, 37, 48, 17, 52, 2, 63, 7, 12, 7, 10, 54, 12, 65, 47, 31, 1, 30, 38, 20, 38, 35, 58,
						21, 38, 10, 54, 61, 6, 1, 25, 8, 57, 46, 44, 9, 61, 54, 2, 53, 47, 41, 10, 13, 1, 7, 0, 21, 48,
						51, 43, 2, 5, 28, 4, 34, 38, 55, 0, 13, 4, 32, 50, 39, 47, 43, 27, 57, 10, 21, 58, 3, 65, 64, 5,
						23, 45, 60, 59, 8, 52, 15, 23, 57, 23, 9, 1, 53, 22, 54, 62, 56, 48, 51, 42, 27, 33, 55, 42, 45,
						41, 23, 45, 0, 61, 6, 56, 24, 5, 29, 38, 13, 24, 21, 24, 13, 21, 25, 44, 12, 12 });
		long endTime = System.nanoTime();

		long totalTime = endTime - startTime;

		System.out.println(totalTime);

		assertEquals(22855, x);
		assertTimeLessThan(totalTime, 300000);
	}

	@Test
	void test4()
			throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		this.alpha = initialize();
		long startTime = System.nanoTime();
		// Array of length 1000
		int x = (int) alpha.invoke(null, new int[] { 31, 33, 56, 26, 50, 2, 14, 43, 57, 35, 3, 37, 14, 21, 20, 55, 42,
				24, 13, 59, 52, 23, 57, 64, 4, 38, 52, 64, 9, 34, 25, 64, 17, 55, 10, 3, 14, 20, 61, 57, 19, 33, 35, 13,
				56, 18, 17, 24, 54, 1, 39, 18, 12, 33, 16, 31, 48, 9, 38, 23, 31, 12, 32, 46, 10, 54, 59, 34, 39, 59,
				16, 41, 51, 36, 50, 15, 33, 12, 28, 33, 26, 15, 56, 27, 3, 24, 57, 1, 9, 39, 23, 53, 62, 65, 39, 60, 32,
				29, 57, 24, 49, 24, 34, 21, 32, 26, 3, 39, 48, 14, 9, 47, 53, 34, 1, 10, 43, 63, 63, 38, 9, 5, 64, 64,
				63, 58, 58, 42, 65, 61, 33, 20, 33, 36, 62, 27, 61, 4, 57, 3, 37, 37, 55, 30, 51, 0, 12, 28, 4, 61, 40,
				44, 41, 52, 21, 31, 56, 60, 49, 9, 44, 63, 30, 7, 57, 56, 61, 2, 27, 39, 14, 2, 11, 55, 14, 34, 6, 29,
				6, 43, 4, 50, 63, 9, 51, 63, 8, 63, 8, 26, 57, 22, 65, 47, 34, 63, 1, 22, 4, 1, 28, 37, 19, 62, 23, 6,
				10, 0, 4, 62, 25, 39, 44, 57, 8, 6, 24, 48, 43, 29, 39, 55, 49, 46, 53, 3, 31, 33, 56, 26, 50, 2, 14, 43, 57, 35, 3, 37, 14, 21, 20, 55, 42,
				24, 13, 59, 52, 23, 57, 64, 4, 38, 52, 64, 9, 34, 25, 64, 17, 55, 10, 3, 14, 20, 61, 57, 19, 33, 35, 13,
				56, 18, 17, 24, 54, 1, 39, 18, 12, 33, 16, 31, 48, 9, 38, 23, 31, 12, 32, 46, 10, 54, 59, 34, 39, 59,
				16, 41, 51, 36, 50, 15, 33, 12, 28, 33, 26, 15, 56, 27, 3, 24, 57, 1, 9, 39, 23, 53, 62, 65, 39, 60, 32,
				29, 57, 24, 49, 24, 34, 21, 32, 26, 3, 39, 48, 14, 9, 47, 53, 34, 1, 10, 43, 63, 63, 38, 9, 5, 64, 64,
				63, 58, 58, 42, 65, 61, 33, 20, 33, 36, 62, 27, 61, 4, 57, 3, 37, 37, 55, 30, 51, 0, 12, 28, 4, 61, 40,
				44, 41, 52, 21, 31, 56, 60, 49, 9, 44, 63, 30, 7, 57, 56, 61, 2, 27, 39, 14, 2, 11, 55, 14, 34, 6, 29,
				6, 43, 4, 50, 63, 9, 51, 63, 8, 63, 8, 26, 57, 22, 65, 47, 34, 63, 1, 22, 4, 1, 28, 37, 19, 62, 23, 6,
				10, 0, 4, 62, 25, 39, 44, 57, 8, 6, 24, 48, 43, 29, 39, 55, 49, 46, 53, 3, 31, 33, 56, 26, 50, 2, 14, 43, 57, 35, 3, 37, 14, 21, 20, 55, 42,
				24, 13, 59, 52, 23, 57, 64, 4, 38, 52, 64, 9, 34, 25, 64, 17, 55, 10, 3, 14, 20, 61, 57, 19, 33, 35, 13,
				56, 18, 17, 24, 54, 1, 39, 18, 12, 33, 16, 31, 48, 9, 38, 23, 31, 12, 32, 46, 10, 54, 59, 34, 39, 59,
				16, 41, 51, 36, 50, 15, 33, 12, 28, 33, 26, 15, 56, 27, 3, 24, 57, 1, 9, 39, 23, 53, 62, 65, 39, 60, 32,
				29, 57, 24, 49, 24, 34, 21, 32, 26, 3, 39, 48, 14, 9, 47, 53, 34, 1, 10, 43, 63, 63, 38, 9, 5, 64, 64,
				63, 58, 58, 42, 65, 61, 33, 20, 33, 36, 62, 27, 61, 4, 57, 3, 37, 37, 55, 30, 51, 0, 12, 28, 4, 61, 40,
				44, 41, 52, 21, 31, 56, 60, 49, 9, 44, 63, 30, 7, 57, 56, 61, 2, 27, 39, 14, 2, 11, 55, 14, 34, 6, 29,
				6, 43, 4, 50, 63, 9, 51, 63, 8, 63, 8, 26, 57, 22, 65, 47, 34, 63, 1, 22, 4, 1, 28, 37, 19, 62, 23, 6,
				10, 0, 4, 62, 25, 39, 44, 57, 8, 6, 24, 48, 43, 29, 39, 55, 49, 46, 53, 3, 31, 33, 56, 26, 50, 2, 14, 43, 57, 35, 3, 37, 14, 21, 20, 55, 42,
				24, 13, 59, 52, 23, 57, 64, 4, 38, 52, 64, 9, 34, 25, 64, 17, 55, 10, 3, 14, 20, 61, 57, 19, 33, 35, 13,
				56, 18, 17, 24, 54, 1, 39, 18, 12, 33, 16, 31, 48, 9, 38, 23, 31, 12, 32, 46, 10, 54, 59, 34, 39, 59,
				16, 41, 51, 36, 50, 15, 33, 12, 28, 33, 26, 15, 56, 27, 3, 24, 57, 1, 9, 39, 23, 53, 62, 65, 39, 60, 32,
				29, 57, 24, 49, 24, 34, 21, 32, 26, 3, 39, 48, 14, 9, 47, 53, 34, 1, 10, 43, 63, 63, 38, 9, 5, 64, 64,
				63, 58, 58, 42, 65, 61, 33, 20, 33, 36, 62, 27, 61, 4, 57, 3, 37, 37, 55, 30, 51, 0, 12, 28, 4, 61, 40,
				44, 41, 52, 21, 31, 56, 60, 49, 9, 44, 63, 30, 7, 57, 56, 61, 2, 27, 39, 14, 2, 11, 55, 14, 34, 6, 29,
				6, 43, 4, 50, 63, 9, 51, 63, 8, 63, 8, 26, 57, 22, 65, 47, 34, 63, 1, 22, 4, 1, 28, 37, 19, 62, 23, 6,
				10, 0, 4, 62, 25, 39, 44, 57, 8, 6, 24, 48, 43, 29, 39, 55, 49, 46, 53, 3, 31, 33, 56, 26, 50, 2, 14, 43, 57, 35, 3, 37, 14, 21, 20, 55, 42,
				24, 13, 59, 52, 23, 57, 64, 4, 38, 52, 64, 9, 34, 25, 64, 17, 55, 10, 3, 14, 20, 61, 57, 19, 33, 35, 13,
				56, 18, 17, 24, 54, 1, 39, 18, 12, 33, 16, 31, 48, 9, 38, 23, 31, 12, 32, 46, 10, 54, 59, 34, 39, 59,
				16, 41, 51, 36, 50, 15, 33, 12, 28, 33, 26, 15, 56, 27, 3, 24, 57, 1, 9, 39, 23, 53, 62, 65, 39, 60, 32,
				29, 57, 24, 49, 24, 34, 21, 32, 26, 3, 39, 48, 14, 9, 47, 53, 34, 1, 10, 43, 63, 63, 38, 9, 5, 64, 64,
				63, 58, 58, 42, 65, 61, 33, 20, 33, 36, 62, 27, 61, 4, 57, 3, 37, 37, 55, 30, 51, 0, 12, 28, 4, 61, 40,
				44, 41, 52, 21, 31, 56, 60, 49, 9, 44, 63, 30, 7, 57, 56, 61, 2, 27, 39, 14, 2, 11, 55, 14, 34, 6, 29,
				6, 43, 4, 50, 63, 9, 51, 63, 8, 63, 8, 26, 57, 22, 65, 47, 34, 63, 1, 22, 4, 1, 28, 37, 19, 62, 23, 6,
				10, 0, 4, 62, 25, 39, 44, 57, 8, 6, 24, 48, 43, 29, 39, 55, 49, 46, 53, 3, 31, 33, 56, 26, 50, 2, 14, 43, 57, 35, 3, 37, 14, 21, 20, 55, 42,
				24, 13, 59, 52, 23, 57, 64, 4, 38, 52, 64, 9, 34, 25, 64, 17, 55, 10, 3, 14, 20, 61, 57, 19, 33, 35, 13,
				56, 18, 17, 24, 54, 1, 39, 18, 12, 33, 16, 31, 48, 9, 38, 23, 31, 12, 32, 46, 10, 54, 59, 34, 39, 59,
				16, 41, 51, 36, 50, 15, 33, 12, 28, 33, 26, 15, 56, 27, 3, 24, 57, 1, 9, 39, 23, 53, 62, 65, 39, 60, 32,
				29, 57, 24, 49, 24, 34, 21, 32, 26, 3, 39, 48, 14, 9, 47, 53, 34, 1, 10, 43, 63, 63, 38, 9, 5, 64, 64,
				63, 58, 58, 42, 65, 61, 33, 20, 33, 36, 62, 27, 61, 4, 57, 3, 37, 37, 55, 30, 51, 0, 12, 28, 4, 61, 40,
				44, 41, 52, 21, 31, 56, 60, 49, 9, 44, 63, 30, 7, 57, 56, 61, 2, 27, 39, 14, 2, 11, 55, 14, 34, 6, 29,
				6, 43, 4, 50, 63, 9, 51, 63, 8, 63, 8, 26, 57, 22, 65, 47, 34, 63, 1, 22, 4, 1, 28, 37, 19, 62, 23, 6,
				10, 0, 4, 62, 25, 39, 44, 57, 8, 6, 24, 48, 43, 29, 39, 55, 49, 46, 53, 3 });
		long endTime = System.nanoTime();

		long totalTime = endTime - startTime;

		System.out.println(totalTime);

		assertEquals(23182, x);
		assertTimeLessThan(totalTime, 300000);
	}

	@Test
	void test5()
			throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		this.alpha = initialize();
		long startTime = System.nanoTime();
		// Array of length 1000
		int x = (int) alpha.invoke(null, new int[] { 6, 43, 54, 41, 35, 59, 13, 61, 59, 43, 32, 33, 65, 53, 33, 3, 54,
				14, 29, 59, 25, 9, 35, 35, 21, 52, 13, 57, 6, 46, 3, 37, 37, 35, 6, 29, 39, 10, 31, 9, 20, 21, 2, 64,
				26, 21, 39, 54, 59, 52, 7, 29, 33, 63, 40, 16, 32, 13, 47, 57, 43, 17, 63, 2, 52, 17, 4, 20, 51, 1, 38,
				61, 58, 50, 0, 39, 23, 62, 24, 19, 31, 13, 56, 2, 26, 64, 29, 12, 48, 61, 25, 34, 50, 40, 33, 42, 59,
				52, 52, 16, 0, 22, 45, 48, 46, 30, 40, 24, 47, 55, 47, 3, 8, 59, 31, 58, 55, 1, 38, 10, 31, 7, 65, 12,
				50, 31, 31, 12, 13, 5, 61, 43, 56, 18, 33, 32, 48, 18, 19, 23, 30, 41, 58, 56, 45, 54, 2, 53, 6, 34, 7,
				37, 4, 0, 29, 26, 3, 62, 6, 33, 39, 61, 50, 60, 29, 55, 41, 46, 17, 52, 24, 3, 5, 31, 43, 33, 0, 26, 4,
				53, 5, 14, 47, 6, 6, 26, 51, 64, 43, 56, 19, 34, 60, 2, 58, 42, 47, 23, 27, 5, 51, 14, 54, 54, 52, 21,
				21, 5, 51, 34, 12, 58, 27, 30, 61, 52, 34, 65, 28, 62, 56, 14, 6, 51, 7, 14, 16, 2, 2, 6, 44, 27, 47, 1,
				54, 53, 51, 58, 64, 44, 36, 53, 47, 19, 37, 23, 26, 2, 50, 3, 52, 53, 43, 6, 13, 57, 58, 20, 9, 23, 7,
				8, 9, 29, 27, 58, 48, 48, 0, 43, 31, 29, 23, 52, 47, 43, 7, 18, 23, 51, 62, 5, 7, 1, 1, 25, 11, 11, 49,
				45, 35, 17, 39, 33, 29, 2, 39, 11, 26, 56, 32, 29, 51, 43, 59, 32, 26, 14, 1, 64, 11, 5, 14, 56, 54, 59,
				6, 14, 27, 34, 32, 14, 39, 42, 49, 18, 32, 39, 50, 1, 46, 54, 52, 5, 27, 1, 20, 18, 0, 25, 8, 28, 54,
				33, 54, 13, 48, 58, 53, 33, 64, 21, 48, 0, 7, 64, 0, 10, 20, 27, 10, 1, 7, 57, 42, 33, 18, 13, 51, 7,
				58, 6, 23, 58, 35, 31, 28, 35, 16, 54, 18, 15, 55, 6, 27, 2, 65, 6, 43, 54, 41, 35, 59, 13, 61, 59, 43, 32, 33, 65, 53, 33, 3, 54,
				14, 29, 59, 25, 9, 35, 35, 21, 52, 13, 57, 6, 46, 3, 37, 37, 35, 6, 29, 39, 10, 31, 9, 20, 21, 2, 64,
				26, 21, 39, 54, 59, 52, 7, 29, 33, 63, 40, 16, 32, 13, 47, 57, 43, 17, 63, 2, 52, 17, 4, 20, 51, 1, 38,
				61, 58, 50, 0, 39, 23, 62, 24, 19, 31, 13, 56, 2, 26, 64, 29, 12, 48, 61, 25, 34, 50, 40, 33, 42, 59,
				52, 52, 16, 0, 22, 45, 48, 46, 30, 40, 24, 47, 55, 47, 3, 8, 59, 31, 58, 55, 1, 38, 10, 31, 7, 65, 12,
				50, 31, 31, 12, 13, 5, 61, 43, 56, 18, 33, 32, 48, 18, 19, 23, 30, 41, 58, 56, 45, 54, 2, 53, 6, 34, 7,
				37, 4, 0, 29, 26, 3, 62, 6, 33, 39, 61, 50, 60, 29, 55, 41, 46, 17, 52, 24, 3, 5, 31, 43, 33, 0, 26, 4,
				53, 5, 14, 47, 6, 6, 26, 51, 64, 43, 56, 19, 34, 60, 2, 58, 42, 47, 23, 27, 5, 51, 14, 54, 54, 52, 21,
				21, 5, 51, 34, 12, 58, 27, 30, 61, 52, 34, 65, 28, 62, 56, 14, 6, 51, 7, 14, 16, 2, 2, 6, 44, 27, 47, 1,
				54, 53, 51, 58, 64, 44, 36, 53, 47, 19, 37, 23, 26, 2, 50, 3, 52, 53, 43, 6, 13, 57, 58, 20, 9, 23, 7,
				8, 9, 29, 27, 58, 48, 48, 0, 43, 31, 29, 23, 52, 47, 43, 7, 18, 23, 51, 62, 5, 7, 1, 1, 25, 11, 11, 49,
				45, 35, 17, 39, 33, 29, 2, 39, 11, 26, 56, 32, 29, 51, 43, 59, 32, 26, 14, 1, 64, 11, 5, 14, 56, 54, 59,
				6, 14, 27, 34, 32, 14, 39, 42, 49, 18, 32, 39, 50, 1, 46, 54, 52, 5, 27, 1, 20, 18, 0, 25, 8, 28, 54,
				33, 54, 13, 48, 58, 53, 33, 64, 21, 48, 0, 7, 64, 0, 10, 20, 27, 10, 1, 7, 57, 42, 33, 18, 13, 51, 7,
				58, 6, 23, 58, 35, 31, 28, 35, 16, 54, 18, 15, 55, 6, 27, 2, 65, 6, 43, 54, 41, 35, 59, 13, 61, 59, 43, 32, 33, 65, 53, 33, 3, 54,
				14, 29, 59, 25, 9, 35, 35, 21, 52, 13, 57, 6, 46, 3, 37, 37, 35, 6, 29, 39, 10, 31, 9, 20, 21, 2, 64,
				26, 21, 39, 54, 59, 52, 7, 29, 33, 63, 40, 16, 32, 13, 47, 57, 43, 17, 63, 2, 52, 17, 4, 20, 51, 1, 38,
				61, 58, 50, 0, 39, 23, 62, 24, 19, 31, 13, 56, 2, 26, 64, 29, 12, 48, 61, 25, 34, 50, 40, 33, 42, 59,
				52, 52, 16, 0, 22, 45, 48, 46, 30, 40, 24, 47, 55, 47, 3, 8, 59, 31, 58, 55, 1, 38, 10, 31, 7, 65, 12,
				50, 31, 31, 12, 13, 5, 61, 43, 56, 18, 33, 32, 48, 18, 19, 23, 30, 41, 58, 56, 45, 54, 2, 53, 6, 34, 7,
				37, 4, 0, 29, 26, 3, 62, 6, 33, 39, 61, 50, 60, 29, 55, 41, 46, 17, 52, 24, 3, 5, 31, 43, 33, 0, 26, 4,
				53, 5, 14, 47, 6, 6, 26, 51, 64, 43, 56, 19, 34, 60, 2, 58, 42, 47, 23, 27, 5, 51, 14, 54, 54, 52, 21,
				21, 5, 51, 34, 12, 58, 27, 30, 61, 52, 34, 65, 28, 62, 56, 14, 6, 51, 7, 14, 16, 2, 2, 6, 44, 27, 47, 1,
				54, 53, 51, 58, 64, 44, 36, 53, 47, 19, 37, 23, 26, 2, 50, 3, 52, 53, 43, 6, 13, 57, 58, 20, 9, 23, 7,
				8, 9, 29, 27, 58, 48, 48, 0, 43, 31, 29, 23, 52, 47, 43, 7, 18, 23, 51, 62, 5, 7, 1, 1, 25, 11, 11, 49,
				45, 35, 17, 39, 33, 29, 2, 39, 11, 26, 56, 32, 29, 51, 43, 59, 32, 26, 14, 1, 64, 11, 5, 14, 56, 54, 59,
				6, 14, 27, 34, 32, 14, 39, 42, 49, 18, 32, 39, 50, 1, 46, 54, 52, 5, 27, 1, 20, 18, 0, 25, 8, 28, 54,
				33, 54, 13, 48, 58, 53, 33, 64, 21, 48, 0, 7, 64, 0, 10, 20, 27, 10, 1, 7, 57, 42, 33, 18, 13, 51, 7,
				58, 6, 23, 58, 35, 31, 28, 35, 16, 54, 18, 15, 55, 6, 27, 2, 65, 6, 43, 54, 41, 35, 59, 13, 61, 59, 43, 32, 33, 65, 53, 33, 3, 54,
				14, 29, 59, 25, 9, 35, 35, 21, 52, 13, 57, 6, 46, 3, 37, 37, 35, 6, 29, 39, 10, 31, 9, 20, 21, 2, 64,
				26, 21, 39, 54, 59, 52, 7, 29, 33, 63, 40, 16, 32, 13, 47, 57, 43, 17, 63, 2, 52, 17, 4, 20, 51, 1, 38,
				61, 58, 50, 0, 39, 23, 62, 24, 19, 31, 13, 56, 2, 26, 64, 29, 12, 48, 61, 25, 34, 50, 40, 33, 42, 59,
				52, 52, 16, 0, 22, 45, 48, 46, 30, 40, 24, 47, 55, 47, 3, 8, 59, 31, 58, 55, 1, 38, 10, 31, 7, 65, 12,
				50, 31, 31, 12, 13, 5, 61, 43, 56, 18, 33, 32, 48, 18, 19, 23, 30, 41, 58, 56, 45, 54, 2, 53, 6, 34, 7,
				37, 4, 0, 29, 26, 3, 62, 6, 33, 39, 61, 50, 60, 29, 55, 41, 46, 17, 52, 24, 3, 5, 31, 43, 33, 0, 26, 4,
				53, 5, 14, 47, 6, 6, 26, 51, 64, 43, 56, 19, 34, 60, 2, 58, 42, 47, 23, 27, 5, 51, 14, 54, 54, 52, 21,
				21, 5, 51, 34, 12, 58, 27, 30, 61, 52, 34, 65, 28, 62, 56, 14, 6, 51, 7, 14, 16, 2, 2, 6, 44, 27, 47, 1,
				54, 53, 51, 58, 64, 44, 36, 53, 47, 19, 37, 23, 26, 2, 50, 3, 52, 53, 43, 6, 13, 57, 58, 20, 9, 23, 7,
				8, 9, 29, 27, 58, 48, 48, 0, 43, 31, 29, 23, 52, 47, 43, 7, 18, 23, 51, 62, 5, 7, 1, 1, 25, 11, 11, 49,
				45, 35, 17, 39, 33, 29, 2, 39, 11, 26, 56, 32, 29, 51, 43, 59, 32, 26, 14, 1, 64, 11, 5, 14, 56, 54, 59,
				6, 14, 27, 34, 32, 14, 39, 42, 49, 18, 32, 39, 50, 1, 46, 54, 52, 5, 27, 1, 20, 18, 0, 25, 8, 28, 54,
				33, 54, 13, 48, 58, 53, 33, 64, 21, 48, 0, 7, 64, 0, 10, 20, 27, 10, 1, 7, 57, 42, 33, 18, 13, 51, 7,
				58, 6, 23, 58, 35, 31, 28, 35, 16, 54, 18, 15, 55, 6, 27, 2, 65, 6, 43, 54, 41, 35, 59, 13, 61, 59, 43, 32, 33, 65, 53, 33, 3, 54,
				14, 29, 59, 25, 9, 35, 35, 21, 52, 13, 57, 6, 46, 3, 37, 37, 35, 6, 29, 39, 10, 31, 9, 20, 21, 2, 64,
				26, 21, 39, 54, 59, 52, 7, 29, 33, 63, 40, 16, 32, 13, 47, 57, 43, 17, 63, 2, 52, 17, 4, 20, 51, 1, 38,
				61, 58, 50, 0, 39, 23, 62, 24, 19, 31, 13, 56, 2, 26, 64, 29, 12, 48, 61, 25, 34, 50, 40, 33, 42, 59,
				52, 52, 16, 0, 22, 45, 48, 46, 30, 40, 24 });
		long endTime = System.nanoTime();

		long totalTime = endTime - startTime;

		System.out.println(totalTime);

		assertEquals(27182, x);
		assertTimeLessThan(totalTime, 300000);
	}

	void assertTimeLessThan(long totalTime, long expected) {
		assertTrue(totalTime < expected, "Time Limit Exceeded, your code ran in " + totalTime + " nanoseconds while expected was " + expected + " nanoseconds.");
		System.out.println("Test executed in " + totalTime + " nanoseconds and maximum allowed time is " + expected + " nanoseconds.");
	}

}
