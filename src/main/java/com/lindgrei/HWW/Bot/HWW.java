package com.lindgrei.HWW.Bot;

import com.lindgrei.HWW.Commands.SlashCommands.*;
import com.lindgrei.HWW.Commands.SlashCommands.ModeratingCommands.GetAllMembers;
import com.lindgrei.HWW.EventListeners.JoinListener;
import com.lindgrei.HWW.Util.Constants;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class HWW {
    public HWW(){
        try {
            JDA api = JDABuilder
                    .createDefault(Constants.TOKEN).setEnabledIntents(GatewayIntent.getIntents(GatewayIntent.ALL_INTENTS))
                    .setActivity(Activity.watching("Over the server..."))
                    .setStatus(OnlineStatus.ONLINE)
                    .setMemberCachePolicy(MemberCachePolicy.ALL)
                    .setChunkingFilter(ChunkingFilter.ALL)
                    .addEventListeners(new CommandManager(), new JoinListener(), new PingSlashCommand(), new RoleSlashCommand(),new AvatarSlashCommand(),
                            new GetAllMembers(), new SetTwitchSlashCommand(), new CreateDatabaseSlashCommand())
                    .build().awaitReady();



            Guild guild = api.getGuildById(979478995483635722L);
            if (guild != null){
//                OptionData twitchName = new OptionData(OptionType.STRING,"twitch_url", "This will let us extract the twitch name from the url", true);
                OptionData twitchName = new OptionData(OptionType.STRING,"twitch", "A direct link, or straight up your twitch username!", true);
                guild.upsertCommand("linktwt", "Links your twitch name to your Discord TAG").addOptions(twitchName).queue();
                guild.upsertCommand("ping","Responds with your ping in ms!").queue();
                guild.upsertCommand("welcome", "Welcomes you to the server!").queue();
                guild.upsertCommand("roles", "Sends a list of all available roles!").queue();
                //OptionData op = new OptionData(OptionType.MENTIONABLE,"user", "The user you want the avatar of.", false);
                guild.upsertCommand("avatar", "Gives you your avatar!").queue();
                guild.upsertCommand("members","Sends all members to Database").setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.ADMINISTRATOR)).queue();


                guild.updateCommands().addCommands(Commands.slash("linktwt", "Links your twitch name to your Discord TAG").addOptions(twitchName)).queue();
                guild.updateCommands().addCommands(Commands.slash("createdb","Creates a db for the server").setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.ADMINISTRATOR))).queue();



            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }






    }}
