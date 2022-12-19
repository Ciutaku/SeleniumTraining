package pages;

public class TestUtils {
    public static String generateRandomAlphaNumericString(int length) {
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index
                    = (int) (alphaNumericString.length()
                    * Math.random());
            sb.append(alphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }

    public static String generateRandomAlphabetString(int length) {
        String alphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index
                    = (int) (alphabetString.length()
                    * Math.random());
            sb.append(alphabetString
                    .charAt(index));
        }
        return sb.toString();
    }

    public static String generateRandomNumericString(int length) {
        String numericString = "0123456789";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index
                    = (int) (numericString.length()
                    * Math.random());
            sb.append(numericString
                    .charAt(index));
        }
        return sb.toString();
    }
}
