import java.sql.Connection;

public class SelectDB {

    private Connection link;
    SelectDB(Connection DB)
    {
        this.link = DB;
    }
}
