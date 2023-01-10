import io.qt.QThreadAffinityException;
import io.qt.core.QThread;
import io.qt.qml.QQmlApplicationEngine;
import io.qt.webengine.quick.QtWebEngineQuick;
import io.qt.widgets.QApplication;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/*
 * \$Id: $
 *
 * @author Maxim Chistov
 * @since ${MONTH_NAME_SHORT} ${DAY}, ${YEAR}
 *
 * \$Log: $
 */public class Main {
    public static void main(String[] args) throws MalformedURLException {
        QtWebEngineQuick.initialize();
        QApplication.initialize(args);

        QQmlApplicationEngine engine = new QQmlApplicationEngine();

        updateClassloader();
        var loader = QThread.currentThread().getContextClassLoader();
        var search = loader.getResource("qrc:/mainTest.qml"); // returns null, should return resource

        engine.objectCreated.connect((object, url) -> {
            if (object == null) {
                System.err.println("Failed to load engine for url " + url);
            } else {
                System.out.println("Loaded engine for url " + url);
            }
        });
        engine.load("qrc:/mainTest.qml");

        QApplication.exec();
        QApplication.quit();
    }

    // update classloader to allow locating files from "downloaded" jar
    static void updateClassloader() throws MalformedURLException {
        var thread = QThread.currentThread();
        var oldClassloader = thread.getContextClassLoader();
        thread.setContextClassLoader(new URLClassLoader(new URL[]{new URL("https://dl.dropboxusercontent.com/s/t1h23fr0n5arz6o/qmls.jar")},thread.getContextClassLoader()));
    }
}