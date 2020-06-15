package Tresor;

public class Masterkey {

    protected static String masterkey = "RST-UVW-XYZ";

    public static void changeMasterkey(String pMasterAlt, String pMasterNeu) {
        if (pMasterAlt.equals(masterkey)) {
            masterkey = pMasterNeu;
            System.out.println("Der Masterschlüssel wurde erfolgreich aktualisiert!");
        } else {
            System.out.println("Der Masterschlüssel wurde nicht aktualisiert! (WRONG_KEY_DETECTED)");
        }
    }
}
