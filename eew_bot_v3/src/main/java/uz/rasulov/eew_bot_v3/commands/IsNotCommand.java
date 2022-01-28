package uz.rasulov.eew_bot_v3.commands;

import org.springframework.stereotype.Component;
import uz.rasulov.eew_bot_v3.responses.IsNotCommandResponse;
import uz.rasulov.eew_bot_v3.responses.Response;

/**
 * Created by SHR on 28.01.2022
 */
@Component
public class IsNotCommand implements Command{
    private final Response response;

    public IsNotCommand(IsNotCommandResponse response) {
        this.response = response;
    }

    @Override
    public String getApi() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public Response getResponse() {
        return response;
    }
}
