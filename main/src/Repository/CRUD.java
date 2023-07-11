package Repository;

import java.io.IOException;

public interface CRUD<T> {

    T getById(int id);


    void create() ;

    void update(int id) ;

    void delete(int id) ;

    void display();
}
