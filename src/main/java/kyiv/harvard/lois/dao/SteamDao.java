/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.dao
 * Interface: Steam
 **/

package kyiv.harvard.lois.dao;

import kyiv.harvard.lois.domain.Game;
import kyiv.harvard.lois.domain.Steam;

import java.util.List;

public interface SteamDao extends GeneralDao<Steam, Integer>  {
    List<Game> findAllGamesBy(Integer id);

}
