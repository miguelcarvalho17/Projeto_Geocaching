package Projeto_Geocaching;

import java.util.ArrayList;

    public class CacheBase {
    private ArrayList<Cache> DB_caches = new ArrayList<>();


    public CacheBase() {
    }

    public CacheBase(ArrayList<Cache> caches) {
            this.DB_caches = caches;
    }

    public ArrayList<Cache> getCaches() {
            return DB_caches;
    }

    public void setCaches(ArrayList<Cache> caches) {
            this.DB_caches = caches;
    }

    @Override
    public String toString() {
            return "CacheBase{" +
                    "caches=" + DB_caches +
                    '}';
    }
    }
