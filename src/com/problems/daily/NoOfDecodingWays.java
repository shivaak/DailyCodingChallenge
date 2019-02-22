/**
 * @author shivaak on 21-Feb-2019
 *
 */
package com.problems.daily;

/**
 * @author shivaak on 21-Feb-2019
 * 
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

 * You can assume that the messages are decodable. For example, '001' is not allowed.
 *
 */
public class NoOfDecodingWays {

	/*
	 * @param k : last k letters of string
	 */
	public int countWays(char[] str, int k) {
		if(k==0) return 1;

		//starting letter of the sequence
		int s = str.length - k; 
		if(str[s]=='0') return 0;

		int n = countWays(str, k-1);

		if(k>=2) {
			int twoChars = (Character.getNumericValue(str[s]) * 10) + Character.getNumericValue(str[s+1]); 
			if(isValid(twoChars)){
				n = n + countWays(str, k-2);
			}
		}

		return n;


	}

	private Boolean isValid(int c) {
		if(c>=1 && c<=26) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String test = "12";
		NoOfDecodingWays obj = new NoOfDecodingWays();
		System.out.println(obj.countWays(test.toCharArray(), test.length()));
	}

}
