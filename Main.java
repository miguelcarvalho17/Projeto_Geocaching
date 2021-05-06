package Projeto_Geocaching;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Basic b1 = new Basic(1, "Daniel");
        Point p1 = new Point(5, 2, "Norte");
        Cache c1 = new Cache("basic", p1, "facil", "geocache1");
        Cache c2 = new Cache("basic", p1, "facil", "geocache2");

        Item i1 = new Item(1, "Livro");
        Item i2 = new Item(2, "Caneta");

        System.out.println(b1);
        b1.insertCache(c1); // Utilizador b1 insere uma caixa
        b1.cachesEscondidasB.add(c1); // caixa adicionada as caches escondidas
        c1.inserir_item(i1); // item inserido na cache


        Basic b2 = new Basic(2, "Miguel");
        b2.cachesVisitadasB.add(c1); // Utilizador b2 visita cache c1
        // devemos remove-la das escondidas agora?
        b2.items.add(i2); // User b2 tem um item no seu arraylist de items
        c1.print_items();
        b2.trocarItem(i1, c1.getNome(), i2); // Troca esse item (i2) pelo i1
        System.out.println("/////////////////");
        c1.print_items();
    }


    public static void readUtilizadores(String path) {
        In in = new In(path);
        while (!in.isEmpty()) {
            String line = in.readLine();
            String[] fields = line.split(",");
            String id = fields[0];
            String nome = fields[1];
            String tipo = fields[2];
            if (tipo.equals("basic")) {
                Basic b = new Basic(Integer.parseInt(id), nome);
            } else if (tipo.equals("premium")) {
                Premium p = new Premium(Integer.parseInt(id), nome);
            } else {
                Admin a = new Admin(Integer.parseInt(id), nome);
            }
        }
    }

    public static void readCaches(String path) {
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

