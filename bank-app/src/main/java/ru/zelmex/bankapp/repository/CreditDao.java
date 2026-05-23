package ru.zelmex.bankapp.repository;
import ru.zelmex.bankapp.model.Credit;
public class CreditDao extends BaseDao<Credit> {
    public CreditDao() {
        super(Credit.class);
    }
}