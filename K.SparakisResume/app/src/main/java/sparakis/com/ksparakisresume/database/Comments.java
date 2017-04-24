package sparakis.com.ksparakisresume.database;
import com.orm.SugarRecord;

/**
 * Created by ksparakis on 1/28/16.
 */

public class Comments extends SugarRecord {
    public String name;
    public String company;
    public String comment;
    public String date;


    public Comments(){
    }

    public Comments( String name, String company, String comment, String date){
        this.name = name;
        this.company = company;
        this.comment = comment;
        this.date = date;

    }
}