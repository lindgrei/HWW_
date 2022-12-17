package com.lindgrei.HWW.Commands.SlashCommands;

import com.lindgrei.HWW.Util.Emoji;
import com.lindgrei.HWW.Util.TimeUtil;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.util.ArrayList;
import java.util.List;

public class PingSlashCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        String command = event.getName();
        if(command.equals("ping")){
            String user = event.getUser().getAsMention();
            long time = event.getTimeCreated().toInstant().toEpochMilli();
            long ping = TimeUtil.GetTimeDiff(time);
            event.reply(user + " Your ping is: `" + ping +" ms`" + Emoji.GetRandomMojiBasedOnPing(ping)).queue();

        }
    }

    @Override
    public void onGuildReady(GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("ping", "Gives you your ping in milliseconds"));
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }
}
