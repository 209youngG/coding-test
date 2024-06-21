
class Solution {
    
    public boolean isPalindrome(String s) {
		String filteredOriginString = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		String reverseString = new StringBuffer(filteredOriginString.toLowerCase()).reverse().toString();

		return filteredOriginString.equals(reverseString);
    }
}