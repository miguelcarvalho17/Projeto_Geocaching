package Projeto_Geocaching;

import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Premium extends Basic {

    public ArrayList<Cache> cachesEscondidasP;

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
        this.cachesEscondidasP = cachesEscondidasP;
        this.cachesVisitadasP = cachesVisitadasP;
    }


    public void criarCachePremium(Cache c) {

        if (this.caches.contains(c.getNome())) {
            System.out.println(" Esta cache ja existe: " + c);
            return;
        }
        this.caches.put(c.getNome(), c);
    }

    public void visitCache(Cache c) {
        LocalDateTime d = LocalDateTime.now();
        Random rand = new Random();
        int rand_int1 = rand.nextInt(1000);
        String acontecimento = "Cache visitada por " + this.nome;
        Log l = new Log(acontecimento,d, rand_int1);
        c.getLogs().add(l);
        this.cachesVisitadasB.add(c);
    }

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
            Random rand = new Random();
            int rand_int1 = rand.nextInt(1000);
            String acontecimento = "Travel Bug inserido na cache: "+ t.getObjeto();
            Log l = new Log(acontecimento,d, rand_int1);
            c.getLogs().add(l);
            cbase.getDB_caches().put(c.getNome(),c);
            return;
        }
        System.out.println("Cache nao encontrada!");
    }

    public void insertCache(Cache c, CacheBase cbase) {

        if (this.caches.contains(c.getNome())) {
            System.out.println(" Esta cache ja existe: " + c);
            return;
        }

        this.caches.put(c.getNome(), c);
        cbase.DB_caches.put(c.getNome(), c);
    }

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

            ((Travel_bugs) i).setLocalizacao(aux);
            System.out.println("Este travel bug tem de ser levado para " +c2missao.getNome());
            ((Travel_bugs) i).setMissao(c2missao);
        }else{
            aux.remover_item(i.getID(), cbase); // i = sai da cache
            this.items.add(i);
            this.items.remove(i2);
            aux.remover_item(i.getID(), cbase); // i = sai da cache

            aux.inserir_item(i2, cbase);   // i2 entra
        }

        LocalDateTime d = LocalDateTime.now();
        Random rand = new Random();
        int rand_int1 = rand.nextInt(1000);
        String acontecimento = "Item trocados: " + i.getObjeto() + "," + i2.getObjeto();
        Log l = new Log(acontecimento,d, rand_int1);
        aux.getLogs().add(l);
    }

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

    public void findCachesPremiumWithObjects(CacheBase cbasePremium) {

        for ( String c : cbasePremium.getDB_caches().keys()) {
            if (cbasePremium.getDB_caches().get(c).getTipo().equals("premium")) {
                if(cbasePremium.getDB_caches().get(c).getnItems()>0){
                    System.out.println(cbasePremium.getDB_caches().get(c).toString());
                }
            }
        }
    }

    public void encontrar_travelBug(Travel_bugs t) {

    }

    @Override
    public String toString() {
        return "Premium{" +
                "ID=" + ID +
                ", nome='" + nome + '\'' +
                '}';
    }
}