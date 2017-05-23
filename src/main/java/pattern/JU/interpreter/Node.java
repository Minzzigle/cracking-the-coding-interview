package pattern.JU.interpreter;

/**
 * Created by cha45 on 2017-05-21.
 */
public abstract class Node {
    public abstract void parse(Context context) throws ParseException;
}
