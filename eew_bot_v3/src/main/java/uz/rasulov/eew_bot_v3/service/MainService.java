package uz.rasulov.eew_bot_v3.service;

import org.telegram.telegrambots.meta.api.objects.Update;
import uz.rasulov.eew_bot_v3.models.Message;

/**
 * Created by SHR on 28.01.2022
 */
public interface MainService {
    Message getMessage(Update update);
}
