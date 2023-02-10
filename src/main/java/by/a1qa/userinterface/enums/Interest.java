package by.a1qa.userinterface.enums;

public enum Interest {
    PONIES("Ponies"), POLO("Polo"), DOUGH("Dough"), SNAILS("Snails"), BALLS("Balls"),
    POST_ITS("Post-its"), FAUCETS("Faucets"), ENVELOPPES("Enveloppes"), CABLES("Cables"),
    QUESTIONS("Questions"), SQUARES("Squares"), PURPLE("Purple"), COTTON("Cotton"),
    DRY_WALL("Dry-wall"), CLOSETS("Closets"), TIRES("Tires"), WINDOWS("Windows"),
    MULLETS("Mullets"), CINNAMON("Cinnamon"), UNSELECT("Unselect");

    private final String elementName;

    Interest(String name) {
        elementName = name;
    }

    @Override
    public String toString(){
        return elementName;
    }
}
