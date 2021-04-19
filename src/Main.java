import model.Game;
import model.Player;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.util.List;
import java.util.Iterator;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        initWeapon();

        Player player = new Player("John", 100);
        Game game = new Game(player);

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

        List listWeapon = racine.getChildren("weapon");
        Iterator i = listWeapon.iterator();
        while(i.hasNext()) {
            Element courant = (Element)i.next();
            System.out.println(courant.getChild("name").getText());
        }
    }

}
