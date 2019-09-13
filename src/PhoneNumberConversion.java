/**
 * for Arabic coders, this code snippet convert Arabic written digits to English
 * written it will convert digits only , characters and symbols will be ignored
 * 
 * @author Maha M. Hamza
 *
 */
public class PhoneNumberConversion {

	public String convert(String num) {
		StringBuilder number = new StringBuilder();

		num.chars().mapToObj(x -> (char) x).forEach(e -> {
			char c = comparingCharacter(e);
			number.append(c);
		});

		return number.toString();
	}

	private char comparingCharacter(Character e) {
		char c = e.charValue();
		if (c >= 0x0660 && c <= 0x0669)
			c -= 0x0660 - '0';
		else if (c >= 0x06f0 && c <= 0x06F9)
			c -= 0x06f0 - '0';
		return c;
	}

}
