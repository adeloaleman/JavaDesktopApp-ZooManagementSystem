/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo.view;

import cctzoo.model.TheModel;
import cctzoo.model.animals.Animal;
import cctzoo.model.keepers.Keeper;
import cctzoo.view.animals.AddAnimalFrame;
import cctzoo.view.animals.UpdateAnimalFrame;
import cctzoo.view.animals.ViewAnimalsFrame;
import cctzoo.view.keepers.AddKeeperFrame;
import cctzoo.view.keepers.UpdateKeeperFrame;
import cctzoo.view.keepers.ViewKeepersFrame;
import java.util.ArrayList;

/**
 *
 * @author guerr
 */
public class TheView {

    ViewAnimalsFrame viewAnimals;
    UpdateAnimalFrame updateAnimal;
    AdminDashboard adminDash;
    AddAnimalFrame addAnimal;
    AddKeeperFrame addKeeper;
    UpdateKeeperFrame updateKeeper;
    ViewKeepersFrame viewKeepers;

    ArrayList<Animal> animals;
    ArrayList<Keeper> keepers;

    public TheView(TheModel model) {

        this.animals = model.getListAnimals();
        this.keepers = model.getListKeepers();

        this.adminDash = new AdminDashboard(this, "Admin - Dashboard", 435, 300, "src/cctzoo/view/images/animal.png");

    }

    public void setAddAnimal(AddAnimalFrame addAnimal) {
        this.addAnimal = addAnimal;
    }

    public void setAddKeeper(AddKeeperFrame addKeeper) {
        this.addKeeper = addKeeper;
    }

    public AddAnimalFrame getAddAnimal() {
        return addAnimal;
    }

    public ViewAnimalsFrame getViewAnimals() {
        return viewAnimals;
    }

    public void setViewAnimals(ViewAnimalsFrame viewAnimals) {
        this.viewAnimals = viewAnimals;
    }

    public void setUpdateAnimal(UpdateAnimalFrame updateAnimal) {
        this.updateAnimal = updateAnimal;
    }

    public UpdateAnimalFrame getUpdateAnimal() {
        return updateAnimal;
    }

    public AdminDashboard getAdminDash() {
        return adminDash;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public AddKeeperFrame getAddKeeper() {
        return addKeeper;
    }

    public UpdateKeeperFrame getUpdateKeeper() {
        return updateKeeper;
    }

    public void setAdminDash(AdminDashboard adminDash) {
        this.adminDash = adminDash;
    }

    public void setUpdateKeeper(UpdateKeeperFrame updateKeeper) {
        this.updateKeeper = updateKeeper;
    }

    public ArrayList<Keeper> getKeepers() {
        return keepers;
    }

    public void setViewKeepers(ViewKeepersFrame viewKeeper) {
        this.viewKeepers = viewKeeper;
    }

    public ViewKeepersFrame getViewKeepers() {
        return viewKeepers;
    }

}
