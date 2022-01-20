package uz.rasulov.essentialenglishwordsbotv2.services;

import org.telegram.telegrambots.meta.api.objects.Update;
import uz.rasulov.essentialenglishwordsbotv2.models.Message;

/**
 * Created by SHR on 12.01.2022
 */
public interface CommonService {
    Message getMessage(Update update);
    Message convertButtonTextToCommandFormat(Message message);

    boolean isCommand(Message message);
}
