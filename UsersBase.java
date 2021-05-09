package Projeto_Geocaching;

import edu.princeton.cs.algs4.RedBlackBST;

import java.util.ArrayList;

public class UsersBase {
    private static String PATH = "data/removed.txt";

    private RedBlackBST<Integer, Basic> basics = new RedBlackBST<>();                /* Array to store users basic */
    private RedBlackBST<Integer, Admin> admins = new RedBlackBST<>();                /* Array to store admins */
    private RedBlackBST<Integer, Premium> premiums = new RedBlackBST<>();             /* Array to store users premium */

    public UsersBase() {
    }

    public UsersBase(RedBlackBST<Integer, Basic> basics, RedBlackBST<Integer, Admin> admins, RedBlackBST<Integer, Premium> premiums) {
        this.basics = basics;
        this.admins = admins;
        this.premiums = premiums;
    }

    public RedBlackBST<Integer, Basic> getBasics() {
        return basics;
    }

    public void setBasics(RedBlackBST<Integer, Basic> basics) {
        this.basics = basics;
    }

    public RedBlackBST<Integer, Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(RedBlackBST<Integer, Admin> admins) {
        this.admins = admins;
    }

    public RedBlackBST<Integer, Premium> getPremiums() {
        return premiums;
    }

    public void setPremiums(RedBlackBST<Integer, Premium> premiums) {
        this.premiums = premiums;
    }

    public void printUsers(){
        for (Integer si : this.getBasics().keys()){
            System.out.println(this.getBasics().get(si) + "\n");
        }
        for (Integer se : this.getPremiums().keys()){
            System.out.println(this.getPremiums().get(se) + "\n");
        }
        for (Integer so : this.getAdmins().keys()){
            System.out.println(this.getAdmins().get(so) + "\n");
        }
    }

    /**
     * Permite remover um user e escreve-lo para um ficheiro txt.
     * @param id
     */
    public void removeAUser(Integer id){
        for (Integer si : this.getBasics().keys()){
            if (this.getBasics().get(si).ID == id){
                Basic b = this.getBasics().get(si);
                b.WriteUserToFile(b, PATH);
                this.getBasics().delete(id);
                return;
            }
        }
        for (Integer se : this.getPremiums().keys()){
            if (this.getPremiums().get(se).ID == id){
                Premium b = this.getPremiums().get(se);
                b.WriteUserToFile(b, PATH);
                this.getPremiums().delete(id);
                return;
            }
        }
        for (Integer so : this.getAdmins().keys()){
            if (this.getAdmins().get(so).ID == id){
                Admin b = this.getAdmins().get(so);
                b.WriteUserToFile(b, PATH);
                this.getAdmins().delete(id);
                return;
            }
        }

    }


    @Override
    public String toString() {
        return "UsersBase{" +
                "basics=" + basics +
                ", admins=" + admins +
                ", premiums=" + premiums +
                '}';
    }
}
