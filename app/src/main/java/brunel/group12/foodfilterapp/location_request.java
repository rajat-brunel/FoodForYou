

/**
 * Created by JamilQanai on 23/03/2017.
 */

package brunel.group12.foodfilterapp;

        import com.android.volley.Response;
        import com.android.volley.toolbox.StringRequest;

        import java.util.HashMap;
        import java.util.Map;


public class location_request extends StringRequest {

    private static final String add_fav_URL = "http://178.62.122.19/grp12/location.php";
    private Map<String,String> params;

    public location_request(String rest, Response.Listener<String> listener){

        super(Method.POST, add_fav_URL, listener, null);
        params = new HashMap<>();
        params.put("rest",rest);
    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
