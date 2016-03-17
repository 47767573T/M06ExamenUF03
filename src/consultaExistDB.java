/**
 * Created by 47767573t on 17/03/16.
 */
import net.xqj.exist.ExistXQDataSource;
import javax.xml.xquery.*;
public class consultaExistDB {
/*
    static XQDataSource xqs = new ExistXQDataSource();
    static String query = "";
    static XQConnection xconn;
    static XQPreparedExpression xqpe;
    static XQResultSequence xqResult;
  */

    public static void main(String[] args) throws XQException {




        String query= "/CATALOG/PLANT/COMMON";
        String comunes = consulta(query);
        System.out.println("FIN");

        String [] name = comunes.replaceAll("</COMMON>","").split("<COMMON>");
        System.out.println("Hi han "+(name.length -1) +" plantes");
        for (int i = 0; i < name.length; i++) {
            System.out.println(name[i]);
        }

    }

    public static String consulta (String q) throws XQException {
        String resultado = "";
        String linea = "";
        XQDataSource xqs = new ExistXQDataSource();
        xqs.setProperty("serverName", "172.31.101.225");
        xqs.setProperty("port", "8080");

        System.out.println("1");
        XQConnection conn = xqs.getConnection();

        XQPreparedExpression xqpe = conn.prepareExpression(q);

        XQResultSequence rs = xqpe.executeQuery();

        while (rs.next()){
            System.out.println("2");
            linea = rs.getItemAsString(null);
            resultado += linea;

        }

        System.out.println(resultado);

        conn.close();
        return resultado;
    }
}