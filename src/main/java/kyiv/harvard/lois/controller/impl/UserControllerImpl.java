/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.controller.impl
 * Class: UserControllerImpl
 **/

package kyiv.harvard.lois.controller.impl;

import kyiv.harvard.lois.controller.UserController;
import kyiv.harvard.lois.service.UserService;
import org.springframework.stereotype.Service;
import kyiv.harvard.lois.domain.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserControllerImpl implements UserController {
    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> findAll() {
        return userService.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userService.findById(id);
    }

    @Override
    public int create(User user) {
        return userService.create(user);
    }

    @Override
    public int update(Integer id, User user) {
        return userService.update(id, user);
    }

    @Override
    public int delete(Integer id) {
        return userService.delete(id);
    }
}
