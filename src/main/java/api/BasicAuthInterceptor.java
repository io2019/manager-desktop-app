package api;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class BasicAuthInterceptor implements Interceptor {

    private String creds;

    public BasicAuthInterceptor(String user, String pass) {
        this.creds = Credentials.basic(user, pass);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request req = chain.request();
        Request authReq = req.newBuilder()
                .header("Authorization", creds).build();
        return chain.proceed(authReq);
    }
}
