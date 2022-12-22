package com.lindgrei.HWW.Util;

import com.diogonunes.jcolor.AnsiFormat;
import com.diogonunes.jcolor.Attribute;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static com.diogonunes.jcolor.Attribute.*;

public class TerminalUtil {
    Attribute[] warn = new Attribute[]{RED_BACK(), BRIGHT_YELLOW_TEXT(), BOLD()};


    static AnsiFormat f = new AnsiFormat(GREEN_BACK(), WHITE_TEXT(), BOLD());
    static AnsiFormat u = new AnsiFormat(BRIGHT_CYAN_TEXT());

    static AnsiFormat c = new AnsiFormat(BRIGHT_MAGENTA_TEXT());

    static AnsiFormat g = new AnsiFormat(BRIGHT_RED_TEXT());

    static AnsiFormat er = new AnsiFormat(BRIGHT_WHITE_TEXT(), RED_BACK(), BOLD());
    public static void logging(SlashCommandInteractionEvent event){
        String time = "[" + DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()) + "] ";
        String user = event.getUser().getAsTag();
        String command = u.format(user) + " " +" -> " +"|"+ c.format(event.getName())+"|" + " @"+g.format(Objects.requireNonNull(event.getGuild()).getName());
        System.out.println(f.format(time) + command);
    }

    public static void err(Exception e){
        String time = "[" + DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()) + "] ";
        String err = f.format(time) + " " + er.format(e.toString() + " " + e.getMessage()) ;
    }



}
