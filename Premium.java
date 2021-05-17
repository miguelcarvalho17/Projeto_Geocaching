package Projeto_Geocaching;

import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Premium extends Basic {

    public ArrayList<Cache> cachesVisitadasP;

    public Premium(int ID, String nome, UsersBase base) {
        super(ID, nome);
        base.getPremiums().put(super.ID,this);
    }

    public Premium(int ID, String nome) {
        super(ID, nome);
    }

    public Premium(int ID, String nome,UsersBase base, ArrayList<Cache> cachesEscondidasP, ArrayList<Cache> cachesVisitadasP) {
        super(ID, nome, base);
        this.cachesVisitadasP = cachesVisitadasP;
    }

    public ArrayList<Cache> getCachesVisitadasP() {
        return cachesVisitadasP;
    }

    public void setCachesVisitadasP(ArrayList<Cache> cachesVisitadasP) {
        this.cachesVisitadasP = cachesVisitadasP;
    }

    /**
     * Permite um user premium visitar qualquer cache.
     * @param c
     * @param cbase
     */
    public void visitCache(Cache c, CacheBase cbase) {
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
     * Permite um utilizador premium inserir um travelbug numa cache.
     * @param t
     * @param c
     * @param cbase
     */
    public void insert_travelbug(Travel_bugs t, Cache c, CacheBase cbase) {
        if (cbase.DB_caches.contains(c.getNome())) {
            if (c.items.contains(t.getID())) {
                System.out.println("O TravelBug ja se encontra na cache!");
                return;
            }
            cbase.getDB_caches().delete(c.getNome());
            c.items.put(t.getID(), t);
            c.setnItems(c.getnItems()+1);
            System.out.println("TravelBug inserido com sucesso");
            c.setnItems(c.getnItems() + 1);
            LocalDateTime d = LocalDateTime.now();
            String acontecimento = "Travel Bug inserido na cache: "+ t.getObjeto();
            Log l = new Log(acontecimento,d);
            c.getLogs().add(l);
            cbase.getDB_caches().put(c.getNome(),c);
            return;
        }
        System.out.println("Cache nao encontrada!");
    }

    /**
     * Permite inserir qualquer tipo de cache.
     * @param c
     * @param cbase
     */
    public void insertCache(Cache c, CacheBase cbase) {

        if (this.caches.contains(c.getNome())) {
            System.out.println(" Esta cache ja existe: " + c);
            return;
        }

        this.caches.put(c.getNome(), c);
        cbase.DB_caches.put(c.getNome(), c);
    }

    /**
     * Permite um user premium trocar items em qualquer cache.
     * @param i
     * @param nome
     * @param i2
     * @param cbase
     * @param c2missao
     */
    public void trocarItem(Item i, String nome, Item i2, CacheBase cbase, Cache c2missao) {
        Cache aux = searchCache(nome);
        // Cache aux = this.caches.get(nome);// procurar nas caches globais, nao nas do utilizador
         // se a cache for do tipo premium um user basic nao pode trocar items.

        if (aux.getItems().get(i.getID()) == null){
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

    /**
     * Permite remover uma cache.
     * @param nome
     * @param cbase
     */
    public void removerCache(String nome, CacheBase cbase) {
        Cache c = this.caches.get(nome);
        if (c != null) {
            System.out.println("Cache removed: " + c.getNome());
            this.caches.delete(nome);
            cbase.DB_caches.delete(nome);
            return;
        }
        System.out.println("Impossivel remover cache!");
    }

    /**
     * Permite editar uma cache.
     * @param nome
     * @param tipo
     * @param coordenadas
     * @param dificuldade
     * @param cbase
     */
    public void editarCache(String nome, String tipo, Point coordenadas, String dificuldade, CacheBase cbase) {
        Cache c = this.caches.get(nome);
        if (c != null ) {
            cbase.DB_caches.delete(c.getNome());
            c.setCoordenadas(coordenadas);
            c.setDificuldade(dificuldade);
            c.setTipo(tipo);
            cbase.DB_caches.put(c.getNome(),c);
            return;
        }
        System.out.println("Impossivel editar uma cache que nao existe!");
    }

    /**
     * Permite encontrar caches premium com 1 ou + objetos.
     * @param cbasePremium
     */
    public void findCachesPremiumWithObjects(CacheBase cbasePremium) {

        for ( String c : cbasePremium.getDB_caches().keys()) {
            if (cbasePremium.getDB_caches().get(c).getTipo().equals("premium")) {
                if(cbasePremium.getDB_caches().get(c).getnItems()>0){
                    System.out.println(cbasePremium.getDB_caches().get(c).toString());
                }
            }
        }
    }

    /**
     * Permite escrever para um ficheiro um user removido.
     * @param b
     * @param path
     */
    public void WriteUserToFile(Premium b, String path){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true)); //append true
            writer.write(String.valueOf(b.ID));
            writer.write(", ");
            writer.write(b.nome);
            writer.write(", ");
            writer.write("premium");
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
        return "User Premium{" +
                "ID=" + ID +
                ", nome='" + nome + '\'' +
                '}';
    }
}