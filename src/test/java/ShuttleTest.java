import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShuttleTest {

    @Test
    void replaceUnknownBusNumber() {
        String text = "mission,  shuttle/mission<star><15>,  star , son , masonc  shuttle/mission<star><18> cosmos, star";
        InputStream in = new ByteArrayInputStream(text.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        text = scanner.nextLine();
        TreeSet<String> act = ShuttleRegular.replaceUnknownBusNumber(text);
        String actual = "";
        for (String s:act
             ) {
           actual += s+ " ";
        }
        String expected = "shuttle/mission<star><15> " +
                "shuttle/mission<star><18> ";
        assertEquals(expected, actual);
    }
}
