package app;

import io.jooby.test.JoobyTest;
import io.jooby.StatusCode;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;

import biz.guglielmo.Main;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@JoobyTest(Main.class)
public class IntegrationTest {

  static OkHttpClient client = new OkHttpClient();

  @Test
  public void shouldSayHi(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort)
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals("Welcome to Jooby!", rsp.body().string());
      assertEquals(StatusCode.OK.value(), rsp.code());
    }
  }
}
