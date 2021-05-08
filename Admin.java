package Projeto_Geocaching;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Admin extends Premium {

  public Admin(int ID, String nome, UsersBase base) {
    super(ID, nome);
    base.getAdmins().put(super.ID,this);
  }

  public Admin(int ID, String nome) {
    super(ID, nome);
  }


  public Object editar_utilizador(Object ob ,int id, UsersBase base, String tipo, String nome) {
    for (Integer i : base.getBasics().keys()){
      if (base.getBasics().get(i).ID == id){
        if (tipo.equals("premium")){
          base.getBasics().delete(i);
          Premium p = new Premium(id, nome, base);
          return p;
        }
        base.getBasics().delete(i);
        Admin a = new Admin(id, nome,base);
        return a;
      }
    }

    for (Integer k : base.getPremiums().keys()){
      if (base.getPremiums().get(k).ID == id){
        if (tipo.equals("basic")){
          base.getPremiums().delete(k);
          Basic b = new Basic(id, nome, base);
          return b;
        }
        base.getPremiums().delete(k);
        Admin a = new Admin(id, nome,base);
        return a;
      }
    }
    System.out.println("Impossivel editar user");
    return ob;
  }

  public void remover_utilizador(int id, UsersBase base) {
    for (int i : base.getBasics().keys()) {

      if (base.getBasics().get(i).ID == id) {
        base.getBasics().delete(i);
        return;
      }
    }
    for (int k : base.getPremiums().keys()) {

      if (base.getPremiums().get(k).ID == id) {
        base.getPremiums().delete(k);
        return;
      }
    }
  }

  public void WriteUserToFile(Admin b, String path){
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(path, true)); //append true
      writer.write(String.valueOf(b.ID));
      writer.write(", ");
      writer.write(b.nome);
      writer.write(", ");
      writer.write("admin");
      writer.newLine();
      for (Item i : b.items){
        writer.write(", ");
        writer.write(i.getObjeto());
      }
      writer.close();
    } catch (Exception e) {
      e.printStackTrace();
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