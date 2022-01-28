package uz.rasulov.eew_bot_v3.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.rasulov.eew_bot_v3.models.Message;

/**
 * Created by SHR on 28.01.2022
 */
@Service
public class MainServiceImpl implements MainService {
    private final Message message;

    public MainServiceImpl(Message message) {
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
}
