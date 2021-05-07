package Projeto_Geocaching;

public class Admin extends Premium {

  public Admin(int ID, String nome, UsersBase base) {
    super(ID, nome);
    base.getAdmins().put(super.ID,this);
  }

  public Admin(int ID, String nome) {
    super(ID, nome);
  }


  public void editar_utilizador(int id) {
  }

  public void remover_utilizador(int id) {

  }


  @Override
  public String toString() {
    return "Admin{" +
            "ID=" + ID +
            ", nome='" + nome + '\'' +
            '}';
  }
}