package service;

import DAO.CarDao;
import model.Car;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.DBHelper;

import java.util.List;

public class CarService {

    private static CarService carService;

    private SessionFactory sessionFactory;

    private CarService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static CarService getInstance() {
        if (carService == null) {
            carService = new CarService(DBHelper.getSessionFactory());
        }
        return carService;
    }
//получить данные всех авто
    public List<Car> getAllCars() {

        return new CarDao(sessionFactory.openSession()).getAllCars();
    }
}
