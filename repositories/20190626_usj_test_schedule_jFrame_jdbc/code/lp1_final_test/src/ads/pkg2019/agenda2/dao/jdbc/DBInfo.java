package ads.pkg2019.agenda2.dao.jdbc;

class DBInfo {
    
//    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadastrosmartphone", "root", "rafael00");
    
    private static String driver = "com.mysql.cj.jdbc.Driver";
//    private static String driver = "com.mysql.jdbc.Driver";
//    private static String url = "jdbc:mysql://localhost:3306/agenda2?useTimezone=true&serverTimezone=UTC";
    private static String url = "jdbc:mysql://localhost:3306/agenda2";
//    private static String url = "jdbc:mysql://localhost:3306/agenda2?useTimezone=true&serverTimezone=UTC";
//    private static String url = "jdbc:mysql://localhost:3306/agenda2";
    private static String user = "root";
//    private static String pass = "entrar";
    private static String pass = "rafael00";

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
