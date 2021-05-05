package Projeto_Geocaching;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Basic b1 = new Basic(1,"Daniel");
        Point p1 = new Point(5,2,"Norte");
        Cache c1 = new Cache("basic",p1,"facil", 5, "geocache1" );



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

