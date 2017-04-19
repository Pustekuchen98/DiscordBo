package listeners;

import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Created by ich1 on 17.04.2017.
 */
public class voiceListener extends ListenerAdapter {

    public void onGuildVoiceJoin(GuildVoiceJoinEvent event) {
        event.getGuild().getTextChannelsByName("voicelog", true).get(0).sendMessage(
                "Member **" + event.getVoiceState().getMember().getUser().getName() + "** joined voice channel **" + event.getChannelJoined().getName() + "**!"
        ).queue();
    }

    public void onGuildVoiceMove(GuildVoiceMoveEvent event) {
        event.getGuild().getTextChannelsByName("voicelog", true).get(0).sendMessage(
                "Member **" + event.getVoiceState().getMember().getUser().getName() + "** went from voice channel **" + event.getChannelLeft().getName() + "** to voice channel **" + event.getChannelJoined().getName() + "**!"
        ).queue();
    }

}
