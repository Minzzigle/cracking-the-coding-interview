package pattern.JU.interpreter;

/**
 * Created by cha45 on 2017-05-21.
 */
// <program> ::= program <command List>
public class ProgramNode extends Node{
    private Node commandListNode;

    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken(TokenType.PROGRAM.getType());
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    public String toString() {
        return "[program " + commandListNode + "]";
    }
}
