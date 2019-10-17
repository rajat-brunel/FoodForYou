package brunel.group12.foodfilterapp;

import java.util.List;

/**
 * Created by Rajat on 01/03/2017.
 */

public class favItems {

    String fav_name;

    public favItems(String fav_name){

        this.fav_name=fav_name;
    }

    private List<favItems> favitem;

    public String getFav_name(){
        return  fav_name;
    }
}
