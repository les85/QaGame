import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String name) {
        super("Игрок с именем " + name + " не найден");
    }
}
