package uz.rasulov.essentialenglishwordsbot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import uz.rasulov.essentialenglishwordsbot.commands.MainCommandsController;
import uz.rasulov.essentialenglishwordsbot.services.CommandsService;

/**
 * Created by SHR on 07.01.2022
 */
@Component
public class TelegramBot extends TelegramLongPollingBot {
    private CommandsService commandsService;
    private MainCommandsController commands;

    @Value("${bot-username}")
    private String botUserName;

    @Value("${bot-token}")
    private String botToken;

    public TelegramBot(CommandsService commandsService, MainCommandsController commands) {
        this.commandsService = commandsService;
        this.commands = commands;
    }

    //methods
    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message receivedMessage = update.getMessage();

            //starts here
            receivedMessage = commandsService.correctNotStandardCommands(receivedMessage);

            SendMessage answer;
            if (commandsService.isCommand(receivedMessage)) {
                answer = commands.mainCommandsController(receivedMessage);
            } else {
                answer = commandsService.notCommand(receivedMessage);
            }

            sendAnswer(answer);
        }
    }

    private void sendAnswer(SendMessage answer) {
        try {
            execute(answer);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
