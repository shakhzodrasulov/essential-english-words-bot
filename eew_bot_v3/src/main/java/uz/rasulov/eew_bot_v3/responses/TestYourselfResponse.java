package uz.rasulov.eew_bot_v3.responses;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import uz.rasulov.eew_bot_v3.service.Emojiz;

import java.util.ArrayList;
import java.util.List;

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
        List<List<InlineKeyboardButton>> testYourselfKeyboardRowsList = new ArrayList<>();

        List<InlineKeyboardButton> testYourselfKeyboardRow;

        int count = 1;
        for (int i = 0; i < 3; i++) {
            testYourselfKeyboardRow = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                if (i == 2) {
                    testYourselfKeyboardRow.add(InlineKeyboardButton.builder()
                            .text("Back")
                            .callbackData("/main_menu")
                            .build());
                    break;
                }
                testYourselfKeyboardRow.add(InlineKeyboardButton.builder()
                        .text("Unit " + count)
                        .callbackData("/test_yourself_" + count)
                        .build());
                count++;
            }
            testYourselfKeyboardRowsList.add(testYourselfKeyboardRow);
        }

        return InlineKeyboardMarkup.builder()
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
