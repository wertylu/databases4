/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.controller.impl
 * Class: GameControllerImpl
 **/

package kyiv.harvard.lois.controller.impl;

import kyiv.harvard.lois.controller.GameController;
import kyiv.harvard.lois.domain.Game;
import kyiv.harvard.lois.service.GameService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameControllerImpl implements GameController {

    private final GameService gameService;

    public GameControllerImpl(GameService gameService) {
        this.gameService = gameService;
    }


    @Override
    public Optional<Game> findByGameGenre(String genre) {
        return gameService.findByGameGenre(genre);
    }

    @Override
    public Optional<Game> findByGameRating(String rating) {
        return gameService.findByGameRating(rating);
    }

    @Override
    public List<Game> findAll() {
        return gameService.findAll();
    }

    @Override
    public Optional<Game> findById(Integer id) {
        return gameService.findById(id);
    }

    @Override
    public int create(Game game) {
        return gameService.create(game);
    }

    @Override
    public int update(Integer id, Game game) {
        return gameService.update(id, game);
    }

    @Override
    public int delete(Integer id) {
        return gameService.delete(id);
    }
}
