package core;

import commands.cmdClear;
import commands.cmdPing;
import commands.cmdSay;
import listeners.commandListener;
import listeners.readyListener;
import listeners.reconnectListener;
import listeners.voiceListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import util.STATIC;
import util.Secrets;

import javax.security.auth.login.LoginException;

/**
 * Created by ich1 on 17.04.2017.
 */
public class Main {

    public static void main(String[] args) {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        builder.setToken(Secrets.TOKEN);
        builder.setAutoReconnect(true);

        builder.setGame(new Game() {
            @Override
            public String getName() {
                return "version " + STATIC.version;
            }

            @Override
            public String getUrl() {
                return null;
            }

            @Override
            public GameType getType() {
                return GameType.DEFAULT;
            }
        });

        builder.setStatus(OnlineStatus.ONLINE);
        builder.addEventListener(new readyListener());
        builder.addEventListener(new reconnectListener());
        builder.addEventListener(new voiceListener());
        builder.addEventListener(new commandListener());
        commandHandler.commands.put("ping", new cmdPing());
        commandHandler.commands.put("say", new cmdSay());
        commandHandler.commands.put("clear", new cmdClear());

        //test

        try {
            JDA jda = builder.buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RateLimitedException e) {
            e.printStackTrace();
        }
    }

}
