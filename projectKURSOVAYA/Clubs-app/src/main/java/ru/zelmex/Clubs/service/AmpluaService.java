package ru.zelmex.Clubs.service;

import ru.zelmex.Clubs.model.Amplua;
import ru.zelmex.Clubs.repository.AmpluaDao;

import java.util.List;
public class AmpluaService {
    private AmpluaDao ampluaDao = new AmpluaDao();
    public AmpluaService() {
    }
    public List<Amplua> findAll() {
        return ampluaDao.findAll();
    }
    public Amplua findOne(final long id) {
        return ampluaDao.findOne(id);
    }
    public void save(final Amplua entity)
    {
        if (entity == null)
            return;
        ampluaDao.save(entity);
    }
    public void update(final Amplua entity)
    {
        if (entity == null)
            return;
        ampluaDao.update(entity);
    }
    public void delete(final Amplua entity)
    {
        if (entity == null)
            return;
        ampluaDao.delete(entity);
    }
    public void deleteById(final Long id)
    {
        if (id == null)
            return;
        ampluaDao.deleteById(id);
    }
}