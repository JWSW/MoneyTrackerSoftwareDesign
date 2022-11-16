import java.util.HashMap;
import java.util.List;

public class DataPersons {
    private static DataPersons uniqueInstance;

    private final HashMap<String, Integer> db;
    public DataPersons() {
        this.db = new HashMap<>() {
        };
    }

    public static DataPersons getInstance(){
        if(uniqueInstance==null){
            uniqueInstance = new DataPersons();
        }
        return uniqueInstance;
    }
}
