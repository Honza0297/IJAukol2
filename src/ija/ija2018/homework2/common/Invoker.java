package ija.ija2018.homework2.common;

public interface Invoker {
   public boolean execute(Command cmd);
   public void undo();
}
