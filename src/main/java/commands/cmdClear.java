package commands;

import core.permsCore;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by ich1 on 19.04.2017.
 */
public class cmdClear implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    public static String HELP = ":warning:  USAGE: ` ~clear <amount ob messages (>2)> to clear an amount of chat messages`";

    private int getNumberOfArg(String arg) {

        try {
            return Integer.parseInt(arg);
        } catch (Exception e) {
            return 0;
        }
    }

    private void clearNumb(MessageReceivedEvent event, String[] args) {


        if (Integer.parseInt(args[0]) > 1) {

            MessageHistory history = new MessageHistory(event.getTextChannel());
            List<Message> msgs;

            try {
                msgs = history.retrievePast(Integer.parseInt(args[0])).complete();
                event.getTextChannel().deleteMessages(msgs).queue();

                msgs = history.retrievePast(2).complete();
                event.getTextChannel().deleteMessageById(msgs.get(0).getId()).queue();

                event.getTextChannel().sendMessage(args[0]+ " Messages deleted!").queue();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (Integer.parseInt(args[0]) == 1) {

            MessageHistory history = new MessageHistory(event.getTextChannel());
            List<Message> msgs;

            try {
                msgs = history.retrievePast(1).complete();
                event.getTextChannel().deleteMessageById(msgs.get(0).getId()).queue();

                msgs = history.retrievePast(2).complete();
                event.getTextChannel().deleteMessageById(msgs.get(0).getId()).queue();

                event.getTextChannel().sendMessage(args[0]+ " Message deleted!").queue();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws ParseException, IOException {
        if (permsCore.check(event) > 1)

            if (args.length > 0 && getNumberOfArg(args[0]) > 0) {
                clearNumb(event, args);
            }

            MessageHistory history = new MessageHistory(event.getTextChannel());
            List<Message> msgs;

            MessageHistory historyAfter = new MessageHistory(event.getTextChannel());

            try {
                Thread.sleep(5000);

                msgs = historyAfter.retrievePast(1).complete();
                event.getTextChannel().deleteMessageById(msgs.get(0).getId()).queue();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        System.out.println("[INFO] Command '-clear' wurde ausgeführt!");
    }

    @Override
    public String help() {
        return HELP;
    }
}
