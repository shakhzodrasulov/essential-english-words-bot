package uz.rasulov.eew_bot_v3.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import uz.rasulov.eew_bot_v3.responses.Response;

/**
 * Created by SHR on 27.01.2022
 */
public interface Command {
    String getApi();
    String getTitle();
    Response getResponse();
}
