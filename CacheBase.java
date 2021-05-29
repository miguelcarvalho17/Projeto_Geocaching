package Projeto_Geocaching;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.util.ArrayList;

    public class CacheBase {

        private static String PATH2 = "data/removedcache.txt";

   SeparateChainingHashST<String, Cache> DB_caches = new SeparateChainingHashST<>();

    public CacheBase() {
    }

    public CacheBase(String path){
        CacheBase cbase = new CacheBase();
        In in = new In(path);
        while (!in.isEmpty()) {
            String line = in.readLine();
            String[] fields = line.split(", ");
            String nome = fields[0];
            String tipo = fields[1];
            String latitude = fields[2];
            String longitude = fields[3];
            String regiao = fields[4];
            String dificuldade = fields[5];
            String nitems = fields[6];

            int items = Integer.parseInt(nitems);
            String[] ids = new String[items];
            String[] objetos = new String[items];
            Item[] items_cache = new Item[items];

            for (int i = 0, k = 0; i < items*2 && k < items; i+=2, k++){
                ids[k] = fields[7+i];
                objetos[k] = fields[7+i+1];
                items_cache[k] =  new Item(Integer.parseInt(ids[k]), objetos[k]);
            }

            Point p = new Point(Double.parseDouble(latitude), Double.parseDouble(longitude), regiao);
            Cache c = new Cache(tipo, p, dificuldade, nome);
            for (int i = 0; i < items; i++){
                c.inserir_item(items_cache[i], cbase);
            }
            cbase.getDB_caches().put(c.getNome(), c);
        }
    }

        public SeparateChainingHashST<String, Cache> getDB_caches() {
            return DB_caches;
        }

        public void setDB_caches(SeparateChainingHashST<String, Cache> DB_caches) {
            this.DB_caches = DB_caches;
        }

        /**
         * Permite printar todas as caches existentes na CacheBase
         */
        public void printDBcaches(){
            for (String c : this.getDB_caches().keys()){
                System.out.println(this.getDB_caches().get(c)+ "\n");
            }
        }

        /**
         * Remove a cache da cachebase e escreve-a para um ficheiro txt.
         * @param nome
         */
        public void removeACache(String nome){
            for (String i : this.getDB_caches().keys()){
                if (i.equals(nome)){
                    Cache c = this.getDB_caches().get(i);
                    c.WriteCacheToFile(c,PATH2);
                    this.getDB_caches().delete(nome);
                    return;
                }
            }

        }

        public Cache findCache(String nome) {
            for (String i : this.getDB_caches().keys()) {
                if (i.equals(nome)) {
                    return this.getDB_caches().get(i);
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return "CacheBase{" +
                    "DB_caches=" + DB_caches +
                    '}';
        }
    }
