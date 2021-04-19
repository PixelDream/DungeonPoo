import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.util.List;
import java.util.Iterator;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        initWeapon();
        System.out.println("Hello World!");
    }

    private static void initWeapon() {
        Document document = null;
        Element racine;
        SAXBuilder sxb = new SAXBuilder();
        try {
            document = sxb.build(new File("src/fixture/weapons.xml"));
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        racine = document.getRootElement();

        List listEtudiants = racine.getChildren("weapon");
        Iterator i = listEtudiants.iterator();
        while(i.hasNext()) {
            Element courant = (Element)i.next();
            System.out.println(courant.getChild("name").getText());
        }
    }

}
