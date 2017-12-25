package cracking.pre;

public class Permutation {
    public void perm(String input) {
        perm(input, "");
    }

    public void perm(String input, String prefix) {
        if(input.length() == 0) {
            System.out.println(prefix);
            return;
        }

        for(int i = 0; i<input.length(); i++) {
            String rem = input.substring(0, i) + input.substring(i + 1);
            perm(rem, prefix + input.charAt(i));
        }
    }

}
