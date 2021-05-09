package Projeto_Geocaching;

import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.util.ArrayList;

    public class CacheBase {

        private static String PATH2 = "data/removedcache.txt";

   SeparateChainingHashST<String, Cache> DB_caches = new SeparateChainingHashST<>();

    public CacheBase() {
    }

        public void printDBcaches(){
          for (String c : this.getDB_caches().keys()){
              System.out.println(this.getDB_caches().get(c)+ "\n");
          }
        }

        public SeparateChainingHashST<String, Cache> getDB_caches() {
            return DB_caches;
        }

        public void setDB_caches(SeparateChainingHashST<String, Cache> DB_caches) {
            this.DB_caches = DB_caches;
        }

        /**
         * Remove a cache da cachebase e escreve-a para um ficheiro txt.
         * @param nome
         */
        public void removeCache(String nome){
            for (String i : this.getDB_caches().keys()){
                if (i.equals(nome)){
                    Cache c = this.getDB_caches().get(i);
                    c.WriteCacheToFile(c,PATH2);
                    this.getDB_caches().delete(nome);
                    return;
                }
            }

        }

        @Override
        public String toString() {
            return "CacheBase{" +
                    "DB_caches=" + DB_caches +
                    '}';
        }
    }
