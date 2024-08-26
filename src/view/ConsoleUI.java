package view;

import java.time.LocalDate;
import java.util.Scanner;

import Jline.console.ConsoleReader;

import Model.Models.Gender;
import presenter.Presenter;

public class ConsoleUI implements View{

    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;
    private PrintHuman humanMenu;
    private PrintFamilytree familyTreeMenu;


    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.presenter = new Presenter(this);
        this.work = true;
        this.menu = new MainMenu(this);
        
    }

    public void createNewTree(){
        System.out.println("input name Family Tree");
    }

    private LocalDate inputDate(){
        System.out.println("input birthdate year");
        String yearString = scanner.nextLine();
        int year = Integer.parseInt(yearString);
        System.out.println("input birthdate mounth");
        String mounthString = scanner.nextLine();
        int mounth = Integer.parseInt(mounthString);
        System.out.println("input birthdate day");
        String dayString = scanner.nextLine();
        int day = Integer.parseInt(dayString);
        return LocalDate.of(year, mounth, day);
    }

    public void bornHuman(){
        System.out.println("input first name");
        String firstName = scanner.nextLine();
        System.out.println("input last name");
        String lastName = scanner.nextLine();
        System.out.println("input family name");
        String familyName = scanner.nextLine();
        LocalDate birthday = inputDate();
        System.out.println("input birthday Place");
        String placename = scanner.nextLine();
        System.out.println("input gender");
        Gender gender = Gender.male;
        presenter.bornHuman(firstName, lastName, familyName, birthday, placename, gender);
    }

    public void wendingHuman(){
        System.out.println("input wide id");
        String wideIdString = scanner.nextLine();
        int wideId = Integer.parseInt(wideIdString);
        System.out.println("input husband id");
        String husbandIdString = scanner.nextLine();
        int husband = Integer.parseInt(husbandIdString);
        LocalDate wendingDate = inputDate();
        System.out.println("input name place wending");
        String placeName = scanner.nextLine();
        presenter.wendingHuman(wideId, husband, wendingDate, placeName);
    }

    public void diedHuman(){
        System.out.println("input human id");
        String humanIdStr = scanner.nextLine();
        int humanId = Integer.parseInt(humanIdStr);
        System.out.println("input date died human");
        LocalDate diedDate = inputDate();
        System.out.println("input name place died");
        String placeName = scanner.nextLine();
        presenter.diedHuman(humanId, diedDate, placeName);
    }

    public void PrintFamilyTreeHuman(){
        presenter.printFamilyTreeHuman();
    }

    public void PrintFamilyTreeEvent(){
        presenter.printEventInFamilyTree();
    }

    //TODO print curent Human in FamilyTree

    public void sortHumanByName(){
        presenter.sortHumanByName();
    }

    public void SortHumanByAge(){
        presenter.sortHumanByAge();
    }

    public void sortHumanById(){
        presenter.sortHumanById();
    }

    public void SaveFamilyTree(){
        System.out.println("input filepath humanDB");
        String filepathHumanDb = scanner.nextLine();
        System.out.println("input filepath EventDB");
        String filepathEventDb = scanner.nextLine();
        presenter.SaveFamilyTree(filepathHumanDb, filepathEventDb);
    }

    public void loadFamilyTree(){
        System.out.println("input filepath humanDB");
        String filepathHumanDb = scanner.nextLine();
        System.out.println("input filepath EventDB");
        String filepathEventDb = scanner.nextLine();
        presenter.LoadFamilyTree(filepathHumanDb);
        presenter.LoadFamilyTree(filepathEventDb);
    }

    @Override
    public void PrintAnswer(String text) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'PrintAnswer'");
    }

    @Override
    public void start() {
  
    }



}
