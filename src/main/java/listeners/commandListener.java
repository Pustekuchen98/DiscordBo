package listeners;

import core.commandParser;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import core.commandHandler;

import java.io.IOException;
import java.text.ParseException;

public class commandListener extends ListenerAdapter {


    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getMessage().getContent().startsWith("-") && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()) {

            try {
                commandHandler.handleCommand(commandParser.parse(event.getMessage().getContent(), event));
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }

    }
}
