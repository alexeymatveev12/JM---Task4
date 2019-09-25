package DAO;

import model.DailyReport;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DailyReportDao {

    private Session session;

    public DailyReportDao(Session session) {
        this.session = session;
    }

    //получить все отчёты
    public List<DailyReport> getAllDailyReports() {
        Transaction transaction = session.beginTransaction();
        List<DailyReport> dailyReports = session.createQuery("FROM DailyReport").list();
        transaction.commit();
        session.close();
        return dailyReports;
    }

//получить отчёт за сегодня !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public List<DailyReport> getTodayDailyReport() {
    Transaction transaction = session.beginTransaction();
    List<DailyReport> dailyReport = session.createQuery("FROM DailyReport").list();
    transaction.commit();
    session.close();
    return dailyReport;
}

    //Удалить все отчёты
    public void deleteAllDailyReports() {
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM DailyReport");
        transaction.commit();
        session.close();
    }
}
