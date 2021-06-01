package dungeon.utils;

import dungeon.model.Attack;
import dungeon.model.Enemy;
import dungeon.model.Trap;
import dungeon.model.Weapon;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FileManager implements Serializable {

    final private String dataFolder = System.getProperty("user.home") + "\\Local Settings\\Application Data\\";
    private static List<Weapon> weaponsList;
    private static List<Trap> trapsList;
    private static List<Enemy> enemiesList;
    private String name_app = "DungeonPoo";
    final public String path = dataFolder + name_app;

    /**
     * FileManager constructor
     * @param name_app Name of the folder we gonna create to save data
     */

    public FileManager(String name_app) {
        this.name_app = name_app;
        writeFolderAppData();

        weaponsList = new ArrayList<>();
        trapsList = new ArrayList<>();
        enemiesList = new ArrayList<>();
        initWeapon();
        initTraps();
        initEnemy();
    }

    /**
     * Create game folder method
     */

    public void writeFolderAppData() {
        try {
            Files.createDirectories(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fetch XML Data File method
     * @param xmlPath Path to the xml file
     * @param xmlObjectName Name of the main tag
     * @return Iterator which can be used to read data from xml file
     */

    private Iterator getXml(String xmlPath, String xmlObjectName){
        Document document = null;
        Element racine;
        SAXBuilder sxb = new SAXBuilder();
        try {
            document = sxb.build(new InputStreamReader(new FileInputStream(xmlPath), StandardCharsets.UTF_8));
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        racine = document.getRootElement();

        List list = racine.getChildren(xmlObjectName);
        Iterator i = list.iterator();
        return i;
    }

    /**
     * Translate all the Weapons in xml to Java Object
     */

    private void initWeapon() {

        Iterator i = getXml("src/dungeon/fixture/weapons.xml", "weapon");

        while(i.hasNext()) {
            Element el = (Element) i.next();
            Weapon weapon = new Weapon(el.getChild("name").getText(), el.getChild("type").getText(), Integer.parseInt(el.getChild("damage").getText()), Double.parseDouble(el.getChild("rarity").getText()));
            weaponsList.add(weapon);
        }
    }

    public void testXmlMethod(){
        
    }

    /**
     * Translate all the Traps in xml to Java Object
     */

    private void initTraps() {

        Iterator i = getXml("src/dungeon/fixture/traps.xml","trap");

        while(i.hasNext()) {
            Element el = (Element) i.next();
            Trap trap = new Trap(el.getChild("name").getText(), Integer.parseInt(el.getChild("damage").getText()), Double.parseDouble(el.getChild("rarity").getText()));
            trapsList.add(trap);
        }
    }

    /**
     * Translate all the Enemy in xml to Java Object
     */

    private void initEnemy() {

        Iterator i = getXml("src/dungeon/fixture/enemies.xml","enemy");

        while(i.hasNext()) {
            Element el = (Element) i.next();
            List<Attack> attacksList = new ArrayList<>();
            for (Element attack : el.getChild("attacks").getChildren("attack")) {
                attacksList.add(new Attack(attack.getChild("name").getText(), Double.parseDouble(attack.getChild("damage").getText())));
            }
            Collections.shuffle(attacksList);
            Enemy enemy = new Enemy(el.getChild("name").getText(), Integer.parseInt(el.getChild("lifepoint").getText()), attacksList);
            enemiesList.add(enemy);
        }
    }

    /**
     * Save Java object to file by Serialization method
     * @param obj Object to save
     * @param nomFichier File's name we want
     */

    public void saveObject(Object obj, String nomFichier) {
        try {
            FileOutputStream file = new FileOutputStream(path + "/" + nomFichier);
            ObjectOutputStream object = new ObjectOutputStream(file);
            object.writeObject(obj);
            object.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get Serialize object from file into Java method
     * @param nomFichier File to open
     * @return Object store in that file
     * @throws IOException Because we read a file
     */

    public Object openSavedObject(String nomFichier) throws IOException {
        Object o = null;
        try (ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(path + "/" + nomFichier))) {
            o = objectInput.readObject();
        } catch (EOFException eof) {
            System.out.println("Fichier de sauvegarde vide.");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return o;
    }

    public static List<Weapon> getWeaponsList() {
        return weaponsList;
    }

    public static List<Trap> getTrapsList() {
        return trapsList;
    }

    public static List<Enemy> getEnemiesList() {
        return enemiesList;
    }
}
