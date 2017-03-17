# Fileio
I ran a task and got the result like this </br>

|     Task     |    Elapsed Time    |
|--------------|--------------------|
| Copy a file byte-by-byte | 4.145808 sec |
| Copy the file using a byte array of size 1KB(1024) | 0.058184 sec |
| Copy the file using a byte array of size 4KB(4096) | 0.055356 sec |
| Copy the file using a byte array of size 64KB(65536) | 0.052369 sec |
| Copy the file using BufferedReader | 0.067242 sec |
### Copy methods at byte by byte.
It' very slow because it have to read one byte at time from start to the end.
### Copy methods by byte of array size.
It's faster than byte to byte because it's can read more than one byte at time.
### Copy methods by using BufferedReader and Printwritter to copy line.
It's slower than Copy method by byte of array size because it have to read line and convert byte <br>
to String.
