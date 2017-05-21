package pattern.JU.interpreter;

import java.util.StringTokenizer;

/**
 * Created by cha45 on 2017-05-21.
 */
public class Context {
    private StringTokenizer stringTokenizer;
    private String currentToken;

    public Context(String text) {
        this.stringTokenizer = new StringTokenizer(text);
        nextToken();
    }

    public void skipToken(String token) throws ParseException {
        if (!token.equals(currentToken)) {
            throw new ParseException("Warning : " + token + "is expected, but" + currentToken + "is found");
        }
        nextToken();
    }

    public String currentToken() {
        return currentToken;
    }

    public int currentNumber() throws ParseException {
        int number;
        try {
            number = Integer.parseInt(currentToken);
        } catch (NumberFormatException ex) {
            throw new ParseException("Warning: " + ex);
        }
        return number;
    }

    public String nextToken() {
        if (stringTokenizer.hasMoreTokens()) {
            currentToken = stringTokenizer.nextToken();
        } else {
            currentToken = null;
        }

        return currentToken;
    }
}
