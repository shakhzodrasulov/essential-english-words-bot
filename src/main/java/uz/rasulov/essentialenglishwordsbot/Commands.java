package uz.rasulov.essentialenglishwordsbot;

import java.util.Map;

/**
 * Created by SHR on 07.01.2022
 */
public class Commands {
    public static Map<String, String> commands = Map.of(
            "/test_yourself","Test yourself "+Emojiz.MUSCLE.getValue(),
            "/learn_new_words","Learn new words "+Emojiz.BOOK.getValue(),
            "/back", Emojiz.ARROW_LEFT.getValue()+"Back"
    );
}
