package utils;

import java.util.HashMap;
import java.util.Map;
public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("MMMCMXCIX"));
    }
    public static int romanToInt(String s) {
        Map<Character, Integer> romanNumerals = new HashMap<>();
        romanNumerals.put('M', 1000);
        romanNumerals.put('D', 500);
        romanNumerals.put('C',100);
        romanNumerals.put('L', 50);
        romanNumerals.put('X', 10);
        romanNumerals.put('V', 5);
        romanNumerals.put('I', 1);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case ('I'):
                    if (i + 1 < s.length()) {
                        if (s.charAt(i + 1) == 'V') {
                            result += romanNumerals.get('V') - romanNumerals.get('I');
                            i++;
                        } else if (s.charAt(i + 1) == 'X') {
                            result += romanNumerals.get('X') - romanNumerals.get('I');
                            i++;
                        } else result += romanNumerals.get('I');
                    } else result += romanNumerals.get('I');
                    break;
                case ('X'):
                    if (i + 1 < s.length()) {
                        if (s.charAt(i + 1) == 'L') {
                            result += romanNumerals.get('L') - romanNumerals.get('X');
                            i++;
                        } else if (s.charAt(i + 1) == 'C') {
                            result += romanNumerals.get('C') - romanNumerals.get('X');
                            i++;
                        } else result += romanNumerals.get('X');
                    } else result += romanNumerals.get('X');
                    break;
                case ('C'):
                    if (i + 1 < s.length()) {
                        if (s.charAt(i + 1) == 'D') {
                            result += romanNumerals.get('D') - romanNumerals.get('C');
                            i++;
                        } else if (s.charAt(i + 1) == 'M') {
                            result += romanNumerals.get('M') - romanNumerals.get('C');
                            i++;
                        } else result += romanNumerals.get('C');
                    } else result += romanNumerals.get('C');
                    break;
                default: result += romanNumerals.get(s.charAt(i));
            }

        }
        return result;
    }
}