package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import json.Data;

public class JsonToJavaObject {
  public static void main(String[] args) throws Exception{
    String json = "{"
            + "\"created_at\":\"Thu Apr 06 15:24:15 +0000 2017\", "
            + "\"id\": 1234567, "
            + "\"text\": \"hello world\""
            + "}";
    ObjectMapper mapper = new ObjectMapper();
    Data data = mapper.readValue(json, Data.class);
    System.out.println(data.created_at);
    System.out.println(data.id);
    System.out.println(data.text);

  }

}
