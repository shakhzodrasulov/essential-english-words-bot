package uz.rasulov.essentialenglishwordsbot;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import static uz.rasulov.essentialenglishwordsbot.Keyboards.startInlineKeyboardMarkup;
import static uz.rasulov.essentialenglishwordsbot.Messages.welcomeText;

/**
 * Created by SHR on 08.01.2022
 */
@Service
public class CommonService {
    public SendMessage welcomeMessage(MessageDto messageDto){
        return SendMessage.builder()
                .chatId(String.valueOf(messageDto.getChatId()))
                .parseMode("Markdown")
                .text(welcomeText)
                .replyMarkup(startInlineKeyboardMarkup)
                .build();
    }
}
