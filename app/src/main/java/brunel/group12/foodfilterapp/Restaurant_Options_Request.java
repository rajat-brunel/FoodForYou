package brunel.group12.foodfilterapp;

    import com.android.volley.Request;
    import com.android.volley.Response;
    import com.android.volley.toolbox.StringRequest;

    import java.util.HashMap;
    import java.util.Map;

/**
 * Created by sharara on 26/02/2017.
 */

    public class Restaurant_Options_Request extends StringRequest {

        private static final String Restaurant_Request_URL = "http://178.62.122.19/grp12/res_options_v2.php";
        private Map<String,String> params;

        public Restaurant_Options_Request(String post_txt, String res, Response.Listener<String> listener){

            super(Request.Method.POST, Restaurant_Request_URL, listener, null);
            params = new HashMap<>();
            params.put("post_txt", post_txt);
            params.put("res",res);
        }

        @Override
        public Map<String,String> getParams() {
            return params;
        }
    }

//}
