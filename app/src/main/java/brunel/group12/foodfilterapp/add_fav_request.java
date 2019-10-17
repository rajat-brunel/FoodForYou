package brunel.group12.foodfilterapp;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rajat on 01/03/2017.
 */

public class add_fav_request extends StringRequest {

    private static final String add_fav_URL = "http://178.62.122.19/grp12/favourite_add.php";
    private Map<String,String> params;

    public add_fav_request(String username, String rest, Response.Listener<String> listener){

        super(Method.POST, add_fav_URL, listener, null);
        params = new HashMap<>();
        params.put("username",username);
        params.put("rest",rest);
    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
