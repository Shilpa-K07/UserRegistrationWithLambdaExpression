import java.util.Scanner;
import java.util.regex.Pattern;

interface UserRegistrationInf {
	boolean validate(String pattern, String input);
}

public class UserRegistration {
	Scanner scanner = new Scanner(System.in);
	public static final String NAMEPATTERN = "[A-Z][A-Za-z]{2,}";
	public static final String EMAILPATTERN = "([0-9A-Za-z])+([-+._][0-9A-Za-z]+)*"
			+ "@([0-9A-Za-z])+[.]([a-zA-Z])+([.][A-Za-z]+)*";
	public static final String MOBILENUMBERPATTERN = "\\d{2}[-\\.\\s]\\d{10}";
	public static final String PASSWORDPATTERN = "^(?=.{8,}).*$";
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
		
		System.out.println("Enter last name ");
		String lastName = scanner.next();
		validateUserInput(NAMEPATTERN, lastName, userRegistrationInf);
		
		System.out.println("Enter email id ");
		String emailId = scanner.next();
		validateUserInput(EMAILPATTERN, emailId, userRegistrationInf);
		
		System.out.println("Enter mobile number ");
		scanner.nextLine();
		String mobileNumber = scanner.nextLine();
		validateUserInput(MOBILENUMBERPATTERN, mobileNumber, userRegistrationInf);
		
		System.out.println("Enter password ");
		String password = scanner.next();
		validateUserInput(PASSWORDPATTERN, password, userRegistrationInf);
	}
}
