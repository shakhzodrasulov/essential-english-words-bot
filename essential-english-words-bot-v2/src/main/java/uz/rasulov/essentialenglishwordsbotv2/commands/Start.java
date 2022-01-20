package uz.rasulov.essentialenglishwordsbotv2.commands;

import org.springframework.stereotype.Component;
import uz.rasulov.essentialenglishwordsbotv2.Constants;
import uz.rasulov.essentialenglishwordsbotv2.models.Message;

/**
 * Created by SHR on 12.01.2022
 */
@Component
public class Start implements Commands {
    @Override
    public void executeCommand(Message message) {
        Constants.SEND_MESSAGE.setText("Welcome!\n/learn_new_words\n/test_yourself");
        Constants.SEND_MESSAGE.setChatId(message.getChatId());
    }
}
