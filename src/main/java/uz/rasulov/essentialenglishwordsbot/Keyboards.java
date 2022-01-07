package uz.rasulov.essentialenglishwordsbot;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;
import static uz.rasulov.essentialenglishwordsbot.Commands.*;

/**
 * Created by SHR on 07.01.2022
 */
public class Keyboards {
    public static List<KeyboardRow> welcomeKeyboard;
    public static List<KeyboardRow> backKeyboard;

    static {
        KeyboardRow firstRow = new KeyboardRow();

        firstRow.add(commands.get("/test_yourself"));
        firstRow.add(commands.get("/learn_new_words"));

        welcomeKeyboard = List.of(firstRow);
    }

    static {
        KeyboardRow firstRow = new KeyboardRow();
        firstRow.add(commands.get("/back"));

        backKeyboard = List.of(firstRow);
    }

    public static ReplyKeyboardMarkup welcomeReplyKeyboardMarkup = ReplyKeyboardMarkup.builder()
            .resizeKeyboard(true)
            .oneTimeKeyboard(true)
            .keyboard(welcomeKeyboard)
            .build();

    public static ReplyKeyboardMarkup backReplyKeyboardMarkup = ReplyKeyboardMarkup.builder()
            .resizeKeyboard(true)
            .oneTimeKeyboard(true)
            .keyboard(backKeyboard)
            .build();

    public static ReplyKeyboardRemove replyKeyboardRemove = ReplyKeyboardRemove.builder()
            .selective(true)
            .removeKeyboard(true)
            .build();
}
