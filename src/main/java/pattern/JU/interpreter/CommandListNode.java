package pattern.JU.interpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cha45 on 2017-05-21.
 */
// <command list> ::= <command>* end
public class CommandListNode extends Node {
    private List<Node> list = new ArrayList<>();

    @Override
    public void parse(Context context) throws ParseException {
        while (true) {
            String token = context.currentToken();
            if(token == null) {
                throw new ParseException("Missing 'end'");
            } else if (TokenType.findTokenTypeByType(token).isEnd()) {
                context.skipToken(TokenType.END.getType());
                break;
            } else {
                Node commandNode = new CommandNode();
                commandNode.parse(context);
                list.add(commandNode);
            }
        }
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
