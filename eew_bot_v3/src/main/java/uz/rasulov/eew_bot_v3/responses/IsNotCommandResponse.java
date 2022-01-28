package uz.rasulov.eew_bot_v3.responses;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

/**
 * Created by SHR on 28.01.2022
 */
@Component
public class IsNotCommandResponse implements Response{
    private final SendMessage response;

    public IsNotCommandResponse() {
        this.response = SendMessage.builder()
                .text(getText())
                .chatId("")
                .build();
    }

    @Override
    public String getText() {
        return "Your message is not command!\nback to /main_menu";
    }

    @Override
    public ReplyKeyboard getKeyboard() {
        return null;
    }

    @Override
    public SendMessage getSendMessage() {
        return response;
    }

    @Override
    public void setChatId(String chatId) {
        response.setChatId(chatId);
    }
}
