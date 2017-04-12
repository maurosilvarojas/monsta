package rms.monsterbank.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by regga on 02/04/2017.
 */

public class Response {
    private List<InTransfers> inTransfers= new ArrayList<InTransfers>();

    public List<InTransfers> getInTransfers() {
        return inTransfers;
    }
}
