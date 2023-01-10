import QtQml
import QtQuick
import QtQuick.Window
import QtQuick.Controls
import QtQuick.Layouts
import Qt.labs.qmlmodels


Window {
    id: root
    width: 1200
    height: 1000
    visible: true
    title: qsTr("NG-MVP")
    flags: Qt.Window
    color: "black"
    property alias webView: webEngine

    ColumnLayout {
        spacing: 2
        Rectangle {
            height: 100
            width: 1200

            Button {
                text: "click me"
                onClicked: {
                    controller.passWebView(webView);
                }
            }
        }

        OurWebEngine {
            height: 800
            width: 1200
            id: webEngine
            objectName: "webEngine"
            url: "https://google.com"
        }
    }
}
