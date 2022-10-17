/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.service
 * Interface: GeneralService
 **/

package kyiv.harvard.lois.service;

import java.util.List;
import java.util.Optional;

public interface GeneralService<T, ID> {
    List<T> findAll();

    Optional<T> findById(ID id);

    int create(T entity);

    int update(ID id, T entity);

    int delete(ID id);
}
