public class PhoneNumberValidator {
	
    public static void main(String[] args) {
//		>---------------------------Test Cases----------------------------<
        System.out.println(isValidPhoneNumber("(123) 456-7890")); // true
        System.out.println(isValidPhoneNumber("(123)456-7890")); // false because no space
        System.out.println(isValidPhoneNumber("1111)555 2345"));  // false
        System.out.println(isValidPhoneNumber("098) 123 4567"));  // false
//      >-----------------------------------------------------------------<
    }
    
    public static boolean isValidPhoneNumber(String phoneNumber) {
    	String regex = "\\(\\d{3}\\) \\d{3}-\\d{4}";
        return phoneNumber.matches(regex);
    }
}