package uz.rasulov.eew_bot_v3.responses;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import uz.rasulov.eew_bot_v3.service.Emojiz;

import java.util.List;

/**
 * Created by SHR on 28.01.2022
 */
@Component
public class MainMenuResponse implements Response{
    private final SendMessage sendMessageResponse;

    public MainMenuResponse() {
        this.sendMessageResponse = SendMessage.builder()
                .text(getText())
                .replyMarkup(getKeyboard())
                .chatId("")
                .build();
    }


    @Override
    public String getText() {
        return "Select what do you want do:";
    }

    @Override
    public ReplyKeyboard getKeyboard() {
        List<KeyboardRow> startKeyboardRowsList;

        KeyboardRow firstRow = new KeyboardRow();

        firstRow.add("Test yourself " + Emojiz.MUSCLE.getValue());
        firstRow.add("Learn new words " + Emojiz.BOOK.getValue());

        startKeyboardRowsList = List.of(firstRow);

        return ReplyKeyboardMarkup.builder()
                .resizeKeyboard(true)
                .oneTimeKeyboard(true)
                .keyboard(startKeyboardRowsList)
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
