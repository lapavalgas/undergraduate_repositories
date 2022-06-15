package com.Cadastros.dao.jdbc;

class DBInfo {
    
    private static String driver = "com.mysql.cj.jdbc.Driver";
//    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/dbsql?useTimezone=true&serverTimezone=UTC";
    private static String user = "root";
    private static String pass = "rootpass";

    public static String getDriver(){
        return driver;
    }
    public static String getUrl() {
        return url;
    }
    public static String getUser() {
        return user;
    }
    public static String getPass() {
        return pass;
    }
}
