public class Solution {
    public static int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (Runner.knows(candidate, i)) {
                candidate = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == candidate) {
                continue;
            }
            if (Runner.knows(candidate, i) ||
                !Runner.knows(i, candidate)) {
                return -1;
            }
        }
        return candidate;
    }
}

//or

import java.util.*;
import java.io.*;

public class Solution {
    public static int findCelebrity(int n) {
        for (int i = 0; i < n; i++) {
            boolean knowsSomeone = false;
            for (int j = 0; j < n; j++) {
                if (i != j && Runner.knows(i, j)) {
                    knowsSomeone = true;
                    break;
                }
            }

            if (!knowsSomeone) {
                boolean everyoneKnows = true;
                for (int j = 0; j < n; j++) {
                    if (i != j && !Runner.knows(j, i)) {
                        everyoneKnows = false;
                        break;
                    }
                }
                if (everyoneKnows) {
                    return i;
                }
            }
        }
        return -1;
    }
}
