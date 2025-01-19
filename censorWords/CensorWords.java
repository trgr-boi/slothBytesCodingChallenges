public class CensorWords {

  private static final int MAX_CHARACTERS = 4;
  
  public static void main(String[] args) {
  //  ===TEST CASES===
    System.out.println(censor("The code is fourty"));
    System.out.println(censor("Two plus three is five"));
    System.out.println(censor("aaaa aaaaa 1234 12345"));
  }

  private static String censor(String input) {
    String regex = "[,\\.\\s]";
    String[] words = input.split(regex);
    for (int i = 0; i < words.length; i++) {
      if (words[i].length() > MAX_CHARACTERS) {
        words[i] = generateAsterisks(words[i].length());
      }
    }
    return String.join(" ", words);
  }

  private static String generateAsterisks(int length) {
    StringBuilder asterisks = new StringBuilder();
    for (int j = 0; j < length; j++) {
      asterisks.append('*');
    }
    return asterisks.toString();
  }
}
