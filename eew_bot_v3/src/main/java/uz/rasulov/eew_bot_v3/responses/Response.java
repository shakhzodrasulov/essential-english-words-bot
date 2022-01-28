package uz.rasulov.eew_bot_v3.responses;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

/**
 * Created by SHR on 27.01.2022
 */
public interface Response {
    String getText();
    ReplyKeyboard getKeyboard();
    SendMessage getSendMessage();
    void setChatId(String chatId);
}
