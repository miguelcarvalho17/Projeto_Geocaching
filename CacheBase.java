package Projeto_Geocaching;

import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.util.ArrayList;

    public class CacheBase {

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


        @Override
        public String toString() {
            return "CacheBase{" +
                    "DB_caches=" + DB_caches +
                    '}';
        }
    }
