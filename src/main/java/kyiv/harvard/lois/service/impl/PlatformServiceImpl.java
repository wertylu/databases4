/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.service.impl
 * Class: PlatformServiceImpl
 **/

package kyiv.harvard.lois.service.impl;

import kyiv.harvard.lois.dao.PlatformDao;
import kyiv.harvard.lois.domain.Platform;
import kyiv.harvard.lois.service.PlatformService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PlatformServiceImpl implements PlatformService {
    private final PlatformDao platformDao;

    public PlatformServiceImpl(PlatformDao platformDao) {
        this.platformDao = platformDao;
    }

    @Override
    public List<Platform> findAll() {
        return platformDao.findAll();
    }

    @Override
    public Optional<Platform> findById(Integer id) {
        return platformDao.findById(id);
    }

    @Override
    public int create(Platform platform) {
        return platformDao.create(platform);
    }

    @Override
    public int update(Integer id, Platform platform) {
        return platformDao.update(id, platform);
    }

    @Override
    public int delete(Integer id) {
        return platformDao.delete(id);
    }
}
