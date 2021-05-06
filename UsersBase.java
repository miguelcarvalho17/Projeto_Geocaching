package Projeto_Geocaching;

import java.util.ArrayList;

public class UsersBase {

    private ArrayList<Admin> admins = new ArrayList<>();                /* Array to store admins */
    private ArrayList<Basic> basics = new ArrayList<>();                /* Array to store users basic */
    private ArrayList<Premium> premiums = new ArrayList<>();             /* Array to store users premium */

    public UsersBase() {
    }

    public UsersBase(ArrayList<Admin> admins, ArrayList<Basic> basics, ArrayList<Premium> premiums) {
        this.admins = admins;
        this.basics = basics;
        this.premiums = premiums;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<Admin> admins) {
        this.admins = admins;
    }

    public ArrayList<Basic> getBasics() {
        return basics;
    }

    public void setBasics(ArrayList<Basic> basics) {
        this.basics = basics;
    }

    public ArrayList<Premium> getPremiums() {
        return premiums;
    }

    public void setPremiums(ArrayList<Premium> premiums) {
        this.premiums = premiums;
    }

    @Override
    public String toString() {
        return "UsersBase:" + "\n"+
                "admins=" + admins + ",\n"+
                "basics=" + basics +",\n"+
                "premiums=" + premiums;
    }
}
