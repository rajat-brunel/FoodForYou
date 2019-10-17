package brunel.group12.foodfilterapp;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Muhammad Azeem on 26/02/2017.
 */

public class rest_page_request extends StringRequest{


        private static final String rest_page_request_URL = "http://178.62.122.19/grp12/rest_page.php";
        private Map<String,String> params;

        public rest_page_request(String res, Response.Listener<String> listener){

            super(Request.Method.POST,rest_page_request_URL, listener, null);
            params = new HashMap<>();
            params.put("res", res);
        }

        @Override
        public Map<String,String> getParams() {
            return params;
        }

}
