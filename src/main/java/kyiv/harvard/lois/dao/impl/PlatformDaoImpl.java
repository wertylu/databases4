/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.dao.impl
 * Class: PlatformDaoImpl
 **/

package kyiv.harvard.lois.dao.impl;


import kyiv.harvard.lois.dao.PlatformDao;
import kyiv.harvard.lois.domain.Platform;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class PlatformDaoImpl implements PlatformDao {
    private static final String FIND_ALL = "SELECT * FROM platform";
    private static final String CREATE = "INSERT platform(platform_name) VALUES (?)";
    private static final String UPDATE = "UPDATE platform SET platform_name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM platform WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM platform WHERE id=?";

    private final JdbcTemplate jdbcTemplate;

    public PlatformDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Platform> findAll() {
        return jdbcTemplate.query(FIND_ALL,
                BeanPropertyRowMapper.newInstance(Platform.class));
    }

    @Override
    public Optional<Platform> findById(Integer id) {
        Optional<Platform> platform;
        try {
            platform = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Platform.class), id));
        } catch (EmptyResultDataAccessException e) {
            platform = Optional.empty();
        }
        return platform;
    }

    @Override
    public int create(Platform platform) {
        return jdbcTemplate.update(CREATE,
                platform.getPlatformName());
    }

    @Override
    public int update(Integer id, Platform platform) {
        return jdbcTemplate.update(UPDATE,
                platform.getPlatformName(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
