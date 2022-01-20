package uz.rasulov.essentialenglishwordsbotv2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import uz.rasulov.essentialenglishwordsbotv2.commands.Commands;
import uz.rasulov.essentialenglishwordsbotv2.models.Message;
import uz.rasulov.essentialenglishwordsbotv2.services.CommandServiceImpl;
import uz.rasulov.essentialenglishwordsbotv2.services.CommonService;

import static uz.rasulov.essentialenglishwordsbotv2.Constants.*;

/**
 * Created by SHR on 12.01.2022
 */
@Component
public class TelegramBot extends TelegramLongPollingBot {
    private CommonService commonService;
    private CommandServiceImpl commandServiceImpl;

    @Value("${bot-username}")
    private String botUsername;

    @Value("${bot-token}")
    private String botToken;

    public TelegramBot(CommonService commonService, CommandServiceImpl commandServiceImpl) {
        this.commonService = commonService;
        this.commandServiceImpl = commandServiceImpl;
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
        //get message from update
        Message receivedMessage = commonService.getMessage(update);

        if (receivedMessage!=null) {
            //convert button-text to command format
            receivedMessage = commonService.convertButtonTextToCommandFormat(receivedMessage);

            //Check received message is command
            if (commonService.isCommand(receivedMessage)){

                //execute commands
                Commands command = commandServiceImpl.getCommandObject(receivedMessage);
                command.executeCommand(receivedMessage);
                send(getSendMessage(receivedMessage.getText(), receivedMessage.getChatId()));
            }
            //when received message is not command
            else {
                send(getIsNotCommandMessage(receivedMessage.getChatId()));
            }
        }
    }

    //send answer to user
    private void send(SendMessage sendMessage){
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
