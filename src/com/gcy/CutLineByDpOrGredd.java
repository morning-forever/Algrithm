package com.gcy;

import java.math.BigInteger;

public class CutLineByDpOrGredd {

	public static void main(String[] args) {
		int length = 65;//2147483647
                          // 2124471432
		int result = matProductAfterCutting_1(length);
		BigInteger result2 = matProductAfterCutting_2(length);
		System.out.println(result);
		System.out.println(result2);
	}

	/**
	 * 贪婪算法
	 * 
	 * @param length
	 * @return
	 */
	private static BigInteger matProductAfterCutting_2(int length) {

		if (length < 2) {
			return BigInteger.valueOf(0);
		}
		if (length == 2) {
			return BigInteger.valueOf(1);
		}
		if (length == 3) {
			return BigInteger.valueOf(2);
		}
		// 当n>=5的时候，尽可能剪长度为3的绳子
		int timeOf3 = length / 3;
		// 当n=4的时候，剪成长度为2的两段
		if (length - timeOf3 * 3 == 1) {
			timeOf3 -= 1;
		}
		// 剪成长度为2的两段
		int timeOf2 = (length - timeOf3 * 3) / 2;
		BigInteger valueOf = BigInteger.valueOf(timeOf3);
		BigInteger valueOf2 = BigInteger.valueOf(timeOf2);
		BigInteger _3cf = ncf(valueOf, 3);
		BigInteger _2cf = ncf(valueOf2, 2);
		//BigInteger timeOf2 = BigInteger.valueOf(length).subtract(xxx);
		//BigInteger bi = BigInteger.valueOf(Math.pow(3, timeOf3));
		//return (int) () * (Math.pow(2, timeOf2)));
		//(int) ((Math.pow(3, timeOf3)) * (Math.pow(2, timeOf2)));
		return _3cf.multiply(_2cf);
	}

	public static BigInteger ncf(BigInteger b1,int l2) {
		BigInteger b = BigInteger.valueOf(1);
		for (int i =0; i<l2 ;i++) {
			b.multiply(b1);
		}
		return b;
	}
	
	/**
	 * 动态规划
	 * 
	 * @param length
	 * @return
	 */
	private static int matProductAfterCutting_1(int length) {

		if (length < 2) {
			return 0;
		}
		if (length == 2) {
			return 1;
		}
		if (length == 3) {
			return 2;
		}
		// 将最优解存储在数组中
		int[] products = new int[length + 1];
		// 数组中第i个元素表示把长度为i的绳子剪成若干段之后的乘积的最大值
		products[0] = 0;
		products[1] = 1;
		products[2] = 2;
		products[3] = 3;

		int max = 0;
		
		
		
		for (int i = 4; i <= length; i++) {
			max = 0;
			// 求出所有可能的f(j)*f(i-j)并比较出他们的最大值
			for (int j = 1; j <= i / 2; j++) {
				int product = products[j] * products[i - j];
				if (product > max) {
					System.out.println("["+i+"]"+j+","+(i-j));
					max = product;
				}
				products[i] = max;
			}
		}
		max = products[length];

		return max;
	}

}
