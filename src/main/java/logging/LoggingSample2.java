package logging;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggingSample2 {
  /*Setting for Logging*/
  /**
   * ログ設定プロパティファイルのファイル内容
   */
  protected static final String LOGGING_PROPERTIES_DATA
          = "handlers=java.util.logging.ConsoleHandler\n"
          + ".level=INFO\n"
          + "java.util.logging.ConsoleHandler.level=INFO\n"
          + "java.util.logging.ConsoleHandler.formatter"
          + "=java.util.logging.SimpleFormatter";
  /**
   * static initializer によるログ設定の初期化
   */
  static {
    final Logger logger = Logger.getLogger("SampleLogging");
    InputStream inStream = null;
    try {
      inStream = new ByteArrayInputStream(
              LOGGING_PROPERTIES_DATA.getBytes("UTF-8"));
      try {
        LogManager.getLogManager().readConfiguration(
                inStream);
        logger.config(
                "ログ設定: LogManagerを設定しました。");
      } catch (IOException e) {
        logger.warning("ログ設定: LogManager設定の際に"
                + "例外が発生しました。:" + e.toString());
      }
    } catch (UnsupportedEncodingException e) {
      logger.severe("ログ設定: UTF-8エンコーディングが"
              + "サポートされていません。:" + e.toString());
    } finally {
      try {
        if (inStream != null) inStream.close();
      } catch (IOException e) {
        logger.warning(
                "ログ設定: ログ設定プロパティファイルのスト"
                        + "リームクローズ時に例外が発生しました。:"
                        + e.toString());
      }
    }
  }








  public static void main(String[] args) {
    final Logger logger = Logger.getLogger("SampleLogging");

    logger.finest("隣の客はよく柿食う客だ。");
    logger.finer("東京都特許許可局。");
    logger.fine("かえるぴょこぴょこ。");
    logger.config("庭には二羽鶏が。");
    logger.info("生麦生米生卵。");
    logger.warning("あかまきがみ。");
    logger.severe("すもももももももものうち。");


  }//main
}
