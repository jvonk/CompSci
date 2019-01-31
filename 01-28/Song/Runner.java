import  java.util.ArrayList;

public class Runner {
    public static void main(String args[]) {
        //What do you have to import to use ArrayList?
        //Because it is part of the java.util package
        //What do you think the ? in ArrayList< ? > represents?
        //the ? represents any non-primitive class
        ArrayList<Song> songList1 = new ArrayList<Song>();
        ArrayList<Song> songList2 = new ArrayList<Song>();
        //What do you think the method add() does?
        //it adds a new item to the ArrayList
        songList1.add(new Song("John", "Happy"));
        songList1.add(new Song("Jose", "Hello"));
        songList2.add(new Song("Toto", "Africa"));
        songList2.add(new Song("South Africa", "Africa"));
        songList2.add(new Song("Weezer", "Africa"));
        //What do you think the method get() does?
        //it gets the item at a position in the ArrayList
        //What method gets called by default when you don't use getName() ?
        //toString()
        System.out.println();
        System.out.println(songList1.get(0).getName());
        System.out.println(songList1.get(1).getName());
        System.out.println(songList1.get(0));
        System.out.println(songList1.get(1));
        System.out.println(songList2.get(0));
        System.out.println(songList2.get(songList2.size()-1));
        //What do you think the method set() does?
        //sets an item in the ArrayList
        System.out.println();
        songList1.set(1, new Song("Jen", "Happy Days"));
        System.out.println(songList1.get(1));
    }
}
