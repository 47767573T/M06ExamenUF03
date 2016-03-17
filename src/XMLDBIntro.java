import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;

import java.io.File;

/**
 * Created by dremon on 10/03/16.
 */
public class XMLDBIntro {
    private static String URI = "xmldb:exist://172.31.101.225:8080/exist/xmlrpc";
    private static String driver = "org.exist.xmldb.DatabaseImpl";

    public static void main(String args[]) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {


        afegirFitxer("plantes.xml");

    }

    private static void afegirFitxer(String fl) throws XMLDBException, ClassNotFoundException, IllegalAccessException, InstantiationException{
        File f = new File("plantes.xml");

        // initialize database driver
        Class cl = Class.forName(driver);
        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");

        // crear el manegador
        DatabaseManager.registerDatabase(database);

        //crear la collecion
        Collection parent = DatabaseManager.getCollection(URI+"/db","admin","dionis");
        CollectionManagementService c = (CollectionManagementService) parent.getService("CollectionManagementService", "1.0");

        c.createCollection("moises");

        Collection col = DatabaseManager.getCollection(URI + "/db/moises", "admin", "dionis");
        //afegir el recurs que farem servir
        Resource res = col.createResource("plantes.xml","XMLResource");
        res.setContent(f);
        col.storeResource(res);

    }
}
