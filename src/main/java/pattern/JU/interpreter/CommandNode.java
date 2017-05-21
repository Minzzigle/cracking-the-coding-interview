package pattern.JU.interpreter;

/**
 * Created by cha45 on 2017-05-21.
 */
// <command> ::= <report command> | <primitive command>
public class CommandNode extends Node {
    private Node node;

    @Override
    public void parse(Context context) throws ParseException {
        if (TokenType.findTokenTypeByType(context.currentToken()).isRepeat()) {
            node = new RepeatCommandNode();
            node.parse(context);
        } else {
            node = new PrimitiveCommandNode();
            node.parse(context);
        }
    }

    @Override
    public String toString() {
        return node.toString();
    }
}
