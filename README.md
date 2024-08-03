# ChuckNorrisEncoder
a fun, beginner level project that can either convert string-->binary-->encrypted-message, or vice-versa. Code style is a bit messy since I wasn't focusing too much on proper variable names, so do excuse that. 

Here's how it works:

1. user types either "encode", "decode", or "exit".
2. Exit is self-explanatory (the program quits).
3. "Encode" means converting a character into Chuck Norris encryption.
4. After the user types "encode" into the scanner and inputs text thereafter, the algorithm iterates through each text character, converting it to binary.
5. Then, it iterates through the binary string and determines whether the current character is 0 or 1.
6. If it is 1, **for example**, it will track how many 1s there are in a row until a 0 becomes the next current character. This behavior is the same if the 0s and 1s are swapped in this given example.
7. 1s in the binary number is converted to 0, and 0s in the binary number are converted to 00.
8. The first "block" of characters in the output should consist of either 0 or 00, which represent 1 or 0, respectively. Then, its frequency should be represented as zeros following it. For example, (1011 -> 0 0 00 0 0 00). Notice how the 1/0 representation block and frequency block alternate until the end of the binary number. This can be seen better if we divide this up (1011 -> 0 0 | 00 0 | 0 00).
   
