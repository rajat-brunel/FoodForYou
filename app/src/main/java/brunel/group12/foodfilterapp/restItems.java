package brunel.group12.foodfilterapp;

import java.util.List;

/**
 * Created by B guy on 18/01/2017.
 */

public class restItems {
    String rest_name;
    String rest_dist;
    String rest_photo;

    public restItems(String rest_name, String rest_dist, String rest_photo){
        this.rest_name=rest_name;
        this.rest_dist=rest_dist;
        this.rest_photo=rest_photo;
    }

    private List<restItems> restitems;

    public String getRest_name(){
        return  rest_name;
    }

    public String getRest_dist(){
        return  rest_dist;
    }

    public String getRest_photo(){return  rest_photo;}

}
