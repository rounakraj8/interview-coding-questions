import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Solution {

    /*
     * Complete the 'getSelectionStatus' function below.
     *
     * The function is expected to return a 2D_STRING_ARRAY.
     * The function accepts 2D_STRING_ARRAY applications as parameter.
     */

    public static final String SELECT = "SELECT";
    public static final String REJECT = "REJECT";
    public static final String NA = "NA";
    public static final String STRIKER = "STRIKER";
    public static final String DEFENDER = "DEFENDER";

    public static List<List<String>> getSelectionStatus(List<List<String>> applications) {
        List<List<String>> result = new ArrayList<>();
        List<List<String>> selected = new ArrayList<>();
        List<List<String>> rejected = new ArrayList<>();
        
        for (List<String> application : applications) {
            if (isEligibleForSelection(application)) {
                selected.add(application);
            } else {
                rejected.add(application);
            }
        }

        selected.sort((a, b) -> Double.compare(Double.parseDouble(a.get(4)), Double.parseDouble(b.get(4))));

        selected.sort((a, b) -> Double.compare(Double.parseDouble(b.get(3)), Double.parseDouble(a.get(3))));

        if(selected.size()%2!=0){
            rejected.add(selected.get(selected.size()/2));
            selected.remove(selected.size()/2);
        }

        for (int i=0; i<selected.size()/2; i++) {
            result.add(Arrays.asList(selected.get(i).get(0), SELECT, STRIKER));
        }

        for (int i=selected.size()/2; i<selected.size(); i++) {
            result.add(Arrays.asList(selected.get(i).get(0), SELECT, DEFENDER));
        }

        for (List<String> r : rejected) {
            result.add(Arrays.asList(r.get(0), REJECT, NA));
        }

        result.sort((a,b)-> a.get(0).compareTo(b.get(0)));

        return result;
    }

    public static boolean isEligibleForSelection(List<String> application) {
        return Double.parseDouble(application.get(1)) >= 5.8 && Double.parseDouble(application.get(2)) <= 23.0 && (Double.parseDouble(application.get(3)) >= 50.0 || Double.parseDouble(application.get(4)) >= 30);
    }

}
