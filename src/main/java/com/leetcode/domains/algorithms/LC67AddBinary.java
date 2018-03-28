
package com.leetcode.domains.algorithms;

public class LC67AddBinary {

	public static void main(String[] args) {
		Solution sol = new Solution();

		String a = args.length > 0 ? args[0] : null;
		String b = args.length > 1 ? args[1] : null;

		System.out.println(sol.addBinary(a, b));
	}

	static class Solution {

		private String trimLeadingZeroes(String a) {
			for (int i = 0; i < a.length(); ++i) {
				if (a.charAt(i) == '1') {
					return a.substring(i);
				}
			}
	
			return "0";
		}
	
		public String addBinary(String a, String b) {
			boolean carry = false;
			String newBin = "";
			char binA, binB, binC;
	
			int i = a.length() - 1;
			int j = b.length() - 1;
	
			for (; i >= 0 && j >= 0; --j, --i) {
				binA = a.charAt(i);
				binB = b.charAt(j);
	
				if (binA == '1' && binB == '1') {
					binC = carry == true ? '1' : '0';
					carry = true;
				} else if(binA == '1' || binB == '1') {
					binC = carry == true ? '0' : '1' ;
				} else if (carry) {
					binC = '1';
					carry = false;
				} else {
					binC = '0';
				}
	
				newBin = binC + newBin;
			}
	
			for (; i >= 0 && carry; --i) {
				binA = a.charAt(i);
	
				if (binA == '1') {
					binA = '0';
				} else {
					binA = '1';
					carry = false;
				}
	
				newBin = binA + newBin;
			}
	
			for (; j >= 0 && carry; --j) {
				binB = b.charAt(j);
	
				if (binB == '1') {
					binB = '0';
				} else {
					binB = '1';
					carry = false;
				}
	
				newBin = binB + newBin;
			}
	
			if (i >= 0) {
				newBin = a.substring(0, i + 1) + newBin;
			} else if (j >= 0) {
				newBin = b.substring(0, j + 1) + newBin;
			} else if (carry) {
				newBin = '1' + newBin;
			}
	
			return trimLeadingZeroes(newBin);
		}
	
	}	

}