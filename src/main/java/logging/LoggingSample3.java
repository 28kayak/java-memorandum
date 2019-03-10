package logging;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggingSample3 {
  /**
   * ログ設定プロパティファイルのファイル名
   */
  protected static final String LOGGING_PROPERTIES = "javalog.properties";
  /**
   * static initializer によるログ設定の初期化
   */
  static {
    final Logger logger = Logger.getLogger("SampleLogging");

    // クラスパスの中から ログ設定プロパティファイルを取得
    logger.fine("ログ設定: " + LOGGING_PROPERTIES
            + " をもとにログを設定します。");
    final InputStream inStream = LoggingSample3.class
            .getClassLoader().getResourceAsStream(
                    LOGGING_PROPERTIES);
    if (inStream == null) {
      logger.info("ログ設定: " + LOGGING_PROPERTIES
              + " はクラスパス上に見つかりませんでした。");
    } else {
      try {
        LogManager.getLogManager().readConfiguration(
                inStream);
        logger.config(
                "ログ設定: LogManagerを設定しました。");
      } catch (IOException e) {
        logger.warning("ログ設定: LogManager設定の際に"
                +"例外が発生しました。:"+ e.toString());
      } finally {
        try {
          if (inStream != null) inStream.close();
        } catch (IOException e) {
          logger.warning("ログ設定: ログ設定プロパティ"
                  +"ファイルのストリームクローズ時に例外が"
                  +"発生しました。:"+ e.toString());
        }
      }//fianlly
    }//else
  }//static

  public static void main(String[] args) {
    final Logger logger = Logger.getLogger("SampleLogging");

    logger.finest("にゃんち注意報");
    logger.finer("東京都特許許可局。");
    logger.fine("かえるぴょこぴょこ。");
    logger.config("庭には二羽鶏が。");
    logger.info("生麦生米生卵。");
    logger.warning("あかまきがみ。");
    logger.severe("すもももももももものうち。");

  }

}//class
