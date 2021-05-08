package Projeto_Geocaching;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        UsersBase base = new UsersBase();
        CacheBase cbase = new CacheBase();
        //readUtilizadores("data/utilizadores.txt",base);
        //readCaches("data/geocaches.txt", cbase);
        Premium b1 = new Premium(1, "Daniel", base);
        Basic b2 = new Basic(2, "Miguel", base);
        Admin a1 = new Admin(3,"Joao", base);
        //saveUsersTXT(base,"data/usersOUT.txt");
        //Basic b2 = new Basic(10,"Miguel", base);
        Point p1 = new Point(5, 2, "Norte");
        Point p2 = new Point(7, -6, "Norte");
        Cache c1 = new Cache("premium", p1, "facil", 0, "geocache1", cbase);
        Cache c2 = new Cache("basic", p2, "medio", 0, "geocache3", cbase);

        Item i2 = new Item(2, "caneta");
        cbase.removeCache("geocache1");
        //b1.inserirItemUser(i2);
        //base.removeAUser(1);
        //base.printUsers();


        //Travel_bugs i1 = new Travel_bugs(1, "moeda");
        //Item i2 = new Item(2, "caneta");
        //b1.visitCache(c1);
        //c1.inserir_item(i1, cbase);
        //b1.inserirItemUser(i2);
        //b1.userInsertItemCache(i2,cbase,"geocache1");
        //b1.userRemoveItemCache(i2,cbase,"geocache1");
        //b1.trocarItem(i1,"geocache1", i2, cbase, c2);

        //b1.visitCache(c2);
        //b1.userInsertItemCache(i1,cbase, "geocache3");

        //c1.remover_item(1, cbase);
        //cbase.printDBcaches();
      //  Item i1 = new Item(1, "moeda");
      //  Item i2 = new Item(2, "caneta");
      //  b2.inserirItemUser(i2);

    /*    for (Item i : b2.items) {
            System.out.println(i.getID() + " " + i.getObjeto() + "\n");
        }
        b2.visitCache(c1);
      //  b2.userInsertItemCache(i2,cbase,"geocache1");
        System.out.println("////////////");
        for (Item i : b2.items) {
            System.out.println(i.getID() + " " + i.getObjeto() + "\n");
        }*/

        //Cache c1 = new Cache("premium", p1, "facil", 0, "geocache1", cbase);
        // Cache c3 = new Cache ("basic",p1,"dificil",0,"geocache3",cbase);
        //b1.insertCache(c1, cbase);
        //b1.visitCache(c1);
        //b2.visitCache(c1);
        //c1.inserir_item(i1, cbase);
    //    c1.print_items();


      //  System.out.println(b2.cachesVisitadasB);
     /*   for (Item i : b1.items) {
            System.out.println(i.getID() + " " + i.getObjeto() + "\n");
        }
       */

       //b1.trocarItem(i1, "geocache1", i2, cbase);

        //c1.print_items();
       cbase.printDBcaches();

    }


    public static void readUtilizadores(String path, UsersBase base) {
        In in = new In(path);
        while (!in.isEmpty()) {
            String line = in.readLine();
            String[] fields = line.split(", ");
            String id = fields[0];
            String nome = fields[1];
            String tipo = fields[2];
            if (tipo.equals("basic")) {
                Basic b = new Basic(Integer.parseInt(id), nome);
                base.getBasics().put(b.ID, b);
            } else if (tipo.equals("premium")) {
                Premium p = new Premium(Integer.parseInt(id), nome);
                base.getPremiums().put(p.ID, p);
            } else {
                Admin a = new Admin(Integer.parseInt(id), nome);
                base.getAdmins().put(a.ID, a);
            }
        }
    }

    public static void readCaches(String path, CacheBase cbase) {
        In in = new In(path);
        while (!in.isEmpty()) {
            String line = in.readLine();
            String[] fields = line.split(", ");
            String nome = fields[0];
            String tipo = fields[1];
            String latitude = fields[2];
            String longitude = fields[3];
            String regiao = fields[4];
            String dificuldade = fields[5];
            String nitems = fields[6];

            int items = Integer.parseInt(nitems);
            String[] ids = new String[items];
            String[] objetos = new String[items];
            Item[] items_cache = new Item[items];

            for (int i = 0, k = 0; i < items*2 && k < items; i+=2, k++){
                ids[k] = fields[7+i];
                objetos[k] = fields[7+i+1];
                items_cache[k] =  new Item(Integer.parseInt(ids[k]), objetos[k]);
            }


            Point p = new Point(Double.parseDouble(latitude), Double.parseDouble(longitude), regiao);
            Cache c = new Cache(tipo, p, dificuldade, nome);
            for (int i = 0; i < items; i++){
                c.inserir_item(items_cache[i], cbase);
            }
            cbase.getDB_caches().put(c.getNome(), c);
        }
    }

    public static void saveUsersTXT(UsersBase base, String utxt){
        try{
            if(!base.getBasics().isEmpty()){
                BufferedWriter writer = new BufferedWriter(new FileWriter(utxt, true));
            for (Integer si :  base.getBasics().keys()){
                writer.write(String.valueOf((base.getBasics().get(si).ID)));
                writer.write(", ");
                writer.write(base.getBasics().get(si).nome);
                writer.write(", ");
                writer.write("basic");
                }
                writer.newLine();
                writer.close();
            }
            if(!base.getPremiums().isEmpty()){
                BufferedWriter writer = new BufferedWriter(new FileWriter(utxt, true));
                for (Integer si :  base.getPremiums().keys()){

                    writer.write(String.valueOf(base.getPremiums().get(si).ID));
                    writer.write(", ");
                    writer.write(base.getPremiums().get(si).nome);
                    writer.write(", ");
                    writer.write("premium");
                }
                writer.newLine();
                writer.close();
            }
            if(!base.getAdmins().isEmpty()){
                BufferedWriter writer = new BufferedWriter(new FileWriter(utxt, true));
                for (Integer si :  base.getAdmins().keys()){

                    writer.write(String.valueOf(base.getAdmins().get(si).ID));
                    writer.write(", ");
                    writer.write(base.getAdmins().get(si).nome);
                    writer.write(", ");
                    writer.write("admin");
                }
                writer.newLine();
                writer.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

