package com.lindgrei.HWW.Bot;

import com.lindgrei.HWW.Commands.SlashCommands.AvatarSlashCommand;
import com.lindgrei.HWW.Commands.SlashCommands.CommandManager;
import com.lindgrei.HWW.Commands.SlashCommands.PingSlashCommand;
import com.lindgrei.HWW.Commands.SlashCommands.RoleSlashCommand;
import com.lindgrei.HWW.Commands.TextCommands.PingCommand;
import com.lindgrei.HWW.EventListeners.JoinListener;
import com.lindgrei.HWW.Util.Constants;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class HWW {
    public HWW(){
        try {
            JDA api = JDABuilder
                    .createDefault(Constants.TOKEN).setEnabledIntents(GatewayIntent.getIntents(GatewayIntent.ALL_INTENTS))
                    .setActivity(Activity.watching("Over the server..."))
                    .setStatus(OnlineStatus.ONLINE)
                    .setMemberCachePolicy(MemberCachePolicy.ALL)
                    .setChunkingFilter(ChunkingFilter.ALL)
                    .enableCache(CacheFlag.ONLINE_STATUS)
                    .addEventListeners(new CommandManager(), new JoinListener(), new PingSlashCommand(), new RoleSlashCommand(),new AvatarSlashCommand())
                    .build().awaitReady();



            Guild guild = api.getGuildById(1027275001554030633L);
            if (guild != null){
                guild.upsertCommand("ping","Responds with your ping in ms!").queue();
                guild.upsertCommand("welcome", "Welcomes you to the server!").queue();
                guild.upsertCommand("roles", "Sends a list of all available roles!").queue();
//                OptionData op = new OptionData(OptionType.MENTIONABLE,"user", "The user you want the avatar of.", false);
                guild.upsertCommand("avatar", "Gives you your avatar!").queue();

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }






    }}
