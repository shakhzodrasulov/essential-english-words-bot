package uz.rasulov.essentialenglishwordsbotv2.services;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.rasulov.essentialenglishwordsbotv2.models.Message;

import static uz.rasulov.essentialenglishwordsbotv2.models.Button.buttonsTexts;
import static uz.rasulov.essentialenglishwordsbotv2.models.Command.commandsList;

/**
 * Created by SHR on 12.01.2022
 */
@Service
public class CommonServiceImpl implements CommonService {
    private Message message;

    public CommonServiceImpl(Message message) {
        this.message = message;
    }

    @Override
    public Message getMessage(Update update) {
        if (update.hasMessage() && update.getMessage().hasText() || update.hasCallbackQuery()) {
            if (update.hasCallbackQuery()) {
                message.setText(update.getCallbackQuery().getData());
                message.setChatId(update.getCallbackQuery().getMessage().getChatId());
            } else {
                message.setText(update.getMessage().getText());
                message.setChatId(update.getMessage().getChatId());
            }
            return message;
        } else return null;
    }

    @Override
    public Message convertButtonTextToCommandFormat(Message message) {
        if (buttonsTexts.containsKey(message.getText())) {
            String command = buttonsTexts.get(message.getText());
            message.setText(command);
        }
        return message;
    }

    @Override
    public boolean isCommand(Message message) {
        if (message.getText().startsWith("/")) {
            return commandsList.contains(message.getText());
        }
        return false;
    }
}
