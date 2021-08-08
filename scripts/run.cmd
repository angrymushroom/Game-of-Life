@ECHO OFF
cd ..\src\main
echo "====== GameOfLife ======"
echo "Compiling Java file..."
javac GameOfLife.java
echo "Generating Javadoc..."
javadoc -author -version -encoding UTF-8 -d ..\..\docs GameOfLife.java
java GameOfLife.java %1 %2