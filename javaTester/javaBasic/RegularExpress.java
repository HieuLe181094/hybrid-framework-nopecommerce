package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.regex.*;
import java.util.*;

public class RegularExpress {
    public static void main(String[] args) {
        String text = "1-15 of 17 items";

        // Regex tìm số sau từ "of"
        Pattern integerPattern = Pattern.compile("of\\s+(\\d+)\\s+items");
        Matcher integerMatcher = integerPattern.matcher(text);

        if (integerMatcher.find()) {
            String total = integerMatcher.group(1);
            System.out.println("Số sau 'of' và trước 'items': " + integerMatcher.group(1));
        } else {
            System.out.println("Không tìm thấy số.");
        }
        }
}

