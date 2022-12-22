package com.lindgrei.HWW.Commands.SlashCommands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.util.ArrayList;
import java.util.List;

import static com.lindgrei.HWW.Database.DatabaseHandler.DB;
import static com.lindgrei.HWW.Util.TerminalUtil.logging;


public class CreateDatabaseSlashCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if(event.getName().equals("createdb")){
            String namae = event.getGuild().getName();
            DB(processing(namae.strip().replace(" ","_").replace("'","")));
            //DB(event.getGuild().getId());
            event.reply("Database created!").setEphemeral(true).queue();
            logging(event);
        }
    }
    @Override
    public void onGuildReady(GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("createdb","Creates a db for the server").setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.ADMINISTRATOR)));
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }

    String processing(String name){
        if(name.contains("'")){
            name = name.replace("'", "\'");
        } else if (name.contains(" ")) {
            name = name.replace(" ","_");
        }
        return name;
    }
}
