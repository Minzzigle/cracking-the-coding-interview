package pattern.JU.interpreter;

/**
 * Created by cha45 on 2017-05-21.
 */
// <primitive command> ::= go | right | left
public class PrimitiveCommandNode extends Node {
    private String name;

    @Override
    public void parse(Context context) throws ParseException {
        name = context.currentToken();
        context.skipToken(name);
        if(TokenType.findTokenTypeByType(name).isUndefinedToken()) {
            throw new ParseException(name + "is undefined");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
