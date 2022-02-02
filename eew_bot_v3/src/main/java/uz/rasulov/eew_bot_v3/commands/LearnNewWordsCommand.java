package uz.rasulov.eew_bot_v3.commands;

import org.springframework.stereotype.Component;
import uz.rasulov.eew_bot_v3.responses.LearnNewWordsResponse;
import uz.rasulov.eew_bot_v3.responses.Response;
import uz.rasulov.eew_bot_v3.service.Constants;
import uz.rasulov.eew_bot_v3.service.Emojiz;

import static uz.rasulov.eew_bot_v3.service.Constants.COMMANDS_LIST;

/**
 * Created by SHR on 27.01.2022
 */
@Component
public class LearnNewWordsCommand implements Command {
    private final Response response;


    public LearnNewWordsCommand(LearnNewWordsResponse response) {
        COMMANDS_LIST.add(this);
        this.response = response;
    }

    @Override
    public String getApi() {
        return "/learn_new_words";
    }

    @Override
    public String getTitle() {
        return "Learn new words " + Emojiz.BOOK.getValue();
    }

    @Override
    public Response getResponse() {
        Constants.scriptName = "learn_new_words";
        return response;
    }
}

