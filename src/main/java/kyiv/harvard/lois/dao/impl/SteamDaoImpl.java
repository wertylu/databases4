/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.dao.impl
 * Class: SteamDaoImpl
 **/

package kyiv.harvard.lois.dao.impl;

import kyiv.harvard.lois.dao.SteamDao;
import kyiv.harvard.lois.domain.Game;
import kyiv.harvard.lois.domain.Steam;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@SuppressWarnings("SqlResolve")
@Service
public class SteamDaoImpl implements SteamDao {

    private static final String FIND_ALL = "SELECT * FROM steam";
    private static final String CREATE = "INSERT steam(money_on_steam, number_of_friends, user_id) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE steam SET money_on_steam=?, number_of_friends=?, user_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM steam WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM steam WHERE id=?";
    private static final String FIND_ALL_GAMES = "SELECT * FROM game WHERE EXISTS(SELECT * FROM steam_has_game  WHERE game_id=id and steam_id=?)";

    private final JdbcTemplate jdbcTemplate;

    public SteamDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public List<Steam> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Steam.class));
    }

    @Override
    public Optional<Steam> findById(Integer id) {
        Optional<Steam> steam;
        try {
            steam = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Steam.class), id));
        } catch (EmptyResultDataAccessException e) {
            steam = Optional.empty();
        }
        return steam;
    }

    @Override
    public int create(Steam steam) {
        return jdbcTemplate.update(CREATE, steam.getMoneyOnSteam(),steam.getNumberOfFriends(),steam.getUserId());
    }

    @Override
    public int update(Integer id, Steam steam) {
        return jdbcTemplate.update(UPDATE,
                steam.getMoneyOnSteam(),steam.getNumberOfFriends(),
                steam.getUserId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public List<Game> findAllGamesBy(Integer id) {
        return jdbcTemplate.query(FIND_ALL_GAMES, BeanPropertyRowMapper.newInstance(Game.class), id);
    }
}
