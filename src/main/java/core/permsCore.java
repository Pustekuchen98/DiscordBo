package core;

import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

import java.util.Arrays;

/**
 * © Pustekuchen98 2017
 *
 * @author Pustekuchen98
 */

public class permsCore {

    public static int check(MessageReceivedEvent event) {

        for ( Role r : event.getGuild().getMember(event.getAuthor()).getRoles() ) {
            if (Arrays.stream(STATIC.Fullperms).parallel().anyMatch(r.getName()::contains)) {
                return 2;
            } else if (Arrays.stream(STATIC.Perms).parallel().anyMatch(r.getName()::contains))
                return 1;
            else
                event.getTextChannel().sendMessage(":warning:  Sorry, " + event.getAuthor().getAsMention() + ", you don't have the permissions to use this command!").queue();
        }
        return 0;
    }

}