class Solution {
    public int compareVersion(String version1, String version2) {
        ArrayList<Integer> list1 = Arrays.stream(version1.split("\\."))
                                 .map(Integer::parseInt)
                                 .collect(Collectors.toCollection(ArrayList::new));


        ArrayList<Integer> list2 = Arrays.stream(version2.split("\\."))
                                 .map(Integer::parseInt)
                                 .collect(Collectors.toCollection(ArrayList::new));

        if(list2.size() < list1.size()){
            while(list2.size() != list1.size()) list2.add(0);
        }else if(list2.size() > list1.size()){
            while(list1.size() != list2.size()) list1.add(0);
        }


        for(int i =0; i< Math.min(list1.size(),list2.size()); i++){
            if(list1.get(i) < list2.get(i)) return -1;
            else if(list1.get(i) > list2.get(i)) return 1;
        }
        return 0;
    }
}

//or

import java.util.*;

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int maxLength = Math.max(v1.length, v2.length);
        
        for (int i = 0; i < maxLength; i++) {
            int num1 = (i < v1.length) ? Integer.parseInt(v1[i]) : 0;
            int num2 = (i < v2.length) ? Integer.parseInt(v2[i]) : 0;
            
            if (num1 < num2) return -1;
            if (num1 > num2) return 1;
            
        }
        
        return 0;
    }
}

