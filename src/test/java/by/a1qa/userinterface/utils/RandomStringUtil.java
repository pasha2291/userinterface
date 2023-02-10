package by.a1qa.userinterface.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomStringUtil {

    private RandomStringUtil() {
    }

    private static final int MAX_DOMAIN_LENGTH = 10;
    private static final int MAX_EMAIL_LENGTH = 10;
    private static final int MIN_PASSWORD_LENGTH = 10;
    private static final String RUS_CHARACTERS = "aбвгдеёжзийклмнопрстуфхчщъыьэюя";
    private static final String ENG_CAPITAL_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERALS = "1234567890";
    private static Random random = new Random();

    private static String getRandomString(int maxLength) {
        return RandomStringUtils.random(random.nextInt(maxLength) + 1,
                true, true);
    }

    private static String getPasswordObligatoryPart() {
        StringBuilder result = new StringBuilder();
        result.append(RUS_CHARACTERS.charAt(random.nextInt(RUS_CHARACTERS.length())));
        result.append(ENG_CAPITAL_CHARACTERS.charAt(random.nextInt(ENG_CAPITAL_CHARACTERS.length())));
        result.append(NUMERALS.charAt(random.nextInt(NUMERALS.length())));
        return result.toString();
    }

    public static String getRandomPassword(String email) {
        StringBuilder result = new StringBuilder();
        result.append(getRandomString(MIN_PASSWORD_LENGTH));
        result.append(getPasswordObligatoryPart());
        result.append(email.charAt(random.nextInt(email.length())));
        if(result.toString().length() < MIN_PASSWORD_LENGTH) {
            while (result.toString().length() < MIN_PASSWORD_LENGTH){
                result.append(getPasswordObligatoryPart());
            }
        }
        return result.toString();
    }

    public static String getRandomEmail(){
        return getRandomString(MAX_EMAIL_LENGTH);
    }

    public static String getRandomDomain(){
        return getRandomString(MAX_DOMAIN_LENGTH);
    }
}
