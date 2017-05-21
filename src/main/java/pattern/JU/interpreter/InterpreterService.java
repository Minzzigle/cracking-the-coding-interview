package pattern.JU.interpreter;

import org.springframework.stereotype.Service;

/**
 * Created by cha45 on 2017-05-21.
 */
@Service
public class InterpreterService {
    public String parse(String input) {
        Node node = new ProgramNode();
        try {
            node.parse(new Context(input));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return node.toString();
    }
}
