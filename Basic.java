package Projeto_Geocaching;

import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Basic {

    public int ID;

    public String nome;

    public ArrayList<Cache> cachesVisitadasB = new ArrayList<>();

    public ArrayList<Item> items = new ArrayList<>();

    SeparateChainingHashST<String, Cache> caches = new SeparateChainingHashST<>();

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Cache> getCachesVisitadasB() {
        return cachesVisitadasB;
    }

    public void setCachesVisitadasB(ArrayList<Cache> cachesVisitadasB) {
        this.cachesVisitadasB = cachesVisitadasB;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public SeparateChainingHashST<String, Cache> getCaches() {
        return caches;
    }

    public void setCaches(SeparateChainingHashST<String, Cache> caches) {
        this.caches = caches;
    }

    public Basic(int ID, String nome, UsersBase base) {
        this.ID = ID;
        this.nome = nome;
        base.getBasics().put(ID, this);
    }

    public Basic(int ID, String nome) {
        this.ID = ID;
        this.nome = nome;
    }

    public Basic(){
    }

    /**
     * Permite um user basico visitar uma cache basica.
     * @param c
     * @param cbase
     */
    public void visitCache(Cache c, CacheBase cbase) {
        if (c.getTipo().equals("premium")){
            System.out.println("Utilizador do tipo basic nao pode interagir com caches premium");
            return;
        }
        if (cbase.getDB_caches().contains(c.getNome())) {
            LocalDateTime d = LocalDateTime.now();
            String acontecimento = "Cache visitada por " + this.nome;
            Log l = new Log(acontecimento, d);
            c.getLogs().add(l);
            this.cachesVisitadasB.add(c);
        }else{
            System.out.println("Cache inexistente!");
        }
    }

    /**
     * Permite um user basico inserir apenas caches basicas.
     * @param c
     * @param cbase
     */
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

    /**
     * Permite remover caches basicas.
     * @param nome
     * @param cbase
     */

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


    /**
     * Permite editar uma cache basica.
     * @param nome
     * @param coordenadas
     * @param dificuldade
     * @param cbase
     */
    public void editarCache(String nome,Point coordenadas, String dificuldade,CacheBase cbase) {
        Cache c = this.caches.get(nome);
        if (c != null) {
            cbase.DB_caches.delete(c.getNome());
            c.setCoordenadas(coordenadas);
            c.setDificuldade(dificuldade);
            cbase.DB_caches.put(c.getNome(),c);
            return;
        }
        System.out.println("Impossivel editar uma cache que nao existe!");
    }

    /**
     * Printa as caches de um user.
     */
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

    /**
     * Procura uma cache no arraylist de caches visitadas pelo user e retorna-a.
     * @param nome
     * @return
     */
    public Cache searchCache(String nome) {

        for (Cache c : this.cachesVisitadasB) {
            if (c.getNome().equals(nome)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Encontra todas caches visitadas por um user(global).
     */
    public void find_visitedCaches() {
        System.out.println(this.nome + " visitou:");
        for (Cache c : this.cachesVisitadasB) {
            System.out.println(c.toString());
        }
    }

    /**
     * Encontra todas caches visitadas por um user(regional).
     * @param regiao
     */
    public void find_visitedCaches_regiao(String regiao) {
        System.out.println(this.nome + " visitou:");
        for (Cache c : this.cachesVisitadasB) {
            if (c.getCoordenadas().regiao.equals(regiao)) {
                System.out.println(c.toString());
            }
        }
    }

    /**
     * Encontra as caches que nao foram visitadas por um user.
     * @param cbase
     */
    public void FindNonVisitedCaches(CacheBase cbase) {
        System.out.println(this.nome + " nao visitou:");
        for (String si : cbase.getDB_caches().keys()) {
            if (!this.cachesVisitadasB.contains(cbase.getDB_caches().get(si))) {
                System.out.println(cbase.getDB_caches().get(si).toString());
            }
        }
    }

    /**
     * Encontra as caches que nao foram visitadas por um user(regional).
     * @param cbase
     * @param regiao
     */
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

    /**
     * Permite um utilizador trocar items numa cache.
     * @param i
     * @param nome
     * @param i2
     * @param cbase
     * @param c2missao
     */
    public void trocarItem(Item i, String nome, Item i2, CacheBase cbase, Cache c2missao) {

            Cache aux = searchCache(nome);
           // Cache aux = this.caches.get(nome);// procurar nas caches globais, nao nas do utilizador
            if(aux != null){
            if (aux.getItems().get(i.getID()) == null)  {

                System.out.println("Item nao encontrado");
                return;
            }
            if (i instanceof Travel_bugs){
                aux.remover_item(i.getID(), cbase); // i = sai da cache
                this.items.add(i);
                this.items.remove(i2);
                aux.remover_item(i.getID(), cbase); // i = sai da cache

                aux.inserir_item(i2, cbase);   // i2 entra

                ((Travel_bugs) i).setPontopartida(aux);
                System.out.println("Este travel bug tem de ser levado para " +c2missao.getNome());
                ((Travel_bugs) i).setMissao(c2missao);
            }else{
                aux.remover_item(i.getID(), cbase); // i = sai da cache
                this.items.add(i);
                this.items.remove(i2);
                aux.remover_item(i.getID(), cbase); // i = sai da cache

                aux.inserir_item(i2, cbase);   // i2 entra
            }
        }
    }

    /**
     * Permite um user inserir um item dentro de uma cache.
     * @param i
     * @param cbase
     * @param nome
     */
    public void userInsertItemCache(Item i, CacheBase cbase, String nome){
        Cache aux = searchCache(nome);

        if(this.items.contains(i)){
            if (i instanceof Travel_bugs){
                if (aux.getNome().equals(((Travel_bugs) i).getMissao().getNome())){
                    System.out.println("Missao cumprida");
                }
            }
            aux.inserir_item(i,cbase);
            this.items.remove(i);
        }
    }

    /**
     * Permite um user remover um item dentro de uma cache.
     * @param i
     * @param cbase
     * @param nome
     */
    public void userRemoveItemCache(Item i, CacheBase cbase, String nome){
        Cache aux = searchCache(nome);
        if(aux.getItems().contains(i.getID())){
            aux.remover_item(i.getID(),cbase);
            this.items.add(i);
        }
    }

    /**
     * Permite adicionar um item ao arraylist de items do user.
     * @param i
     */
    public void inserirItemUser(Item i){
        this.items.add(i);
    }

    /**
     * Escreve um user removido para um ficheiro txt.
     * @param b
     * @param path
     */
    public void WriteUserToFile(Basic b, String path){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true)); //append true
            writer.write(String.valueOf(b.ID));
            writer.write(", ");
            writer.write(b.nome);
            writer.write(", ");
            writer.write("basic");
            for (Item i : b.items){
                writer.write(", ");
                writer.write(i.getObjeto());
            }
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return "User Basic{" + "ID=" + ID + "; nome=" + nome + "}";
    }


}