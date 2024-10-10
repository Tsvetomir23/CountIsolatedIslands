# Find number of closed islands

This is simple implementation of the solution for closed islands problem written in Java with Depth-first search and recursion.

## Task

Given a binary matrix mat[][] of dimensions N X M such that 1 denotes land and 0 denotes water. Find the number of closed islands in the given matrix.
An island is a 4-directional (up, right, down and left) connected part of 1&#39;s.<br/>
**Note:** A closed island is a group of 1s surrounded by only 0s on all the boundaries (except diagonals). In simple words, a closed island is an island whose none of the 1s lie on the edges of the matrix.

***Example 1:*** <br/>
**Input:** <br/>
N = 5, M = 8
mat[][] = {{0, 0, 0, 0, 0, 0, 0, 1}, <br/>
{0, 1, 1, 1, 1, 0, 0, 1}, <br/>
{0, 1, 0, 1, 0, 0, 0, 1}, <br/>
{0, 1, 1, 1, 1, 0, 1, 0}, <br/>
{1, 0, 0, 0, 0, 1, 0, 1}} <br/>
**Output:** <br/>
2 <br/>
**Explanation:** <br/>
mat[][] = {{0, 0, 0, 0, 0, 0, 0, 1}, <br/>
{0, 1, 1, 1, 1, 0, 0, 1}, <br/>
{0, 1, 0, 1, 0, 0, 0, 1}, <br/>
{0, 1, 1, 1, 1, 0, 1, 0}, <br/>
{1, 0, 0, 0, 0, 1, 0, 1}} <br/>
There are 2 closed islands. The islands in dark are closed because they are completely
surrounded by 0s (water). There are two more islands in the last column of the matrix, but they
are not completely surrounded by 0s. Hence they are not closed islands.

***Example 2:*** <br/>
**Input:** <br/>
N = 3, M = 3 <br/>
mat[][] = {{1, 0, 0}, <br/>
{0, 1, 0}, <br/>
{0, 0, 1}} <br/>
**Output:** <br/>
1 <br/>
**Explanation:** <br/>
mat[][] = {{1, 0, 0}, <br/>
{0, 1, 0}, <br/>
{0, 0, 1}} <br/>
There is just a one closed island. <br/>
**Constraints:** <br/>
**1 ≤ N,M ≤ 500**


# Solution
It's expecting two integers N x M for the 2 dimensional matrix. Throwing exception for not integer value.
Next it's expecting N * M values for the matrix. It's accepting non-breaking space, whitespace and separated comma values, but must be on one line.

*Example:*
>Enter the number of rows:
**3** <br/>
Enter the number of columns:
**3** <br/>
Enter the matrix of size 3 x 3: **0, 0,    &nbsp;&nbsp;&nbsp;0, 0, &nbsp;&nbsp;&nbsp;1, 0,&nbsp;&nbsp;1,0,  1**<br/>
The entered matrix is:<br/>
0 0 0 <br/>
0 1 0 <br/>
1 0 1 <br/>
Number of closed islands: 1
