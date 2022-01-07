package uz.rasulov.essentialenglishwordsbot.services;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import static uz.rasulov.essentialenglishwordsbot.Commands.commands;
import static uz.rasulov.essentialenglishwordsbot.Keyboards.backReplyKeyboardMarkup;

/**
 * Created by SHR on 07.01.2022
 */
@Service
public class CommandsService {
    public boolean isCommand(Message message) {
        return  (message.getText().startsWith("/"));
    }


    public SendMessage notCommand(Message receivedMessage) {
        return SendMessage.builder()
                .text("It is not command, please check your command")
                .chatId(receivedMessage.getChatId().toString())
                .replyMarkup(backReplyKeyboardMarkup)
                .build();
    }

    public Message correctNotStandardCommands(Message receivedMessage) {
        if (commands.containsValue(receivedMessage.getText())) {
            for (String key : commands.keySet()) {
                if (commands.get(key).equals(receivedMessage.getText())) {
                    receivedMessage.setText(key);
                }
            }
        }
        ;
        return receivedMessage;
    }
}
