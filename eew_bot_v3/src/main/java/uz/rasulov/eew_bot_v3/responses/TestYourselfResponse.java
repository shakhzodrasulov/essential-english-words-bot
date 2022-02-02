package uz.rasulov.eew_bot_v3.responses;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import uz.rasulov.eew_bot_v3.service.Emojiz;

import java.util.ArrayList;
import java.util.List;

import static uz.rasulov.eew_bot_v3.service.Emojiz.ARROW_LEFT;
import static uz.rasulov.eew_bot_v3.service.Emojiz.BOOK;

/**
 * Created by SHR on 27.01.2022
 */
@Component
public class TestYourselfResponse implements Response {
    private final SendMessage sendMessageResponse;

    public TestYourselfResponse() {
        this.sendMessageResponse = SendMessage.builder()
                .text(getText())
                .replyMarkup(getKeyboard())
                .parseMode("Markdown")
                .chatId("")
                .build();
    }

    @Override
    public String getText() {
        return "*Select Unit for test yourself:*" + Emojiz.MUSCLE.getValue();
    }

    @Override
    public ReplyKeyboard getKeyboard() {

        List<KeyboardRow> testYourselfKeyboardRowsList = new ArrayList<>();

        KeyboardRow testYourselfKeyboardRow;

        int count = 1;
        for (int i = 0; i < 4; i++) {
            testYourselfKeyboardRow = new KeyboardRow();
            for (int j = 0; j < 3; j++) {
                if (i == 3) {
                    testYourselfKeyboardRow.add(ARROW_LEFT.getValue()+" Main Menu");
                    break;
                }
                testYourselfKeyboardRow.add(BOOK.getValue()+" unit " + count);
                count++;
            }
            testYourselfKeyboardRowsList.add(testYourselfKeyboardRow);
        }

        return ReplyKeyboardMarkup.builder()
                .resizeKeyboard(true)
                .oneTimeKeyboard(true)
                .keyboard(testYourselfKeyboardRowsList)
                .build();
    }

    @Override
    public SendMessage getSendMessage() {
        return sendMessageResponse;
    }

    @Override
    public void setChatId(String chatId) {
        sendMessageResponse.setChatId(chatId);
    }
}
