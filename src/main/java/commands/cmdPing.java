package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import core.permsCore;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by ich1 on 18.04.2017.
 */
public class cmdPing implements Command {


    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {


        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws ParseException, IOException {

        event.getTextChannel().sendMessage("Pong!").queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
            System.out.println("[INFO] Command '-ping' wurde ausgeführt!");
    }

    @Override
    public String help() {
        return null;
    }

}
