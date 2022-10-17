/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.controller
 * Interface: GameController
 **/

package kyiv.harvard.lois.controller;

import kyiv.harvard.lois.domain.Game;

import java.util.Optional;

public interface GameController extends GeneralController<Game, Integer>{
    Optional<Game> findByGameGenre(String genre);

    Optional<Game> findByGameRating(String rating);
}
