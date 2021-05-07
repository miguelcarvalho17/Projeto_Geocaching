package Projeto_Geocaching;

import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.util.ArrayList;

public class Premium extends Basic {

    public ArrayList<Cache> cachesEscondidasP;

    public ArrayList<Cache> cachesVisitadasP;


    public Premium(int ID, String nome, UsersBase base) {
        super(ID, nome);
        base.getPremiums().add(this);
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

    public void criar_travelbug(Travel_bugs t, Cache c) {
        if (this.caches.contains(c.getNome())) {
            if (c.travelBugs.contains(t.getID())) {
                System.out.println("O TravelBug ja se encontra na cache!");
                return;
            }
            c.travelBugs.put(t.getID(), t);
            System.out.println("TravelBug inserido com sucesso");
            c.setnItems(c.getnItems() + 1);
            return;
        }
        System.out.println("Cache nao encontrada!");
    }

    public void insertCache(Cache c) {

        if (this.caches.contains(c.getNome())) {
            System.out.println(" Esta cache ja existe: " + c);
            return;
        }

        this.caches.put(c.getNome(), c);
    }

    public void findCachesPremiumWithObjects(CacheBase cbasePremium) {

        for (Cache c : cbasePremium.getCaches()) {
            if (c.getTipo().equals("premium")) {
                if(c.getnItems()>0){
                    System.out.println(c.toString());
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