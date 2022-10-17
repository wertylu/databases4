/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.controller.impl
 * Class: PlatformControllerImpl
 **/

package kyiv.harvard.lois.controller.impl;


import kyiv.harvard.lois.controller.PlatformController;
import kyiv.harvard.lois.domain.Platform;
import kyiv.harvard.lois.service.PlatformService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatformControllerImpl  implements PlatformController {
    private final PlatformService platformService;

    public PlatformControllerImpl(PlatformService platformService) {
        this.platformService = platformService;
    }

    @Override
    public List<Platform> findAll() {
        return platformService.findAll();
    }

    @Override
    public Optional<Platform> findById(Integer id) {
        return platformService.findById(id);
    }

    @Override
    public int create(Platform platform) {
        return platformService.create(platform);
    }

    @Override
    public int update(Integer id, Platform platform) {
        return platformService.update(id, platform);
    }

    @Override
    public int delete(Integer id) {
        return platformService.delete(id);
    }
}
