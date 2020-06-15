package Tresor;

public class Safe {

    private String[] text = new String[100];
    private String schluessel;

    public Safe(String pSchluessel) {
        schluessel = pSchluessel;
        init();
    }

    private void init () {
        text[0] = "Hello World!";
        text[1] = "Hello Cat!";
        text[2] = "Hello Dog!";
        text[3] = "Hello Rat!";
    }

    public void changeSchluessel(String pSchluesselAlt, String pSchluesselNeu) {
        if (pSchluesselAlt.equals(schluessel) || pSchluesselAlt.equals(Masterkey.masterkey)) {
            schluessel = pSchluesselNeu;
            System.out.println("Der Schlüssel für den Tresor wurde erfolgreich geändert!");
        } else {
            System.out.println("Der Schlüssel wurde nicht geändert! (WRONG_KEY_DETECTED)");
        }
    }

    public String getText(String pSchluessel, int pTextNummer) {

        if (pSchluessel.equals(schluessel) || pSchluessel.equals(Masterkey.masterkey)) {
            if (!(pTextNummer >= 0 && pTextNummer <= 99)) {
                return "Der Text kann nicht ausgegeben werden! (ARRAYKEY_OUT_OF_RANGE)";
            } else {
                try {
                    if (text[pTextNummer].isEmpty() || text[pTextNummer] == null) {
                        return "Nur zur NullPointerException erzeugung da :P";
                    } else {
                        return text[pTextNummer];
                    }
                } catch (NullPointerException e) {
                    return "Der Text kann nicht ausgegeben werden! (NO_TEXT_SAVED)";
                }
            }
        } else {
            return "Der Text kann nicht ausgegeben werden! (WRONG_KEY_DETECTED)";
        }
    }

    public void setText(String pSchluessel, int pTextNummer, String pText) {
        if (pSchluessel.equals(schluessel) || pSchluessel.equals(Masterkey.masterkey)) {
            if (!(pTextNummer >= 0 && pTextNummer <= 99)) {
                System.out.println("Der Text konnte nicht aktualisiert/erstellt werden! (ARRAYKEY_OUT_OF_RANGE)");
            } else {
                text[pTextNummer] = pText;
                System.out.println("Der Text wurde erfolgreich aktualisiert/erstellt!");
            }
        } else {
            System.out.println("Der Text konnte nicht aktualisiert/erstellt werden! (WRONG_KEY_DETECTED)");
        }
    }

    public void delText(String pSchluessel, int pTextNummer) {
        if (pSchluessel.equals(schluessel) || pSchluessel.equals(Masterkey.masterkey)) {
            if (!(pTextNummer >= 0 && pTextNummer <= 99)) {
                System.out.println("Der Text konnte nicht gelöscht werden! (ARRAYKEY_OUT_OF_RANGE)");
            } else {
                if (text[pTextNummer] != null) {
                    text[pTextNummer] = null;
                    System.out.println("Der Text wurde erfolgreich gelöscht!");
                } else {
                    System.out.println("Der Text konnte nicht gelöscht werden! (NO_TEXT_FOUND)");
                }
            }
        } else {
            System.out.println("Der Text konnte nicht gelöscht werden! (WRONG_KEY_DETECTED)");
        }
    }
}