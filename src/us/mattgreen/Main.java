package us.mattgreen;


import java.io.*;
import java.util.ArrayList;


public class Main implements java.io.Serializable{

    private final static FileOutput outFile = new FileOutput("animals.txt");
    private final static FileInput inFile = new FileInput("animals.txt");
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Talkable> zoo = new ArrayList<>();

        //Lines to Replace
        //zoo.add(new Dog(true, "Pete"));
        //zoo.add(new Cat(9, "Anne Belly"));
        //zoo.add(new Student(19, "Joe John Johnson"));
        //End Lines to Replace

        boolean addAnotherAnimal=true;
        AnimalIO input = new AnimalIO();
        do {
            try {
                zoo.add(input.getAnimal());
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
                addAnotherAnimal=false;
            }
        } while(addAnotherAnimal);

        for (Talkable thing: zoo) {
            printOut(thing);
        }
        outFile.fileClose();
        inFile.fileRead();
        inFile.fileClose();
        //LEAVE THIS CODE FOR NEXT WEEK
        FileInput indata = new FileInput("animals.txt");
        String line;

        //Open animals.txt as a binary file
        FileInputStream fstream = new FileInputStream("animals.txt");

        while ((line = indata.fileReadLine()) != null) {
            System.out.println(line);
        }
        //indicate.fileClose();

    }

    public static void printOut(Talkable p)  {
        System.out.println(p.getName() + " says=" + p.talk());
        outFile.fileWrite(p.getName() + "|" + p.talk());

        //for (int i = 0; i < Talkable.; i++){
        //    outFile.fileWrite (p.getName());
        //}

    }
}
