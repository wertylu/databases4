/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.service.impl
 * Class: GameServiceImpl
 **/

package kyiv.harvard.lois.service.impl;


import kyiv.harvard.lois.dao.GameDao;
import kyiv.harvard.lois.domain.Game;
import kyiv.harvard.lois.service.GameService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {
    private final GameDao gameDao;

    public GameServiceImpl(GameDao gameDao) {
        this.gameDao = gameDao;
    }


    @Override
    public List<Game> findAll() {
        return gameDao.findAll();
    }

    @Override
    public Optional<Game> findById(Integer id) {
        return gameDao.findById(id);
    }

    @Override
    public int create(Game game) {
        return gameDao.create(game);
    }

    @Override
    public int update(Integer id, Game game) {
        return gameDao.update(id, game);
    }

    @Override
    public int delete(Integer id) {
        return gameDao.delete(id);
    }

    @Override
    public Optional<Game> findByGameGenre(String genre) {
        return gameDao.findByGameGenre(genre);
    }

    @Override
    public Optional<Game> findByGameRating(String rating) {
        return gameDao.findByGameRating(rating);
    }
}
