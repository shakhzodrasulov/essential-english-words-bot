package uz.rasulov.essentialenglishwordsbot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static uz.rasulov.essentialenglishwordsbot.Constants.start;

/**
 * Created by SHR on 07.01.2022
 */
@Component
public class TelegramBot extends TelegramLongPollingBot {
    private CommandsService commandsService;
    private CommonService commonService;
    private CommandsController commandsController;

    private MessageDto message;

    @Value("${bot-username}")
    private String botUserName;

    @Value("${bot-token}")
    private String botToken;

    public TelegramBot(CommandsService commandsService, CommonService commonService, CommandsController commandsController) {
        this.commandsService = commandsService;
        this.commonService = commonService;
        this.commandsController = commandsController;
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

        if (update.hasMessage() && update.getMessage().hasText() || update.hasCallbackQuery()) {
            String text;
            long chatId;

            if (update.hasCallbackQuery()){
                text = update.getCallbackQuery().getData();
                chatId = update.getCallbackQuery().getMessage().getChatId();
            } else {
                text = update.getMessage().getText();
                chatId = update.getMessage().getChatId();
            }
            message = MessageDto.builder()
                    .text(text)
                    .chatId(chatId)
                    .build();

            SendMessage answer;

            //starts here
            if (!start && !message.getText().equals("/welcome")) {
                answer = commonService.welcomeMessage(message);
            } else {
                message = commandsService.correctNotStandardCommands(message);

                if (commandsService.isCommand(message)) {
                    answer = commandsController.mainCommandsController(message);
                } else {
                    answer = commandsService.notCommand(message);
                }
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
