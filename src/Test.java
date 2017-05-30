import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by sunjiaxin on 2017/4/14.
 */
public class Test {
    public static void main(String[] args) {
        Map map = new HashMap(5);
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");

        Set<Map.Entry> entrySet =  map.entrySet();
        entrySet =  map.entrySet();
        entrySet =  map.entrySet();
    }
}
