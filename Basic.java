package Projeto_Geocaching;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.util.ArrayList;

public class Basic {

    public int ID;

    public String nome;

    public ArrayList<Cache> cachesVisitadasB = new ArrayList<>();

    public ArrayList<Item> items = new ArrayList<>();

    public ArrayList<Cache> cachesEscondidasB = new ArrayList<>();

    SeparateChainingHashST<String, Cache> caches = new SeparateChainingHashST<>();

    public Basic(int ID, String nome, UsersBase base) {
        this.ID = ID;
        this.nome = nome;
        base.getBasics().put(ID, this);
    }

    public Basic(int ID, String nome) {
        this.ID = ID;
        this.nome = nome;
    }

    public void visitCache(Cache c) {
        this.cachesVisitadasB.add(c);
    }


    public void insertCache(Cache c, CacheBase cbase) {

        if (this.caches.contains(c.getNome())) {
            System.out.println(" Esta cache ja existe: " + c);
            return;
        } else if (c.getTipo().equals("premium")) {
            System.out.println("Utilizador do tipo basic nao pode inserir caches premium");
            return;
        }
        this.caches.put(c.getNome(), c);
        cbase.getDB_caches().put(c.getNome(), c);
    }


    public void removerCache(String nome, CacheBase cbase) {
        Cache c = this.caches.get(nome);
        if (c != null && !c.getTipo().equals("premium")) {
            System.out.println("Cache removed: " + c.getNome());
            this.caches.delete(nome);
            cbase.DB_caches.delete(nome);
            return;
        }
        System.out.println("Impossivel remover cache!");
    }

    public void editarCache(String nome, String tipo, Point coordenadas, String dificuldade) {
        Cache c = this.caches.get(nome);
        if (c != null) {
            c.setCoordenadas(coordenadas);
            c.setDificuldade(dificuldade);
            c.setTipo(tipo);
            return;
        }
        System.out.println("Impossivel editar uma cache que nao existe!");
    }

    public void printCaches() {
        if (this.caches.isEmpty()) {
            System.out.println("Nao existem caches");
            return;
        }
        for (String si : this.caches.keys()) {
            System.out.println("Cache: " + this.caches.get(si));
            this.caches.get(si).print_items();
        }
    }

    public Cache searchCache(String nome) {

        for (Cache c : this.cachesVisitadasB) {
            if (c.getNome().equals(nome)) {
                return c;
            }
        }
        return null;
    }

    public void find_visitedCaches() {
        System.out.println(this.nome + " visitou:");
        for (Cache c : this.cachesVisitadasB) {
            System.out.println(c.toString());
        }
    }

    public void find_visitedCaches_regiao(String regiao) {
        System.out.println(this.nome + " visitou:");
        for (Cache c : this.cachesVisitadasB) {
            if (c.getCoordenadas().regiao.equals(regiao)) {
                System.out.println(c.toString());
            }
        }
    }

    public void FindNonVisitedCaches(CacheBase cbase) {
        System.out.println(this.nome + " nao visitou:");
        for (String si : cbase.getDB_caches().keys()) {
            if (!this.cachesVisitadasB.contains(cbase.getDB_caches().get(si))) {
                System.out.println(cbase.getDB_caches().get(si).toString());
            }
        }
    }

    public void FindNonVisitedCaches_Regiao(CacheBase cbase, String regiao) {
        System.out.println(this.nome + " nao visitou:");
        for (String si : cbase.getDB_caches().keys()) {
            if (!this.cachesVisitadasB.contains(cbase.getDB_caches().get(si))) {
                if (cbase.getDB_caches().get(si).getCoordenadas().regiao.equals(regiao)) {
                    System.out.println(cbase.getDB_caches().get(si).toString());
                }
            }
        }
    }

    public void trocarItem(Item i, String nome, Item i2, CacheBase cbase) {

            Cache aux = searchCache(nome);
           // Cache aux = this.caches.get(nome);// procurar nas caches globais, nao nas do utilizador
            if (aux.getTipo().equals("premium")) {
                System.out.println("Utilizador do tipo basic nao pode interagir com caches premium");
                return;
            } // se a cache for do tipo premium um user basic nao pode trocar items.

            if (aux.getItems().get(i.getID()) == null)  {

                System.out.println("Item nao encontrado");
                return;
            }

            this.items.set(this.items.indexOf(i2),i);

           aux.remover_item(i.getID(), cbase); // i = sai da cache

            aux.inserir_item(i2, cbase);   // i2 entra


        }


    public void inserirItemUser(Item i){
        this.items.add(i);
    }


    @Override
    public String toString() {
        return "User Basic->" + "ID=" + ID + "; nome=" + nome;
    }


}