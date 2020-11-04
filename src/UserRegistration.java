import java.util.Scanner;
import java.util.regex.Pattern;

interface UserRegistrationInf {
	boolean validate(String pattern, String input);
}

public class UserRegistration {
	Scanner scanner = new Scanner(System.in);
	public static final String NAMEPATTERN = "[A-Z][A-Za-z]{2,}";
	UserRegistrationInf userRegistrationInf = (pattern, input) -> Pattern.matches(pattern, input);
	
	public static void main(String[] args) {
		System.out.println("Welcome to User Registration !");
		
		UserRegistration userRegistration = new UserRegistration();
		userRegistration.readUserInput();
	}
	
	private void validateUserInput(String pattern, String input, UserRegistrationInf userRegistrationInf) { 
		boolean result = userRegistrationInf.validate(pattern, input); 
		if(result)
			System.out.println("Valid input");
		else
			System.out.println("Invalid input");
	} 
	
	private void readUserInput() {
		System.out.println("Enter first name ");
		String firstName = scanner.next();
		validateUserInput(NAMEPATTERN, firstName, userRegistrationInf);
	}
}
