package uz.rasulov.essentialenglishwordsbot;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;
import static uz.rasulov.essentialenglishwordsbot.Commands.*;

/**
 * Created by SHR on 07.01.2022
 */
public class Keyboards {
    public static List<KeyboardRow> welcomeKeyboard2;
    public static List<KeyboardRow> backKeyboard;

    public static List<List<InlineKeyboardButton>> startKeyboard = new ArrayList<>();
    public static List<List<InlineKeyboardButton>> welcomeKeyboard = new ArrayList<>();

    static {
        KeyboardRow firstRow = new KeyboardRow();
        firstRow.add(commands.get("/test_yourself"));
        firstRow.add(commands.get("/learn_new_words"));
        welcomeKeyboard2 = List.of(firstRow);
    }

    static {
        KeyboardRow firstRow = new KeyboardRow();
        firstRow.add(commands.get("/back"));
        backKeyboard = List.of(firstRow);
    }

    static {
        //startKeyboard
        List<InlineKeyboardButton> startKeyboardFirstRow = new ArrayList<>();
        InlineKeyboardButton startKeyboardFirstButton = InlineKeyboardButton.builder()
                .text(commands.get("/start"))
                .callbackData("/welcome")
                .build();

        startKeyboardFirstRow.add(startKeyboardFirstButton);
        startKeyboard.add(startKeyboardFirstRow);
    }

    static {
        //welcomeKeyboard
        List<InlineKeyboardButton> welcomeKeyboardFirstRow = new ArrayList<>();
        InlineKeyboardButton welcomeKeyboardFirstButton = InlineKeyboardButton.builder()
                .text(commands.get("/test_yourself"))
                .callbackData("/test_yourself")
                .build();
        InlineKeyboardButton welcomeKeyboardSecondButton = InlineKeyboardButton.builder()
                .text(commands.get("/learn_new_words"))
                .callbackData("/learn_new_words")
                .build();

        welcomeKeyboardFirstRow.add(welcomeKeyboardFirstButton);
        welcomeKeyboardFirstRow.add(welcomeKeyboardSecondButton);
        welcomeKeyboard.add(welcomeKeyboardFirstRow);
    }

    public static ReplyKeyboardMarkup welcomeReplyKeyboardMarkup = ReplyKeyboardMarkup.builder()
            .resizeKeyboard(true)
            .oneTimeKeyboard(true)
            .keyboard(welcomeKeyboard2)
            .build();

    public static ReplyKeyboardMarkup backReplyKeyboardMarkup = ReplyKeyboardMarkup.builder()
            .resizeKeyboard(true)
            .oneTimeKeyboard(true)
            .keyboard(backKeyboard)
            .build();

    public static InlineKeyboardMarkup startInlineKeyboardMarkup = InlineKeyboardMarkup.builder()
            .keyboard(startKeyboard)
            .build();

    public static InlineKeyboardMarkup welcomeInlineKeyboardMarkup = InlineKeyboardMarkup.builder()
            .keyboard(welcomeKeyboard)
            .build();

    public static ReplyKeyboardRemove replyKeyboardRemove = ReplyKeyboardRemove.builder()
            .selective(true)
            .removeKeyboard(true)
            .build();
}
