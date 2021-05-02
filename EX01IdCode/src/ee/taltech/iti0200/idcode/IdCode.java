package ee.taltech.iti0200.idcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class IdCode {

    public static final int FIRST_ID_YEAR = 1800;
    public static final int THIRD_ID_YEAR = 2000;
    public static final int SECOND_ID_YEAR = 1900;
    public static final int LAST_BIRTHPLACE_YEAR = 2012;
    public static final int MAX_QUEUE_NUMBER = 999;
    public static final int LEAP_YEAR_DIVIDER = 400;
    public static final int IRREGULAR_FEBRUARY = 29;
    public static final int REGULAR_FEBRUARY = 28;
    public static final int MAX_MONTHS = 12;
    public static final int REGULAR_THIRTY = 30;
    public static final int REGULAR_THIRTY_ONE = 31;
    public static final int BIRTHPLACE_START = 7;
    public static final int DATE_OF_BIRTH_END = 6;
    private final String idCodeValue;
    private static final int ID_CODE_LENGTH = 11;

    enum Gender {
        MALE, FEMALE
    }

    private static final Map<String, String> NUM_RANGE_AND_CITY_NAME = Map.ofEntries(
            entry("001,010", "Kuressaare"),
            entry("011,020", "Tartu"),
            entry("021,220", "Tallinn"),
            entry("221,270", "Kohtla-Järve"),
            entry("271,370", "Tartu"),
            entry("371,420", "Narva"),
            entry("421,470", "Pärnu"),
            entry("471,490", "Tallinn"),
            entry("491,520", "Paide"),
            entry("521,570", "Rakvere"),
            entry("571,600", "Valga"),
            entry("601,650", "Viljandi"),
            entry("651,710", "Võru")
    );

    private static final int[] THIRTY_DAYS = {4, 6, 9, 11},
            THIRTY_ONE_DAYS = {1, 3, 5, 7, 8, 10, 12};

    private static final int[] MULTIPLIERS_1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1},
            MULTIPLIERS_2 = {3, 4, 5, 6, 7, 8, 9, 1, 2, 3};

    public String getIdCodeValue() {
        return idCodeValue;
    }

    public IdCode(String idCodeValue) {
        this.idCodeValue = idCodeValue;
    }

    public boolean isCorrect() {
        if (idCodeValue.length() == ID_CODE_LENGTH) {
            return isGenderNumberCorrect() && isYearNumberCorrect() && isMonthNumberCorrect() && isDayNumberCorrect()
                    && isQueueNumberCorrect() && isControlNumberCorrect();
        }
        return false;
    }

    public String getInformation() {
        // This is a {sugu} born on {DD.MM.YYYY} in {linn}
        Gender gender = getGender();
        String birthPlace = getBirthPlace();
        String dayOfBirth = idCodeValue.charAt(5) + "" + idCodeValue.charAt(DATE_OF_BIRTH_END);
        String monthOfBirth = idCodeValue.charAt(3) + "" + idCodeValue.charAt(4);
        String birthYear = Integer.toString(getFullYear());

        if (isCorrect()) {
            return String.format("This is a %s born on %s.%s.%s in %s", gender, dayOfBirth,
                    monthOfBirth, birthYear, birthPlace);
        } else {
            return "Given invalid ID code!";
        }
    }

    public Gender getGender() {
        if (!isNumeric(idCodeValue.substring(0, 1))) {
            return null;
        }
        int genderNum = Character.getNumericValue(idCodeValue.charAt(0));
//        if (isGenderNumberCorrect()) {}
        if (genderNum % 2 == 0) {
            return Gender.FEMALE;
        } else if (genderNum % 2 == 1) {
            return Gender.MALE;
        }
        return null;
    }

    public String getBirthPlace() {
        if (!isNumeric(idCodeValue)) {
            return "Wrong input!";
        }
        int birthPlace = Integer.parseInt(idCodeValue.substring(BIRTHPLACE_START, 10));
        if (getFullYear() > LAST_BIRTHPLACE_YEAR) {
            return null;
        }
        for (Map.Entry<String, String> entry : NUM_RANGE_AND_CITY_NAME.entrySet()) {
            String[] values = entry.getKey().split(",");
            if (Integer.parseInt(values[0]) <= birthPlace && Integer.parseInt(values[1]) >= birthPlace) {
                return entry.getValue();
            }
        }
        return null;
    }

    public int getFullYear() {
        if (!isNumeric(idCodeValue)) {
            return -1;
        }
        int genderCode = Character.getNumericValue(idCodeValue.charAt(0));
        int yearNums = Integer.parseInt(idCodeValue.substring(1, 3));
        if (genderCode > 0 && genderCode < 3) {
            return FIRST_ID_YEAR + yearNums;
        } else if (genderCode < 5) {
            return SECOND_ID_YEAR + yearNums;
        } else if (genderCode < BIRTHPLACE_START) {
            return THIRD_ID_YEAR + yearNums;
        }
        return -1;
    }

    private boolean isGenderNumberCorrect() {
        if (!isNumeric(idCodeValue)) {
            return false;
        }
        int genderNum = Character.getNumericValue(idCodeValue.charAt(0));
        // System.out.println(genderNum);
        return genderNum > 0 && genderNum <= DATE_OF_BIRTH_END;
    }

    private boolean isYearNumberCorrect() {
        if (!isNumeric(idCodeValue)) {
            return false;
        }
        int yearNums = Integer.parseInt(idCodeValue.substring(1, 3));
        return yearNums >= 0 && yearNums < 100;

    }

    private boolean isMonthNumberCorrect() {
        if (!isNumeric(idCodeValue)) {
            return false;
        }
        int monthNums = Integer.parseInt(idCodeValue.substring(3, 5));
        return monthNums > 0 && monthNums <= MAX_MONTHS;
    }

    private boolean isDayNumberCorrect() {
        if (!isNumeric(idCodeValue)) {
            return false;
        }
        int daysNum = Integer.parseInt(idCodeValue.substring(5, BIRTHPLACE_START));
        int monthNum = Integer.parseInt(idCodeValue.substring(3, 5));
        int fullYear = getFullYear();
        if (monthNum == 2) {
            if (daysNum <= IRREGULAR_FEBRUARY && isLeapYear(fullYear)) {
                return true;
            } else if (daysNum <= REGULAR_FEBRUARY) {
                return true;
            }
        }
        if (daysNum <= REGULAR_THIRTY) {
            for (int month : THIRTY_DAYS) {
                if (monthNum == month) {
                    return true;
                }
            }
        }
        if (daysNum <= REGULAR_THIRTY_ONE) {
            for (int month : THIRTY_ONE_DAYS) {
                if (monthNum == month) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isQueueNumberCorrect() {
        if (!isNumeric(idCodeValue)) {
            return false;
        }
        int queueNumber = Integer.parseInt(idCodeValue.substring(BIRTHPLACE_START, 10));
        return 0 <= queueNumber && queueNumber <= MAX_QUEUE_NUMBER;
    }

    private boolean isControlNumberCorrect() {
        if (!isNumeric(idCodeValue)) {
            return false;
        }
        int controlNumber = Character.getNumericValue(idCodeValue.charAt(10));
        List<Integer> multipliedWithFirstSet = new ArrayList<>();
        List<Integer> multipliedWithSecondSet = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int firstMultiplied = Character.getNumericValue(idCodeValue.charAt(i)) * MULTIPLIERS_1[i];
            multipliedWithFirstSet.add(firstMultiplied);
            int secondMultiplied = Character.getNumericValue(idCodeValue.charAt(i)) * MULTIPLIERS_2[i];
            multipliedWithSecondSet.add(secondMultiplied);
        }
        if (sum(multipliedWithFirstSet) % ID_CODE_LENGTH == controlNumber) {
            return true;
        } else if (sum(multipliedWithFirstSet) % ID_CODE_LENGTH == 10) {
            if (sum(multipliedWithSecondSet) % ID_CODE_LENGTH == controlNumber) {
                return true;
            } else if (sum(multipliedWithSecondSet) % ID_CODE_LENGTH == 10) {
                return 0 == controlNumber;
            }
        }
        return false;
    }

    private boolean isLeapYear(int fullYear) {
        if (fullYear % 4 == 0 || fullYear % LEAP_YEAR_DIVIDER == 0) {
            return true;
        } else if (fullYear % 100 == 0) {
            return false;
        }
        return false;
    }

    private static int sum(List<Integer> list) {
        int sum = 0;
        for (int x : list) {
            sum += x;
        }
        return sum;
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IdCode validMaleIdCode = new IdCode("37605030299");
        IdCode validMaleIdCode2 = new IdCode("a");
        System.out.println(validMaleIdCode2.getGender());
        System.out.println(validMaleIdCode.isCorrect());
        System.out.println(validMaleIdCode.getInformation());
        System.out.println(validMaleIdCode.getGender());
        System.out.println(validMaleIdCode.getBirthPlace());
        System.out.println(validMaleIdCode.getFullYear());
        System.out.println(validMaleIdCode.isGenderNumberCorrect());
        System.out.println(validMaleIdCode.isYearNumberCorrect());
        System.out.println(validMaleIdCode.isMonthNumberCorrect());
        System.out.println(validMaleIdCode.isDayNumberCorrect());
        System.out.println(validMaleIdCode.isQueueNumberCorrect());
        System.out.println(validMaleIdCode.isControlNumberCorrect());
        System.out.println(validMaleIdCode.isLeapYear(validMaleIdCode.getFullYear()));
    }

}
