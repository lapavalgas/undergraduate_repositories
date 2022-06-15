package ads.pkg2019.agenda2.dao.jdbc;

class DBInfo {
    
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/dbsql?useTimezone=true&serverTimezone=UTC";
    private static String user = "user";
    private static String pass = "pass";

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
