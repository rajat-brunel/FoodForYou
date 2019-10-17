package brunel.group12.foodfilterapp;


import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    private static final String Register_Request_URL = "http://178.62.122.19/grp12/register.php";
    private Map<String, String> params;

    public RegisterRequest(String first_name, String last_name, String username, String password, Response.Listener<String> listener){

        super(Method.POST, Register_Request_URL, listener, null);
        params = new HashMap<>();
        params.put("first_name", first_name);
        params.put("last_name", last_name);
        params.put("username", username);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
