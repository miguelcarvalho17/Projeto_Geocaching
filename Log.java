package Projeto_Geocaching;

import java.time.LocalDateTime;

public class Log {

  public String acontecimento;

  public LocalDateTime data;

  public int ID;

  public Log(String acontecimento, LocalDateTime data, int ID) {
    this.acontecimento = acontecimento;
    this.data = data;
    this.ID = ID;
  }

  public Log() {
  }

  public String getAcontecimento() {
    return acontecimento;
  }

  public void setAcontecimento(String acontecimento) {
    this.acontecimento = acontecimento;
  }

  public LocalDateTime getData() {
    return data;
  }

  public void setData(LocalDateTime data) {
    this.data = data;
  }

  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  @Override
  public String toString() {
    return "Log{" +
            "ID=" + ID +
            ",acontecimento='" + acontecimento + '\'' +
            ", data=" + data +
            '}';
  }
}