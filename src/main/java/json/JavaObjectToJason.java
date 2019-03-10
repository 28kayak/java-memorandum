package json;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaObjectToJason {
  public static void main(String[] args) throws Exception {
    Data data = new Data();
    data.created_at = "Thu Apr 06 15:24:15 +0000 2017";
    data.id = 8838345;
    data.text = "地下に眠る千両箱";

    ObjectMapper mapper = new ObjectMapper();
    String json = mapper.writeValueAsString(data);

    System.out.println(json);
  }
}
