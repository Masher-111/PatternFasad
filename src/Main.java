/*
implementation of the facade pattern on the example of a computer
 */

public class Main {
    public static void main(String[] args) {
        Computer myComp = new Computer();
        myComp.copyData();
    }
}

/*
the computer class (facade) combines all instances of classes
 */
class Computer
{
    //creating class instances to access class methods
    Power myPower = new Power();
    DVDRom myDVDRom = new DVDRom();
    HDD myHDD = new HDD();

    //the copy data method determines the order in which methods are called
    void copyData()
    {
        myPower.turnOn();
        myDVDRom.loadDisk();
        myHDD.copyFromDVD(myDVDRom);

    }

}

/*
computer power supply class
 */
class Power
{
    void turnOn(){};
    void turnOff(){};
}

/*
drive class
 */
class DVDRom
{
    //checking the presence of a disk in the drive
    private boolean disk = false;
    public boolean hasDisk()
    {
        return disk;
    }
    //loading a disk
    void loadDisk()
    {
        disk = true;
    };
    //removing a disk
    void unloadDisk()
    {
        disk = false;
    };
}

/*
a class HDD with the ability to copy data from disk
 */
class HDD
{
    void copyFromDVD(DVDRom dvd)
    {
        System.out.println("Copying is finish");
    };
}