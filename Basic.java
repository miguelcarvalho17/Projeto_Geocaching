package Projeto_Geocaching;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.util.ArrayList;

public class Basic {

    public int ID;

    public String nome;

    public ArrayList<Cache> cachesVisitadasB= new ArrayList<>();

    public ArrayList<Item> items = new ArrayList<>();

    public ArrayList<Cache> cachesEscondidasB = new ArrayList<>();


    SeparateChainingHashST<String, Cache> caches = new SeparateChainingHashST<>();

    public Basic(int ID, String nome) {
        this.ID = ID;
        this.nome = nome;
    }

    public void criarUtilizador(Basic b) {

    }

    public void insertCache(Cache c) {

        if (this.caches.contains(c.getNome())) {
            System.out.println(" Esta cache ja existe: " + c);
            return;
        } else if (c.getTipo().equals("premium")) {
            System.out.println("Utilizador do tipo basic nao pode inserir caches premium");
            return;
        }
        this.caches.put(c.getNome(), c);
        //this.cachesEscondidasB.add(c);
    }


    public void removerCache(String nome) {
        Cache c = this.caches.get(nome);
        if (c != null && !c.getTipo().equals("premium")) {
            System.out.println("Cache removed: " + c.getNome());
            this.caches.delete(nome);
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

    public void trocarItem(Item i, String nome, Item i2) {
        Cache c = this.searchCache(nome);

        if (c.getItems().get(i.getID()) == null) {

            System.out.println("Item nao encontrado");
            return;
        }
        c.remover_item(i.getID()); // i = sai da cache
        c.inserir_item(i2);   // i2 entra
        this.items.add(i); // guarda o item que o user removeu no seu arraylist de items
    }

    @Override
    public String toString() {
        return "User Basic->" + "ID=" + ID + "; nome=" + nome;
    }
}