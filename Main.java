package Projeto_Geocaching;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        UsersBase base = new UsersBase();
        CacheBase cbase = new CacheBase();
        Basic b1 = new Basic(1,"Daniel");
        base.getBasics().add(b1);
        Basic b2 = new Basic(2,"Miguel");
        base.getBasics().add(b2);
        Point p1 = new Point(5,2,"Norte");
        Point p2 = new Point(5,2,"Sul");
        Cache c1 = new Cache("basic",p1,"facil",  "geocache1");
        cbase.getCaches().add(c1);
        Cache c2 = new Cache("basic",p2,"facil",  "geocache2");
        cbase.getCaches().add(c2);
        Item i1 = new Item(2,"Livro");

        c2.inserir_item(i1);

        //System.out.println(base.toString());
        //System.out.println(cbase.toString());

        //b1.visitCache(c1);
        //b2.visitCache(c1);

        c1.findUsersVisitedCache(base);
        //b2.visitCache(c2);

        //b2.FindNonVisitedCaches(cbase);
        //b2.FindNonVisitedCaches_Regiao(cbase, "Sul");

        //b2.find_visitedCaches();
        //b2.find_visitedCaches_regiao("Norte");

        //System.out.println(b1);
        //b1.insertCache(c1);
        //b1.editarCache("geocache1", "premium", p1,"dificil");
        //b1.insertCache(c2);
        //c2.inserir_item(i1);
        //b1.printCaches();
        //System.out.println("-----------------------------");
        //b1.removerCache("geocache1");
        //c2.remover_item(2);
        //c2.editar_item(2, "Caderno");
        //b1.printCaches();


        //Premium p = new Premium(2, "Paulo");
        //Cache c3 = new Cache("premium", p1, "dificil","geocache3");
        //p.insertCache(c3);
        //Travel_bugs t = new Travel_bugs(3, "Coin");
        //p.criar_travelbug(t, c3);
        //System.out.println(p);
        //p.printCaches();

    }




    public static void readUtilizadores(String path){
        In in = new In(path);
        while (!in.isEmpty()) {
            String line = in.readLine();
            String[] fields = line.split(",");
            String id = fields[0];
            String nome = fields[1];
            String tipo = fields[2];
            if (tipo.equals("basic")){
                Basic b = new Basic(Integer.parseInt(id), nome);
            }else if(tipo.equals("premium")){
                Premium p = new Premium(Integer.parseInt(id), nome);
            }else{
                Admin a = new Admin(Integer.parseInt(id), nome);
            }
        }
        }

     public static void readCaches(String path){
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

         }
     }
    }

