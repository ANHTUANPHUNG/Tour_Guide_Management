package Repository;

import java.io.IOException;

public interface CRUD<T> {

    T getById(int id);


    void create() throws IOException;

    void update() throws IOException;

    void delete(int id) throws IOException;

    void display();
}
