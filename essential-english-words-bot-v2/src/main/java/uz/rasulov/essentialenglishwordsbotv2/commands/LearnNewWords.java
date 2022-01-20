package uz.rasulov.essentialenglishwordsbotv2.commands;

import org.springframework.stereotype.Component;
import uz.rasulov.essentialenglishwordsbotv2.models.Message;
import uz.rasulov.essentialenglishwordsbotv2.processes.Processes;

import static uz.rasulov.essentialenglishwordsbotv2.Constants.*;

/**
 * Created by SHR on 12.01.2022
 */
@Component
public class LearnNewWords implements Commands {
    @Override
    public void executeCommand(Message message) {
        inProcess = Processes.LEARN_NEW_WORDS.getValue();
    }
}
