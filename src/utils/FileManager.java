package utils;

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

public class FileManager {

    final private String dataFolder = System.getProperty("user.home") + "\\Local Settings\\Application Data\\";
    public List<Weapon> weaponsList;
    private String name_app = "DungeonPoo";
    final public String path = dataFolder + name_app;

    public FileManager(String name_app) {
        weaponsList = new ArrayList<>();
        this.name_app = name_app;

        writeFolderAppData();
        initWeapon();
    }

    public void writeFolderAppData() {
        try {
            Files.createDirectories(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initWeapon() {
        Document document = null;
        Element racine;
        SAXBuilder sxb = new SAXBuilder();
        try {
            document = sxb.build(new File("src/fixture/weapons.xml"));
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        racine = document.getRootElement();

        List list = racine.getChildren("weapon");
        Iterator i = list.iterator();

        while(i.hasNext()) {
            Element el = (Element) i.next();
            Weapon weapon = new Weapon(el.getChild("name").getText(), el.getChild("type").getText(), Integer.parseInt(el.getChild("damage").getText()), Double.parseDouble(el.getChild("rarety").getText()));
            weaponsList.add(weapon);
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
}
