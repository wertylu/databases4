/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.dao.impl
 * Class: GameDaoImpl
 **/

package kyiv.harvard.lois.dao.impl;

import kyiv.harvard.lois.dao.GameDao;
import kyiv.harvard.lois.domain.Game;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class GameDaoImpl implements GameDao {
    private static final String FIND_ALL = "SELECT * FROM game";
    private static final String CREATE = "INSERT game(genre, rating, engine, platform_id ) VALUES (?, ?,?,?)";
    private static final String UPDATE = "UPDATE game SET genre=?, rating=?, engine=?, platform_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM game WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM game WHERE id=?";
    private static final String FIND_BY_GAME_GENRE = "SELECT * FROM game WHERE genre=?";
    private static final String FIND_BY_GAME_RATING = "SELECT * FROM game WHERE rating=?";
    private final JdbcTemplate jdbcTemplate;

    public GameDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }




    @Override
    public List<Game> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Game.class));
    }

    @Override
    public Optional<Game> findById(Integer id) {
        Optional<Game> game;
        try {
            game = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Game.class), id));
        } catch (EmptyResultDataAccessException e) {
            game = Optional.empty();
        }
        return game;
    }

    @Override
    public int create(Game game) {
        return jdbcTemplate.update(CREATE, game.getGenre(), game.getRating(),
                game.getEngine(), game.getPlatformId());
    }

    @Override
    public int update(Integer id, Game game) {
        return jdbcTemplate.update(UPDATE, game.getGenre(), game.getRating(),
                game.getEngine(), game.getPlatformId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<Game> findByGameGenre(String genre) {
        Optional<Game> game;
        try {
            game = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_GAME_GENRE,
                    BeanPropertyRowMapper.newInstance(Game.class), genre));
        } catch (EmptyResultDataAccessException e) {
            game = Optional.empty();
        }
        return game;
    }

    @Override
    public Optional<Game> findByGameRating(String rating) {
        Optional<Game> game;
        try {
            game = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_GAME_RATING,
                    BeanPropertyRowMapper.newInstance(Game.class), rating));
        } catch (EmptyResultDataAccessException e) {
            game = Optional.empty();
        }
        return game;
    }
}
