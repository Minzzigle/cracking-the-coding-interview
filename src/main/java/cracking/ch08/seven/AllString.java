package cracking.ch08.seven;

/**
 * AllString
 *
 * @author jongUn
 * @since 2018. 03. 16.
 */
public class AllString {
	public void print(String input) {
		print(input, "");
	}

	private void print(String input, String prefix) {
		if(input.length() == 0) {
			System.out.println(prefix);
			return;
		}

		for(int i = 0; i<input.length(); i++) {
			String rest = input.substring(0, i) + input.substring(i+1);
			print(rest, prefix + input.charAt(i));
		}
	}
}
