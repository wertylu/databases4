/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.service.impl
 * Class: SteamServiceImpl
 **/

package kyiv.harvard.lois.service.impl;


import kyiv.harvard.lois.dao.SteamDao;
import kyiv.harvard.lois.domain.Game;
import kyiv.harvard.lois.domain.Steam;
import kyiv.harvard.lois.service.SteamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SteamServiceImpl implements SteamService {
    private final SteamDao steamDao;

    public SteamServiceImpl(SteamDao steamDao) {
        this.steamDao = steamDao;
    }


    @Override
    public List<Steam> findAll() {
        return steamDao.findAll();
    }

    @Override
    public Optional<Steam> findById(Integer id) {
        return steamDao.findById(id);
    }

    @Override
    public int create(Steam steam) {
        return steamDao.create(steam);
    }

    @Override
    public int update(Integer id, Steam steam) {
        return steamDao.update(id, steam);
    }

    @Override
    public int delete(Integer id) {
        return steamDao.delete(id);
    }

    @Override
    public List<Game> findAllGamesBy(Integer id) {
        return steamDao.findAllGamesBy(id);
    }
}
