package uz.rasulov.essentialenglishwordsbot.commands;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import uz.rasulov.essentialenglishwordsbot.services.CommandsService;

import static uz.rasulov.essentialenglishwordsbot.Keyboards.*;
import static uz.rasulov.essentialenglishwordsbot.Messages.*;

/**
 * Created by SHR on 07.01.2022
 */
@Service
public class MainCommandsController {
    private CommandsService commandsService;

    private Message previous;

    public MainCommandsController(CommandsService commandsService) {
        this.commandsService = commandsService;
    }

    public SendMessage mainCommandsController(Message receivedMessage) {

        //commands controller
        switch (receivedMessage.getText()) {
            case "/start": return welcomeAnswer(receivedMessage);
            case "/back": return back();
            case "/test_yourself": return testYourself(receivedMessage);
            case "/learn_new_words": return learnNewWords(receivedMessage);
            default:
                return nonCommand(receivedMessage);
        }
    }

    private SendMessage learnNewWords(Message receivedMessage) {
        return SendMessage.builder()
                .chatId(receivedMessage.getChatId().toString())
                .text("Select Unit for learn new words:")
                .replyMarkup(backReplyKeyboardMarkup)
                .build();
    }

    private SendMessage testYourself(Message receivedMessage) {
        return SendMessage.builder()
                .chatId(receivedMessage.getChatId().toString())
                .text("Select Unit for test yourself:")
                .replyMarkup(backReplyKeyboardMarkup)
                .build();
    }

    private SendMessage nonCommand(Message receivedMessage) {
        return SendMessage.builder()
                .chatId(receivedMessage.getChatId().toString())
                .text("nonCommand")
                .build();
    }

    private SendMessage back() {
        return mainCommandsController(previous);
    }

    private SendMessage welcomeAnswer(Message receivedMessage) {
        previous = receivedMessage;
        return SendMessage.builder()
                .chatId(receivedMessage.getChatId().toString())
                .replyMarkup(welcomeReplyKeyboardMarkup)
                .parseMode("Markdown")
                .text(welcomeText)
                .build();
    }


}
