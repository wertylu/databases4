/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.controller
 * Interface: SteamController
 **/

package kyiv.harvard.lois.controller;

import kyiv.harvard.lois.domain.Game;
import kyiv.harvard.lois.domain.Steam;

import java.util.List;

public interface SteamController extends GeneralController<Steam, Integer>  {
    List<Game> findAllGamesBy(Integer id);
}
