package uz.rasulov.eew_bot_v3.commands;

import org.springframework.stereotype.Component;
import uz.rasulov.eew_bot_v3.responses.Response;
import uz.rasulov.eew_bot_v3.responses.StartResponse;

import static uz.rasulov.eew_bot_v3.service.Constants.COMMANDS_LIST;

/**
 * Created by SHR on 27.01.2022
 */
@Component
public class StartCommand implements Command {
    private final Response response;

    public StartCommand(StartResponse response) {
        COMMANDS_LIST.add(this);
        this.response = response;
    }

    @Override
    public String getApi() {
        return  "/start";
    }

    @Override
    public String getTitle() {
        return "Start";
    }

    @Override
    public Response getResponse() {
        return response;
    }
}
