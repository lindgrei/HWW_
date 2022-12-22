package com.lindgrei.HWW.Database;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.sql.*;
import java.util.Arrays;

import static com.lindgrei.HWW.Util.TerminalUtil.err;
import static java.sql.DriverManager.getConnection;

public class DatabaseHandler {
    public static void InsertIntoDatabase(String name, long id, String Tag){
        Connection c = null;

        try{
            Class.forName("org.postgresql.Driver");
            c = getConnection("jdbc:postgresql://localhost:5432/waougri");
            c.setAutoCommit(false);

//            PreparedStatement st = null;
//
//
//            st =c.prepareStatement("INSERT INTO SERVER  (ID, NAME, Twitch) VALUES (?,?,?) ON CONFLICT DO NOTHING ");
//            st.setLong(1,id);
//            st.setString(2, Tag);
//            st.setString(3, "");
//            st.executeUpdate();
//            st.close();
//            c.commit();
//            c.close();

            Statement stt = c.createStatement();
            String qr = "INSERT INTO $1 (ID, Members, TwitchUsername) VALUES ($3,$4, $5) ON CONFLICT DO NOTHING";
            qr = qr.replace("$1", name);
            qr = qr.replace("$4", Tag);
            qr = qr.replace("$3", String.valueOf(id));
            qr = qr.replace("$5", "");
            stt.executeQuery(qr);
            c.commit();
            stt.close();
            c.close();


        } catch (ClassNotFoundException | SQLException e) {
            err(e);
            throw new RuntimeException(e);
        }
    }

    public static boolean InsertTwitchNameIntoDatabase(SlashCommandInteractionEvent event,String name, long id, String TwitchName){
        boolean status = true;
        Connection c = null;
        Statement stmt = null;

        try{
            Class.forName("org.postgresql.Driver");
            c = getConnection("jdbc:postgresql://localhost:5432/waougri");
            stmt = c.createStatement();
            c.setAutoCommit(false);


            Statement st = c.createStatement();
            String qr = "UPDATE $1 SET TwitchUsername = $2 WHERE ID = $3";
            qr = qr.replace("$1", name);
            qr = qr.replace("$2",TwitchName);
            qr = qr.replace("$3", String.valueOf(id));
            st.executeUpdate(qr);
            c.commit();
            st.close();
            c.close();
        } catch (SQLException | ClassNotFoundException e) {
            event.getChannel().sendMessage("A Runtime Exception has happened. Contact the owner! "  +"`"+ Arrays.toString(e.getStackTrace())+"`").queue();
            err(e);
            throw new RuntimeException(e);

        }


        return status;
    }



    public static void DB(String name){
        Connection c = null;
        try{

            Class.forName("org.postgresql.Driver");
            c = getConnection("jdbc:postgresql://localhost:5432/waougri");
            c.setAutoCommit(false);
            Statement st = c.createStatement();
            String qr = "CREATE TABLE IF NOT EXISTS $1(ID int PRIMARY KEY ," +
                    " Members text, " +
                    "TwitchUsername text)";
            qr = qr.replace("$1", name);
            st.executeUpdate(qr);
            c.commit();
            st.close();
            c.close();

        } catch (SQLException | ClassNotFoundException e) {
            err(e);
            throw new RuntimeException(e);
        }
    }

    }

