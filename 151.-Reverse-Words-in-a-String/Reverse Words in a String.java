class Solution {
    public String reverseWords(String s) {

        StringBuilder sb = new StringBuilder(s);
        StringBuilder sb2 = new StringBuilder();

        while (sb.length() > 0 &&
               Character.isWhitespace(sb.charAt(sb.length() - 1))) {
            sb.setLength(sb.length() - 1);
        }

        int start = 0;

        while (start < sb.length() &&
               Character.isWhitespace(sb.charAt(start))) {
            start++;
        }

        if (start > 0) {
            sb.delete(0, start);
        }

        int j = sb.length() - 1;

        for (int i = sb.length() - 1; i >= 0; i--) {

            if (sb.charAt(i) == ' ') {

                sb2.append(sb.substring(i + 1, j + 1) + " ");

                while (i >= 0 && Character.isWhitespace(sb.charAt(i))) {
                    i--;
                }

                j = i;
            }
        }

        if (j >= 0) {
            sb2.append(sb.substring(0, j + 1));
        }

        return sb2.toString().trim();
    }
}
