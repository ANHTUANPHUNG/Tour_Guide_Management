package Repository;

import java.io.IOException;

public interface CRUD<T> {

    T getById();


    void create() ;

    void update() ;

    void delete() ;

    void display();
}
