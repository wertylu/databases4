/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.service
 * Interface: GameService
 **/

package kyiv.harvard.lois.service;

import kyiv.harvard.lois.domain.Game;

import java.util.Optional;

public interface GameService extends GeneralService<Game, Integer> {
    Optional<Game> findByGameGenre(String genre);

    Optional<Game> findByGameRating(String rating);
}
