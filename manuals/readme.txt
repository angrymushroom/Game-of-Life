This is a simple terminal application for Game Of Life.
If you want to know how to run the application, please see the user manual.

[Input]
[1] seed file named: seed.txt
	example: 
		3, 5
		1, 1, 0, 0, 1
		0, 1, 0, 0, 0
		0, 1, 0, 0, 1
	Attention! 
	In the first row, you should provide the size of the first generation. 
	The first number represent the number of row. 
	The second number represent column.
	You must make sure that the matrix size in the first row is the same as the matrix size below.

[2] the generation you want to iterate over. 
	Attention! This needs to an integer.


[Output]
The result will be displayed in both terminal and file.
In the terminal:
	* means alive
	- means dead
There will be a series of file named "generation_x.txt". For each generation, you can search for the corresponding file.
In the files:
	1 means alive
	0 means dead