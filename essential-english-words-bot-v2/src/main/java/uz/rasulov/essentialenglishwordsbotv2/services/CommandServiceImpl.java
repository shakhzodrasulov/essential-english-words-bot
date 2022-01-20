package uz.rasulov.essentialenglishwordsbotv2.services;

import org.springframework.stereotype.Service;
import uz.rasulov.essentialenglishwordsbotv2.commands.Commands;
import uz.rasulov.essentialenglishwordsbotv2.commands.LearnNewWords;
import uz.rasulov.essentialenglishwordsbotv2.commands.Start;
import uz.rasulov.essentialenglishwordsbotv2.commands.TestYourself;
import uz.rasulov.essentialenglishwordsbotv2.models.Message;

/**
 * Created by SHR on 12.01.2022
 */
@Service
public class CommandServiceImpl implements CommandService {
    private final Start start;
    private final LearnNewWords learnNewWords;
    private final TestYourself testYourself;

    public CommandServiceImpl(Start start, LearnNewWords learnNewWords, TestYourself testYourself) {
        this.start = start;
        this.learnNewWords = learnNewWords;
        this.testYourself = testYourself;
    }


    public Commands getCommandObject(Message receivedMessage) {
        switch (receivedMessage.getText()){
            case "/start": return start;
            case "/learn_new_words": return learnNewWords;
            case "/test_yourself": return testYourself;
            default: return null;
        }
    }
}
