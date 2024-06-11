package Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(getDefinition());

    }

    public static String getDefinition() {
        ArrayList<String[]> dict = new ArrayList<>();
        dict.add(new String[]{"allo", "salutation 1"});
        dict.add(new String[]{"bonjour", "salutation 2"});

        String toReturn;

        dict.forEach(def -> {
            if (def[0] == "allo") {
                toReturn = def[1];
            }
        });

        return toReturn;
    } 
}

