package uz.rasulov.essentialenglishwordsbotv2.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import uz.rasulov.essentialenglishwordsbotv2.models.Message;

/**
 * Created by SHR on 12.01.2022
 */
public interface Commands {
    void executeCommand(Message message);
}
