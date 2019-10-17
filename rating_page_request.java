package brunel.group12.foodfilterapp;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bhavesh on 20/02/2017.
 */

public class rating_page_request extends StringRequest
{

    private static final String rating_page_request_URL ="http://178.62.122.19/grp12/rating.php"
    private Map<String,String> params;

    public rating_page_request(String res_id, Response.Listener<String> listener){

        super(Request.Method.POST, rating_page_request_URL, listener, null);
        params = new HashMap<>();
        params.put("res_id",res);
    }

    @Override
    public Map<String,String> getParams() {
        return params;
    }
}
