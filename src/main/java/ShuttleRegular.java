import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShuttleRegular {
    public static TreeSet<String> replaceUnknownBusNumber(String input) {
        TreeSet<String> tr = new TreeSet<>();



        /*String input = "mission,  shuttle/mission<star><15>,  star , son , masonc  shuttle/mission<star><18> cosmos, star, " +
                "earth, shuttle/mission<moon><19> moon, milkyway, shuttle/mission<star><201> star"; */
        input = input.trim();
        Pattern p = Pattern.compile("(?<=\\s)[\\w]+$");
        Matcher m = p.matcher(input);
        String s = null;
        if (m.find()) {
            s = m.group();
        }

        Pattern p1 = Pattern.compile("\\bshuttle/mission<\\w+><\\d+>");
        Matcher m1 = p1.matcher(input);

        while (m1.find()) {
            if (m1.group().contains("<" + s + ">")) {
                //  System.out.println(m1.group());
                tr.add(m1.group());
            }
        }
        for (String s1 : tr
        ) {
            System.out.println(s1);

        }
        return tr;

    }
}