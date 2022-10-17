/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.domain
 * Class: Game
 **/

package kyiv.harvard.lois.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Game {
    private Integer id;
    private String genre;
    private Integer rating;
    private String engine;
    private Integer platformId;
}

