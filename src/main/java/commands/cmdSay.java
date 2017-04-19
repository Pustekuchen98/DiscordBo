package commands;

import core.permsCore;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ich1 on 19.04.2017.
 */
public class cmdSay implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {


        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws ParseException, IOException {

        if (permsCore.check(event) < 1) return;
        // LAMBDA VERSION

        List argsList = Arrays.asList(args);
        StringBuilder sb = new StringBuilder();
        argsList.forEach(s -> sb.append(s + " "));
        send(sb.toString(), event);

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        System.out.println("[INFO] Command '-say' wurde ausgeführt!");
    }

    @Override
    public String help() {
        return null;
    }

    private void send(String msg, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage(msg).queue();
    }
}
