package poly.barber.controller;

import java.util.List;

public interface CrudController<Entity> {
    void open();

    void setForm(Entity entity);

    Entity getForm();

    void fillToTable(List<Entity> lst);

    void edit();

    void clear();

    void setEditable(boolean editable);

    void checkAll();

    void uncheckAll();

    void deleteCheckedItems();

    void moveFirst();

    void movePrevious();

    void moveNext();

    void moveLast();

    void moveTo(int rowIndex);
}
