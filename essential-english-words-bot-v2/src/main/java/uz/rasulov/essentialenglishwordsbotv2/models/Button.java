package uz.rasulov.essentialenglishwordsbotv2.models;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by SHR on 12.01.2022
 */
@Component
public class Button {
    public static Map<String, String> buttonsTexts = Map.of(
            "Learn new Words", "/learn_new_words",
            "Test yourself", "/test_yourself"
    );


}
