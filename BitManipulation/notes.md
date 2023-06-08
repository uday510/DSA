1. a & a = a 
2. a | a = a
3. a ^ a = 0
4. a ^ 0 = a
5. 0 ^ a = a
6. a | b = b | a
7. a & b = b & a
8. a ^ b = b ^ a
9. a ^ (b ^ c) = (a ^ b) ^ c = (a ^ c) ^ b
10. a << i = a * (2 ** i)
11. a >> i = a / (2 ** i)
12. To check 0th bit set or not -> a & 1
   
--------- 1 is left shifting i times -----------    

                    +-------> unset (0)
13. a & (1 << i) ---|
                    +-------> set (1)

--------- 1 is right shifting i times -----------


                      +----------> unset (0)
14. a & (1 >> i)  ----|
                      +-----------> set (1)


    
To check ith bit : a & (1 << i) or (a >> i) & 1

To set ith bit : a | (1 << i) or a | (1 >> i)

0|1 ^ 0 = 0/1
1|0 ^ 1 = 0/1

To toggle ith bit : a ^ (a << i).

Negative number represented as 2's complement of its positive number.
