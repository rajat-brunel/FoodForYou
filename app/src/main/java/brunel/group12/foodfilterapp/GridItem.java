package brunel.group12.foodfilterapp;

/**
 * Created by Rajat on 16/01/2017.
 */

public class GridItem {



    String desc;

    String imgURL;

    String post;

    public GridItem(String desc, String imgURL, String post) {

        this.desc = desc;
        this.imgURL = imgURL;
        this.post = post;

    }

    public String getDesc(){

        return desc;
    }

    public String getImgURL(){

        return imgURL;
    }

    public String getpost(){

        return post;
    }
}
