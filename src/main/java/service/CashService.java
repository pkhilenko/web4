package service;

import DAO.CashDao;
import model.Cash;

import java.util.List;

public class CashService {
    private static CashService cashService;

    public static CashService getInstance() {
        if (cashService == null) {
            cashService = new CashService();
        }
        return cashService;
    }

    CashDao cashDao = null;

    CashDao dao = getCashDao();

    private CashDao getCashDao() {
        if (cashDao == null) {
            cashDao = new CashDao();
        }
        return cashDao;
    }

    public void addCash(Cash cash) {
        dao.add(cash);
    }

    public List<Cash> getAllCash() {
        return dao.getAllCash();
    }

    public void clearCash() {
        dao.clearCash();
    }
}
