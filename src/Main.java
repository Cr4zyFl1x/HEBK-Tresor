// Pakete importieren
import Tresor.*;

public class Main {

    public static void main(String[] args) {

        Safe safe1 = new Safe("ABC-DEF-GHI"); // Tresor mit Schlüssel 'ABC-DEF-GHI' erzeugen
        Safe safe2 = new Safe("123-456-789"); // Tresor mit Schlüssel '123-456-789' erzeugen


        /*  'Masterkey.*' ist static, da nur ein Masterkey existiert!
         *  Die Variable 'Masterkey.masterkey' ist NICHT sichtbar! -> In 'Tresor' vererbt
         *  Lediglich die Methode 'Masterkey.changeMasterkey()' kann zum ändern des Keys genutzt werden!
         *	Masterschlüssel bei Init. : RST-UVW-XYZ
         */

        Masterkey.changeMasterkey("RST-UVW-XYZ" , "ZYX-WVU-TSR");
        // System.out.println(Masterkey.masterkey); // Print Masterkey

        /*	Main.java:19: error: masterkey has protected access in Masterkey
         *      System.out.println(Masterkey.masterkey);
         *                                  ^
         *	1 error
         */


        // Schlüssel des Tresors(1) ändern.
        safe1.changeSchluessel("ABC-DEF-GHI", "IHG-FED-CBA");

        // Schlüssel des Tresors(2) unter Anwenung des Masterschlüssels ändern.
        safe2.changeSchluessel("ZYX-WVU-TSR", "987-654-321");



        // Gespeicherte Texte ausgeben (0 - 99)
        System.out.println(safe1.getText("IHG-FED-CBA", 0));

        // Text erstellen/aktualisieren
        safe1.setText("IHG-FED-CBA", 0, "Hello Moon!");

        // Aktualisierte/Neue Texte ausgeben
        System.out.println(safe1.getText("IHG-FED-CBA", 0));

        // Texte löschen
        safe1.delText("IHG-FED-CBA", 0);

        // Aktualisierte/Neue Texte ausgeben
        System.out.println(safe1.getText("IHG-FED-CBA", 0)); // Text ist nicht vorhanden

    }
}
