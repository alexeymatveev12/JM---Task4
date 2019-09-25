package DAO;

import model.Car;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CarDao {

    private Session session;

    public CarDao(Session session) {
        this.session = session;
    }

    /*
    Покупатели могут запросить список имеющихся  машин по url `/customer`GET запросом
      и купить с помощью POST запроса на тот же url, передав параметры марки машины, названия и госномера.

     */

    // 1 посмотреть все авто из базы
    // 2 добавить авто в базу
    //3 удалить купленное авто из базы
    //4 удалить все авто из базы

    public List<Car> getAllCars() {
        Transaction transaction = session.beginTransaction();
        List<Car> allCars = session.createQuery("FROM Car").list();
        transaction.commit();
        session.close();
        return allCars;
    }

      public void addNewCar(Car car) {
        Transaction transaction = session.beginTransaction();
        session.save(car);
        transaction.commit();
        session.close();
    }
    public void deleteSoldCar(Car car) {
        Transaction transaction = session.beginTransaction();
        session.delete(car);
        transaction.commit();
        session.close();
    }

    public void deleteAllCars(Car car) {
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Car");
        query.executeUpdate();
        transaction.commit();
        session.close();

    }
}
