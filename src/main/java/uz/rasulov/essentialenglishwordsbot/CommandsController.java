package uz.rasulov.essentialenglishwordsbot;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import static uz.rasulov.essentialenglishwordsbot.Constants.start;
import static uz.rasulov.essentialenglishwordsbot.Keyboards.*;
import static uz.rasulov.essentialenglishwordsbot.Messages.*;

/**
 * Created by SHR on 07.01.2022
 */
@Service
public class CommandsController {

    private String previous;

    public SendMessage mainCommandsController(MessageDto messageDto) {

        //commands controller
        switch (messageDto.getText()) {
            case "/welcome": return whatYouWantTextAnswer(messageDto);
            case "/back": back(messageDto);
            case "/test_yourself": return testYourself(messageDto);
            case "/learn_new_words": return learnNewWords(messageDto);
            default:
                return nonCommand(messageDto);
        }
    }

    private SendMessage learnNewWords(MessageDto messageDto) {
        return SendMessage.builder()
                .chatId(String.valueOf(messageDto.getChatId()))
                .text("Select Unit for learn new words:")
                .replyMarkup(backReplyKeyboardMarkup)
                .build();
    }

    private SendMessage testYourself(MessageDto messageDto) {
        return SendMessage.builder()
                .chatId(String.valueOf(messageDto.getChatId()))
                .text("Select Unit for test yourself:")
                .replyMarkup(backReplyKeyboardMarkup)
                .build();
    }

    private SendMessage nonCommand(MessageDto messageDto) {
        return SendMessage.builder()
                .chatId(String.valueOf(messageDto.getChatId()))
                .text("nonCommand")
                .build();
    }

    private MessageDto back(MessageDto messageDto) {
        messageDto.setText(previous);
        return messageDto;
    }

    private SendMessage whatYouWantTextAnswer(MessageDto messageDto) {
        start = true;
        previous = messageDto.getText();
        return SendMessage.builder()
                .chatId(String.valueOf(messageDto.getChatId()))
                .replyMarkup(welcomeInlineKeyboardMarkup)
                .parseMode("Markdown")
                .text(whatYouWantText)
                .build();
    }


}
