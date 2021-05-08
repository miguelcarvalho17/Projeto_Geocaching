package Projeto_Geocaching;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        UsersBase base = new UsersBase();
        CacheBase cbase = new CacheBase();
        //readUtilizadores("data/utilizadores.txt",base);
        Premium b1 = new Premium(1, "Daniel", base);
        Basic b2 = new Basic(2, "Miguel", base);

        //Basic b2 = new Basic(10,"Miguel", base);
        Point p1 = new Point(5, 2, "Norte");

        Item i1 = new Item(1, "tu madre");
        Item i2 = new Item(2, "tu padre");


        Cache c1 = new Cache("premium", p1, "facil", 0, "geocache1", cbase);
        // Cache c3 = new Cache ("basic",p1,"dificil",0,"geocache3",cbase);
        b1.insertCache(c1, cbase);
        b1.visitCache(c1);
        b2.visitCache(c1);
        c1.inserir_item(i1, cbase);
    //    c1.print_items();
        b2.inserirItemUser(i2);

      //  System.out.println(b2.cachesVisitadasB);

     /*   for (Item i : b1.items) {
            System.out.println(i.getID() + " " + i.getObjeto() + "\n");
        }

        for (Item i : b1.items) {
            System.out.println(i.getID() + " " + i.getObjeto() + "\n");
        }*/

       b2.trocarItem(i1, "geocache1", i2, cbase);

        c1.print_items();


    }


    public static void readUtilizadores(String path, UsersBase base) {
        In in = new In(path);
        while (!in.isEmpty()) {
            String line = in.readLine();
            String[] fields = line.split(",");
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
            String[] fields = line.split(",");
            String nome = fields[0];
            String tipo = fields[1];
            String dificuldade = fields[2];
            String regiao = fields[3];
            String latitude = fields[4];
            String longitude = fields[5];
            String nitems = fields[6];

            Point p = new Point(Double.parseDouble(latitude), Double.parseDouble(longitude), regiao);
            Cache c = new Cache(tipo, p, dificuldade, Integer.parseInt(nitems), nome);
            cbase.getDB_caches().put(c.getNome(), c);
        }
    }
}

