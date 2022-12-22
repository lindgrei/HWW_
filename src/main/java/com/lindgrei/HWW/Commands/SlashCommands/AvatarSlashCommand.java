package com.lindgrei.HWW.Commands.SlashCommands;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.util.ArrayList;
import java.util.List;

import static com.lindgrei.HWW.Util.TerminalUtil.logging;

public class AvatarSlashCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){
        if(event.getName().equals("avatar")){


            event.reply(event.getUser().getAvatar().getUrl()).queue();
            logging(event);
    }


}
    @Override
    public void onGuildReady(GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("avatar", "Gives you your avatar!"));
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }
}
