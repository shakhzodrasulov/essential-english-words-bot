package uz.rasulov.essentialenglishwordsbot;

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
    public boolean isCommand(MessageDto messageDto) {
        return  (messageDto.getText().startsWith("/"));
    }


    public SendMessage notCommand(MessageDto messageDto) {
        return SendMessage.builder()
                .text("It is not command, please check your command")
                .chatId(String.valueOf(messageDto.getChatId()))
                .replyMarkup(backReplyKeyboardMarkup)
                .build();
    }

    public MessageDto correctNotStandardCommands(MessageDto messageDto) {
        if (commands.containsValue(messageDto.getText())) {
            for (String key : commands.keySet()) {
                if (commands.get(key).equals(messageDto.getText())) {
                    messageDto.setText(key);
                }
            }
        }
        return messageDto;
    }
}
