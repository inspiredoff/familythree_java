package Model.Service.FamilyTreeNameDatabase;

import java.util.ArrayList;
import java.util.List;

import Model.Models.FamilyTreeName.FamilyTree;;


public class FamilyTreeNameDatabase {

    private List<FamilyTree> familyTreeNameDatabase;

    public FamilyTreeNameDatabase() {
        this.familyTreeNameDatabase = new ArrayList<>();
    }

    public void addFamilyTree(int familyTreeId, String familyTreeName){
        FamilyTree familyTree = new FamilyTree(familyTreeId, familyTreeName);
        this.familyTreeNameDatabase.add(familyTree);
    }

    public String getFamilyTreeNameById(int familyTreeId){
        for (FamilyTree familyTree : familyTreeNameDatabase) {
            if (familyTree.getFamilyTreeId() == familyTreeId) {
                return familyTree.getName();
            }
        }
        System.out.println("Family tree not found");
        return null;
    }
}
