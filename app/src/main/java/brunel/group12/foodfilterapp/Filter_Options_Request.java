package brunel.group12.foodfilterapp;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rajat on 20/02/2017.
 */

public class Filter_Options_Request extends StringRequest{

    private static final String Filter_Request_URL = "http://178.62.122.19/grp12/filter_options_v2.php";
    private Map<String,String> params;

    public Filter_Options_Request(String post_txt, Response.Listener<String> listener){

        super(Request.Method.POST, Filter_Request_URL, listener, null);
        params = new HashMap<>();
        params.put("post_txt", post_txt);
    }

    @Override
    public Map<String,String> getParams() {
        return params;
    }
}
