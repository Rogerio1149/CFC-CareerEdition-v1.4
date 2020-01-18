package comparator;

import java.util.Comparator;

import positions.PlayerQB;

/**
 * Created by ahngu on 11/13/2017.
 */

public class CompPlayerPassYards implements Comparator<PlayerQB> {
    @Override
    public int compare(PlayerQB a, PlayerQB b) {
        return a.getPassYards() > b.getPassYards() ? -1 : a.getPassYards() == b.getPassYards() ? 0 : 1;
    }
}
