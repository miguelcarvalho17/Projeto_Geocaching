package Projeto_Geocaching;

public class Admin extends Premium {

    public Admin(int ID, String nome, UsersBase base) {
        super(ID, nome);
        base.getAdmins().put(super.ID, this);
    }

    public Admin(int ID, String nome) {
        super(ID, nome);
    }


    public void editar_utilizador(int id, UsersBase base, String tipo, String nome) {
        for (Integer i : base.getBasics().keys()){
            if (base.getBasics().get(i).ID == id){
                if (tipo.equals("premium")){
                    base.getBasics().delete(i);
                    Premium p = new Premium(id, nome, base);
                    return;
                }
                base.getBasics().delete(i);
                Admin a = new Admin(id, nome,base);
                return;
            }
        }

        for (Integer k : base.getPremiums().keys()){
            if (base.getPremiums().get(k).ID == id){
                if (tipo.equals("premium")){
                    base.getPremiums().delete(k);
                    Basic b = new Basic(id, nome, base);
                    return;
                }
                base.getPremiums().delete(k);
                Admin a = new Admin(id, nome,base);
                return;
            }
        }
    }

    public void remover_utilizador(int id, UsersBase cbase) {

        for (int i : cbase.getBasics().keys()) {

            if (cbase.getBasics().get(i).ID == id) {
                cbase.getBasics().delete(i);
                return;
            }
        }
        for (int k : cbase.getPremiums().keys()) {

            if (cbase.getPremiums().get(k).ID == id) {
                cbase.getPremiums().delete(k);
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "Admin{" +
                "ID=" + ID +
                ", nome='" + nome + '\'' +
                '}';
    }
}