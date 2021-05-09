package Projeto_Geocaching;

import edu.princeton.cs.algs4.In;


import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {
        UsersBase base = new UsersBase();
        CacheBase cbase = new CacheBase();

        //Requisito 6
        readUtilizadores("data/utilizadores.txt",base);
        readCaches("data/geocaches.txt", cbase);

        //Tarefa Stor
        //Manuel
        Basic manuel = base.getBasics().get(1);
        Item i1 = new Item(2, "bolo");
        manuel.inserirItemUser(i1);
        Cache c1 = cbase.DB_caches.get("geocache1");
        Cache c2 = cbase.DB_caches.get("geocache2");
        Travel_bugs t = new Travel_bugs(19, "capa");
        c2.inserir_item(t, cbase);
        Cache c6 = cbase.DB_caches.get("geocache6");
        Cache c8 = cbase.DB_caches.get("geocache8");
        Cache c13 = cbase.DB_caches.get("geocache13");
        Cache c16 = cbase.DB_caches.get("geocache16");
        Cache c17 = cbase.DB_caches.get("geocache17");
        manuel.visitCache(c1, cbase);
        manuel.visitCache(c2, cbase);
        manuel.trocarItem(t, "geocache2",i1,cbase , c17);
        manuel.visitCache(c6, cbase);
        manuel.visitCache(c8, cbase);
        manuel.visitCache(c13, cbase);
        manuel.visitCache(c16, cbase);
        manuel.visitCache(c17, cbase);
        manuel.userInsertItemCache(t, cbase, "geocache17");

        System.out.println("----------------------//-------------------------");

        //Pedro
        Basic pedro = base.getBasics().get(2);
        Cache c18 = cbase.DB_caches.get("geocache18");
        pedro.visitCache(c18, cbase);
        pedro.visitCache(c13, cbase);
        pedro.visitCache(c8, cbase);
        Item capa = cbase.DB_caches.get("geocache8").items.get(13);
        pedro.userRemoveItemCache(capa, cbase, "geocache8");






        //base.printUsers();
        //cbase.printDBcaches();

        //requisito3(cbase, base);

        //requisito5(cbase, base);

        //Requisito 7
        //saveUsersTXT(base,"data/usersOUT.txt");
        //saveCachesTXT(cbase,"data/geocachesOUT.txt");

        //Requisito 8
        //requisito8(cbase, base);



    }

    public static void requisito3(CacheBase cbase, UsersBase base) {

    //Pesquisa de users
    Basic b1 = base.getBasics().get(4);
    Admin a1 = base.getAdmins().get(3);

    //Inserçao de um user
        Admin b3 = new Admin(25, "Joao", base);

        //Apagar um user
        base.getBasics().delete(b1.getID());

        //Editar o nome de um user basic
    base.getBasics().get(b1.getID()).setNome("Paula");

    //(Editar user)-Tornar um user basic num user premium
    b1 = (Premium)a1.editar_utilizador(b1,4, base, "premium", "Joana");

    //Inserçao de um item num utilizador
    Item i3 = new Item(19, "bola");
    b1.inserirItemUser(i3);

    //Remoçao de um item num utilizador
        b1.items.remove(i3);

    //Utilizador remove Item da Cache
        b1.userRemoveItemCache(i3,cbase,"geocache1");

        //Inserçao de uma cache
        Point p2 = new Point(-6.345875, 5.23455, "Madeira");
        Cache c2 = new Cache("basic",p2, "dificil", 0, "geocache100", cbase);

        //Utilizador insere uma nova cache
        b1.insertCache(c2, cbase);

        //Remoçao de uma cache
        cbase.DB_caches.delete(c2.getNome());

        //Editar uma cache, torna-la premium, um utilizador basic tentar visita-la
        Cache c = cbase.getDB_caches().get("geocache1");
        cbase.getDB_caches().get("geocache1").setTipo("premium");
        b1.visitCache(c, cbase);

        //Inserçao de um Item numa cache
        Item i1 = new Item(20, "luvas");
        cbase.getDB_caches().get("geocache1").inserir_item(i1, cbase);

        //Printar items dentro de uma cache
        c.print_items();

        //Remover um item numa cache
        c.items.delete(i1.getID());

        //Editar item numa cache
        c.editar_item(i1.getID(), "bolo");

        //Utilizador insere item numa cache
        a1.userInsertItemCache(i1,cbase,"geocache1");

        //Troca de items realizado numa cache
        b1.trocarItem(i1, "geocache1", i3, cbase, c);

        //Inserçao de um travel bug
        Travel_bugs t1 = new Travel_bugs(1, "moeda");

    }

    public static void requisito5(CacheBase cbase, UsersBase base){

        //Remoçao de uma cache, guarda a informaçao items, logs, coordenadas no ficheiro removedcache.txt
        cbase.removeACache("geocache1");
        //cbase.printDBcaches();

        Basic b1 = new Basic(7,"Paulo", base);
        Item i1 = new Item(1, "livro");
        b1.inserirItemUser(i1);

        //Remoçao de um user, guardando a informaçao dele, items, nome, ID
        base.removeAUser(7);
        //base.printUsers();
    }

    public static void requisito8(CacheBase cbase, UsersBase base){
        //  a)Todas as caches visitadas por um utilizador. Global e por região;
        //Global
        Admin a = base.getAdmins().get(3);
        Basic b = base.getBasics().get(1);
        Point p2 = new Point(-6.345875, 5.23455, "madeira");
        Cache c2 = new Cache("basic",p2, "dificil", 0, "geocache100", cbase);
        Point p3 = new Point(-5.345875, 10.23455, "norte");
        Cache c3 = new Cache("basic",p3, "dificil", 0, "geocache50", cbase);
        a.visitCache(c2, cbase);
        a.visitCache(c3, cbase);
        //a.find_visitedCaches();

        //Regiao
        //a.find_visitedCaches_regiao("madeira");

        //  b)Todas as caches não visitadas por um utilizador. Global e por região;
        //Global
        //a.FindNonVisitedCaches(cbase);

        //Regiao
        //a.FindNonVisitedCaches_Regiao(cbase, "norte");

        //c) Todos os utilizadores que já visitaram uma dada cache;
        //b.visitCache(c2, cbase);
        //c2.findUsersVisitedCache(base);

        Cache c4 = new Cache("premium",p3, "dificil", 0, "geocache75", cbase);
        Item i2 = new Item(6, "caneta");
        c4.inserir_item(i2, cbase);

        Cache c5 = new Cache("premium",p3, "dificil", 0, "geocache90", cbase);

        //d) Todas as caches premium que têm pelo menos um objecto;
        a.findCachesPremiumWithObjects(cbase);

    }

    /**
     * Lê os users de um ficheiro txt e insere-os.
     * @param path
     * @param base
     */
    public static void readUtilizadores(String path, UsersBase base) {
        In in = new In(path);
        while (!in.isEmpty()) {
            String line = in.readLine();
            String[] fields = line.split(", ");
            String id = fields[0];
            String nome = fields[1];
            String tipo = fields[2];
            if (tipo.equals("basic")) {
                Basic b = new Basic(Integer.parseInt(id), nome);
                base.getBasics().put(b.ID, b);
            } else if (tipo.equals("premium")) {
                Premium p = new Premium(Integer.parseInt(id), nome);
                base.getPremiums().put(p.ID, p);
            } else {
                Admin a = new Admin(Integer.parseInt(id), nome);
                base.getAdmins().put(a.ID, a);
            }
        }
    }

    /**
     * Lê as caches de um ficheiro txt e insere-as.
     * @param path
     * @param cbase
     */
    public static void readCaches(String path, CacheBase cbase) {
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

    /**
     * Guarda os users do sistema num ficheiro txt.
     * @param base
     * @param utxt
     */
    public static void saveUsersTXT(UsersBase base, String utxt){
        try{
            if(!base.getBasics().isEmpty()){
                BufferedWriter writer = new BufferedWriter(new FileWriter(utxt, true));
            for (Integer si :  base.getBasics().keys()){
                writer.write(String.valueOf((base.getBasics().get(si).ID)));
                writer.write(", ");
                writer.write(base.getBasics().get(si).nome);
                writer.write(", ");
                writer.write("basic");
                }
                writer.newLine();
                writer.close();
            }
            if(!base.getPremiums().isEmpty()){
                BufferedWriter writer = new BufferedWriter(new FileWriter(utxt, true));
                for (Integer si :  base.getPremiums().keys()){

                    writer.write(String.valueOf(base.getPremiums().get(si).ID));
                    writer.write(", ");
                    writer.write(base.getPremiums().get(si).nome);
                    writer.write(", ");
                    writer.write("premium");
                }
                writer.newLine();
                writer.close();
            }
            if(!base.getAdmins().isEmpty()){
                BufferedWriter writer = new BufferedWriter(new FileWriter(utxt, true));
                for (Integer si :  base.getAdmins().keys()){

                    writer.write(String.valueOf(base.getAdmins().get(si).ID));
                    writer.write(", ");
                    writer.write(base.getAdmins().get(si).nome);
                    writer.write(", ");
                    writer.write("admin");
                }
                writer.newLine();
                writer.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Guarda as caches do sistema num ficheiro txt.
     * @param cbase
     * @param ctxt
     */
    public static void saveCachesTXT(CacheBase cbase, String ctxt){
        try {
            if (!cbase.getDB_caches().isEmpty()){
                BufferedWriter writer = new BufferedWriter(new FileWriter(ctxt, true));
                for (String si : cbase.getDB_caches().keys()){
                    writer.write(cbase.DB_caches.get(si).getNome());
                    writer.write(", ");
                    writer.write(cbase.DB_caches.get(si).getTipo());
                    writer.write(", ");
                    writer.write(String.valueOf(cbase.DB_caches.get(si).getCoordenadas().latitude));
                    writer.write(", ");
                    writer.write(String.valueOf(cbase.DB_caches.get(si).getCoordenadas().longitude));
                    writer.write(", ");
                    writer.write(cbase.DB_caches.get(si).getCoordenadas().regiao);
                    writer.write(", ");
                    writer.write(cbase.DB_caches.get(si).getDificuldade());
                    writer.write(", ");
                    writer.write(String.valueOf(cbase.DB_caches.get(si).getnItems()));

                    for (Integer i : cbase.DB_caches.get(si).items.keys()){
                        writer.write(", ");
                        writer.write(cbase.DB_caches.get(si).items.get(i).getObjeto());
                    }
                    writer.newLine();
                    writer.write("Logs: ");
                    writer.newLine();
                    for (int i = 0; i < cbase.DB_caches.get(si).getLogs().size();i++){
                        writer.write(String.valueOf(cbase.DB_caches.get(si).getLogs().get(i).ID));
                        writer.write(", ");
                        writer.write(cbase.DB_caches.get(si).getLogs().get(i).acontecimento);
                        writer.write(", ");
                        writer.write(String.valueOf(cbase.DB_caches.get(si).getLogs().get(i).data));
                        writer.newLine();
                    }
                    writer.newLine();
                }
                writer.close();
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

