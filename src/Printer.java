import javafx.util.Pair;

import java.util.Map;

public interface Printer {

    void print(Pair<String, Map<String, String>> information);
}