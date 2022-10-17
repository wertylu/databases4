/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.domain
 * Class: User
 **/

package kyiv.harvard.lois.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private Integer platformId;
}
