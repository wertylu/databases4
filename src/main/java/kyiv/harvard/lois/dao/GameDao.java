/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.dao
 * Interface: GameDao
 **/

package kyiv.harvard.lois.dao;

import kyiv.harvard.lois.domain.Game;

import java.util.Optional;

public interface GameDao extends GeneralDao<Game, Integer>{
    Optional<Game> findByGameGenre(String genre);

    Optional<Game> findByGameRating(String rating);
}
