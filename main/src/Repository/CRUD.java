package Repository;

import java.io.IOException;

public interface CRUD<T> {

        T getById(int id);


        void createGuide() throws IOException;

        void update(int id);

        void delete(int id) throws IOException;
        void display();
}
