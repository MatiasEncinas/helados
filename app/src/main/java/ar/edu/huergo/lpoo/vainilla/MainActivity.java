package ar.edu.huergo.lpoo.vainilla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.net.CookieHandler;
import java.net.CookieManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Activar el uso de cookies en esta app
        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://raw.githubusercontent.com/huergo-2020-3ao/helados/master/data-json/helados.json";

        // en python:
        //      response = requests.get(url)
        // y despues:
        //      response.text == '{"gustos": ... }'

        JsonObjectRequest req = new JsonObjectRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject dataGustos) {
                        Log.d("HOLA", "Response is: " + dataGustos);
                        GustosFragment gustos = GustosFragment.newInstance(dataGustos.toString());
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, gustos).commit();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("HOLA", "That didn't work!");
                Log.d("HOLA", error.getMessage());
            }
        });

        // Add the request to the RequestQueue.
        queue.add(req);



        /*
        CODIGO DE EJEMPLO PARA VER SI FUNCIONAN LAS COOKIES
        (pueden ignorarlo, es confuso el orden de los logs)

        queue.add(new JsonObjectRequest(
                Request.Method.GET, "https://httpbin.org/cookies/set?freeform=hola", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject res) {
                        Log.d("HOLA", "1: tengo estos cookies " + res + " pero acabo de setear hola");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("HOLA", "That didn't work!");
                Log.d("HOLA", error.getMessage());
            }
        }));

        queue.add(new JsonObjectRequest(
                Request.Method.GET, "https://httpbin.org/cookies", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject res) {
                        Log.d("HOLA", "2: ahora tengo estos cookies " + res);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("HOLA", "That didn't work!");
                Log.d("HOLA", error.getMessage());
            }
        }));


        queue.add(new JsonObjectRequest(
                Request.Method.GET, "https://httpbin.org/cookies/set?freeform=chau", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject res) {
                        Log.d("HOLA", "3: tengo estos cookies " + res + " pero acabo de setear chau");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("HOLA", "That didn't work!");
                Log.d("HOLA", error.getMessage());
            }
        }));

        queue.add(new JsonObjectRequest(
                Request.Method.GET, "https://httpbin.org/cookies", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject res) {
                        Log.d("HOLA", "4: ahora tengo estos cookies " + res);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("HOLA", "That didn't work!");
                Log.d("HOLA", error.getMessage());
            }
        }));
        */





    }
}