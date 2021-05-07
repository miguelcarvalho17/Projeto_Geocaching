package Projeto_Geocaching;

import edu.princeton.cs.algs4.RedBlackBST;

import java.util.ArrayList;

public class UsersBase {

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

    @Override
    public String toString() {
        return "UsersBase{" +
                "basics=" + basics +
                ", admins=" + admins +
                ", premiums=" + premiums +
                '}';
    }
}
