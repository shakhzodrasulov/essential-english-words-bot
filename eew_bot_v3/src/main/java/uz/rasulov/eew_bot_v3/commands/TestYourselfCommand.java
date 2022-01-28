package uz.rasulov.eew_bot_v3.commands;

import org.springframework.stereotype.Component;
import uz.rasulov.eew_bot_v3.responses.Response;
import uz.rasulov.eew_bot_v3.responses.TestYourselfResponse;
import uz.rasulov.eew_bot_v3.service.Emojiz;

import static uz.rasulov.eew_bot_v3.service.Constants.COMMANDS_LIST;

/**
 * Created by SHR on 27.01.2022
 */
@Component
public class TestYourselfCommand implements Command {
    private final Response response;


    public TestYourselfCommand(TestYourselfResponse response) {
        COMMANDS_LIST.add(this);
        this.response = response;
    }

    @Override
    public String getApi() {
        return "/test_yourself";
    }

    @Override
    public String getTitle() {
        return "Test yourself " + Emojiz.MUSCLE.getValue();
    }

    @Override
    public Response getResponse() {
        return response;
    }
}

