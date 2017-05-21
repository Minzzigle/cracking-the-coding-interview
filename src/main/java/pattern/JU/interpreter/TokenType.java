package pattern.JU.interpreter;

/**
 * Created by cha45 on 2017-05-21.
 */
public enum TokenType {
    PROGRAM("program"),
    COMMAND("command"),
    GO("go"),
    RIGHT("right"),
    LEFT("left"),
    END("end"),
    REPEAT("repeat");

    private final String type;

    TokenType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static TokenType findTokenTypeByType(String type) {
        TokenType [] values = TokenType.values();
        for(TokenType tokenType : values) {
            if(tokenType.getType().equals(type)) {
                return tokenType;
            }
        }

        return null;
    }

    public boolean isEnd() {
        return END == this;
    }

    public boolean isRepeat() {
        return REPEAT == this;
    }

    public boolean isUndefinedToken() {
        return GO != this && LEFT != this && RIGHT != this;
    }
}
