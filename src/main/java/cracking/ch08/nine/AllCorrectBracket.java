package cracking.ch08.nine;

public class AllCorrectBracket {
    public void print(int size) {
        print(size, 0, 0, "");
    }

    private void print(int size, int openBracketSize, int closeBracketSize, String result) {
        if(openBracketSize == size) {
            for(int i = 0; i<openBracketSize - closeBracketSize; i++) {
                result += ')';
            }
            System.out.println(result);
            return;
        }

        if(openBracketSize > closeBracketSize) {
            print(size, openBracketSize + 1, closeBracketSize, result + "(");
            print(size, openBracketSize, closeBracketSize + 1, result + ")");
        } else {
            print(size, openBracketSize + 1, closeBracketSize, result + "(");
        }
    }
}
