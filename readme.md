Jambi can't locate filed from downloaded jars

In provided example we try to add to our thread' context classloader file from downloaded jar:
it contains just files `mainTest.qml` and `OurWebEngine.qml`

Before we were adding all .qml files from downloaded files like this: `QtJambiResources.addSearchPath(absolutePath)`
but it was removed in Jambi 6.4.2 
How do we do it now? Jambi can't load qrc:/ files from downloaded jjars anymore