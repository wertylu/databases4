/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.controller.impl
 * Class: SteamControllerImpl
 **/

package kyiv.harvard.lois.controller.impl;

import kyiv.harvard.lois.controller.SteamController;
import kyiv.harvard.lois.domain.Game;
import kyiv.harvard.lois.domain.Steam;
import kyiv.harvard.lois.service.SteamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SteamControllerImpl implements SteamController {
    private final SteamService steamService;

    public SteamControllerImpl(SteamService steamService) {
        this.steamService = steamService;
    }


    @Override
    public List<Steam> findAll() {
        return steamService.findAll();
    }

    @Override
    public Optional<Steam> findById(Integer id) {
        return steamService.findById(id);
    }

    @Override
    public int create(Steam steam) {
        return steamService.create(steam);
    }

    @Override
    public int update(Integer id, Steam steam) {
        return steamService.update(id, steam);
    }

    @Override
    public int delete(Integer id) {
        return steamService.delete(id);
    }

    @Override
    public List<Game> findAllGamesBy(Integer id) {
        return steamService.findAllGamesBy(id);
    }
}
