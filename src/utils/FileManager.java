package utils;

import model.Attack;
import model.Weapon;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileManager implements Serializable {

    final private String dataFolder = System.getProperty("user.home") + "\\Local Settings\\Application Data\\";
    public List<Weapon> weaponsList;
    public List<Attack> attacksList;
    private String name_app = "DungeonPoo";
    final public String path = dataFolder + name_app;

    public FileManager(String name_app) {
        weaponsList = new ArrayList<>();
        attacksList = new ArrayList<>();
        this.name_app = name_app;

        writeFolderAppData();
        initWeapon();
        initAttack();
        for (Attack attack : attacksList) {
            System.out.println(attack.getName());
        }
    }

    public void writeFolderAppData() {
        try {
            Files.createDirectories(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Iterator getXml(String xmlPath, String objectName){
        Document document = null;
        Element racine;
        SAXBuilder sxb = new SAXBuilder();
        try {
            document = sxb.build(new File(xmlPath));
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        racine = document.getRootElement();

        List list = racine.getChildren(objectName);
        Iterator i = list.iterator();
        return i;
    }

    private void initWeapon() {

        Iterator i = getXml("src/fixture/weapons.xml", "weapon");

        while(i.hasNext()) {
            Element el = (Element) i.next();
            Weapon weapon = new Weapon(el.getChild("name").getText(), el.getChild("type").getText(), Integer.parseInt(el.getChild("damage").getText()), Double.parseDouble(el.getChild("rarety").getText()));
            weaponsList.add(weapon);
        }
    }

    private void initAttack() {

        Iterator i = getXml("src/fixture/attacks.xml","attack");

        while(i.hasNext()) {
            Element el = (Element) i.next();
            Attack attack = new Attack(el.getChild("name").getText(), Integer.parseInt(el.getChild("damage").getText()), Double.parseDouble(el.getChild("luck").getText()));
            attacksList.add(attack);
        }
    }

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

    public Object openSavedObject(String nomFichier){
        Object o = null;
        try (ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(path + "/" + nomFichier))) {
            o = objectInput.readObject();
        } catch (EOFException eof) {
            System.out.println("Fichier de sauvegarde vide.");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return o;
    }
}
