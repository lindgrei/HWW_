package com.lindgrei.HWW.Commands.SlashCommands;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.lindgrei.HWW.Util.TerminalUtil.logging;

public class RoleSlashCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if(event.getName().equals("roles")){
            event.deferReply().setEphemeral(true).queue();

            StringBuilder response = new StringBuilder();
            for(Role role : Objects.requireNonNull(event.getGuild()).getRoles()){
                response.append(role.getAsMention()).append("\n");


            }
            logging(event);
            event.getHook().sendMessage(response.toString()).queue();
        }
    }
    @Override
    public void onGuildReady(GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("roles", "Sends a list of all available roles!"));
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }

}
