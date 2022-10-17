/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.domain
 * Class: Steam
 **/

package kyiv.harvard.lois.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Steam {
    private Integer id;
    private Integer moneyOnSteam;
    private Integer numberOfFriends;
    private Integer userId;
}
