package uz.rasulov.eew_bot_v3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import uz.rasulov.eew_bot_v3.commands.Command;
import uz.rasulov.eew_bot_v3.commands.IsNotCommand;
import uz.rasulov.eew_bot_v3.models.Message;
import uz.rasulov.eew_bot_v3.service.Constants;
import uz.rasulov.eew_bot_v3.service.MainServiceImpl;

/**
 * Created by SHR on 27.01.2022
 */
@Component
public class TelegramBot extends TelegramLongPollingBot {
    @Value("${bot-username}")
    private String botUsername;

    @Value("${bot-token}")
    private String botToken;

    private final MainServiceImpl mainService;
    private final Command isNotCommand;

    public TelegramBot(MainServiceImpl mainService, IsNotCommand isNotCommand) {
        this.mainService = mainService;
        this.isNotCommand = isNotCommand;
    }


    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message receivedMessage = mainService.getMessage(update);

        if (receivedMessage != null) {

            Command receivedCommand = Constants.COMMANDS_LIST.stream()
                    .filter(command -> receivedMessage.getText().equals(command.getApi()) || receivedMessage.getText().equals(command.getTitle()))
                    .findFirst()
                    .orElse(isNotCommand);

            SendMessage response = receivedCommand.getResponse().getSendMessage();
            response.setChatId(receivedMessage.getChatId());
            send(response);
        }
    }

    //send answer to user
    private void send(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
