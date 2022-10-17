/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.service
 * Interface: SteamService
 **/

package kyiv.harvard.lois.service;

import kyiv.harvard.lois.domain.Game;
import kyiv.harvard.lois.domain.Steam;

import java.util.List;

public interface SteamService extends GeneralService<Steam, Integer> {
    List<Game> findAllGamesBy(Integer id);
}

