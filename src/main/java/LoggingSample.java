import java.util.logging.Logger;

public class LoggingSample {
  public static void main(String[] args) {
    final Logger logger = Logger.getLogger("SampleLogging");
    //logger.info("隣の客は良く柿食う客だ。");
    //final Logger logger = Logger.getLogger("SampleLogging");
    logger.finest("隣の客はよく柿食う客だ。");
    logger.finer("東京都特許許可局。");
    logger.fine("かえるぴょこぴょこ。");
    logger.config("庭には二羽鶏が。");
    /*
     * Java実行環境はデフォルト状態ではINFOレベルより下のレベルのログは出力されないようになっているからなのです。
     * */
    logger.info("生麦生米生卵。");//displayed
    logger.warning("あかまきがみ。");//displayed
    logger.severe("すもももももももものうち。");//displayed




  }


}
/*
*
* <dependency>
  <groupId>org.slf4j</groupId>
  <artifactId>log4j-over-slf4j</artifactId>
  <version>1.7.5</version>
</dependency>
*/