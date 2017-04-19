package listeners;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.ReconnectedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Created by ich1 on 17.04.2017.
 */
public class reconnectListener extends ListenerAdapter {

    public void onReconnect (ReconnectedEvent event) {

        String out = "\nThis bot is running on following servers: \n";
        for (Guild g : event.getJDA().getGuilds() ) {
            out += g.getName()+ " (" + g.getId() + ") \n";
        }

        System.out.println(out);

        for(Guild g : event.getJDA().getGuilds()) {
            g.getTextChannels().get(0).sendMessage(
                    "Hey guys! I'm back again!"
            ).queue();
        }
    }
}
