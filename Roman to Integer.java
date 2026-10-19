class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int num = 0;
        for (int j = 0; j < s.length(); j++) {
            int current = map.get(s.charAt(j));
            if (j < s.length() - 1 &&
                current < map.get(s.charAt(j + 1))) {
                num -= current;
            } else {
                num += current;
            }
        }
        return num;
    }
}
