package com.lindgrei.HWW.Database;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class DatabaseHandler {
    public static void createDB() {
        Connection c;

        try {
            Class.forName("org.postgresql.Driver");
            c = getConnection("jdbc:postgresql://localhost:5432/waougri");
            c.setAutoCommit(false);

            Statement st;
            st = c.createStatement();
            String sql = "CREATE TABLE  SERVER (\n" +
                    "\tID BIGINT DEFAULT NULL,\n" +
                    "\tTAG TEXT DEFAULT NULL,\n" +
                    "\tMSGS INT,\n" +
                    "\tXP NUMERIC,\n" +
                    "\tTWITCH TEXT,\n" +
                    "\t LEVEL INT DEFAULT 1, \n"+
                    "\tPRIMARY KEY (ID,TAG)\n" +
                    ");";


            st.executeUpdate(sql);
            st.close();
            c.commit();
            c.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean InsertMember(long id, String tag) {
        Connection c;
        boolean ztatus;

        try {
            Class.forName("org.postgresql.Driver");
            c = getConnection("jdbc:postgresql://localhost:5432/waougri");
            c.setAutoCommit(false);

            PreparedStatement st;
            st = c.prepareStatement("INSERT INTO SERVER VALUES (?,?,?,?,?,?) ON CONFLICT DO NOTHING ");
            st.setLong(1, id);
            st.setString(2, tag);
            st.setInt(3,0 );
            st.setDouble(4, 0.00);
            st.setString(5, "None");
            st.setInt(6,1);

            //String sql = "INSERT INTO SERVER VALUES ($1,$2,$3,$4,$5) ON CONFLICT DO NOTHING ";


            st.executeUpdate();
            st.close();
            c.commit();
            c.close();
            ztatus = true;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ztatus;
    }

    public static boolean checkIfMemberExists(long id) {
        Connection c;
        boolean ztatus;

        try {
            Class.forName("org.postgresql.Driver");
            c = getConnection("jdbc:postgresql://localhost:5432/waougri");
            c.setAutoCommit(false);

            PreparedStatement st;
            st = c.prepareStatement("SELECT * FROM SERVER WHERE ID = ?");
            st.setLong(1, id);

            ResultSet rs  = st.executeQuery();
            System.out.println(rs.next());

            ztatus = rs.next() ? true : false;

            st.close();
            c.commit();
            c.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return ztatus;
    }

    public static boolean incrementMSGCounter(long id){
        Connection c = null;
        boolean ztatus = false;
        try {
            Class.forName("org.postgresql.Driver");
            c = getConnection("jdbc:postgresql://localhost:5432/waougri");
            c.setAutoCommit(false);

            PreparedStatement st = null;
            //st = c.prepareStatement("SELECT MSGS FROM SERVER WHERE ID = ? ");

            st = c.prepareStatement("UPDATE SERVER SET MSGS = MSGS + 1 WHERE ID = ? ");
            st.setLong(1, id);
            st.executeUpdate();
            st.close();
            c.commit();
            c.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return ztatus;
    }

    public static void addXpToUser(long id, double xp){
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = getConnection("jdbc:postgresql://localhost:5432/waougri");
            c.setAutoCommit(false);


            PreparedStatement st;

            st = c.prepareStatement("UPDATE SERVER SET XP = XP + ? WHERE ID = ? ");
            st.setLong(2, id);
            st.setDouble(1, xp);

            System.out.println("Added " + xp);


            st.executeUpdate();

            st.close();
            c.commit();
            c.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
        public static void main(String[] args) {
            System.out.println("it was like 4 years ago, when I was 12".length());
    }

}
