package brunel.group12.foodfilterapp;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sharara on 16/02/2017.
 */

public class login_request extends StringRequest {
    private static final String Login_Request_URL = "http://178.62.122.19/grp12/login.php";
    private Map<String, String> params;

    public login_request(String username, String password, Response.Listener<String> listener){

        super(Request.Method.POST, Login_Request_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
