package com.lindgrei.HWW.Commands.SlashCommands.ModeratingCommands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.util.ArrayList;
import java.util.List;

import static com.lindgrei.HWW.Database.DatabaseHandler.InsertIntoDatabase;
import static com.lindgrei.HWW.Util.TerminalUtil.logging;

public class GetAllMembers extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("members")) {
            List<Member> members = event.getGuild().getMembers();

            logging(event);
            for(Member m : members){
                InsertIntoDatabase(event.getGuild().getName().strip().replace(" ","_").replace("'",""), Long.parseLong(m.getUser().getId()), m.getUser().getAsTag());
            }

            event.getChannel().sendMessage("Done adding all members!").queue();


        }
    }
    public void onGuildReady(GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("members","Sends all members to Database").setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.ADMINISTRATOR)));
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }

}


